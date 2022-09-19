<template>
  <div>
      <div class="title">普通员工列表</div>
    <el-table
      v-loading="listLoading1"
      :data="workerlist"
      element-loading-text="Loading"
      border
      stripe
      fit
      highlight-current-row>
        <el-table-column align="center" label="ID" width="95">
            <template slot-scope="scope">
                {{ scope.row.id }}
            </template>
        </el-table-column>
        <el-table-column align="center" label="员工姓名" >
            <template slot-scope="scope">
                {{scope.row.realname}}
            </template>
        </el-table-column>
        
        <el-table-column align="center" label="员工电话" >
            <template slot-scope="scope">
                {{scope.row.phone}}
            </template>
        </el-table-column>
        <el-table-column align="center" label="员工身份" >
            <template slot-scope="scope">
                {{scope.row.role}}
            </template>
        </el-table-column>
        <el-table-column align="center" label="员工身份证" >
            <template slot-scope="scope">
                {{scope.row.identity}}
            </template>
        </el-table-column>
        <el-table-column align="center" label="操作" >
            <template slot-scope="scope">
                <el-button
                v-if="$store.state.user.role=='master'&&scope.row.role!='hr'" @click.native="sethr(scope.row.id)">提升为hr</el-button>
            </template>
        </el-table-column>
        </el-table>

        <div class="title">HR员工列表</div>
        <el-table
      v-loading="listLoading2"
      :data="hrlist"
      element-loading-text="Loading"
      border
      stripe
      fit
      highlight-current-row>
        <el-table-column align="center" label="ID" width="95">
            <template slot-scope="scope">
                {{ scope.row.id }}
            </template>
        </el-table-column>
        <el-table-column align="center" label="员工姓名" >
            <template slot-scope="scope">
                {{scope.row.realname}}
            </template>
        </el-table-column>
        
        <el-table-column align="center" label="员工电话" >
            <template slot-scope="scope">
                {{scope.row.phone}}
            </template>
        </el-table-column>
        <el-table-column align="center" label="员工身份" >
            <template slot-scope="scope">
                {{scope.row.role}}
            </template>
        </el-table-column>
        <el-table-column align="center" label="员工身份证" >
            <template slot-scope="scope">
                {{scope.row.identity}}
            </template>
        </el-table-column>
        <el-table-column align="center" label="操作" >
            <template slot-scope="scope">
                <el-button
                v-if="$store.state.user.role=='master'&&scope.row.role!='hr'" @click.native="sethr(scope.row.id)">提升为hr</el-button>
            </template>
        </el-table-column>
        </el-table>
  </div>
</template>

<script>
export default {
    name:'CompanyWorkerList',
    data:function(){
      return{
            listLoading1:true,
            listLoading2:true,
            workerlist:[],
            hrlist:[]
      }
    },
    created(){
      
      this.queryworker()
      this.queryhr()
    //   console.log(this.workerlist)
    },
    methods:{
        sethr:function(id){
            let fd = new FormData()
            let that = this
            fd.append('userId',id)
            this.$axios.post('/api/master/setHr',fd,{headers:{'token':this.$store.state.user.token}}).then((res)=>{
                console.log(res)
                that.queryworker()
                that.queryhr()
            })
        },
        queryworker:function(){
            let fd = new FormData()
            let that = this
            this.$axios.post('/api/hr/companyUser',fd,{headers:{'token':this.$store.state.user.token}}).then((res)=>{
                console.log(res)

                that.workerlist=res.data.data.users
                that.listLoading1 = false
            })
        },
        queryhr:function(){
            let fd1 = new FormData()
            let that = this
            fd1.append('workId',2)
            this.$axios.post('/api/hr/companyHr',fd1,{headers:{'token':this.$store.state.user.token}}).then((res)=>{
                console.log(res)
                that.hrlist=  res.data.data.users
                that.listLoading2 = false
            })
        }
    }
}
</script>

<style scoped>
.title{
    margin: 1em 0;
}
</style>