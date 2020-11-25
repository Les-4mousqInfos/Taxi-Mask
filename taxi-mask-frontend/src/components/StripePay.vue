<template>
  <div>
    <form action='http://localhost:8000/payment/charge-card' method='POST' id='checkout-form' >
    <input type='hidden' :value='putAmount' name='amount' /> 
    <script type="application/javascript"
            src='https://checkout.stripe.com/checkout.js'
            class='stripe-button'
            :data-key='publicKey'
            :data-amount='amount'
            data-currency='eur'
            :data-label='btnLabel'
            data-name='Taxi Mask - Commande'
            data-description='Paroi de protection'
            :data-image='require(`../assets/img/logo.png`)'
            data-locale='auto'
            data-zip-code='false'>
            
    </script>
</form>
  </div>
</template>
<style  >

 .stripe-button-el{ 
    background: #2d3753 !important;
    border-color: #2d3753 !important;
 }
 .stripe-button-el span{
   background: #2d3753 !important;
 }
</style>
<script>  
export default {
  props:{
    amount: String
  },
   data() {
        return { 
          publicKey:'',
          btnLabel:'Payer avec une carte'
        }
    },
    computed: {
      putAmount(){ 
        return parseFloat(this.amount)/100
      },
       
    },
    created(){
      this.$store.dispatch('payment/getStripePublicKey').then( async res =>{ 
        this.publicKey =  res.data
      }).catch(err=>{
        alert(err)
      })
    },
    methods: {
        
    },
    
}
</script>