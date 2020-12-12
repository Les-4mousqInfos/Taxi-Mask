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
    //const BearerToken = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzb21lVXNlciIsImlhdCI6MTYwNzc4Mjc2MiwiZXhwIjoxNjA3ODY5MTYyfQ.d6SiK95TzZfua1x43lgdk1ZFxo5IihkYeeFJKO38Yk4jr52X8ND7L_4PoTD_8kbxKIucXObjDCbrzCSy4HStLQ"
    const BearerToken = "asf";

    export default {
        data() {
            return {

            }
        },
         methods: {
           createpayment(){
               console.log(SERVER_URL);
               console.log(BearerToken);
                axios.post(SERVER_URL+"/paypal/make/payment?sum="+sum, {
                    headers: {
                        'Authorization': 'Bearer '+BearerToken,
                        "Content-Type": "application/json",
                    }
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