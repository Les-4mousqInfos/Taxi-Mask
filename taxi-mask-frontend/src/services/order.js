import axios from 'axios' 
import {SERVER_URL, ORDER_URL, AUTH_TOKEN, CID_TOKEN} from './config-server'; 


axios.defaults.withCredentials = true 




export async function saveOrder(order) {
    let auth = localStorage.getItem(AUTH_TOKEN);
    auth = auth!=null?auth:''
    console.log(auth)
    let config = {
    headers: {
        Authorization: "Bearer "+auth, 
        }
    }
    const result = await axios.post(`${SERVER_URL}/${ORDER_URL}`, order, config)
    console.log(result)
    if (result.status === 200) { 
        console.log(result.data)
        localStorage.setItem(CID_TOKEN, result.data.tokenUn)
        return result.data

    }else{
        console.log(result.data)
    }
}
