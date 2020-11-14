<template>
  <div>
    <v-container>
      <div class="row"> 
        <div class="col-md-2"></div>
        <div class="col-md-8 col-sm-8 col-xs-12 card card-container">
          <v-form @submit.prevent="submit" onsubmit="return false;" ref="form" lazy-validation > 
          <div class="pl-6">
            <p class="display-1 mb-0">Paroi de protection</p>
            <v-card-actions class="pa-0">
              <p class="headline font-weight-light pt-3"></p>
              <v-spacer></v-spacer>
          <!--    <v-rating v-model="rating" class="" background-color="warning lighten-3"
                        color="warning" dense></v-rating> -->
              <span class="body-2	font-weight-thin"> </span>
            </v-card-actions>
            
            <p class="title">Trappe</p>
            <v-radio-group  required
            :rules="[v => !!v || 'Choisissez un trappe']"
             v-model="formu.trappe" row>
              <v-radio label="Avec trappe" value="w-trappe"></v-radio>
              <v-radio label="Sans trappe" value="s-trappe"></v-radio> 
            </v-radio-group>
            <p class="title">Type de protection</p>
            <v-radio-group required :rules="[v => !!v || 'Choisissez un type de protection']" v-model="formu.typeProtection" v-for="(item,id) in protections" :key="id">
              <v-radio :label="item.label" :value="item"></v-radio> 
            </v-radio-group> 
            
            <p class="title">Marque</p>
            <v-select   v-model="formu.voiture.marque"
                :items="marques" 
                item-text="label"
                item-value="id"
                :rules="[v=>!!v || 'Veuillez choisir un modèle']"
                label="Choisissez la marque"
                solo
              ></v-select>

            <p class="title">Modèle</p> 
            <v-text-field style="margin-top: -30px;"
              :rules="[v=>!!v || 'Veuillez choisir un modèle']" 
              v-model="formu.voiture.modele"
              hide-details="auto"
            ></v-text-field>
            <br>
            <p class="title">Immatriculation</p> 
            <v-text-field style="margin-top: -30px;"
              :rules="[v => !!v || 'Veuillez saisir le n° matricule du véhicule']"
               v-model="formu.voiture.immatriculation"
              hide-details="auto"
            ></v-text-field>
            <br>
            <p class="title">Date de première immatriculation</p> 
            <v-menu 
              ref="menu"
              :close-on-content-click="false"
              transition="scale-transition"
              offset-y
              min-width="290px"
            >
              <template v-slot:activator="{ on, attrs }">
                <v-text-field style="margin-top:-30px"
                  v-model="date" 
                  prepend-icon="mdi-calendar"
                  readonly
                  v-bind="attrs"
                  v-on="on"
                ></v-text-field>
              </template>
              <v-date-picker
                ref="picker"
                v-model="date"
                :max="new Date().toISOString().substr(0, 10)"
                min="1950-01-01" 
              ></v-date-picker>
            </v-menu>
            <br>
            <p class="title">Toit</p>
            <v-radio-group  required v-model="formu.toit"  row>
              <span v-for="(item,id) in toits" :key="id">
                <v-radio :label="item.label" :value="item.id"></v-radio> 
              </span>
            </v-radio-group> 
            <br>
            <p class="title">Etiquette</p>
            <v-radio-group  required v-model="formu.etiquette" row>
              <span v-for="(item,id) in toits" :key="id">
                <v-radio :label="item.label" :value="item.id"></v-radio>
              </span> 
            </v-radio-group> 
            <br>
            <div class="row">
              <div class="col-6">
                <p class="title">Photo de la carte grise</p>
                <v-file-input style="margin-top: -30px;"
                  show-size
                  truncate-length="15"
                ></v-file-input> 
              </div>
              <div class="col-6">
                <p class="title">Photo de la voiture</p>
                <v-file-input  style="margin-top: -30px;"
                  show-size
                  truncate-length="15"
                ></v-file-input> 
              </div>
            </div>
            <br>
            <div>
              <p class="title">Date de passage</p>
              <v-row>
                <div class="col-6">
                  <v-date-picker v-model="formu.datePassage"></v-date-picker>
                </div>
                <div class="col-6">
                  <v-time-picker
                    format="ampm" v-model="formu.timePassage"
                    ampm-in-title
                  ></v-time-picker>
                </div>
              
              </v-row>
            </div>

            <br>
              <v-btn type="submit" :disabled="loading"  class="primary white--text" outlined tile dense>
              <v-icon>mdi-cart</v-icon>Réserver maintenant</v-btn>
            <!--  <v-btn class="ml-4" outlined tile>ADD TO WISHLIST</v-btn> -->
          </div>
          </v-form>
         </div>
       
      </div> 
    </v-container>
   </div>
