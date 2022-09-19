<template>
  <div>
      <el-tabs v-model="activeName" type="card" @tab-click="handleClick">
        <el-tab-pane label="求职" name="first">
            <div v-if="this.$store.state.user.role=='master'" class="title">HR求职列表</div>
            <el-table
            v-if="this.$store.state.user.role=='master'"
            v-loading="listLoading"
            :data="hr_applylist"
            element-loading-text="Loading"
            border
            stripe
            fit
            highlight-current-row>
                <el-table-column align="center" label="ID" width="95">
                    <template slot-scope="scope">
                        {{ scope.row.applyid }}
                    </template>
                </el-table-column>
                <el-table-column align="center" label="公司名称" >
                    <template slot-scope="scope">
                        {{scope.row.companyid}}
                    </template>
                </el-table-column>
                
                <el-table-column align="center" label="用户ID" >
                    <template slot-scope="scope">
                        {{scope.row.userid}}
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
                <el-table-column align="center" label="操作" >
                <template slot-scope="scope">
                    <el-button v-if="scope.row.isaccept==0" @click.native="pass_hr_apply(scope.row.applyid,scope.$index)">同意</el-button>
                    <el-button v-if="scope.row.isaccept==0" @click.native="reject_hr_apply(scope.row.applyid,scope.$index)">拒绝</el-button>
                    <el-button v-if="scope.row.isaccept!=0" disabled>已处理</el-button>
                </template>
            </el-table-column>
                </el-table>

                <div  class="title">User求职列表</div>
                <el-table
                v-if="this.$store.state.user.role=='hr'||this.$store.state.user.role=='master'"
                v-loading="listLoading"
                :data="user_applylist"
                element-loading-text="Loading"
                border
                stripe
                fit
                highlight-current-row>
                <el-table-column align="center" label="ID" width="95">
                    <template slot-scope="scope">
                        {{ scope.row.applyid }}
                    </template>
                </el-table-column>
                <el-table-column align="center" label="公司名称" >
                    <template slot-scope="scope">
                        {{scope.row.companyid}}
                    </template>
                </el-table-column>
                
                <el-table-column align="center" label="用户ID" >
                    <template slot-scope="scope">
                        {{scope.row.userid}}
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
                <el-table-column align="center" label="操作" >
                <template slot-scope="scope">
                    <el-button v-if="scope.row.isaccept==0" @click.native="pass_user_apply(scope.row.applyid,scope.$index)">同意</el-button>
                    <el-button v-if="scope.row.isaccept==0" @click.native="reject_user_apply(scope.row.applyid,scope.$index)">拒绝</el-button>
                    <el-button v-if="scope.row.isaccept!=0" disabled>已处理</el-button>
                </template>
            </el-table-column>
                </el-table>
        </el-tab-pane>
    <el-tab-pane label="离职" name="second">
        <div v-if="this.$store.state.user.role=='master'" class="title">HR离职列表</div>
        <el-table
        v-if="this.$store.state.user.role=='master'"
        v-loading="listLoading"
        :data="hr_quitlist"
        element-loading-text="Loading"
        border
        stripe
        fit
        highlight-current-row>
            <el-table-column align="center" label="ID" width="95">
                <template slot-scope="scope">
                    {{ scope.applyid }}
                </template>
            </el-table-column>
            <el-table-column align="center" label="公司名称" >
                <template slot-scope="scope">
                    {{scope.row.companyid}}
                </template>
            </el-table-column>
            
            <el-table-column align="center" label="用户ID" >
                <template slot-scope="scope">
                    {{scope.row.userid}}
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
            <el-table-column align="center" label="操作" >
                <template slot-scope="scope">
                    <el-button v-if="scope.row.isaccept==0" @click.native="pass_hr_quit(scope.row.applyid,scope.$index)">同意</el-button>
                    <el-button v-if="scope.row.isaccept==0" @click.native="reject_hr_quit(scope.row.applyid,scope.$index)">拒绝</el-button>
                    <el-button v-if="scope.row.isaccept!=0" disabled>已处理</el-button>

                </template>
            </el-table-column>
            </el-table>

            <div  class="title">User离职列表</div>
            <el-table
            v-if="this.$store.state.user.role=='hr'||this.$store.state.user.role=='master'"
            v-loading="listLoading"
            :data="user_quitlist"
            element-loading-text="Loading"
            border
            stripe
            fit
            highlight-current-row>
            <el-table-column align="center" label="ID" width="95">
                <template slot-scope="scope">
                    {{ scope.row.applyid }}
                </template>
            </el-table-column>
            <el-table-column align="center" label="公司名称" >
                <template slot-scope="scope">
                    {{scope.row.companyid}}
                </template>
            </el-table-column>
            
            <el-table-column align="center" label="用户ID" >
                <template slot-scope="scope">
                    {{scope.row.userid}}
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
             <el-table-column align="center" label="操作" >
                <template slot-scope="scope">
                    <el-button v-if="scope.row.isaccept==0" @click.native="pass_user_quit(scope.row.applyid,scope.$index)">同意</el-button>
                    <el-button v-if="scope.row.isaccept==0" @click.native="reject_user_quit(scope.row.applyid,scope.$index)">拒绝</el-button>
                    <el-button v-if="scope.row.isaccept!=0" disabled>已处理</el-button>

                </template>
            </el-table-column>
        </el-table>
        </el-tab-pane>
  </el-tabs>
    
  </div>
