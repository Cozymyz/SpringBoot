<template>
  <div class="bord">
      <div class="bordtop">
          <div>
              <img :src="avatarUrl||this.$host+user.photo" class="avatar" alt="">
              <el-upload
                class="upload"
                action="#"
                :on-error="uploadError"
                :show-file-list="false"
                :on-success="handleAvatarSuccess"
                :before-upload="beforeAvatarUpload"
            >
              <span>编辑头像</span>
            </el-upload>
          </div>
           
           <div class="bordcolumn">
               <div class="username">{{user.username}}</div>
               <div class="simpleinfo">年龄：{{user.age}}</div>
               <div class="simpleinfo">邮箱：{{user.email}}</div>
               <div class="simpleinfo">姓名：{{user.realname}}</div>
               <div class="simpleinfo">手机号：{{user.phone}}</div>
               <div class="simpleinfo">性别：{{user.sex}}</div>
               <div class="simpleinfo">身份证：{{user.identity}}</div>
               <div class="simpleinfo">生日：{{user.birthday}}</div>
           </div>
            <el-button class="changebtn" type="primary" @click="showFormDlg">修改</el-button>
      </div>
      <el-upload
        class="upload-demo"
        action="#"
        :on-remove="handleRemove"
        :before-upload="beforeResumeUpload"
        :limit="1"
        :file-list="fileList">
        <el-button size="small" type="primary">上传简历</el-button>
        </el-upload>
        <a :href="this.$host+this.$store.state.user.userInfo.resume">下载简历</a>
     <el-dialog
        title="修改信息"
        :visible.sync="formDlgVisible"
        width="30%"
        :before-close="handleClose">
        <div class="form">
            <div class="formitem">
                <div class="littletitle">用户名</div>
                <el-input v-model="username_input"></el-input>
            </div>
            <div class="formitem">
                <div class="littletitle">密码</div>
                <el-input id="password" v-model="password_input"></el-input>
            </div>
            <div class="formitem">
                <div class="littletitle">邮箱</div>
                <el-input v-model="email_input"></el-input>
            </div>
            <div class="formitem">
                <div class="littletitle">手机号</div>
                <el-input v-model="phone_input"></el-input>
            </div>
            
        </div>
        <span slot="footer" class="dialog-footer">
            <el-button @click="formDlgVisible = false">取 消</el-button>
            <el-button type="primary" @click="modify">确 定</el-button>
        </span>
        </el-dialog>
        
  </div>
</template>

<script>
export default {
    name:'Myinfo',
    data(){
        return{
            user:this.$store.state.user.userInfo,
            avatarFileUrl:'',
            avatarUrl:'',
            formDlgVisible:false,
            username_input:'',
            password_input:'',
            fileList:[],
            // age_input:'',
            email_input:'',
            // identity_input:'',
            // birthday_input:'',
            // sex_input:'',
            // realname_input:'',
            phone_input:''
        }
    },
    created(){
        let fd = new FormData()
        let that = this
        this.$axios.post('/api/user/getUserInfo',fd,{headers:{'token':this.$store.state.user.token}}).then((res)=>{
            console.log(res.data.data.user)
            that.user = res.data.data.user
        })
    },
    computed:{
        // userphoto:function(){
        //     console.log(this.$store.state.user.userInfo.photo)
        //     let str = this.$store.state.user.userInfo.photo
        //     let index = str.lastIndexOf("/")
        //     str =str .substring(index+1,str.length);
        //     console.log(str) 
        //     return this.$host+'/photo/'+str
        // }
    },
    methods:{
        handleAvatarSuccess(res, file) {
             this.avatarUrl = URL.createObjectURL(file.raw)
        },
        beforeAvatarUpload(file) {
            const fd = new FormData()
            const that = this
            fd.append('file', file)// 传文件
            // fd.append('srid',this.upLoadData.srid);//传其他参数
            this.$axios.post('/api/user/uploadUserPhoto', fd, { headers: {
                'token': that.$store.state.user.token
            }}).then(function(res) {
                console.log(res)
                console.log(file)
                that.avatarUrl = window.URL.createObjectURL(file)
                that.avatarFileUrl = res.data.userphotourl
            })
            return false// 屏蔽了action的默认上传
        },
        beforeResumeUpload(file) {
            const fd = new FormData()
            const that = this
            fd.append('file', file)// 传文件
            // fd.append('srid',this.upLoadData.srid);//传其他参数
            this.$axios.post('/api/user/uploadUserResume', fd, { headers: {
                'token': that.$store.state.user.token
            }}).then(function(res) {
                console.log(res)
                console.log(file)
                console.log('success')
                // that.avatarFileUrl = res.data.userphotourl
            })
            return false// 屏蔽了action的默认上传
        },
        uploadError(error) {
            console.log('error!')
            console.log(error)
        },
        showFormDlg(){
            this.formDlgVisible = true
        },
        handleClose(done) {
            this.$confirm('确认关闭？')
            .then(() => {
                done();
            })
            .catch(_ => {console.log(_)});
        },
        modify(){
            let that = this
            let fd = new FormData()
            fd.append('userName',this.username_input)
            fd.append('password',this.password_input)
            fd.append('phone',this.phone_input)
            fd.append('email',this.email_input)
            this.$axios.post('/api/user/update',fd,{headers:{'token':this.$store.state.user.token}}).then((res)=>{
                console.log(res)
                that.$store.commit('user/SET_USERINFO', res.data.data.user)
                that.formDlgVisible = false
            })
        },
         handleRemove(file, fileList) {
            console.log(file, fileList);
        },
        download(){
            let fd = new FormData()
            this.$axios.post('/api/user/downloadSelfResume',fd,{headers:{'token':this.$store.state.user.token}}).then((res)=>{
                console.log(res)
            })
        }
    }
}
</script>

<style scoped>
.bord{
    margin: 2em;
    padding: 1em;
    border-radius: 5px;
    background: #f2f2f2;
    display: flex;
    flex-direction: column;
    /* box-shadow: 0 0 2px; */
}
.username{
    font-size: 1.25em;
    margin-bottom: 0.5em;

}
.bordcolumn{
    margin-left: 1em;
    text-align: left;
    display: flex;
    flex-direction: column;
}
.bordtop{
    display: flex;
    flex-direction: row;
}
.avatar{
    display: block;
    width: 160px;
    height: 160px;
}
.simpleinfo{
    /* text-align: left; */
    /* margin-left: 1em; */
    font-size: 0.75em;
}
.simpleinfo+.simpleinfo{
    margin-top: 0.5em;
}
.changebtn{
    margin-left: auto;
    /* padding: 2em; */
    height: 3em;
}
.upload{
    text-align:left;
    margin-left:3em;
    margin-top: 1em;
    font-size:0.75em;
    color:#3379cc;
}
.form{
    display: flex;
    flex-wrap: wrap;
}
.littletitle{
    text-align: left;
    margin-bottom: 0.5em;
}
.formitem{
    margin-left: 3em;
    margin-top: 1em;
}
</style>