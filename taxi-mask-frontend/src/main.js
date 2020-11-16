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
import store from './store';
import 'bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import VeeValidate from 'vee-validate';
import { library } from '@fortawesome/fontawesome-svg-core';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';
import {
  faHome,
  faUser,
  faUserPlus,
  faSignInAlt,
  faSignOutAlt
} from '@fortawesome/free-solid-svg-icons';
// import 'material-design-icons-iconfont/dist/material-design-icons.css'

library.add(faHome, faUser, faUserPlus, faSignInAlt, faSignOutAlt);


Vue.config.productionTip = false 
Vue.use(VeeValidate);
Vue.component('font-awesome-icon', FontAwesomeIcon);
/* eslint-disable no-new */
new Vue({
    el: '#app',
    router,
    vuetify,
    store,
    components: {
        App
    },
    template: '<App/>'
})