</template>

<script>
export default {
    name:'ApplyList',
    data:function(){
      return{
            listLoading:true,
            hr_applylist:[],
            user_applylist:[],
            hr_quitlist:[],
            user_quitlist:[],
            accepttype:['未处理','同意','拒绝'],
            applytype:['离职','就职'],
            activeName: 'first'
      }
    },
    created(){
      let fd = new FormData()
      let that = this
      this.$axios.post('/api/hr/jobList',fd,{headers:{'token':this.$store.state.user.token}}).then((res)=>{
        console.log(res.data.data.applies)
        that.user_applylist = res.data.data.applies
        that.listLoading = false
      })
      if(this.$store.state.user.role=='master'){
          this.gethr_applylist()
      }
    },
    methods:{
        handleClick(tab, event) {
            console.log(tab, event);
            let fd = new FormData()
            let that = this
            this.$axios.post('/api/hr/dimissionList',fd,{headers:{'token':this.$store.state.user.token}}).then((res)=>{
                console.log(res.data.data.applies)
                that.user_quitlist = res.data.data.applies
                that.listLoading = false
            })
        },
        gethr_applylist(){
             let fd = new FormData()
            let that = this
            this.$axios.post('/api/master/jobList',fd,{headers:{'token':this.$store.state.user.token}}).then((res)=>{
                console.log(res.data.data.applies)
                that.hr_applylist = res.data.data.applies
                that.listLoading = false
            })
        },
        gethr_quitlist(){
            let fd = new FormData()
            let that = this
            this.$axios.post('/api/master/dimissionList',fd,{headers:{'token':this.$store.state.user.token}}).then((res)=>{
                console.log(res.data.data.applies)
                that.hr_quitlist = res.data.data.applies
                that.listLoading = false
            })
        },
        pass_hr_apply(applyid){
            let fd = new FormData()
            // let that = this
            fd.append('applyId',applyid)
            fd.append('isAccept',1)
            this.$axios.post('/api/master/job',fd,{headers:{'token':this.$store.state.user.token}}).then((res)=>{
                console.log(res)

            })
        },
        reject_hr_apply(applyid){
            let fd = new FormData()
            // let that = this
            fd.append('applyId',applyid)
            fd.append('isAccept',2)
            this.$axios.post('/api/master/job',fd,{headers:{'token':this.$store.state.user.token}}).then((res)=>{
                console.log(res)

            })
        },
        pass_user_apply(applyid){
            let fd = new FormData()
            // let that = this
            fd.append('applyId',applyid)
            fd.append('isAccept',1)
            this.$axios.post('/api/hr/job',fd,{headers:{'token':this.$store.state.user.token}}).then((res)=>{
                console.log(res)

            })
        },
        reject_user_apply(applyid){
            let fd = new FormData()
            // let that = this
            fd.append('applyId',applyid)
            fd.append('isAccept',2)
            this.$axios.post('/api/hr/job',fd,{headers:{'token':this.$store.state.user.token}}).then((res)=>{
                console.log(res)

            })
        },
        pass_hr_quit(applyid){
            let fd = new FormData()
            // let that = this
            fd.append('applyId',applyid)
            fd.append('isAccept',1)
            this.$axios.post('/api/master/demission',fd,{headers:{'token':this.$store.state.user.token}}).then((res)=>{
                console.log(res)

            })
        },
        reject_hr_quit(applyid){
            let fd = new FormData()
            // let that = this
            fd.append('applyId',applyid)
            fd.append('isAccept',2)
            this.$axios.post('/api/master/demission',fd,{headers:{'token':this.$store.state.user.token}}).then((res)=>{
                console.log(res)

            })
        },
        pass_user_quit(applyid,index){
            let fd = new FormData()
            let that = this
            fd.append('applyId',applyid)
            fd.append('isAccept',1)
            this.$axios.post('/api/hr/demission',fd,{headers:{'token':this.$store.state.user.token}}).then((res)=>{
                console.log(res)
                that.user_quitlist[index].isaccept=1
            })
        },
        reject_user_quit(applyid){
            let fd = new FormData()
            // let that = this
            fd.append('applyId',applyid)
            fd.append('isAccept',2)
            this.$axios.post('/api/hr/demission',fd,{headers:{'token':this.$store.state.user.token}}).then((res)=>{
                console.log(res)

            })
        },
    }
}
</script>

<style scoped>
.title{
  margin: 1em 0;
}
</style>