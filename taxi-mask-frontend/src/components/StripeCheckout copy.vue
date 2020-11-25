<template>
  <div>
    <v-container>
      <v-row>
        <v-col md="3"></v-col>
        <v-col :cols="12" md="6" sm="12" >
          <v-card elevation="2"   class="mx-auto my-12"
    max-width="374">
         <h1>Finaliser votre paiement</h1> 
          <v-form ref="form" name="form" @submit.prevent="handleRegister">
             <fieldset>
            <card
              class="stripe-card"
              :class='{ complete }'
              stripe='pk_test_CVgUwNSgxYgdf142oWjl8Fci00iSrKTdem'
              :options='stripeOptions'
              @change="change($event)"
            />

             <div
                v-if="errorMessage"
                id="card-errors"
                class="notification is-danger"
                style="color:#fff"
                v-text="errorMessage"
              />
            </fieldset>
            <!-- CSRF Field -->
            <input
              type="hidden"
              name="_token"
              :value="csrf"
            >

            <br>  

            <v-btn class='primary pay-with-stripe' @click='pay' :disabled='!complete'>Payer avec la carte</v-btn>
            
          </v-form>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </div>      
 
</template>

<script> 
import { Card, createToken } from 'vue-stripe-elements-plus'

export default {
  data () {
    return {
      complete: false,
      errorMessage: '',
      stripeOptions: {
        // see https://stripe.com/docs/stripe.js#element-options for details
      }
    }
  },

  components: { Card },
 data: () => ({ 
      complete: false,
       stripeOptions: {
        // see https://stripe.com/docs/stripe.js#element-options for details
        style: {
          base: {
            color: '#32325d',
            lineHeight: '18px',
            fontFamily: '"Raleway", Helvetica, sans-serif',
            fontSmoothing: 'antialiased',
            fontSize: '16px',
            '::placeholder': {
              color: '#aab7c4',
            },
          },
          invalid: {
            color: '#fa755a',
            iconColor: '#fa755a',
          },
        },
        hidePostalCode: true,
      },
    }),
  methods: {
    pay () {
      // createToken returns a Promise which resolves in a result object with
      // either a token or an error key.
      // See https://stripe.com/docs/api#tokens for the token object.
      // See https://stripe.com/docs/api#errors for the error object.
      // More general https://stripe.com/docs/stripe.js#stripe-create-token.
      createToken().then(data => console.log(data.token))
    },
    change(event) { 
      this.errorMessage = event.error ? event.error.message : ''
    },
  }
}
</script>

<style>
.stripe-card {
  width: 300px;
  border: 1px solid grey;
}
.stripe-card.complete {
  border-color: green;
}
</style>

 