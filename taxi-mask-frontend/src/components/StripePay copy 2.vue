<template>
  <div>
    <form id="payment-form" class="w-75 px-5 d-flex flex-column align-items-center" >
        <div ref="cardNumber" class="form-control m-2"></div>
        <div ref="cardExpiry" class="form-control m-2"></div>
        <div ref="cardCvc" class="form-control m-2"></div>
        <input :disabled="lockSubmit" class="btn btn-primary shadow-sm" type="submit" value="Donate" v-on:click.prevent="purchase" />
 
        <div class="stripe-element-container"  id= "cardNumber" ref="cardNumber"></div>
  
        <div class="side-by-side">
            <div class="stripe-element-container" id="cardExpiry" ref="cardExpiry"></div>        
            <div class="stripe-element-container" id="cardCvc" ref="cardCvc"></div>        
        </div>
    
    </form>
  </div>
</template>

<script> 
export default {
   data() {
        return {}
    },
    computed: {},
    methods: {},
    mounted: function () {
      var self=this;
      self.$http.get(self.api+"/pubkey").then(response => {
          if(response.status==200){
              self.spk=response.data.pk
          }
          else{
              throw new Error("failed to get public key")
          }
      }).then(()=>{
          self.stripe= Stripe(self.spk);

          elements=self.stripe.elements({
            fonts: [
                {
                // integrate your font into stripe
                cssSrc: 'https://fonts.googleapis.com/css?family=Roboto&display=swap',
                }
            ]
        });
        var style = {
            base:{
                fontSize:( 0.05*window.innerWidth)  + "px",
                fontFamily: 'Roboto, Sans-Serif',
                color:window.getComputedStyle(document.documentElement).getPropertyValue('--font-color')
            },
            invalid: {
                color: '#fa755a',
                iconColor: '#fa755a'
            }
        };
              
        self.cardNumber = elements.create('cardNumber', {style: style});
        self.cardNumber.mount(self.$refs.cardNumber);
        self.cardExpiry = elements.create('cardExpiry', {style: style});
        self.cardExpiry.mount(self.$refs.cardExpiry);
        self.cardCvc = elements.create('cardCvc', {style: style});
        self.cardCvc.mount(self.$refs.cardCvc);

 
      }).catch((err) => {
          alert("error: "+err.message)
      });

 
    },
}
</script>