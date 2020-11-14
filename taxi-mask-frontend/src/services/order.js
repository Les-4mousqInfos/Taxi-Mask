import axios from 'axios' 
import authHeader from './auth-header';
import {SERVER_URL, ORDER_URL, CARDS} from './config-server'; 


axios.defaults.withCredentials = true 

const config = {
    headers: authHeader()
} 

export async function saveOrder(order) { 
   const result = axios.post(`${SERVER_URL}/${ORDER_URL}`, order, config) 
    return result
}

export async function getOrders(){
    const result = await axios.get(`${SERVER_URL}/${ORDER_URL}`, config)
    return result
}
