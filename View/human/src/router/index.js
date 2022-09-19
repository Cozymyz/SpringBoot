import Vue from 'vue'
import Router from 'vue-router'
import Cookies from 'js-cookie'
import Login from '@views/Login'
import Index from '@views/Index'
import CompanyList from '@views/Companylist'
import Myinfo from '@views/Myinfo'
import Myapply from '@views/Myapply'
import Workexp from '@views/Workexp'
import ApplyList from '@views/Applylist'
import Signin from '@views/SignIn'
import Mycompany from '@views/Mycompany'
import AdminAllUser from '@views/AdminAllUser'
import AdminAllCompany from '@views/AdminAllCompany'
Vue.use(Router)

const routes = [
  { path: '/login',name:'Login', component: Login },
  {
    path: '/index',name:'Index', component: Index,
    children: [
      { path: '/companylist', name:'CompanyList', component: CompanyList },
      { path: '/myinfo', name: 'Myinfo',component: Myinfo},
      { path: '/myapply', name: 'Myapply', component: Myapply },
      { path: '/workexp', name: 'Workexp',component: Workexp },
      { path: '/applylist', name: 'ApplyList',component: ApplyList },
      { path: '/signin', name: 'Signin',component: Signin},
      { path: '/mycompany', name: 'Mycompany',component: Mycompany},
      { path: '/adminalluser', name: 'AdminAllUser', component: AdminAllUser },
      { path: '/adminallcompany', name: 'AdminAllCompany', component: AdminAllCompany }
    ]
  },
]



const createRouter = () => new Router({
  // mode: 'history', // require service support
  scrollBehavior: () => ({ y: 0 }),
  routes
})

const router = createRouter()

router.beforeEach((to, from, next) => {
  if (to.path === '/login') return next();
  if (from.path === '/login') return next();
  const tokenStr = Cookies.get('humanres_token')
  if (!tokenStr) {
    return next('/login')
  }
  next()
})




export default router