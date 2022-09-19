<template>
  <div>
      <div v-if="this.$store.state.user.userInfo.companyid">
      <div class="white">当前所在公司</div>
      <el-card class="box-card">
        <div slot="header" class="clearfix">
            <span class="card-title">{{company.companyname}}</span>
            <el-button style="float: right; padding: 3px 0" type="text" @click="showQuitDlg(company.id,company.companyname)">申请离职</el-button>
        </div>
        
        <div class="text item">
            公司地址：{{company.companyaddress}}
        </div>
        <div class="text item">
            成立时间：{{company.companysettime}}
        </div>
        <div>
            <el-button v-if="isSigned==0"
                        @click.native.prevent="signIn"
                        type="primary"
                        size="small">签到</el-button>
                        <el-button
                        v-if="isSigned==1"
                        disabled
                        type="info"
                        size="small">已签到</el-button>
                        <el-button
                        v-if="isSigned==2"
                        disabled
                        type="info"
                        size="small">不用签到</el-button>
            <el-button v-if="$store.state.user.role=='master'" type="text" @click="showChangeInfoDlg">修改公司信息</el-button>            
        </div>
      </el-card>
        <div class="white"></div>
    </div>
    <div v-if="this.$store.state.user.role=='hr'||this.$store.state.user.role=='master'">
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
                <el-button @click.native="checkInfo(scope.row.id)">查看信息</el-button>
                <el-button
                v-if="$store.state.user.role=='master'||$store.state.user.role=='hr'" @click.native="checkWorkExp(scope.row.id)">查看工作经历</el-button>
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
                <el-button @click.native="checkInfo(scope.row.id)">查看信息</el-button>
                <el-button
                v-if="$store.state.user.role=='master'||$store.state.user.role=='hr'" @click.native="checkWorkExp(scope.row.id)">查看工作经历</el-button>
                <el-button
                v-if="$store.state.user.role=='master'&&scope.row.role!='hr'" @click.native="sethr(scope.row.id)">提升为hr</el-button>
                
            </template>
        </el-table-column>
        </el-table>
  </div>
    <el-dialog
        title="申请离职"
        :visible.sync="quitDlgVisible"
        width="30%"
        :before-close="handleClose">
        <span style="font-size:1.25em;">公司名称：{{company.companyname}}</span>
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
         <el-dialog
        title="用户信息"
        :visible.sync="workerDlgVisible"
        width="30%"
        :before-close="handleClose">
        <div class="bordtop">
          <div>
              <img :src="this.$host+workerInfo.photo" class="avatar" alt="">
          </div>
           <div class="bordcolumn">
               <div class="username">{{workerInfo.username}}</div>
               <div class="simpleinfo">年龄：{{workerInfo.age}}</div>
               <div class="simpleinfo">邮箱：{{workerInfo.email}}</div>
               <div class="simpleinfo">姓名：{{workerInfo.realname}}</div>
               <div class="simpleinfo">手机号：{{workerInfo.phone}}</div>
               <div class="simpleinfo">性别：{{workerInfo.sex}}</div>
               <div class="simpleinfo">身份证：{{workerInfo.identity}}</div>
               <div class="simpleinfo">生日：{{workerInfo.birthday}}</div>
               <a :href="this.$host+workerInfo.resume">下载简历</a>
           </div>
           
      </div>
      <el-table
            :data="signinlist"
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

            </el-table>
        </el-dialog>
         <el-dialog
        title="工作经历"
        :visible.sync="workexpDlgVisible"
        width="80%"
        :before-close="handleClose">
        <div class="container">
            <ul class="ulflex">
            <li v-if="works.length==0" class="white">暂无工作经历</li>
                <li v-for="(work,index) in works" :key="work.workid" class="liflex">
                <div class="white">工作经历{{works.length-index}}</div>
                    <el-card class="box-card">
                        <div slot="header" class="clearfix">
                        <span class="card-title">{{work.companyName}} <a href="#" @click="getAchieve(work.workid,work.companyName)">查看绩效考核</a></span>
                        </div>
                        <div class="text item">
                        工作状态：{{work.isend?'已结束':'就职中'}}
                        </div>
                        <div class="text item">
                            HR姓名：{{work.hrname}}
                        </div>
                        <div class="text item">
                            成立时间：{{work.hrid}}
                        </div>
                        <div class="text item">
                        开始时间：{{work.starttime}}
                        </div>
                        <div class="text item">
                        结束时间：{{work.endtime}}
                        </div>
                        <div class="text item">
                        评价：{{work.evaluation||'暂无'}}
                        </div>
                        <div class="text item" v-if="$store.state.user.userInfo.companyid==work.companyid&&!work.evaluation&&($store.state.user.role=='master'||$store.state.user.role=='hr')">
                            <el-button type="primary" @click="showWorkEstimateDlg">评价</el-button>
                        </div>
                </el-card>
                    
                </li>
            </ul>
            <div class="box-right" :class="{'notactive':active==0,'active':active==1}">
            <div class="white">绩效考核</div>
            <el-card>
            <div slot="header" class="clearfix">
                <span class="card-title">{{nowcompany}}</span>
                <el-button type="text" class="pubAchieveBtn" v-if="isnowwork&&$store.state.user.role=='master'" @click="showPubAchieveDlg(works[0].useid)">发布绩效</el-button>
            </div>
            <div v-if="this.achieves.length>0">
            <el-steps direction="vertical" :active="1">
                <el-step v-for="(achieve) in achieves" :key="achieve.achieveid">
                <template slot="title">
                    {{achieve.starttime+'~'+achieve.endtime+'   '+achieve.info}}
                    <el-button v-if="!achieve.score" @click="showEstimateDlg(achieve.achieveid)">评价绩效</el-button>
                </template>
                <template slot="description" class="info">
                    <div style="display:flex;">
                    <div style="color:#f40;margin:0.5em 0;">任务列表</div>
                    <el-button class="pubTaskBtn" type="text" v-if="isnowwork&&$store.state.user.role=='master'" @click="showPubTaskDlg(achieve.achieveid)">发布任务</el-button></div>
                        <el-collapse  v-for="(item,index) in achieve.taskList" :key="item.taskid" :v-model="item">
                            <el-collapse-item style="position:relative;">
                            <template slot="title">
                                {{(index+1)+'、'+item.info}}<i v-if="item.subline" class="header-icon righticon el-icon-success"></i>
                            </template>
                            <div>截止时间: {{item.deadline}}</div>
                            <div>提交时间: {{item.subline?item.subline:'未提交'}}</div>
                            <div style="color:#f00;">得分: {{item.score?item.score:'待评价'}}</div>
                          
                            <el-button class="done_btn" size="mini" v-if="$store.state.user.role=='master'&&!item.score" type="primary" @click="showScoreDlg(item.taskid)">打分</el-button>
                            </el-collapse-item>
                        </el-collapse>
                </template>
                </el-step>
            </el-steps>
            
      </div>
      
      <div v-else>暂无绩效</div>
    </el-card>
        <div style="display:flex;">
            <div class="white">重大事件</div>
            <el-button style="margin-left:auto;" size="mini" type="text" v-if="$store.state.user.role=='hr'" @click="showEventDlg(works[0].useid)">添加重大事件</el-button>
        </div>
        <el-card>
        
        <div v-if="this.events.length>0">
            <el-collapse  v-for="(item,index) in events" :key="item.eventid" :v-model="item">
                    <el-collapse-item style="position:relative;">
                        <template slot="title">
                        {{(index+1)+'、'+item.title}}
                        </template>
                        <div>事件内容: {{item.info}}</div>
                    </el-collapse-item>
                    </el-collapse>
        </div>
        <div v-else>暂无重大事件</div>
        </el-card>

    </div>
   
