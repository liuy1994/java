<template>
  <div class="form-wrapper">
    <el-tabs v-model="activeName" class="demo-tabs" >
      <el-tab-pane label="登录" name="login">
        <el-form
            ref="loginFormRef"
            :model="ruleForm"
            :rules="rules"
            class="demo-ruleForm"
            :size="formSize"
            status-icon
        >
          <el-form-item prop="username">
            <el-input v-model="ruleForm.username" placeholder="用户名"/>
          </el-form-item>
          <el-form-item prop="password">
            <el-input v-model="ruleForm.password" placeholder="密码" type="password"/>
          </el-form-item>
          <el-form-item>
            <el-row :gutter="20">
              <el-col :span="12">
                <el-button  @click.prevent="resetForm(loginFormRef)">Reset</el-button>
              </el-col>
              <el-col :span="12">
                <el-button type="primary" @click="submitForm(loginFormRef)">
                  Submit
                </el-button>
              </el-col>

            </el-row>
          </el-form-item>
        </el-form>
      </el-tab-pane>
      <el-tab-pane label="注册" name="register">
        <el-form
            ref="registerFormRef"
            :model="ruleForm"
            :rules="rules"
            class="demo-ruleForm"
            :size="formSize"
            status-icon
        >
          <el-form-item prop="username">
            <el-input v-model="ruleForm.username" placeholder="用户名"/>
          </el-form-item>
          <el-form-item prop="password">
            <el-input v-model="ruleForm.password" placeholder="密码" type="password"/>
          </el-form-item>
          <el-form-item prop="rePassword" v-if="activeName === 'register'">
            <el-input v-model="ruleForm.rePassword" placeholder="确认密码" type="password"/>
          </el-form-item>
          <el-form-item>
            <el-row :gutter="20">
              <el-col :span="12">
                <el-button @click.prevent="resetForm(registerFormRef)">Reset</el-button>
              </el-col>
              <el-col :span="12">
                <el-button type="primary" @click="submitForm(registerFormRef)">
                  Submit
                </el-button>
              </el-col>
            </el-row>
          </el-form-item>
        </el-form>
      </el-tab-pane>
    </el-tabs>

  </div>
</template>

<script lang="ts" setup>
import { reactive, ref } from 'vue'
import type { FormInstance, FormRules } from 'element-plus'
import { LoginForm, registerApi } from "@/http/user"
import { useUserStore } from "@/stores/user"
import { ElMessage } from "element-plus"

const store = useUserStore()
console.log(store)
const activeName = ref("login")
const formSize = ref('large')
const loginFormRef = ref<FormInstance>()
const registerFormRef = ref<FormInstance>()
const ruleForm = reactive<LoginForm>({
  username: '',
  password: '',
  rePassword: '',
})

const rules = reactive<FormRules<LoginForm>>({
  username: [
    { required: true, message: 'Please input username', trigger: 'blur' },
  ],
  password: [
    { required: true, message: 'Please input password', trigger: 'blur' },
  ],
  rePassword: [
    { required: true, message: 'Please input password again', trigger: 'blur' },
    {  validator: (rule, value, callback) => {
      if (value !== ruleForm.password) {
        callback(new Error('The two passwords do not match!'))
      } else {
        callback()
      }
    }, trigger: 'change' }
  ],

})

const submitForm = async (formEl: FormInstance | undefined) => {
  if (!formEl) return
  await formEl.validate(async (valid) => {
    if (valid) {
      const params = { ...ruleForm }
      if (activeName.value === 'login') {
        delete params.rePassword
        await store.login(params)

        ElMessage.success("登录成功")
      }
      if (activeName.value === 'register') {
        registerApi(params)
        ElMessage.success("注册成功")
      }
    }
  })
}

const resetForm = (formEl: FormInstance | undefined) => {
  if (!formEl) return
  formEl.resetFields()
}

</script>

<style scoped>
.form-wrapper {
  width: 260px;
  margin: 0px auto;
  padding-top: 120px;
}

</style>
