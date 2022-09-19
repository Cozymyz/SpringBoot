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
        <el-button type="success" round @click.native.prevent="showAdd()">新增公司</el-button>
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
            <el-table-column align="center" label="成立时间" width="120px">
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
        </el-table>
        <el-pagination
            :current-page.sync="curPage"
            :page-size="pagesize"
            :pager-count="5"
            :total="companylist.length"
            background
            layout="prev, pager, next"
            style="margin-top:10px">
            </el-pagination>
        <el-dialog
        title="新增公司"
        :visible.sync="dialogVisible"
        :before-close="handleClose"
        width="30%">
            <el-form ref="addCompanyForm" :model="addCompanyForm" aria-autocomplete="on" label-position="left">
                <el-form-item prop="companyNama" label="CompanyName">

                    <el-input
                        ref="companyNama"
                        v-model="addCompanyForm.companyNama"
                        placeholder="CompanyName"
                        name="companyNama"
                        type="text"
                        />

                </el-form-item>

                <el-form-item prop="companyAddress" label="CompanyAddress">

                    <el-input
                        ref="companyAddress"
                        v-model="addCompanyForm.companyAddress"
                        placeholder="CompanyAddress"
                        name="companyAddress"
                        type="text"
                        />

                </el-form-item>

                <el-form-item prop="companySetTime" label="CompanySetTime">

                    <el-input
                        ref="companySetTime"
                        v-model="addCompanyForm.companySetTime"
                        placeholder="CompanySetTime"
                        name="companySetTime"
                        type="text"
                        />

                </el-form-item>
            </el-form>
            <el-button type="primary" @click.native.prevent="subAdd()">确 定</el-button>
        </el-dialog>
  </div>
</template>

<script>
export default {
    name:'AdminAllCompany',
    data(){
        return{
            addCompanyForm: {
                companyNama: '',
                companyAddress: '',
                companySetTime: ''
            },
            companylist: [],
            listLoading: true,
            search: '',
            searchData: [],
            pagesize: 5,
            curPage: 1,
            dialogVisible: false
        }
    },
    created(){
        this.getAllCompany()
    },
    methods:{
        getAllCompany:function(){
            this.$axios.post('/api/admin/allCompany')
            .then((res)=>{
                console.log(res.data.data.Companies)
                this.companylist = res.data.data.Companies
                this.listLoading = false
            })
        },
        subAdd:function(){
            let fd = new FormData
            fd.append('companyNama', this.addCompanyForm.companyNama)
            fd.append('companyAddress', this.addCompanyForm.companyAddress)
            fd.append('companySetTime', this.addCompanyForm.companySetTime)
            this.$axios.post('/api/admin/setCompany', fd).then((res) =>{
                console.log(res.data)
                if(res.data.status==400){
                    this.$message.error({
                        message: '新增公司失败'
                    })
                    this.listLoading = false
                }else if(res.data.status==200){
                    this.$message({
                        message: '新增成功',
                        type: 'success'
                    })
                    this.dialogVisible = false
                    this.getAllCompany()
                    this.listLoading =false
                }
            }).catch((error) => {
            console.log(error)
          })
        },
        showAdd:function(){
            this.dialogVisible = true
        },
        handleSearch:function() {
            let search  = this.search
            console.log(search)
            if(search){
                this.searchData = this.companylist.filter(value => value.companyname.indexOf(this.search) !== -1)
                console.log(this.searchData)
                this.companylist = this.searchData
            }else{
                this.$axios.post('/api/admin/allCompany')
                .then((res)=>{
                    console.log(res.data.data.Companies)
                    this.companylist = res.data.data.Companies
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