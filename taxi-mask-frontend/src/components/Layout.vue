<template>
  <v-app id="inspire">
    <v-app-bar
      :clipped-left="$vuetify.breakpoint.lgAndUp"
      app
      color="primary"
      dark
    >
<!--      <v-app-bar-nav-icon @click.stop="drawer = !drawer" />-->

      <v-toolbar-title
        style="width: 350px"
      >
        <a href="/" class="white--text" style="text-decoration: none"><v-icon>mdi-truck</v-icon>&nbsp;Taxi Mask</a>
      </v-toolbar-title>
      <!-- <v-text-field
        flat
        solo-inverted
        hide-details
        prepend-inner-icon="mdi-magnify"
        label="Search"
        class="hidden-sm-and-down pl-10 ml-4"
      /> --> 
      <v-spacer />
      <v-btn v-if="!$store.state.auth.status.loggedIn" icon href="/register">
        <v-icon>mdi-account-circle</v-icon>
      </v-btn>

      <v-menu v-else open-on-hover offset-y>
          <template v-slot:activator="{ on }">
            <v-btn v-on="on">
             <v-icon>mdi-account-circle</v-icon>
            </v-btn>
          </template>
          <v-card
            class="mx-auto"
            max-width="344"
            outlined
          >

            <v-list-item>
              <v-list-item-title> {{$store.state.auth.user.username}}</v-list-item-title>
            </v-list-item>
            <v-divider inset></v-divider>
            <v-list-item>
              <v-list-item-title>
                <v-btn style="width:100%" href="/profile" @click="activeBtnOn(0)"  class="v-btn" >
                  <span>Profil</span>
                </v-btn> 
              </v-list-item-title>
            </v-list-item> 
            <v-list-item style="margin-bottom: 5%;">
               <v-list-item-title>
                <v-btn href="/mes-commandes" @click="activeBtnOn(0)"  class="v-btn" >
                  <span>Mes commandes</span>
                </v-btn> 
              </v-list-item-title> 
            </v-list-item>

          </v-card>
        </v-menu> 
      <v-btn  href="/cart" v-if="!$store.state.auth.status.loggedIn" icon>
        <v-badge
          :content="cardContent"
          :value="cardContent"
          color="green"
          overlap
        >
          <v-icon>mdi-cart</v-icon>
        </v-badge>
      </v-btn>
    </v-app-bar>
    <v-main>
      <v-bottom-navigation
        :value="activeBtn"
        color="primary"
        horizontal
      >
        <v-btn href="/" @click="activeBtnOn(0)"  class="v-btn" >
          <span>Home</span>
        </v-btn> 
        <v-btn href="/order" @click="activeBtnOn(1)"  class="v-btn">
          <span>Commander</span>
        </v-btn>
         
        <v-btn href="/" @click="activeBtnOn(2)">
          <span>Nous contacter</span>
        </v-btn>
        <v-menu  open-on-hover offset-y> 
          <template v-slot:activator="{ on }">
            <v-btn v-on="on" style="margin-left:40%">
              <span><img :src="require('../assets/img/fr.png')"/></span>
            </v-btn>
          </template>
          <v-card
            class="mx-auto"
            max-width="344"
            outlined
          >

            <v-list-item  
              href="#"
            >
              <v-list-item-titlef><img :src="require('../assets/img/fr.png')"/></v-list-item-titlef>
            </v-list-item>
            <v-list-item  
              href="#"
            >
              <v-list-item-title><img :src="require('../assets/img/us.png')"/></v-list-item-title>
            </v-list-item>

          </v-card>
        </v-menu>

      </v-bottom-navigation>
    </v-main>

      <router-view/>
    <v-footer
      :padless="true"
    >
      <v-card
        flat
        tile
        width="100%"
        class="secondary white--text text-center"
      >
        <v-card-text>
          <v-btn href="/" style="text-decoration:none"
            class="mx-4 white--text"
            icon
          >
            <v-icon size="24px">mdi-home</v-icon>
          </v-btn>
          <v-btn
            class="mx-4 white--text"
            icon
          >
            <v-icon size="24px">mdi-email</v-icon>
          </v-btn>
          <v-btn
            class="mx-4 white--text"
            icon
          >
            <v-icon size="24px">mdi-calendar</v-icon>
          </v-btn> 

        </v-card-text>

        <v-card-text class="white--text pt-0">
         </v-card-text>

        <v-divider></v-divider>

        <v-card-text class="white--text">
          {{ new Date().getFullYear() }} — <strong>Les 4mousqInfos</strong>
        </v-card-text>
      </v-card>
    </v-footer>
  </v-app>
</template>
<style>
  .v-item-group.v-bottom-navigation .v-btn.v-btn--active{
    background-color:#F7F7F7!important
  }
  .v-application--is-ltr .v-divider--inset:not(.v-divider--vertical) {
    margin-left: 0px;
  }
  .v-divider--inset:not(.v-divider--vertical) {
    max-width: calc(100% - 0px);
  }
</style>
<script>
import {CARD_CONTENT} from '../services/config-server';
    export default {
        data () {
            return { 
                activeBtn: 0,
                cardContent:0
            }
        }, 
        created(){
          this.cardContent =this.$store.state.order.cardContent 
          this.activeBtnOn(this.$route.path)
        },
        updated(){
           this.cardContent = localStorage.getItem(CARD_CONTENT)
           console.log('update'+this.cardContent)
           console.log('update'+this.$store.state.order.cardContent) 
           this.activeBtnOn(this.$route.path)
          
        },
        computed:{
          selectedBtn(){
            return ''
          }
        },
        methods:{
          on(){
            
          },
        activeBtnOn(path){
           switch(path){
            case '/':
              this.activeBtn=0
              break
            case '/order':
              this.activeBtn=1  
              break
            default:
              this.activeBtn=100
              break  
          }
        }

        }
    }
</script>
