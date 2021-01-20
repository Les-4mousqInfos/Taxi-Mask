
import PaymentService from '../services/payment.service';

const initialState = {}
export const payment = {
    namespaced: true,
    state: {...initialState},
    actions: {
        async getStripePublicKey() { 
            return await PaymentService.getStripePublicKey()
        },
        async chargeCard(charge) { 
            return await PaymentService.chargeCard(charge)
        },
        
    },
    mutations: {
         
    }
};
