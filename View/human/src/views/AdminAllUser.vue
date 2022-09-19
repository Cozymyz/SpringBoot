<template>
    <div class="app-container">
        <div class="white">用户列表</div>
        <div class="search-box">
            <el-input
                v-model="search"
                placeholder="请输入用户名"
            />
            <div class="search-icon" @click="handleSearch()">
                <img src="@assets/search.png" alt="">   
            </div>
        </div>
        <el-button size="small" type="primary" @click.native.prevent="downloadExample">下载模板</el-button>
        <el-button size="small" type="primary" @click.native.prevent="downloadUser">下载用户表格</el-button>
        
        <el-upload
        action="#"
        :before-upload="beforeResumeUpload"
        :limit="1"
        style="width:90px">
        <el-button style="margin-bottom:10px" size="small" type="success">上传Excel</el-button>
        </el-upload>
        
        <el-table
        v-loading="listLoading"
        :data="userlist"
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

            <el-table-column align="center" label="Name">
                <template slot-scope="scope">
                    {{ scope.row.username }}
                </template>
            </el-table-column>

            <el-table-column align="center" label="Role">
                <template slot-scope="scope">
                    {{ scope.row.role }}
                </template>
            </el-table-column>

            <el-table-column align="center" label="Phone">
                <template slot-scope="scope">
                    {{ scope.row.phone }}
                </template>
            </el-table-column>

            <el-table-column align="center" label="Email">
                <template slot-scope="scope">
                    {{ scope.row.email }}
                </template>
            </el-table-column>

            <el-table-column align="center" label="Sex">
                <template slot-scope="scope">
                    {{ scope.row.sex }}
                </template>
            </el-table-column>

            <el-table-column align="center" label="Birthday">
                <template slot-scope="scope">
                    {{ scope.row.birthday }}
                </template>
            </el-table-column>

            <el-table-column align="center" label="Age">
                <template slot-scope="scope">
                    {{ scope.row.age }}
                </template>
            </el-table-column>

            <el-table-column align="center" label="Identity">
                <template slot-scope="scope">
                    {{ scope.row.identity }}
                </template>
            </el-table-column>

            <el-table-column align="center" label="Resume">
                <template slot-scope="scope">
                    {{ scope.row.resume }}
                </template>
            </el-table-column>

            <el-table-column align="center" label="State">
                <template slot-scope="scope">
                    <el-tag v-if="scope.row.ban==0">正常</el-tag>
                    <el-tag v-if="scope.row.ban==1" type="info" disabled>禁用</el-tag>
                </template>
            </el-table-column>

            <el-table-column align="center" label="Oprate">
                <template slot-scope="scope">
                    <el-button size="mini" v-if="scope.row.ban==0" type="info" @click.native.prevent="disableUser(scope.row.id)">禁用</el-button>
                    <el-button size="mini" v-if="scope.row.ban==1" type="success" @click.native.prevent="ableUser(scope.row.id)">解禁</el-button>
                </template>
            </el-table-column>

            <el-table-column align="center" label="SetMaster">
                <template slot-scope="scope">
                    <el-button size="mini" v-if="scope.row.ban==0" type="info" @click.native.prevent="selectCompany(scope.row.id)">设置主管</el-button>
                    <el-button v-if="scope.row.ban==1" type="text" disabled>禁用</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-pagination
            :current-page.sync="curPage"
            :page-size="pagesize"
            :pager-count="5"
            :total="total"
            background
            @prev-click="handlePrev"
            @next-click="handleNext"
            prev-text="上一页"
            next-text="下一页"
            layout="prev, next"
            style="margin-top:10px">
            </el-pagination>
        <el-dialog
        title="设置主管"
        :visible.sync="dialogVisible"
        :before-close="handleClose"
        width="30%">
            <el-table
            :data="companylist"
            element-loading-text="Loading"
            border
            stripe
            fit
            highlight-current-row
            @row-click="setMaster">
                <el-table-column align="center" label="点击公司完成设置" >
                    <template slot-scope="scope">
                        {{scope.row.companyname}}
                    </template>
                </el-table-column>
            </el-table>
        </el-dialog>
    </div>
