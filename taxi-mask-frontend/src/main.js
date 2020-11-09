/* 
new Vue({
  render: h => h(App),
}).$mount('#app')
 */

// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import vuetify from '@/plugins/vuetify' // path to vuetify export
import App from './App'
import router from './router' 
import axios from 'axios'
import VueAxios from 'vue-axios'
import { LoaderPlugin } from 'vue-google-login';




// import 'material-design-icons-iconfont/dist/material-design-icons.css'
 
Vue.config.productionTip = false  

axios.defaults.withCredentials = true
Vue.use(VueAxios, axios)
Vue.use(LoaderPlugin, { client_id: 'CLIENT_ID' });
/* eslint-disable no-new */
new Vue({
    el: '#app',
    router,
    vuetify,
    components: {
        App
    },
    template: '<App/>'
})

