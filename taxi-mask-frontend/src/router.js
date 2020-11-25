import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home' 
import Order from '@/components/Order'
import MyOrder from '@/components/MyOrder'
import Cart from '@/components/Cart'
import Layout from '@/components/Layout'
import Profile from '@/views/Profile'
import Login from '@/views/Login'
import Register from '@/views/Register'
import BoardAdmin from '@/views/BoardAdmin'
import BoardUser from '@/views/BoardUser'
import File from '@/components/File'
import StripePay from '@/components/StripePay';

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      component: Layout,
      children:[
        {
          path:'/',
          component:Home,
          name:'Home'
        },
        {
          path:'/order',
          component:Order,
          name:'Order'
        },
        {
          path:'/mes-commandes',
          component:MyOrder,
          name:'MyOrder'
        },
        {
          path:'/file',
          component:File,
          name:'File'
        },
        {
          path:'/check-pay',
          component:StripePay,
          name:'StripePay'
        },
        {
          path:'/cart',
          component:Cart,
          name:'Cart'
        },
        {
          path: '/login',
          component: Login
        },
        {
          path: '/register',
          component: Register
        },
        {
          path: '/profile',
          name: 'profile',
          // lazy-loaded
          component: Profile
        },
        {
          path: '/admin',
          name: 'admin',
          // lazy-loaded
          component: BoardAdmin
        },
        {
          path: '/user',
          name: 'user',
          // lazy-loaded
          component: BoardUser
        }
      ]

    }
  ],
    mode:'history'
},

  )
