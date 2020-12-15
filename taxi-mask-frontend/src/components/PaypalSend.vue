<template>
    <div class="text-center">  
        <button class="btn btn-gold bold outline" @click="createpayment" style="background-color: #FFC20E;">Pay with PayPal
        </button>
    </div>
</template>
<script>

    import axios from 'axios'
    import {SERVER_URL} from '../services/config-server';
    const sum = 10;
    const BearerToken = ""

    export default {
        data() {
            return {

            }
        },
         methods: {
           createpayment(){
               //console.log(SERVER_URL);
               //console.log(BearerToken);
                axios.post(SERVER_URL+"/paypal/make/payment?sum="+sum, {
                    /*headers: {
                        //currently not working although the bearer is supposed to be correctly defined on auth.service.js, so there isn't to worry in theory
                        'Authorization': 'Bearer '+BearerToken,
                        "Content-Type": "application/json",
                    }*/
                })
                .then(response => {
                    this.datas = response.data
                    console.log(response.data);
                    const redirect_url = response.data.redirect_url;
                    console.log(redirect_url);
                    window.location.href = ''+redirect_url;
                })
                .catch(function (error) {
                    console.log(error);
                });
            }
         }
    }
</script>