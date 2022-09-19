import Vue from 'vue'
import Cookies from 'js-cookie'
// import { resetRouter } from '@/router'
// import { getInfo } from '@/api/user'
import axios from 'axios'
const TokenKey = 'humanres_token'
const UserInfo = 'humanres_user'
const Role = 'role'
export function getToken() {
    return Cookies.get(TokenKey)
}
function setToken(token) {
    return Cookies.set(TokenKey, token)
}
function removeToken() {
    return Cookies.remove(TokenKey)
}
function getUserInfo() {
    return Cookies.getJSON(UserInfo)
}
function getRole(){
    return Cookies.getJSON(Role)
}
function setRole(role) {
    return Cookies.set(Role, role)
}
function removeRole(){
    return Cookies.remove(Role)
}
function setUserInfo(user) {
    return Cookies.set(UserInfo, user)
}
function removeUserInfo() {
    return Cookies.remove(UserInfo)
}

const getDefaultState = () => {
    return {
        token: getToken(),
        userInfo: getUserInfo(),
        role: getRole()
    }
}

const state = getDefaultState()

const mutations = {
    RESET_STATE: (state) => {
        Object.assign(state, getDefaultState())
    },
    SET_TOKEN: (state, token) => {
        state.token = token
        setToken(token)
    },
    REMOVE_TOKEN: (state) => {
        removeToken()
        removeUserInfo()
        removeRole()
        Object.assign(state, getDefaultState())
    },
    SET_USERINFO: (state, data) => {
        state.userInfo = data
        state.role = data.role
        // removeUserInfo()
        setUserInfo(data)
        setRole(data.role)
    },
    UPDATE_USERINFO: (state, data) => {
        Vue.set(state.userInfo, 'userPhoto', data.userPhoto)
    },

}

const actions = {
    getInfo({ commit, state }) {
        return new Promise((resolve, reject) => {
            let fd = new FormData()
            axios.post('/api/user/getUserInfo',fd,{headers:{'token':state.token}}).then((res)=>{
                console.log(res)
                const {data } = res
                console.log(state.token)
                console.log('data')
                console.log(data)
                const { role } = data.data.user
                commit('SET_USERINFO', role)
                // commit('SET_TOKEN', token)
                resolve(data)
            }).catch(error => {
                reject(error)
            })
        })
    },
    // login({ commit }, userInfo) {
    //     const { login_username, login_password } = userInfo
    //     return new Promise((resolve, reject) => {
    //         login(login_username, login_password)
    //             .then(response => {
    //                 const { data } = response
    //                 console.log(response)
    //                 if (data.message === 400) {
    //                     reject(400)
    //                 } else if (data.message === 200) {
    //                     commit('SET_TOKEN', data.token)
    //                     commit('SET_USERINFO', data.user)
    //                     setToken(data.token)
    //                     setUserInfo(data.user)
    //                 }
    //                 resolve()
    //             }).catch(error => {
    //                 reject(error)
    //             })
    //     })
    // },
    // register({ commit }, userInfo) {
    //     const { register_username, register_password } = userInfo
    //     return new Promise((resolve, reject) => {
    //         register(register_username, register_password).then(response => {
    //             const { data } = response
    //             console.log(response)
    //             console.log(data.message === 400)
    //             if (data.message === 400) {
    //                 reject(400)
    //             } else if (data.message === 200) {
    //                 commit('SET_TOKEN', data.token)
    //                 commit('SET_USERINFO', data.user)
    //                 setToken(data.token)
    //                 setUserInfo(data.user)
    //             }

    //             resolve()
    //         }).catch(error => {
    //             reject(error)
    //         })
    //     })
    // }
    logout({commit}) {

      console.log('333')
      // resetRouter()
    //   console.log(this.$store.state.user.token)
        commit('REMOVE_TOKEN')
    },

}

export default {
    namespaced: true,
    state,
    mutations,
    actions
}
