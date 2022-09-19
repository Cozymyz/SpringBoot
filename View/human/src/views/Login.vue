<template>
  <div class="login-container">
    <el-form ref="loginForm" :rules="rules" :model="loginForm" class="login-form" auto-complete="on" label-position="left">

      <div class="title-container">
        <h3 class="title">人事管理系统</h3>
      </div>

      <el-form-item prop="username">

        <el-input
          ref="username"
          v-model="loginForm.username"
          placeholder="Username"
          name="username"
          type="text"
          tabindex="1"
          auto-complete="on"
        />
      </el-form-item>

      <el-form-item prop="password">

        <el-input
          ref="password"
          v-model="loginForm.password"
          placeholder="Password"
          name="password"
          tabindex="2"
          auto-complete="on"
          @keyup.enter.native="submitLogin"
        />
        
      </el-form-item>

      <el-form-item prop="code">

        <el-input
          ref="code"
          v-model="loginForm.code"
          name="code"
          placeholder="VerifyCode"
          /> 

      </el-form-item>

      <div class="ver-pic">
        <img :src="src" @click="getVerify()" />
      </div>
      <el-button :loading="loading" type="primary" style="width:100%;margin-bottom:30px;" @click.native.prevent="submitLogin">登录</el-button>
      <el-button type="primary" style="width:100%;margin:auto;margin-bottom:30px" @click.native.prevent="dialogVisible=true">注册</el-button>

    </el-form>
    <el-dialog
    title="用户注册"
    :visible.sync="dialogVisible"
    width="30%"
    :before-close="handleClose" class="register-dialog">
      <el-form ref="registerForm" :model="registerForm" class="register-form" aria-autocomplete="on" label-position="left">
        
        <el-form-item prop="username">

          <el-input
            ref="username"
            v-model="registerForm.username"
            placeholder="UserName"
            name="username"
            type="text"
            />

        </el-form-item>

        <el-form-item prop="password">
          
          <el-input
            ref="password"
            v-model="registerForm.password"
            placeholder="Passowrd"
            name="password"
            type="password"
            />

        </el-form-item>

        <el-form-item prop="phone">

          <el-input
            ref="phone"
            v-model="registerForm.phone"
            placeholder="Phone"
            name="phone"
            type="text"
            />

        </el-form-item>

        <el-form-item prop="email">

          <el-input
            ref="email"
            v-model="registerForm.email"
            placeholder="Email"
            name="eamil"
            type="eamil"
            />

        </el-form-item>

        <el-form-item prop="sex">

          <el-radio v-model="registerForm.sex" label="男">男</el-radio>
          <el-radio v-model="registerForm.sex" label="女">女</el-radio>

        </el-form-item>

        <el-form-item prop="identity">

          <el-input
            ref="identity"
            v-model="registerForm.identity"
            placeholder="Identity"
            name="identity"
            type="text"
            />

        </el-form-item>

        <el-form-item prop="realname">

          <el-input
            ref="realname"
            v-model="registerForm.realname"
            placeholder="RealName"
            name="realname"
            type="text"
            />
            
        </el-form-item>
      </el-form>
      <el-button @click="dialogVisible = false">取 消</el-button>
      <el-button type="primary" @click.native.prevent="userRegister">确 定</el-button>
    </el-dialog>
  </div>
</template>

<script>

