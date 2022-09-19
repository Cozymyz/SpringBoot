<template>
  <div class="app-container">
      
    <div class="white">公司列表</div>
        <div class="search-box">
            <el-input
                v-model="search"
                placeholder="请输入公司名称"
            />
            <div class="search-icon" @click="handleSearch()">
                <img src="@assets/search.png" alt="">   
            </div>
        </div>
      <el-table
      v-loading="listLoading"
      :data="companylist.slice((curPage-1)*pagesize,curPage*pagesize)"
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
        <el-table-column align="center" label="公司名称" >
            <template slot-scope="scope">
                {{scope.row.companyname}}
            </template>
        </el-table-column>
        <el-table-column align="center" label="公司地址" >
            <template slot-scope="scope">
                {{scope.row.companyaddress}}
            </template>
        </el-table-column>
        <el-table-column align="center" label="成立时间" >
            <template slot-scope="scope">
                {{scope.row.companysettime}}
            </template>
        </el-table-column>
        <el-table-column align="center" label="公司相册" width="450px">
            <template slot-scope="scope">
                <!-- {{scope.row.photolist}} -->
                <el-image v-for="item in scope.row.photoList" :key="item.id" :src="'http://chengbei.site:8080'+item.url" style="width: 80px; height: 80px; margin-left: 10px" :preview-src-list="scope.row.photoList" />
            </template>
        </el-table-column>
        <el-table-column align="center" label="操作" fixed="right" width="95" >
            <template slot-scope="scope">

                <el-button
                v-if="company.id!==scope.row.id"
                  @click.native.prevent="showApplyDlg(scope.row.id,scope.row.companyname)"
                  type="text"
                  size="small">申请入职</el-button>
                <el-button
                  v-else
                  @click.native.prevent="showQuitDlg(scope.row.id,scope.row.companyname)"
                  type="text"
                  size="small">申请离职</el-button>
                  
            </template>
        </el-table-column>
      </el-table>
      <el-pagination
        :current-page.sync="curPage"
        :page-size="pagesize"
        :pager-count="5"
        :total="companylist.length"
        background
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        layout="prev, pager, next">
        </el-pagination>
      <el-dialog
        title="申请入职"
        :visible.sync="applyDlgVisible"
        width="30%"
        :before-close="handleClose">
        <span style="font-size:1.25em;">公司名称：{{nowcompanyname}}</span>
        <div class="white"></div>
        <el-input
            type="textarea"
            :rows="5"
            placeholder="请输入申请内容"
            v-model="applycontent">
        </el-input>
        <span slot="footer" class="dialog-footer">
            <el-button @click="applyDlgVisible = false">取 消</el-button>
            <el-button type="primary" @click="applyJob">确 定</el-button>
        </span>
        </el-dialog>
        <el-dialog
        title="申请离职"
        :visible.sync="quitDlgVisible"
        width="30%"
        :before-close="handleClose">
        <span style="font-size:1.25em;">公司名称：{{nowcompanyname}}</span>
        <div class="white"></div>
        <el-input
            type="textarea"
            :rows="5"
            placeholder="请输入离职原因"
            v-model="quitcontent">
        </el-input>
        <span slot="footer" class="dialog-footer">
            <el-button @click="quitDlgVisible = false">取 消</el-button>
            <el-button type="primary" @click="quitJob">确 定</el-button>
        </span>
        </el-dialog>
  </div>
</template>

<script>
export default {
    name:'CompanyList',
    data(){
        return{
            companylist: [],
            listLoading: true,
            company:{},
            search: '',
            searchData: [],
            pagesize: 5,
            curPage: 1,
            nowcompany:0,
            nowcompanyname:'',
            applyDlgVisible:false,
            applycontent:'',
            quitDlgVisible:false,
            quitcontent:'',
            isSigned:false
        }
    },
    created(){
        let that = this
        
        this.$axios.post('/api/user/getAllCompany')
        .then((res)=>{
            console.log(res.data.data.companies)
            that.companylist = res.data.data.companies
            that.listLoading = false
        })

    },
    methods:{
        showApplyDlg:function(id,name){
            this.nowcompany = id
            this.nowcompanyname = name
            this.applyDlgVisible = true
        },
        showQuitDlg:function(id,name){
            this.nowcompany = id
            this.nowcompanyname = name
            this.quitDlgVisible = true
        },
        handleSearch:function() {
            let search  = this.search
            console.log(search)
            if(search){
                this.searchData = this.companylist.filter(value => value.companyname.indexOf(this.search) !== -1)
                console.log(this.searchData)
                this.companylist = this.searchData
            }else{
                this.$axios.post('/api/user/getAllCompany')
                .then((res)=>{
                    console.log(res.data.data.companies)
                    this.companylist = res.data.data.companies
                    this.listLoading = false
                })
            }
        },
        handleClose(done) {
            this.$confirm('确认关闭？')
            .then(() => {
                done();
            })
            .catch(_ => {console.log(_)});
        },
        applyJob(){
            let that = this
            let fd = new FormData()
            fd.append('submitTime',this.getNowDate())
            fd.append('companyId',this.nowcompany)
            fd.append('info',this.applycontent)
            this.$axios.post('/api/user/applyJob',fd,{headers:{'token':this.$store.state.user.token}}).then((res)=>{
                console.log(res)
                that.$message({
                    message: '申请成功',
                    type: 'success'
                })
                that.applyDlgVisible = false
            })
        },
        quitJob(){
            let that = this
            let fd = new FormData()
            fd.append('submitTime',this.getNowDate())
            fd.append('companyId',this.nowcompany)
            fd.append('info',this.quitcontent)
            this.$axios.post('/api/user/applyDimission',fd,{headers:{'token':this.$store.state.user.token}}).then((res)=>{
                console.log(res)
                that.$message({
                    message: '申请成功',
                    type: 'success'
                })
                that.quitDlgVisible = false
            })
        },
        handleSizeChange(val){
            this.pagesize = val
            this.$axios.post('/api/user/getAllCompany')
            .then((res)=>{
                console.log(res.data.data.companies)
                this.companylist = res.data.data.companies
                this.listLoading = false
            })
        },
        handleCurrentChange(val){
            this.curPage = val
            this.$axios.post('/api/user/getAllCompany')
            .then((res)=>{
                console.log(res.data.data.companies)
                this.companylist = res.data.data.companies
                this.listLoading = false
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
.text {
    font-size: 14px;
    text-align:left;
  }
.card-title{
    text-align:left;
}
  .item {
    margin-bottom: 18px;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both
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