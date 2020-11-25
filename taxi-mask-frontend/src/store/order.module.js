
import {saveOrder, getOrders, saveFile, getStripeSession} from '../services/order';
import {CARD_LIST,CARD_CONTENT} from '../services/config-server';
const cards = localStorage.getItem(CARD_LIST);
const cardContent = localStorage.getItem(CARD_CONTENT)
  
const initialState = {cards,cardContent}

export const order = {
    namespaced: true,
    state: {...initialState},
    actions: {
        async save({commit},order) { 
            return await saveOrder(order)
        },
        async stripeCheckoutSession({commit},file) { 
            return await getStripeSession()
        },
        async saveFile({commit},file) { 
            return await saveFile(file)
        },
        async list() {
           return await getOrders()
        },
    },
    mutations: {
        updateCard(state, payload){
            console.log('mut=='+payload)
            state = {...state}
            state.cardContent = payload
            console.log('xx'+state.cards)
            console.log('xx'+state.cardContent)
        }
    }
};
