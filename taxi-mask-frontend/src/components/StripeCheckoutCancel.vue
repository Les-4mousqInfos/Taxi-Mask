<template>
  <div>
    <section
      class="section has-background-white-bis"
      style="margin-top:5%"
    >
      <div class="container has-text-centered">
        <div class="is-size-5 mb-6 notification is-success">
          <h2 class="title is-3">
            Payement annulé
          </h2>
          <p>
              Merci pour votre confiance
            (Réf:  )
          </p>
          <br>
          <br>
          <div class="columns is-centered">
            <div class="column is-one-quarter">
              <!--   <a target="_black"  :href="$route('paiement.generateBill',{'token':data.token,'typeOp': data.typeOp})"  class="button is-primary is-medium is-fullwidth">Téléchager le reçu</a> -->
              <a
                target="_black"
                :href="billPath"
                class="button is-primary is-medium is-fullwidth"
              >Téléchager le reçu</a>
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script> 
export default {
  components: {}, 
  props: { 
  }, 
  data() {
    return {
      
    }
  },
  created() {
   
  },
  methods: {
   
  },
}
</script>
<style scoped>
 
</style>
