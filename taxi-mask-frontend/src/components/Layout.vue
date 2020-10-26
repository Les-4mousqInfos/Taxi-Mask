<template>
  <v-app id="inspire">
   
    <v-content>
      <v-bottom-navigation
        :value="activeBtn"
        color="primary"
        horizontal
        style="height: 100;"
      >
        <v-spacer /> 
        
        <v-toolbar-title
          style="width: 350px;margin:1%"
        >
          <a href="/" class="white--text" style="text-decoration: none"><img :src="require('../assets/img/Taxi-Mask-On.png')"/></a>
        </v-toolbar-title>
        <div style="margin-top:3.2%">
          <a href="/" value="1" class="v-btn">
            <span>Accueil</span>
          </a>

          
        
          <a href="/" class="v-btn" style="margin-left:15px;margin-right:15px">
            <span>Nos réalisations</span>
          </a> 

          <a href="/" class="v-btn">
            <span>Nous contacter</span>
          </a>

        </div>
        
       
        <v-spacer /> 
        <!-- <v-btn icon>
          <v-icon>mdi-account-circle</v-icon>
        </v-btn> -->
         <div style="margin-top:3.2% ;margin-right:10px">
         
          <v-btn
            href="/shop"
            class="ma-2"
            outlined
            color="info"
          >
            Commander
          </v-btn>
        </div>
         <div style="margin-top:3.2%">
       <!--  <v-btn v-on="on" icon>
          <v-badge
            content="2"
            value="2"
            color="blue"
            overlap
          >
            <v-icon>mdi-bell</v-icon>
          </v-badge>
        </v-btn> -->
        
        <span>
          <v-badge
            content="2"
            value="2"
            color="blue"
            overlap
          >
            <v-icon>mdi-cart</v-icon>
          </v-badge>
        </span> 
         </div>
          <v-spacer /> 
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
