import axios from 'axios'  
import {SERVER_URL,MARQUE} from './config-server'

 

export async function getMarques(order) { 
   const result = axios.get(`${SERVER_URL}/${MARQUE}`) 
    return result
}
 