</div>
        </el-dialog>
        <el-dialog title="任务打分" width="30%" :visible.sync="scoreDlgVisible">
                <div class="lititle">打分：</div><el-input size="medium" v-model="taskscore" class="taskscore_input"></el-input>
                 <span slot="footer" class="dialog-footer">
                    <el-button @click="scoreDlgVisible = false">取 消</el-button>
                    <el-button type="primary" @click="giveScore(nowtaskid,taskscore)">确 定</el-button>
                </span>
            </el-dialog>
            <el-dialog title="评价绩效" width="30%" :visible.sync="achieveEstimateDlgVisible">
                <div class="lititle">打分：</div><el-input size="medium" v-model="achieveEstimateScore" class="taskscore_input"></el-input>
                <div class="lititle">评价：</div><el-input size="medium" v-model="achieveEstimateInfo" class="taskscore_input"></el-input>
                 <span slot="footer" class="dialog-footer">
                    <el-button @click="achieveEstimateDlgVisible = false">取 消</el-button>
                    <el-button type="primary" @click="estimateAchieve">确 定</el-button>
                </span>
            </el-dialog>
            <el-dialog title="发布绩效" width="30%" :visible.sync="pubAchieveDlgVisible">
                <div class="lititle">绩效标题：</div><el-input size="medium" v-model="pubAchieveInfo" class="taskscore_input"></el-input>
                <div class="lititle">起始时间：</div><el-input size="medium" v-model="pubAchieveStart" class="taskscore_input"></el-input>
                <div class="lititle">截止时间：</div><el-input size="medium" v-model="pubAchieveEnd" class="taskscore_input"></el-input>
                 <span slot="footer" class="dialog-footer">
                    <el-button @click="pubAchieveDlgVisible = false">取 消</el-button>
                    <el-button type="primary" @click="pubAchieve">确 定</el-button>
                </span>
            </el-dialog>
            <el-dialog title="发布任务" width="30%" :visible.sync="pubTaskDlgVisible">
                <div class="lititle">任务标题：</div><el-input size="medium" v-model="pubTaskInfo" class="taskscore_input"></el-input>
                <div class="lititle">截止时间：</div><el-input size="medium" v-model="pubTaskDeadline" class="taskscore_input"></el-input>
                 <span slot="footer" class="dialog-footer">
                    <el-button @click="pubTaskDlgVisible = false">取 消</el-button>
                    <el-button type="primary" @click="pubTask">确 定</el-button>
                </span>
            </el-dialog>
            <el-dialog title="添加重大事件" width="30%" :visible.sync="setEventDlgVisible">
                <div class="lititle">重大事件标题：</div><el-input size="medium" v-model="setEventTitle" class="taskscore_input"></el-input>
                <div class="lititle">重大事件内容：</div><el-input size="medium" v-model="setEventInfo" class="taskscore_input"></el-input>
                 <span slot="footer" class="dialog-footer">
                    <el-button @click="setEventDlgVisible = false">取 消</el-button>
                    <el-button type="primary" @click="setEvent">确 定</el-button>
                </span>
            </el-dialog>
            <el-dialog title="修改公司信息" width="30%" :visible.sync="changeInfoDlgVisible">
                <div class="lititle">公司名称：</div><el-input size="medium" v-model="changeInfoName" class="taskscore_input"></el-input>
                <div class="lititle">公司地址：</div><el-input size="medium" v-model="changeInfoAddress" class="taskscore_input"></el-input>
                <div class="lititle">公司创立时间：</div><el-input size="medium" v-model="changeInfoSettime" class="taskscore_input"></el-input>
                 <span slot="footer" class="dialog-footer">
                    <el-button @click="changeInfoDlgVisible = false">取 消</el-button>
                    <el-button type="primary" @click="changeInfo">确 定</el-button>
                </span>
            </el-dialog>
            <el-dialog title="评价工作经历" width="30%" :visible.sync="workEstimateDlgVisible">
                <div class="lititle">评价内容：</div><el-input size="medium" v-model="workEstimateContent" class="taskscore_input"></el-input>
                 <span slot="footer" class="dialog-footer">
                    <el-button @click="workEstimateDlgVisible = false">取 消</el-button>
                    <el-button type="primary" @click="setEvaluation">确 定</el-button>
                </span>
            </el-dialog>
  </div>
