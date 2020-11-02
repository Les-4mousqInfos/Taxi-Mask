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
      <v-btn icon>
        <v-icon>mdi-account-circle</v-icon>
      </v-btn>
     <!--  <v-btn v-on="on" icon>
        <v-badge
          content="2"
          value="2"
          color="green"
          overlap
        >
          <v-icon>mdi-bell</v-icon>
        </v-badge>
      </v-btn> -->
      <v-btn v-on="on" href="/cart" icon>
        <v-badge
          content="2"
          value="2"
          color="green"
          overlap
        >
          <v-icon>mdi-cart</v-icon>
        </v-badge>
      </v-btn>
    </v-app-bar>
    <v-content>
      <v-bottom-navigation
        :value="activeBtn"
        color="primary"
        horizontal
      >
        <v-btn href="/" class="v-btn">
          <span>Home</span>
        </v-btn> 
        <v-btn href="/order" class="v-btn">
          <span>Commander</span>
        </v-btn>
         
        <v-btn href="/">
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
              @click=""
              href="#"
            >
              <v-list-item-titlef><img :src="require('../assets/img/fr.png')"/></v-list-item-titlef>
            </v-list-item>
            <v-list-item 
              @click=""
              href="#"
            >
              <v-list-item-title><img :src="require('../assets/img/us.png')"/></v-list-item-title>
            </v-list-item>

          </v-card>
        </v-menu>

      </v-bottom-navigation>
    </v-content>

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
          <v-btn
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
<style  scoped>
  
</style>
<script>
    export default {
        data () {
            return {
                items: [
                    { title: 'T-Shirts' },
                    { title: 'Jackets' },
                    { title: 'Shirts' },
                    { title: 'Jeans' },
                    { title: 'Shoes' },
                ],
                activeBtn: 1,
            }
        },
        methods:{
          on(){
            
          }
        }
    }
</script>
