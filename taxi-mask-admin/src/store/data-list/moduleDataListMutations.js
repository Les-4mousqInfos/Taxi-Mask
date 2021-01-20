/*=========================================================================================
  File Name: moduleCalendarMutations.js
  Description: Calendar Module Mutations
  ----------------------------------------------------------------------------------------
  Item Name: Vuexy - Vuejs, HTML & Laravel Admin Dashboard Template
  Author: Pixinvent
  Author URL: http://www.themeforest.net/user/pixinvent
==========================================================================================*/


export default {
  ADD_ITEM(state, item) {
    state.products.unshift(item)
  },
  ADD_MARQUE(state, item) {
    state.marques.unshift(item)
  },
  SET_PRODUCTS(state, products) {
    state.products = products
  },
  SET_MARQUES(state, marques) {
    state.marques = marques
  },
  // SET_LABELS(state, labels) {
  //   state.eventLabels = labels
  // },
  UPDATE_PRODUCT(state, product) {
      const productIndex = state.products.findIndex((p) => p.id == product.id)
      Object.assign(state.products[productIndex], product)
  },
  UPDATE_MARQUE(state, marque) {
    const marqueIndex = state.marques.findIndex((p) => p.id == marque.id)
    Object.assign(state.marques[marqueIndex], marque)
},
  REMOVE_ITEM(state, itemId) {
      const ItemIndex = state.products.findIndex((p) => p.id == itemId)
      state.products.splice(ItemIndex, 1)
  },
  REMOVE_MARQUE(state, itemId) {
    const ItemIndex = state.marques.findIndex((p) => p.id == itemId)
    state.marques.splice(ItemIndex, 1)
},
}