export default {
  name: 'Login',
  data:function(){
    return{
      dialogVisible:false,
      loading:false,
      src:'',
      registerForm:{
        username:'',
        password:'',
        phone:'',
        email:'',
        role:'user',
        sex:'男',
        identity:'',
        realname:''
      },
      loginForm:{
        username:'',
        password:'',
        code:''
      },
      rules: {
          username: [{required: true, message: '请输入用户名', trigger: 'blur'}],
          password: [{required: true, message: '请输入密码', trigger: 'blur'}],
          code: [{required: true, message: '请输入验证码', trigger: 'blur'}]
      }
    }
  },
created(){
  // this.src="http://chengbei.site:8090/user/verifyCode?"+Math.ceil(Math.random()*10)
  this.getVerify()
},

  methods:{
    submitLogin() {
      this.$refs.loginForm.validate((valid) => {
        if (valid) {
            this.loading = true;
            let fd = new FormData
            fd.append('username',this.loginForm.username)
            fd.append('password',this.loginForm.password)
            fd.append('code', this.loginForm.code)
            console.log(this.src)
            this.$axios.post('/api/user/login' ,fd).then((res) => {
              console.log(res.data)
              if(res.data.status==400){
                if(res.data.data.info==2){
                  this.$message.error({
                    message:'验证码错误'
                  })
                }else{
                  this.$message.error({
                    message:'用户名或密码错误'
                  })
                }
                // this.getVerify()
                this.loading=false
              }else if(res.data.status==200){
                this.$store.commit('user/SET_TOKEN',res.data.data.token)
                this.$store.commit('user/SET_USERINFO',res.data.data.user)
                this.loading = false
                this.$router.push({ path: '/workexp' })
              }
            }).catch((error) => {
              console.log(error)
            })
            
        } else {
          this.loading = false
          this.$message.error({
            message: '用户名或密码格式不正确，请重新输入'
          })
          console.log('error login!!')
          return false
        } 
      })
    },

    userRegister() {
      this.$refs.registerForm.validate((valid) =>{
        if(valid){
          this.loading = true
          let fd =new FormData
          fd.append('username', this.registerForm.username)
          fd.append('password', this.registerForm.password)
          fd.append('phone', this.registerForm.phone)
          fd.append('email', this.registerForm.email)
          fd.append('sex', this.registerForm.sex)
          fd.append('role', this.registerForm.role)
          fd.append('identity', this.registerForm.identity)
          fd.append('realname', this.registerForm.realname)
          console.log(fd)
          this.$axios.post('/api/user/register', fd).then((res)=>{
            console.log(res.data)
            if(res.data.status==400){
              console.log(res.data.data.errors[0])
              this.$message.error({
                message: res.data.data.errors[0]
              })
              this.loading = false
            }else if(res.data.status==200){
              this.$store.commit('user/SET_TOKEN',res.data.data.token)
              this.$store.commit('user/SET_USERINFO',res.data.data.user)
              this.loading = false
              this.$router.push({ path: '/workexp' })
            }
          }).catch((error) => {
            console.log(error)
          })
        }else {
          this.loading = false
          this.$message.error({
            message: '不合法输入'
          })
          console.log('error register!!')
          return false
        } 
      })
    },

    handleClose(done) {
        this.$confirm('确认关闭？')
        .then(() => {
            done();
        })
        .catch(_ => {console.log(_)});
    },
    
    getVerify() {
      console.log('123')
      let session  = sessionStorage.getItem('verify_code')
      console.log(session)
      // this.src="http://chengbei.site:8090/user/verifyCode?"+Math.ceil(Math.random()*10)
      this.$axios.get('/api/user/verifyCode', {responseType: 'arraybuffer'}).then((res) =>{
        console.log(res)
        console.log(res.data)
        let codeimg = 'data:image/png;base64,' + btoa(
          new Uint8Array(res.data).reduce((data, byte) => data + String.fromCharCode(byte), ''))
        this.src = codeimg
        // this.src="http://chengbei.site:8090/user/verifyCode?"+Math.ceil(Math.random()*10)
        // this.src = res +Math.ceil(Math.random()*10)
      }).catch(error=>{
        console.log(error)
      })
      
    }
  }
}
</script>




<style lang="scss">
/* 修复input 背景不协调 和光标变色 */
/* Detail see https://github.com/PanJiaChen/vue-element-admin/pull/927 */

$bg:#283443;
$light_gray:#fff;
$cursor: #fff;

@supports (-webkit-mask: none) and (not (cater-color: $cursor)) {
  .login-container .el-input input {
    color: $cursor;
  }
}

/* reset element-ui css */
.login-container {
  .el-input {
    display: inline-block;
    height: 47px;
    width: 85%;

    input {
      background: transparent;
      border: 0px;
      -webkit-appearance: none;
      border-radius: 0px;
      padding: 12px 5px 12px 15px;
      color: $light_gray;
      height: 47px;
      caret-color: $cursor;

      &:-webkit-autofill {
        box-shadow: 0 0 0px 1000px $bg inset !important;
        -webkit-text-fill-color: $cursor !important;
      }
    }
  }

  .el-dialog{
    background-color: #2d3a4b;
  }

  .el-dialog__title{
    color: #fff;
  }

  .el-form-item {
    border: 1px solid rgba(255, 255, 255, 0.1);
    background: rgba(0, 0, 0, 0.1);
    border-radius: 5px;
    color: #454545;
  }
}

</style>

<style lang="scss" scoped>
$bg:#2d3a4b;
$dark_gray:#889aa4;
$light_gray:#eee;

.login-container {
  min-height: 100%;
  width: 100%;
  background-color: $bg;
  overflow: hidden;

  .login-form {
    position: relative;
    width: 520px;
    max-width: 100%;
    padding: 160px 35px 0;
    margin: 0 auto;
    overflow: hidden;
  }

  .register-form .el-form-item{
    background-color: #2d3a4b;
  }

  .svg-container {
    padding: 6px 5px 6px 15px;
    color: $dark_gray;
    vertical-align: middle;
    width: 30px;
    display: inline-block;
  }

  .title-container {
    position: relative;

    .title {
      font-size: 26px;
      color: $light_gray;
      margin: 0px auto 40px auto;
      text-align: center;
      font-weight: bold;
    }
  }
}
</style>
