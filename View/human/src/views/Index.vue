<template>
  <div>
    <header class="header"> <span>人事管理系统</span>
      <header-user class="headeruser" />
    </header>
    <el-container>
      <!-- 侧边栏 -->
      <el-aside :width="isCollapse ? '64px' : '200px'">
        <!-- <div class="toggle-button" @click="toggleCollapse">|||</div> -->
        <!-- 侧边栏菜单区域 -->
        <el-menu background-color="#333744" text-color="#fff" active-text-color="#409EFF" unique-opened :collapse="isCollapse" :collapse-transition="false" router>
             <el-menu-item v-if="this.$store.state.user.role=='admin'" index="/adminallcompany">公司列表</el-menu-item>
            <el-menu-item v-if="this.$store.state.user.role=='admin'" index="/adminalluser">用户列表</el-menu-item>
            <el-menu-item v-if="this.$store.state.user.role=='user' || this.$store.state.user.role=='hr'||this.$store.state.user.role=='master'" index='/companylist'>公司列表</el-menu-item>
            <el-menu-item v-if="this.$store.state.user.role=='user' || this.$store.state.user.role=='hr'||this.$store.state.user.role=='master'" index='/workexp'>工作经历</el-menu-item>
            <el-menu-item v-if="this.$store.state.user.role=='user' || this.$store.state.user.role=='hr'||this.$store.state.user.role=='master'" index='/myapply'>我的申请</el-menu-item>
            <el-menu-item v-if="this.$store.state.user.role=='user' || this.$store.state.user.role=='hr'||this.$store.state.user.role=='master'" index='/myinfo'>我的信息</el-menu-item>
            <el-menu-item v-if="this.$store.state.user.role=='user' || this.$store.state.user.role=='hr'||this.$store.state.user.role=='master'" index='/mycompany'>我的公司</el-menu-item>
            <el-menu-item v-if="this.$store.state.user.role=='user'||this.$store.state.user.role=='hr'" index='/signin'>我的签到</el-menu-item>
            <el-menu-item v-if="this.$store.state.user.role=='hr'||this.$store.state.user.role=='master'" index='/applylist'>申请列表</el-menu-item>
        </el-menu>
      </el-aside>
      <!-- 右侧内容主体 -->
      <el-main>
        <!-- 路由占位符 -->
        <router-view></router-view>
      </el-main>
    </el-container>
  </div>
</template>

<script>
export default {
  name: 'Index',
  data(){
    return{
      isCollapse: false,
    }
  },
  methods:{
    toggleCollapse() {
      this.isCollapse = !this.isCollapse
    },
  }
}
</script>

<style scoped>
  .header {
    background-color: #2c3e50;
    color: #fff;
    display:flex;
    flex-direction: row;
    padding: 0 2em;
    /* justify-content: flex-end; */
    /* text-align: center; */
    line-height: 40px;
  }
  .header>span{
    display: flex;
    font-size: 1.25em;
    align-items: center;
  }
  .headeruser{
    margin: 14px 0 14px auto;
  }
   /* .el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 160px;
  } */
  .main{
    display: flex;
    flex-direction: row;
  }
  /* .wrap{
    width: 200px;
    background-color:#2c3e50;
    color: #333;
    text-align: center;
} */
/* ul{
  padding-top: 1em;
}
li{
  color:#fff;
}
li+li{
  margin-top: 1em;
} */
</style>
