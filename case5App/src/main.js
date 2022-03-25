import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import ElementUI from "element-ui";
import "element-ui/lib/theme-chalk/index.css";
import locale from "element-ui/lib/locale/lang/en";
import axios from "axios";

Vue.use(ElementUI, { locale });

Vue.config.productionTip = false;

axios.defaults.baseURL =
    "http://localhost:8080";

axios.defaults.headers.common["Content-Type"] = "application/json";

if (localStorage.getItem("token")) {
    axios.defaults.headers.common["Authorization"] = localStorage.getItem("token");
}

axios.interceptors.response.use(
    function (response) {
        return response;
    },
    function (error) {
        console.log(error);
        if (error.response) {
            if (error.response.status === 401) {
                console.log(error);
                localStorage.removeItem("token");

                location.reload();
            }
        }
        return Promise.reject(error);
    }
);
new Vue({
    router,
    render: function (h) {
        return h(App);
    },
    mounted() {
        if (!this.isLogged) {
            setTimeout(() => {
                if (
                    this.$route.name != "Login" &&
                    this.$route.name != "Register"
                ) {
                    this.$router.push({
                        name: "Login",
                    });
                }
            }, 0);
        } else {
            setTimeout(() => {
                if (
                    this.$route.name != "Products"
                ) {
                    this.$router.push({
                        name: "Products",
                    });
                }
            }, 0);
        }
    },
    computed: {
        isLogged() {
            return localStorage.getItem("token");
        },
    },
}).$mount("#app");
