<template>
  <div>
    <v-container >
      <p class="display-1 font-weight-light	text-center pa-2">Mes commandes</p>
      <v-row>
        <v-col :cols="12" md="12" sm="12"  >
            <v-data-table
              :headers="headers"
              class="elevation-1"
              :loading="loading" 
              :items="orderList"
              loading-text="Loading..."
              striped
            >
            
            <template  v-slot:item="{ item }">
              <tr>
              <td>
                <v-list-item >
                  <v-list-item-avatar>
                  <!--  <v-img :src="require('../assets/img/cars/car.jpg')"></v-img> -->
                    <v-img :src="'http://localhost:8080/'+item.photoVoitureFileName"></v-img>
                  </v-list-item-avatar>

                  <v-list-item-content>
                    <v-list-item-title >{{item.voiture.immatriculation}}</v-list-item-title>
                    <v-list-item-subtitle>{{item.voiture.marque}}</v-list-item-subtitle>
                    <v-list-item-subtitle>{{item.voiture.modele}}</v-list-item-subtitle>
                  </v-list-item-content>
                </v-list-item>
              </td>
              <td class="text-xs-right">{{item.createdAt|formatDate}}</td>
              <td class="text-xs-right">{{item.etiquette}}</td>
              <td class="text-xs-right">{{item.typeProtection}}</td>
              <td class="text-xs-right">{{item.prixProtection}}</td>
              <td class="text-xs-right">
                  <v-btn class="ma-2" small outlined fab color="teal"><v-icon>mdi-format-list-bulleted-square</v-icon></v-btn>
              </td> 
              </tr>
            </template>
             <template v-slot:no-data>
                <v-alert :value="true" color="error" icon="warning">
                  Aucune donnée :(
                </v-alert>
              </template>
          
            </v-data-table>
 
        </v-col>
         
      </v-row>
    </v-container>
 
  </div>
</template>
<style scoped>
 
  tbody tr:nth-of-type(odd) {
    background-color: rgba(0, 0, 0, .05);
  }
</style>
 
<script>
    export default {
        data: () => ({
            rating: 4.5,
            orderList: [],
            loading:true,
            headers: [
              {
                text: 'Voiture',
                align: 'start',
                sortable: false,
                value: 'voiture',
                 width: "20%"
              },
              { text: 'Date', align: 'start', value: 'createdAt' },
              { text: 'Etiquette', align: 'start', value: 'etiquette' },
              { text: 'Protection', align: 'start', value: 'typeProtection' },
              { text: 'Prix(€)', align: 'start', value: 'prixProtection' },
              { text: '#',  align: 'start', sortable: false,},
            ],
            

        }),
        computed: {
          loggedIn() {
            return this.$store.state.auth.status.loggedIn;
          },
          
        }, 
        mounted(){
          if (!this.loggedIn) {
            this.$router.push('/login');
            return
          }
          this.$store.dispatch('order/list').then( async res =>{ 
            setTimeout(() => {
              this.loading = false 
            }, 2000); 
            if(res.status===200){ 
              setTimeout(() => {
                this.orderList = [...res.data]
              }, 1500);
            
            }
          })
        }
    }
</script>