</template>
<script> 
import {CARD_LIST,CARD_CONTENT} from '../services/config-server';
    export default {
      components:{ 
      },
        data: () => ({ 
            message:'',
            isLoading:false,
            breadcrums: [
                {
                  text: 'Home',
                  disabled: false,
                  href: '/',
                },
                {
                  text: 'Commander',
                  disabled: true,
                  href: 'product',
                } 
            ],
            item: 1,
            protections: [
                {
                  id: 'partielle',
                  prix:180,
                  label: 'Partielle : Paroi de séparation partielle sur mesure , allant du niveau d\'accoudoir jusqu\'à plafond avec fixation sur les montant ( siège en mouvement libre) (€180,00)', 
                },
                {
                  id: 'totale',
                  prix:360,
                  label: 'Totale : Paroi de séparation hermétique sur mesure, en poli carbonate de 2 mm d\'épaisseur (€360,00)', 
                },
                 
            ],
            toits: [
                {
                  id: 'sans',
                  label: 'Sans', 
                },
                {
                  id: 'ouvrant',
                  label: 'Ouvrant'
                },
                {
                  id: 'panoramique',
                  label: 'Panoramique'
                },
                 
            ],
            etiquettes: [
                {
                  id: 'SANS',
                  label: 'Sans (€0.00)', 
                },
                {
                  id: 'M',
                  label: 'M(€12.00)'
                },
                {
                  id: 'XL',
                  label: 'XL(€12.00)'
                },
                 
            ],
            marques:[
              {
                id:1,
                label:'Toyota',
              },
              {
                id:2,
                label:'Honda',
              }
            ],
            rules: [
              value => !!value || 'Required.',
            ], 
            menu: false,
            date: null,
            picker: new Date().toISOString().substr(0, 10),
            formu:{voiture:{},photoCarteGrise:"",photoVoiture:""},
            loading:false
        }),
      watch: {
        menu (val) {
          val && setTimeout(() => (this.$refs.picker.activePicker = 'YEAR'))
        },
      }, 
      methods: { 
        async submit () { 
          this.loading = true
          this.formu.voiture.datePreimma = this.date
          if(!this.$refs.form.validate()){
            this.loading = false
            return
          } 
          this.formu.prixProtection = this.formu.typeProtection.prix
          this.formu.typeProtection = this.formu.typeProtection.id
          this.$store.dispatch('order/save', {...this.formu}).then( async res =>{ 
            
             console.log(res)
            if(res.status===200){ 
              let ids = res.data.id
              console.log(this.$store.state.order)
              const cards = this.$store.state.order.cards
              let cardContent =0
              if(cards!==null && cards!=='undefined'){
                ids = ids+','+cards
                cardContent = ids.split(',')
                cardContent = cardContent.length 
                await this.$store.commit('order/updateCard', cardContent)
                //console.log(this.$store.state.order.cards)
              }
              console.log(ids)
              await localStorage.setItem(CARD_LIST,ids);
              await localStorage.setItem(CARD_CONTENT,cardContent);
              this.$toasted.success('Commande enregistrée avec succès!').goAway(1200)
              setTimeout(() => {
                 this.loading=false
              }, 1000);
              setTimeout(() => {
                if(this.$store.state.auth.status.loggedIn){
                  this.$router.push('/mesCommandes')
                }else{
                  this.$router.push('/register')
                }
              }, 1500);
              
            }else{
              this.$toasted.error('Erreur d\'enregistrment, veuillez reessayer!').goAway(1200)
            }
            
          }).catch(err=>{
            console.log(err+'eeeeeeeee')
          // this.message = err.data.message 
            this.$toasted.error(err).goAway(1200)
            setTimeout(() => {
              this.loading =false
            }, 1000); 
          
          })
           
        },
        clear () { 
          this.formu={}
          this.$refs.form.reset()
        },

      },
    }
</script>
