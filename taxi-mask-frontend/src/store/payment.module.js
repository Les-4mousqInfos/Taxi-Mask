
import PaymentService from '../services/payment.service';

const initialState = {}
export const payment = {
    namespaced: true,
    state: {...initialState},
    actions: {
        async getStripePublicKey({commit}) { 
            return await PaymentService.getStripePublicKey()
        },
        async chargeCard({commit},charge) { 
            return await PaymentService.chargeCard(charge)
        },
        
    },
    mutations: {
         
    }
};
