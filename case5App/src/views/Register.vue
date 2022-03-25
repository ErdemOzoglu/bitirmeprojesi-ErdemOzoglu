<template>
    <div id="register">
        <el-input v-model="form.name" size="small" placeholder="İsim"></el-input>
        <el-input v-model="form.surname" size="small" placeholder="Soyisim"></el-input>
        <el-input v-model="form.userName" size="small" placeholder="Kullanıcı Adı"></el-input>
        <el-input v-model="form.password" type="password" size="small" placeholder="Parola"></el-input>
        <el-button type="primary" @click="register">Kayıt Ol</el-button>
    </div>
</template>

<script>
import axios from "axios";

export default {
    name: "Register",
    data(){
        return {
            form: {
            name:null,
            surname:null,
            userName:null,
            password:null
            }
        };
    },
    methods: {
        register(){
            axios.post("auth/register", this.form).then(() => {
                this.$message.success("Kayıt Başarılı!");
            }).catch(() => {
                this.$message.error('Hata!');
            });
        }
    }
};
</script>

<style lang="less">
#register {
    width: 250px;
    display: flex;
    flex-direction: column;
    .el-input {
        margin-bottom: 15px;
    }
}
</style>
