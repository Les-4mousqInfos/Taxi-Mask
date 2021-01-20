/*=========================================================================================
  File Name: moduleCalendarActions.js
  Description: Calendar Module Actions
  ----------------------------------------------------------------------------------------
  Item Name: Vuexy - Vuejs, HTML & Laravel Admin Dashboard Template
  Author: Pixinvent
  Author URL: http://www.themeforest.net/user/pixinvent
==========================================================================================*/

import axios from "@/axios.js"
import authHeader from '../../services/auth-header';
const API_URL = 'http://localhost:8080/api/test';
export default {
  addItem({ commit }, item) {
    console.log(item);
    return new Promise((resolve, reject) => {
      axios.post(API_URL +"/marques", item )
        .then((response) => {
          commit('ADD_MARQUE', Object.assign(item, {id: response.data.id}))
          resolve(response)
        })
        .catch((error) => { reject(error) })
    })
  },
  fetchDataListItems({ commit }) {
    return new Promise((resolve, reject) => {
      axios.get(API_URL +"/marques", { headers: authHeader() })
        .then((response) => {
          commit('SET_MARQUES', response.data)
          resolve(response)
        })
        .catch((error) => { reject(error) })
    })
  },
  // fetchEventLabels({ commit }) {
  //   return new Promise((resolve, reject) => {
  //     axios.get("/api/apps/calendar/labels")
  //       .then((response) => {
  //         commit('SET_LABELS', response.data)
  //         resolve(response)
  //       })
  //       .catch((error) => { reject(error) })
  //   })
  // },
  updateItem({ commit }, item) {
    console.log(item);
        return new Promise((resolve, reject) => {
      axios.put(API_URL +"/marques/"+item.id, item)
        .then((response) => {
          commit('UPDATE_MARQUE', response.data)
          resolve(response)
        })
        .catch((error) => { reject(error) })
    })
  },
  removeItem({ commit }, itemId) {
    return new Promise((resolve, reject) => {
      axios.delete(API_URL +"/marques/"+itemId)
        .then((response) => {
          commit('REMOVE_MARQUE', itemId)
          resolve(response)
        })
        .catch((error) => { reject(error) })
    })
  },
  // eventDragged({ commit }, payload) {
  //   return new Promise((resolve, reject) => {
  //     axios.post(`/api/apps/calendar/event/dragged/${payload.event.id}`, {payload: payload})
  //       .then((response) => {

  //         // Convert Date String to Date Object
  //         let event = response.data
  //         event.startDate = new Date(event.startDate)
  //         event.endDate = new Date(event.endDate)

  //         commit('UPDATE_EVENT', event)
  //         resolve(response)
  //       })
  //       .catch((error) => { reject(error) })
  //   })
  // },
}
