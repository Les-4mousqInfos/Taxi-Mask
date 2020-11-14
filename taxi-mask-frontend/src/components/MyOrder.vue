<template>
  <div>
    <v-container >
      <p class="display-3 font-weight-light	text-center pa-4">Mes commandes</p>
      <v-row>
        <v-col :cols="12" md="12" sm="12"  >
            <v-data-table
              item-key="id"
              :headers="headers"
              class="elevation-1"
              :loading="loading" 
              :items="orderList"
              loading-text="Loading..."
            >

            <template   v-slot:item.voiture="{item}">
              <td>{{ item.name }}
                <v-list-item >
                  <v-list-item-avatar>
                    <v-img :src="require('../assets/img/cars/car.jpg')"></v-img>
                  </v-list-item-avatar>

                  <v-list-item-content>
                    <v-list-item-title >{{item.voiture.immatriculation}}</v-list-item-title>
                    <v-list-item-subtitle>{{item.voiture.modele}}</v-list-item-subtitle>
                    <v-list-item-subtitle>{{item.voiture.marque}}</v-list-item-subtitle>
                  </v-list-item-content>
                </v-list-item>
              </td>
              <td class="text-xs-right">{{ props.item.calories }}</td>
              <td class="text-xs-right">{{ props.item.fat }}</td>
              <td class="text-xs-right">{{ props.item.carbs }}</td>
              <td class="text-xs-right">{{ props.item.protein }}</td>
              <td class="text-xs-right">{{ props.item.iron }}</td>
              <td class="text-xs-right"></td>
            </template>
          
            </v-data-table>
         <!--    <v-simple-table>
            <template v-slot:default>
              <thead>
              <tr>
                <th class="text-center">Voiture</th> 
                <th class="text-center">Date</th>
                <th class="text-center">Etiquette</th>
                <th class="text-center">Protection</th>
                <th class="text-center">Prix</th>
                <th class="text-center">#</th>
              </tr>
              </thead>
              <tbody>
              <tr v-for="(item, key) in orderList" :key="key">
                <td>
                  <v-list-item
                  key="1" 
                >
                  <v-list-item-avatar>
                    <v-img :src="require('../assets/img/cars/car.jpg')"></v-img>
                  </v-list-item-avatar>

                  <v-list-item-content>
                    <v-list-item-title >{{item.voiture.immatriculation}}</v-list-item-title>
                    <v-list-item-subtitle>{{item.voiture.modele}}</v-list-item-subtitle>
                    <v-list-item-subtitle>{{item.voiture.marque}}</v-list-item-subtitle>
                  </v-list-item-content>
                </v-list-item></td>
                <td>12/11/2020</td>
                <td>{{item.etiquette}}</td>
                <td>{{item.typeProtection}}</td>
                
                
                <td>$80.00</td>
                <td>
                  <v-btn class="ma-2" small outlined fab color="teal"><v-icon>mdi-format-list-bulleted-square</v-icon></v-btn>
                </td>
              </tr> 
              </tbody>
            </template>
          </v-simple-table> -->
        </v-col>
         
      </v-row>
    </v-container>
 
  </div>
</template>
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
                value: 'voiture.immatriculation',
                 width: "20%"
              },
              { text: 'Date', align: 'start', value: 'createdAt' },
              { text: 'Etiquette', align: 'start', value: 'etiquette' },
              { text: 'Protection', align: 'start', value: 'typeProtection' },
              { text: 'Prix', align: 'start', value: 'prixProtection' },
              { text: '#',  align: 'start', sortable: false,},
            ],
            /* headers:[
               <thead>
              <tr>
                <th class="text-center">Voiture</th> 
                <th class="text-center">Date</th>
                <th class="text-center">Etiquette</th>
                <th class="text-center">Protection</th>
                <th class="text-center">Protection</th>
                <th class="text-center">#</th>
              </tr>
              </thead>
            ] */

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

