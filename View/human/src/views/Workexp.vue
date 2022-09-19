<template>
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
          </el-card>
            
        </li>
    </ul>
    <div class="box-right" :class="{'notactive':active==0,'active':active==1}">
      <div class="white">绩效考核</div>
       <el-card>
      <div slot="header" class="clearfix">
        <span class="card-title">{{nowcompany}}</span>
      </div>
      <div v-if="this.achieves.length>0">
       <el-steps direction="vertical" :active="1">
        <el-step v-for="(achieve,ach_index) in achieves" :key="achieve.achieveid" :title="achieve.starttime+'~'+achieve.endtime+'   '+achieve.info">
          <template slot="description" class="info">
              <div style="color:#f40;margin:0.5em 0;">任务列表</div>
                  <el-collapse  v-for="(item,index) in achieve.taskList" :key="item.taskid" :v-model="item">
                    <el-collapse-item style="position:relative;">
                      <template slot="title">
                        {{(index+1)+'、'+item.info}}<i v-if="item.subline" class="header-icon righticon el-icon-success"></i>
                      </template>
                      <div>截止时间: {{item.deadline}}</div>
                      <div>提交时间: {{item.subline?item.subline:'未提交'}}</div>
                      <div style="color:#f00;">得分: {{item.score?item.score:'待评价'}}</div>
                      <el-button class="done_btn" size="small" v-if="!item.subline" type="primary" @click="done_task(item.taskid,ach_index,index)">完成</el-button>
                    </el-collapse-item>
                  </el-collapse>
          </template>
        </el-step>

      </el-steps>
      </div>
      <div v-else>暂无绩效</div>
    </el-card>
    <div class="white">重大事件</div>
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
</template>

<script>

export default {
  name: 'Workexp',
  data(){
    return{
        works:[],
        active:0,
        nowcompany:'',
        achieves:[],
        tasklist:[],
        events:[]
    }
  },
  computed: {
    
  },
  created(){
      const fd = new FormData()
      let that =  this
      this.$axios.post('/api/user/getSelfWork',fd,{headers:{'token':this.$store.state.user.token}})
      .then((res)=>{
          console.log(res.data.data.works)
          that.works = res.data.data.works.reverse()
      }).catch((error)=>{
          console.log(error)
      })

      
  },
  methods:{
    getAchieve(id,name){
      let that = this 
      console.log(id)
      let fd = new FormData()
      fd.append('workId',id)
      this.$axios.post('/api/user/getWorkAchieve',fd,{headers:{'token':this.$store.state.user.token}}).then((res)=>{
        console.log(res)
        that.active = 1
        that.achieves = res.data.data.achieves
        that.nowcompany = name

      })
      this.$axios.post('/api/user/getWorkEvent',fd,{headers:{'token':this.$store.state.user.token}}).then((res)=>{
        console.log(res)
        that.events = res.data.data.events
      })
    },
    done_task(taskId,ach_index,index){
      let that = this
      let fd =  new FormData()
      fd.append('taskId',taskId)
      fd.append('submitTime',this.getNowDate())
      this.$axios.post('/api/user/subTask',fd,{headers:{'token':this.$store.state.user.token}}).then((res)=>{
        console.log(res)
        that.achieves[ach_index].taskList[index].subline =  this.getNowDate()
      })
  
      // console.log(this.achieves[ach_index].taskList[index].score)
    }
  }
}
</script>

<style scoped>
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
.singletask{
  /* margin: 0.5em 0; */
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
</style>
