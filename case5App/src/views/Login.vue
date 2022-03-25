<template>
    <div id="login">
        <el-input
            size="small"
            type="text"
            placeholder="username"
            v-model="form.userName"
        ></el-input>
        <el-input
            size="small"
            type="password"
            placeholder="password"
            v-model="form.password"
        ></el-input>
        <el-button type="primary" @click="login">Giriş Yap</el-button>
    </div>
</template>

<script>
import axios from "axios";

export default {
    name: "Login",
    data() {
        return {
            form: {
                userName: null,
                password: null,
            },
        };
    },
    methods: {
        login() {
            axios.post("auth/login", this.form).then((res) => {
                localStorage.setItem("token", res.data.data);
                axios.defaults.headers.common["Authorization"] = res.data.data;
                this.$router.push({ name: "Products" });
            }).catch(() => {
                this.$message.error('Hata!');
            });
        },
    },
};
</script>

<style lang="less">
#login {
    width: 250px;
    display: flex;
    flex-direction: column;
    .el-input {
        margin-bottom: 15px;
    }
}
</style>