</template>
<script>
export default {
    name: 'AdminAllUser',
    data(){
        return{
            adminUserForm:{
                userId: '',
                companyId: ''
            },
            userlist: [],
            companylist: [],
            listLoading: true,
            search: '',
            searchData: [],
            pagesize: 5,
            curPage: 1,
            total: 0,
            setuserId: '',
            dialogVisible: false
        }
    },
    created(){
        this.getUser()

        this.$axios.post('/api/admin/allCompany').then((res)=>{
            console.log(res.data.data.Companies)
            this.companylist = res.data.data.Companies
        })
    },
    methods:{
        getUser:function(){
            let fd = new FormData
            fd.append('pageNumber', this.curPage)
            fd.append('pageSize', this.pagesize)
            this.$axios.post('/api/admin/allUser', fd).then((res) =>{
                console.log(res.data)
                this.userlist = res.data.data.users
                this.total = res.data.data.allNumber
                this.listLoading = false
            })
        },
        handleSearch:function() {
            let search  = this.search
            console.log(search)
            if(search){
                this.searchData = this.userlist.filter(value => value.username.indexOf(this.search) !== -1)
                console.log(this.searchData)
                this.userlist = this.searchData
            }else{
                this.getUser()
            }
        },
        handleClose(done) {
            this.$confirm('确认关闭？')
            .then(() => {
                done();
            })
            .catch(_ => {console.log(_)});
        },
        handlePrev:function(){
            this.curPage-=1
            console.log(this.curPage)
            this.getUser()
        },
        handleNext:function(){
            this.curPage+=1
            console.log(this.curPage)
            this.getUser()
        },
        selectCompany:function(id){
            this.dialogVisible = true
            console.log(id)
            this.setuserId = id
        },
        setMaster:function(row){
            console.log(row.id)
            let setcomId = row.id
            let fd = new FormData
            fd.append('userId', this.setuserId)
            fd.append('companyId', setcomId)
            this.$axios.post('/api/admin/setMaster', fd).then((res) =>{
                console.log(res.data)
                if(res.data.status==400){
                    this.$message.error({
                        message: '设置主管失败'
                    })
                }else if(res.data.status==200){
                    this.$message({
                        message: '设置成功',
                        type: 'success'
                    })
                    this.dialogVisible = false
                    this.getUser()
                    this.listLoading = false
                }
            })
        },
        beforeResumeUpload(file) {
            let fd = new FormData
            fd.append('file', file)// 传文件
            this.$axios.post('/api/admin/uploadExcel', fd).then(function(res) {
                console.log(res.data)
                console.log(file)
                if(res.data.status==400){
                    this.$message.error({
                        message: '上传失败'
                    })
                }else if(res.data.status==200){
                    this.$message({
                        message: '上传成功',
                        type: 'success'
                    })
                    this.getUser()
                    this.listLoading = false
                }
            })
            return false// 屏蔽了action的默认上传
        },
        downloadExample:function(){
            // this.$axios.post('/api/admin/getExcelExample', {responseType: 'blob'}).then((res) =>{
            //     console.log(res.data)
            //     let a = document.createElement('a')
            //     let fileurl = window.URL.createObjectURL(new Blob([res.data.url]))
            //     a.style.display = 'none'
            //     a.href = fileurl
            //     a.setAttribute('download', "模板文件")
            //     a.click()
            // })
            let a = document.createElement('a')
            a.style.display = 'none'
            a.href = "http://chengbei.site:8080/resume/example.xls"
            a.click()
        },
        downloadUser:function(){
            const querystring = require("querystring")
            this.$axios.post('/api/admin/getUserExcel', querystring.stringify({}), {responseType: 'blob'}).then((res) =>{
                console.log(res)
                console.log(res.data)
                let a = document.createElement('a')
                let blob = new Blob([res.data], {type: 'application/vnd.ms-excel'})
                a.style.display = 'none'
                a.href = window.URL.createObjectURL(blob)
                a.setAttribute('download', '用户表格')
                a.click()
            })
        },
        disableUser:function(id){
            let fd = new FormData
            fd.append('userId', id)
            this.$axios.post('/api/admin/banUser', fd).then((res) =>{
                console.log(res.data)
                if(res.data.status==400){
                    this.$message.error({
                        message: '禁用失败'
                    })
                }else if(res.data.status==200){
                    this.$message({
                        message: '禁用成功',
                        type: 'success'
                    })
                    this.getUser()
                    this.listLoading = false
                }
            })
        },
        ableUser:function(id){
            let fd = new FormData
            fd.append('userId', id)
            this.$axios.post('/api/admin/disbanUser', fd).then((res) =>{
                console.log(res.data)
                if(res.data.status==400){
                    this.$message.error({
                        message: '解禁失败'
                    })
                }else if(res.data.status==200){
                    this.$message({
                        message: '解禁成功',
                        type: 'success'
                    })
                    this.getUser()
                    this.listLoading = false
                }
            })
        }
    }
}
</script>
<style scoped>

.white{
    /* height: 20px; */
    margin:1em 0;
    text-align:left;
}

  .search-box{
  display: flex;
  margin: 10px 0 10px 0;
  width: 260px;
  float: left;
}
.search-icon{
  width: 50px;
  height: 40px;
  padding: 0;
  border-top-right-radius: 8px;
  border-bottom-right-radius: 8px;
  float: left;
  background: #409EFF;
  cursor: pointer;
}
.search-icon img{
  width: 20px;
  height: 20px;
  margin-top: 11px;
  text-align: center;
  vertical-align: middle;
}

</style>