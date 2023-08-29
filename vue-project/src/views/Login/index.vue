<template>
  <div class="form-wrapper">
    <el-tabs v-model="activeName" class="demo-tabs" >
      <el-tab-pane label="登录" name="login">
        <el-form
            ref="ruleFormRef"
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
            <el-input v-model="ruleForm.password" placeholder="密码"/>
          </el-form-item>
          <el-form-item>
            <el-row gutter="20">
              <el-col span="12">
                <el-button @click="resetForm(ruleFormRef)">Reset</el-button>
              </el-col>
              <el-col span="12">
                <el-button type="primary" @click="submitForm(ruleFormRef)">
                  Submit
                </el-button>
              </el-col>

            </el-row>
          </el-form-item>
        </el-form>
      </el-tab-pane>
      <el-tab-pane label="注册" name="register">
        <el-form
            ref="ruleFormRef"
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
            <el-input v-model="ruleForm.password" placeholder="密码"/>
          </el-form-item>
          <el-form-item prop="rePassword" v-if="activeName === 'register'">
            <el-input v-model="ruleForm.rePassword" placeholder="确认密码"/>
          </el-form-item>
          <el-form-item>
            <el-row gutter="20">
              <el-col span="12">
                <el-button @click="resetForm(ruleFormRef)">Reset</el-button>
              </el-col>
              <el-col span="12">
                <el-button type="primary" @click="submitForm(ruleFormRef)">
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

interface RuleForm {
  username: string
  password: string
  rePassword: string
}
const activeName = ref("login")
const formSize = ref('large')
const ruleFormRef = ref<FormInstance>()
const ruleForm = reactive<RuleForm>({
  username: '',
  password: '',
  rePassword: '',
})

const rules = reactive<FormRules<RuleForm>>({
  username: [
    { required: true, message: 'Please input username', trigger: 'blur' },
  ],
  password: [
    { required: true, message: 'Please input password', trigger: 'blur' },
  ],
  rePassword: [
    { required: true, message: 'Please input password again', trigger: 'blur' },
  ],

})

const submitForm = async (formEl: FormInstance | undefined) => {
  if (!formEl) return
  await formEl.validate((valid, fields) => {
    if (valid) {
      console.log('submit!', ruleForm)
    } else {
      console.log('error submit!', fields)
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
