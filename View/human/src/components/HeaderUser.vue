<template>
  <div class="wrap">
      <el-dropdown>
  <span class="el-dropdown-link">
    <img :src="this.$host+this.$store.state.user.userInfo.photo" id="userAvatar" alt="">
  </span>
  <el-dropdown-menu slot="dropdown">
    <el-dropdown-item>{{iden}}</el-dropdown-item>
    <el-dropdown-item @click.native="logout">注销</el-dropdown-item>

  </el-dropdown-menu>
</el-dropdown>

<!-- <div slot="reference" class="container"><img src="@assets/avatar.jpg" id="userAvatar" alt=""></div> -->
  </div>
</template>

<script>
export default {
    name:'HeaderUser',
    data:function(){
        return{
            iden:this.$store.state.user.role
        }
    },
    computed:{
        // userphoto:function(){
        //     // console.log(this.$store.state.user.userInfo.photo)
        //     let str = this.$store.state.user.userInfo.photo
        //     let index = str.lastIndexOf("/")
        //     str =str .substring(index+1,str.length);
        //     console.log(str) 
        //     return this.$host+'/photo/'+str
        // },
    },
   
    methods:{
        logout:function(){
            this.$store.dispatch('user/logout')
            console.log('111')
            this.$router.push('/login')
        }
    }
}
</script>

<style scoped>
    .wrap{
        display: flex;
        align-items: center;
        padding-right: 1em;
        
    }
    #userAvatar{
        border-radius:20px;
        height: 36px;
        width: 36px;
    }
    .container::after{
        content: '';
        position: absolute;
        right: 2em;
        top:1.4em;
        border: 0.3em solid;
        border-color: white transparent transparent;
    }
    .container:hover::after{
        top:1em;
        border-color:transparent transparent white; /* 鼠标悬停时，让箭头向上 */
    }
</style>