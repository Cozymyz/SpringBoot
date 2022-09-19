<template>
  <div class="login_container">
    <el-form :rules="rules"
              ref="loginForm"
              v-loading="loading"
              element-loading-text="正在登录..."
              element-loading-spinner="el-icon-loading"
              element-loading-background="rgba(0, 0, 0, 0.8)"
              :model="loginForm"
              class="loginContainer">
            <h3 class="loginTitle">系统登录</h3>
            <el-form-item prop="username">
               <!-- <i class="el-icon-user-solid"></i> -->
                <el-input id="input_username" size="normal" type="text" v-model="loginForm.username" auto-complete="off"
                          placeholder="请输入用户名">
                         </el-input>
            </el-form-item>
            <el-form-item prop="password">
                <el-input size="normal" type="password" v-model="loginForm.password" auto-complete="off"
                          placeholder="请输入密码"></el-input>
            </el-form-item>
            <el-button size="normal" type="primary" style="width: 100%;" @click="submitLogin">登录</el-button>
    </el-form>
  </div>
</template>

<script>

export default {
  name: 'LoginForm',
  data:function(){
    return{
      loading:false,
      loginForm:{
        username:'',
        password:'',
      },
      rules: {
          username: [{required: true, message: '请输入用户名', trigger: 'blur'}],
          password: [{required: true, message: '请输入密码', trigger: 'blur'}],
      }
    }
  },
  methods:{
    submitLogin() {
        this.$refs.loginForm.validate((valid) => {
            if (valid) {
                this.loading = true;
                let fd = new FormData
                fd.append('username',this.loginForm.username)
                fd.append('password',this.loginForm.password)
                this.$axios.post('/api/user/login' ,fd).then((res) => {
                  console.log(res.data)
                  if(res.data.status==400){
                    this.$message.error({
                      message:'用户名或密码错误'
                    })
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
    }
  }
}
</script>

<style scoped>
.login_container{
    padding: 1em;
    background: #fff;
    display:flex;
    border: 1px solid #eaeaea;
    border-radius: 0.5em;
    box-shadow: 0 0px 25px;
    flex-direction: column;
    align-items: space-around;
}

.login_container div{
  display: flex;
  flex-direction: row;
  align-items: center;
  margin: 1em 0.5em 1em;
}
.login_container div i{
  width: 20px;
  height: 20px;
}
.login_container input{
  outline: none;
  margin-left: 1em;
  border-radius: 0.25em;
  border: 1px solid #ccc;
  padding: 0.75em 0.25em 0.75em 1em;
}
.btn_login{
  display:block;
  background-color: #409EFF;
  width: 100%;
  color: #fff;
  outline: none;
  padding: 0.75em 0;
  border-radius: 0.25em;
  border: none;
}
</style>
