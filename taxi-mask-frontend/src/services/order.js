import axios from 'axios' 
import {SERVER_URL, ORDER_URL, AUTH_TOKEN, CID_TOKEN} from './config-server'; 


axios.defaults.withCredentials = true 


export async function saveOrder(order) {
    const auth = localStorage.getItem(AUTH_TOKEN);
    const result = await axios.post(`${SERVER_URL}/${ORDER_URL}`, order)
    console.log(result)
    if (result.status === 200) {
        const token = await getCookie('token-ph')
        console.log(token)
        await localStorage.setItem('MAL_USER_TOKEN', token)
        return result.data
    }
}
