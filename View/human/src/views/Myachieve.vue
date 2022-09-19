<template>
    <div class="app-container">
123
    </div>
</template>
<script>
export default {
    name: 'Myachieve',
    data(){
        return{
            achievelist: [],
            achieve: {}
        }
    },
    created(){
        
    },
    methods:{
        getAchieve(workid){
            let fd = new FormData()
            fd.append('workId', workid)
            this.$axios.post('/api/user/getWorkAchieve', fd, {headers:{'token':this.$store.state.user.token}})
            .then((res) =>{
                console.log(res.data)
            })
        }
    }
}
</script>