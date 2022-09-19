import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css';
import 'normalize.css/normalize.css'
import router from './router'
import store from './store'
import '@components/global'
import axios from 'axios'
// import '@/styles/index.scss'

Vue.use(ElementUI)
Vue.prototype.$host = 'http://chengbei.site:8080'
Vue.prototype.$axios = axios
Vue.prototype.$axios.defaults.withCredentials = true
Vue.prototype.getNowDate = function () {
  const date_ = new Date()
  const Y = date_.getFullYear()
  const M = date_.getMonth() + 1
  const D = date_.getDate()

  const now_date = Y + '-' + M + '-' + D // eslint-disable-line no-unused-vars

  return now_date
}
Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
