<template>
    <div id="app">
        <div id="nav" v-if="!isLogged">
            <router-link to="/login">Giriş Yap</router-link>
            <router-link to="/register">Kayıt Ol</router-link>
        </div>
        <div id="nav" v-if="isLogged">
            <router-link to="/products">Ürünler</router-link>
            <a href="javascript:void()" @click="logout">Çıkış Yap</a>
        </div>
        <div id="content"><router-view /></div>
    </div>
</template>

<script>
import axios from "axios";

export default {
    name: "App",
    data() {
        return {};
    },
    methods: {
        logout() {
            console.log("a");
            localStorage.removeItem("token");
            axios.defaults.headers.common["Authorization"] = "";
            this.$router.push({ name: "Login" });
        },
    },
    computed: {
        isLogged() {
            return localStorage.getItem("token");
        },
    },
};
</script>

<style lang="less">
* {
    font-family: Avenir, Helvetica, Arial, sans-serif;
}
#app {
    color: #2c3e50;
    display: flex;
    flex-direction: column;
    align-items: center;
    #content {
        width: 1000px;
        display: flex;
        flex-direction: column;
        align-items: center;
    }
}

#nav {
    display: flex;
    background: #eee;
    border-radius: 5px;
    height: 50px;
    margin-top: 20px;
    margin-bottom: 20px;
    a {
        line-height: 50px;
        padding: 0 15px;
        color: #333;
        text-decoration: none;

        &.router-link-exact-active {
            color: #42b983;
        }
    }
}
</style>
