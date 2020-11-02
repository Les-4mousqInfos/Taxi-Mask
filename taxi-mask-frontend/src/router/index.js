import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home' 
import Order from '@/components/Order'
import Cart from '@/components/Cart'
import Layout from '@/components/Layout'

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
          path:'/cart',
          component:Cart,
          name:'Cart'
        }
      ]

    }
  ],
    mode:'history'
},

  )
