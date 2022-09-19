<template>
  <div>
    <el-table
      v-loading="listLoading"
      :data="applylist"
      element-loading-text="Loading"
      border
      stripe
      fit
      highlight-current-row>
        <el-table-column align="center" label="ID" width="95">
            <template slot-scope="scope">
                {{ scope.$index+1 }}
            </template>
        </el-table-column>
        <el-table-column align="center" label="公司名称" >
            <template slot-scope="scope">
                {{scope.row.companyid}}
            </template>
        </el-table-column>
        
        <el-table-column align="center" label="申请类型" >
            <template slot-scope="scope">
                {{applytype[scope.row.applytype-1]}}
            </template>
        </el-table-column>
        <el-table-column align="center" label="申请信息" >
            <template slot-scope="scope">
                {{scope.row.info}}
            </template>
        </el-table-column>
        <el-table-column align="center" label="受理人" >
            <template slot-scope="scope">
                {{scope.row.acceptor}}
            </template>
        </el-table-column>
        <el-table-column align="center" label="提交时间" >
            <template slot-scope="scope">
                {{scope.row.subtime}}
            </template>
        </el-table-column>
        <el-table-column align="center" label="申请结果" >
            <template slot-scope="scope">
                {{accepttype[scope.row.isaccept]}}
            </template>
        </el-table-column>
        </el-table>
  </div>
</template>

<script>
export default {
    name:'Myapply',
    data(){
        return{
            listLoading:true,
            applylist:[],
            accepttype:['未处理','同意','拒绝'],
            applytype:['离职','就职']
        }
    },
    created(){
        let that = this
        let fd = new FormData()
        this.$axios.post('/api/user/jobList',fd,{headers:{'token':this.$store.state.user.token}}).then((res)=>{
            console.log(res)
            that.applylist = res.data.data.applies
            that.listLoading = false
        })
    }
}
</script>

<style scoped>

</style>