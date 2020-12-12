<template>
    <div class="text-center">  
        <button class="btn btn-gold bold outline" @click="createpayment">Pay with paypal
        </button>
    </div>
</template>
<script>

    import axios from 'axios'
    const FRONTEND_URL = "http://localhost:8080";
    const sum = 10;

    export default {
        data() {
            return {

            }
        },
         methods: {
           createpayment(){
                axios.post(FRONTEND_URL+"/paypal/make/payment?sum="+sum, {
                    headers: {
                        'Authorization': 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzb21lVXNlciIsImlhdCI6MTYwNzc4Mjc2MiwiZXhwIjoxNjA3ODY5MTYyfQ.d6SiK95TzZfua1x43lgdk1ZFxo5IihkYeeFJKO38Yk4jr52X8ND7L_4PoTD_8kbxKIucXObjDCbrzCSy4HStLQ',
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