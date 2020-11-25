<template>
  <stripe-checkout
    ref="checkoutRef"
    :pk="publishableKey"
    :items="items"
    :successUrl="successUrl"
    :cancelUrl="cancelUrl"
  >
    <template slot="checkout-button">
      <v-btn class="primary white--text mt-5" @click="checkout">{{title}}</v-btn>
    </template>
  </stripe-checkout>
</template>

<script>
import { StripeCheckout } from 'vue-stripe-checkout';
export default {
  components: {
    StripeCheckout
  },
  props:{
    title:String
  },
  data: () => ({
    loading: false,
    publishableKey: 'pk_test_CVgUwNSgxYgdf142oWjl8Fci00iSrKTdem',
    items: [
      {
        sku: 'prod_IQOh1AKyJc7ZR2', 
        quantity: 1
      }
    ],
    successUrl: 'https://staging.aidseafrica.org/',
    cancelUrl: 'https://staging.aidseafrica.org/',
  }),
  methods: {
    checkout () {
      this.$refs.checkoutRef.redirectToCheckout();
    }
  }
}
</script>