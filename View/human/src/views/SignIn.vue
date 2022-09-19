<template>
    <div class="app-container">
        <div v-if="this.$store.state.user.userInfo.companyid">
            <div class="conpanyname">{{company.companyname}}</div>
            <el-table
            v-loading="listLoading"
            :data="signinlist"
            element-loading-text="Loading"
            border
            stripe
            fit
            highlight-current-row>

                <el-table-column align="center" label="ID">
                    <template slot-scope="scope">
                        {{scope.row.signinid}}
                    </template>
                </el-table-column>

                <el-table-column align="center" label="Date">
                    <template slot-scope="scope">
                        {{scope.row.daytime}}
                    </template>
                </el-table-column>

                <el-table-column align="center" label="Attend">
                    <template slot-scope="scope">
                         {{scope.row.attend==1?'已签到':'未签到'}}
                    </template>
                </el-table-column>

                <el-table-column align="center" label="操作" fixed="right" width="95" >
                    <template slot-scope="scope">

                        <el-button
                        v-if="scope.row.attend==0"
                        @click.native.prevent="signIn"
                        type="primary"
                        size="small">签到</el-button>
                        <el-button
                        v-if="scope.row.attend==1"
                        disabled
                        type="info"
                        size="small">已签到</el-button>
                        
                    </template>
                </el-table-column>
            </el-table>
        </div>
        <div v-else>
            暂无任职
        </div>
    </div>
</template>
<script>
export default {
    name:'Signin',
    data(){
        return{
            listLoading: true,
            company:{},
            signinlist:[]
        }
    },
    created(){
        let that = this
        if(this.$store.state.user.userInfo.companyid){
            let fd = new FormData()
            fd.append('companyId',this.$store.state.user.userInfo.companyid)
            this.$axios.post('/api/user/getCompanyInfo',fd,{headers:{'token':this.$store.state.user.token}})
            .then((res)=>{
                console.log(res)
                that.company = res.data.data.company
            })
        }

        this.getSignIn()
    },
    methods:{
        getSignIn(){
            this.$axios.post('/api/user/UserSignIn', new FormData, {headers:{'token':this.$store.state.user.token}}).then((res) =>{
                console.log(res.data)
                console.log(res.data.data.signins)
                this.signinlist = res.data.data.signins
                this.listLoading = false
            })
        },

        signIn(){
            this.$axios.post('/api/user/signIn', new FormData, {headers:{'token':this.$store.state.user.token}}).then((res) =>{
                console.log(res.data)
                if(res.data.status==200){ 
                    this.getSignIn()
                }else{
                    this.$message.error({
                        message:'签到失败'
                    })
                }
            })
        }
    }
}
</script>