</template>

<script>
export default {
    name:'Mycompany',
    data:function(){
        return{
            company:{},
            quitDlgVisible:false,
            quitcontent:'',
            isSigned:0,
            listLoading1:true,
            listLoading2:true,
            workerlist:[],
            hrlist:[],
            workerInfo:{},
            workerDlgVisible:false,
            workexpDlgVisible:false,
            works:[],
            nowwork:0,
            nowcompanyid:0,
            nowachieve:0,
            taskscore:'',
            nowcompany:'',
            nowuserid:0,
            isnowwork:true,
            achieves:[],
            events:[],
            tasklist:[],
            signinlist:[],
            active:0,
            nowtaskid:0,
            scoreDlgVisible:false,
            achieveEstimateDlgVisible:false,
            achieveEstimateScore:'',
            achieveEstimateInfo:'',
            pubAchieveDlgVisible:false,
            pubAchieveInfo:'',
            pubAchieveStart:'',
            pubAchieveEnd:'',
            pubTaskDlgVisible:false,
            pubTaskInfo:'',
            pubTaskDeadline:'',
            setEventDlgVisible:false,
            setEventTitle:'',
            setEventInfo:'',
            changeInfoDlgVisible:false,
            changeInfoName:'',
            changeInfoAddress:'',
            changeInfoSettime:'',
            workEstimateDlgVisible:false,
            workEstimateContent:''
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

        if(this.$store.state.user.userInfo.companyid){
            let fd = new FormData()
            this.$axios.post('/api/user/checkSignIn',fd,{headers:{'token':this.$store.state.user.token}}).then((res)=>{
                console.log(res)
                that.isSigned = res.data.data.status
            })
        }
        this.queryworker()
        this.queryhr()
    },
    methods:{
        showQuitDlg:function(id,name){
            this.nowcompany = id
            this.nowcompanyname = name
            this.quitDlgVisible = true
        },
        showPubAchieveDlg:function(userid){
            console.log(this.works)
            this.nowuserid = userid
            this.pubAchieveDlgVisible = true
        },
        showPubTaskDlg:function(achieveid){
            this.nowachieve = achieveid
            this.pubTaskDlgVisible = true
        },
        showEstimateDlg:function(achieveid){
            this.nowachieve = achieveid
            this.achieveEstimateDlgVisible = true
        },
        showEventDlg:function(userid){
            this.nowuserid = userid
            this.setEventDlgVisible = true
        },
        showChangeInfoDlg:function(){
            this.changeInfoDlgVisible = true
        },
        showWorkEstimateDlg:function(){
            this.workEstimateDlgVisible = true
        },
        checkInfo:function(id){
            let that = this
            let fd = new FormData()
            fd.append('userId',id)
            this.$axios.post('/api/hr/getUserInfo',fd,{headers:{'token':this.$store.state.user.token}}).then((res)=>{
                console.log(res)
                that.workerInfo = res.data.data.user
                that.workerDlgVisible = true
            })
            this.$axios.post('/api/hr/UserSignIn',fd,{headers:{'token':this.$store.state.user.token}}).then((res)=>{
                console.log(res)
                that.signinlist = res.data.data.signins
            })
        },
        checkWorkExp:function(id){
            let that = this
            let fd = new FormData()
            fd.append('userId',id)
            this.$axios.post('/api/hr/getUserWork',fd,{headers:{'token':this.$store.state.user.token}}).then((res)=>{
                console.log(res)
                that.works = res.data.data.works.reverse()
                that.nowwork  = that.works[0].workid
                // that.workerInfo = res.data.data.user
                that.workexpDlgVisible = true
                that.nowuserid = res.data.data.works[0].useid
                that.nowcompanyid = res.data.data.works[0].companyid
            })
        },
        getAchieve:function(id,name){
            let that = this
            let fd = new FormData()
            fd.append('workId',id)
            this.$axios.post('/api/hr/getWorkAchieve',fd,{headers:{'token':this.$store.state.user.token}}).then((res)=>{
                console.log(res)
                that.active = 1
                that.achieves = res.data.data.achieves
                that.nowcompany = name
                if(id!=that.nowwork) that.isnowwork = false
                else that.isnowwork = true
            })
            this.$axios.post('/api/hr/getWorkEvent',fd,{headers:{'token':this.$store.state.user.token}}).then((res)=>{
                console.log(res)
                that.events = res.data.data.events
            })
        },
        pubAchieve:function(){
            let that = this
            console.log('userId'+this.nowuserid)
            let fd = new FormData()
            fd.append('userId',this.nowuserid)
            fd.append('info',this.pubAchieveInfo)
            fd.append('startTime',this.pubAchieveStart)
            fd.append('endTime',this.pubAchieveEnd)
            this.$axios.post('/api/master/setAchieve',fd,{headers:{'token':this.$store.state.user.token}}).then((res)=>{
                console.log(res)
                that.pubAchieveDlgVisible = false
            })
        },
        pubTask:function(){
            let that = this
            let fd = new FormData()
            fd.append('achieveId',this.nowachieve)
            fd.append('info',this.pubTaskInfo)
            fd.append('deadLine',this.pubTaskDeadline)
            this.$axios.post('/api/master/setTask',fd,{headers:{'token':this.$store.state.user.token}}).then((res)=>{
                console.log(res)
                that.pubTaskDlgVisible = false
                that.$message({
                    type:'success',
                    message:'发布成功，请刷新查看'
                })
            })
        },
        setEvent:function(){
            let that = this
            let fd = new FormData()
            fd.append('userId',this.nowuserid)
            fd.append('title',this.setEventTitle)
            fd.append('info',this.setEventInfo)
            this.$axios.post('/api/hr/setEvent',fd,{headers:{'token':this.$store.state.user.token}}).then((res)=>{
                console.log(res)
                that.setEventDlgVisible = false
                that.$message({
                    type:'success',
                    message:'添加成功，请刷新查看'
                })
            })
        },
        estimateAchieve:function(){
            let that = this
            let fd = new FormData()
            fd.append('achieveId',this.nowachieve)
            fd.append('score',this.achieveEstimateScore)
            fd.append('estimate',this.achieveEstimateInfo)
            this.$axios.post('/api/master/estimateAchieve',fd,{headers:{'token':this.$store.state.user.token}}).then((res)=>{
                console.log(res)
                that.achieveEstimateDlgVisible = false
                that.$message({
                    type:'success',
                    message:'评价成功，请刷新查看'
                })
            })
        },
        changeInfo:function(){
           let that = this
            let fd = new FormData()
            fd.append('companyNama',this.changeInfoName)
            fd.append('companyAddress',this.changeInfoAddress)
            fd.append('companySetTime',this.changeInfoSettime)
            this.$axios.post('/api/master/setCompany',fd,{headers:{'token':this.$store.state.user.token}}).then((res)=>{
                console.log(res)
                that.changeInfoDlgVisible = false
                that.$message({
                    type:'success',
                    message:'更新成功，请刷新查看'
                })
            }) 
        },
        setEvaluation:function(){
            let that = this
            let fd = new FormData()
            console.log(111)
            console.log(this.nowuserid)
            fd.append('userId',this.nowuserid)
            fd.append('evaluation',this.workEstimateContent)
            this.$axios.post('/api/hr/setEstimate',fd,{headers:{'token':this.$store.state.user.token}}).then((res)=>{
                console.log(res)
                that.workEstimateDlgVisible = false
                that.$message({
                    type:'success',
                    message:'评价成功，请刷新查看'
                })
            }) 
        },
        handleClose(done) {
            this.$confirm('确认关闭？')
            .then(() => {
                done();
            })
            .catch(_ => {console.log(_)});
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
        },
        signIn:function(){
            let that = this
            let fd = new FormData()
            this.$axios.post('/api/user/signIn',fd,{headers:{'token':this.$store.state.user.token}}).then((res)=>{
                console.log(res)
                that.isSigned = 1
            })
        },
        showScoreDlg(taskid){
            this.nowtaskid = taskid
            this.scoreDlgVisible = true
        },
        giveScore(taskid,score){
           
            if(parseInt(score)<0||parseInt(score)>100){
                this.$message({
                    type:'warning',
                    message:'请输入正确的分数'
                })
            }else{
                let that = this
                let fd = new FormData()
                fd.append('taskId',taskid)
                fd.append('score',parseInt(score))
                this.$axios.post('/api/master/scoreTask',fd,{headers:{'token':this.$store.state.user.token}}).then((res)=>{
                    console.log(res)
                    that.scoreDlgVisible = false
                })
            }
            
            
            
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
.title{
    margin: 1em 0;
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
  .username{
    font-size: 1.5em;
    text-align: left;
    margin-left: 2em;
    margin-bottom: 0.5em;
}
.avatar{
    display: block;
    width: 160px;
    height: 160px;
}
.simpleinfo{
    margin-left: 2em;
    text-align: left;
    /* font-size: 0.75em; */
}
.bordtop{
    display: flex;
    flex-direction: row;
}

.container{
  display: flex;
}
.white{
  margin: 1em 1em;
  text-align: left;
}
.text {
    font-size: 14px;
    text-align:left;
  }
.card-title{
    text-align:left;
    display: flex;
}
.card-title>a{
  margin-left: auto;
  text-decoration: none;
  color: #3479cc;
  font-size: 0.8em;
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
.box-card{
  /* width: 500px; */
  /* flex: 1 1 auto; */
  margin: 0 1em;
}
.ulflex{
  flex:1;
}
.righticon{
  margin-left: 0.5em;
}
.box-right{
  flex: 2;
  /* width: 1000px; */
  position: relative;
  margin: 0 3em;

}
.notactive{
  display:none
}
.active{
  display: blcok;
}
/deep/ .el-step__description{
  font-size: 0.8em;
}
/deep/ .el-collapse{
  border:none;
  /* margin-top: 0.5em; */
}
/deep/ .el-collapse-item__header{
  border: none;
  /* margin-top: 0.5em; */
}
/deep/ .el-step__description{
  padding-right: 0;
}
/deep/ .el-step__title.is-process{
  margin-top: 0.5em;
}

.done_btn{
  /* float: right; */
  position: absolute;
  right: 10px;
  bottom: 10px;
}
/deep/ .el-collapse-item__content{
  margin-left: 1.5em;
  padding-bottom: 0;
}
.taskScore_input{
    margin: 1em 0;
}
.pubAchieveBtn{
    position: absolute;
    right: 20px;
    top: 50px;
    /* bottom: 20px; */
}
.pubTaskBtn{
    margin-left:auto;
}
.info{
    position:relative;
}
.lititle{
    margin: 1em 0;
}
</style>