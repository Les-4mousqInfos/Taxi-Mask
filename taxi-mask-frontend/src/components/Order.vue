<template>
  <div>
    <v-container>
      <div class="row">
        <div class="col-md-5 col-sm-5 col-xs-12">
          <v-carousel>
            <v-carousel-item
              :src="require('../assets/img/home/slider1.jpg')"
            >
            </v-carousel-item>
            <v-carousel-item
              :src="require('../assets/img/home/slider2.jpg')"
            >
            </v-carousel-item>
           

          </v-carousel>
        </div>
        <div class="col-md-7 col-sm-7 col-xs-12">
          <v-breadcrumbs class="pb-0" :items="breadcrums"></v-breadcrumbs>
          <div class="pl-6">
            <p class="display-1 mb-0">Paroi de protection</p>
            <v-card-actions class="pa-0">
              <p class="headline font-weight-light pt-3">$360.00</p>
              <v-spacer></v-spacer>
           <!--    <v-rating v-model="rating" class="" background-color="warning lighten-3"
                        color="warning" dense></v-rating> -->
              <span class="body-2	font-weight-thin"> 2</span>
            </v-card-actions>
            
            <p class="title">Trappe</p>
            <v-radio-group required v-model="row" row>
              <v-radio label="Avec trappe" value="w-trappe"></v-radio>
              <v-radio label="Sans trappe" value="s-trappe"></v-radio> 
            </v-radio-group>
            <p class="title">Type de protection</p>
            <v-radio-group required v-model="row" v-for="(item,id) in protections" :key="id">
              <v-radio :label="item.label" :value="item.id"></v-radio> 
            </v-radio-group> 
            
            <p class="title">Marque</p>
             <v-select
                :items="items"
                label="Choisissez la marque"
                solo
              ></v-select>

            <p class="title">Modèle</p> 
            <v-text-field style="margin-top: -30px;"
              :rules="rules"
              hide-details="auto"
            ></v-text-field>
            <br>
            <p class="title">Immatriculation</p> 
            <v-text-field style="margin-top: -30px;"
              :rules="rules"
              hide-details="auto"
            ></v-text-field>
            <br>
            <p class="title">Date de première immatriculation</p> 
            <v-menu 
              ref="menu"
              v-model="menu"
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
                @change="save"
              ></v-date-picker>
            </v-menu>
            <br>
            <p class="title">Toit</p>
            <v-radio-group  required v-model="row"  row>
              <span v-for="(item,id) in toits" :key="id">
                <v-radio :label="item.label" :value="item.id"></v-radio> 
              </span>
            </v-radio-group> 
            <br>
            <p class="title">Etiquette</p>
            <v-radio-group  required v-model="row" row>
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
                <v-file-input style="margin-top: -30px;"
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
                  <v-date-picker v-model="picker"></v-date-picker>
                </div>
                <div class="col-6">
                  <v-time-picker
                    format="ampm"
                    ampm-in-title
                  ></v-time-picker>
                </div>
               
              </v-row>
            </div>

            <br>
            <v-btn class="primary white--text" outlined tile dense><v-icon>mdi-cart</v-icon>Réserver maintenant</v-btn>
            <!--  <v-btn class="ml-4" outlined tile>ADD TO WISHLIST</v-btn> -->

          </div>

        </div>
      </div> 
    </v-container>
   </div>
</template>
<script>
    export default {
        data: () => ({
            rating:4.5,
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
                  label: 'Partielle : Paroi de séparation partielle sur mesure , allant du niveau d\'accoudoir jusqu\'à plafond avec fixation sur les montant ( siège en mouvement libre) (€180,00)', 
                },
                {
                  id: 'totale',
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
            rules: [
              value => !!value || 'Required.',
            ], 
            menu: false,
            date: null,
            picker: new Date().toISOString().substr(0, 10),

        }),
      watch: {
        menu (val) {
          val && setTimeout(() => (this.$refs.picker.activePicker = 'YEAR'))
        },
      },
      methods: {
        save (date) {
          this.$refs.menu.save(date)
        },
      },
    }
</script>
