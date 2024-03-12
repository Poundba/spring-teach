<template>
  <div
      style="width: 100vw;height: 100vh;display: flex;align-items: center;justify-content: center">
    <div style="width: 300px;padding:10px;border: 3px solid pink;border-radius: 10px;text-align: center">
      <h3>X X 系 统</h3>
      <el-form
          ref="loginFormRef"
          label-width="auto"
          :model="loginForm"
          :rules="loginRules">
        <el-form-item label="用户名" prop="username">
          <el-input v-model="loginForm.username"/>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input type="password" v-model="loginForm.password"/>
        </el-form-item>
      </el-form>
      <el-button style="width: 100%" type="primary" @click="login">登 录</el-button>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import qs from "qs";

export default {
  data() {
    return {
      loginForm: {
        username: '',
        password: ''
      },
      loginRules: {
        username: [
          {required: true, trigger: "blur", message: "请输入您的账号"}
        ],
        password: [
          {required: true, trigger: "blur", message: "请输入您的密码"}
        ],
      },
    }
  },
  methods: {
    login() {
      this.$refs.loginFormRef.validate((isValid) => {
        if (isValid) {
          axios.post('/api/login', qs.stringify(this.loginForm)).then(res => {
            console.log(res.data.code)
            if (res.data.code === 200) {
              this.$router.push('/user')
            }
          });
        } else {
          console.log('err')
        }
      })
    },
  }
}
</script>
