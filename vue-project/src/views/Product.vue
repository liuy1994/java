<template>
  <el-row>
    <el-button type="primary" @click="handleEdit()">新增</el-button>
  </el-row>
  <el-table :data="tableData" style="width: 100%">
    <el-table-column prop="id" label="ID" width="64" />
    <el-table-column prop="name" label="名称"  />
    <el-table-column prop="description" label="描述" />
    <el-table-column prop="price" label="价格" />
    <el-table-column  label="操作" >
      <template #default="scope">
        <el-button size="small" @click="handleEdit(scope.row)">编辑</el-button>
        <el-popconfirm title="Are you sure to delete this?" @confirm="handleDelete(scope.row.id)">
          <template #reference>
            <el-button size="small" type="danger">删除</el-button>
          </template>
        </el-popconfirm>

      </template>
    </el-table-column>
  </el-table>
  <el-dialog
      v-model="dialogVisible"
      :title="`${form.id ? '编辑' : '新增'}商品`"
      width="30%"
      :before-close="handleClose"
  >
    <el-form :model="form" label-width="60px" ref="formRef">
      <el-form-item label="ID" prop="id" style="visibility: hidden;height: 0;margin: 0">
        <el-input v-model="form.id" />
      </el-form-item>

      <el-form-item label="名称" prop="name">
        <el-input v-model="form.name" />
      </el-form-item>
      <el-form-item label="价格" prop="price">
        <el-input-number v-model="form.price" min="0"/>
      </el-form-item>
      <el-form-item label="描述" prop="description">
        <el-input v-model="form.description" />
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="handleClose">Cancel</el-button>
        <el-button type="primary" @click="submit">
          Confirm
        </el-button>
      </span>
    </template>
  </el-dialog>
</template>

<script setup lang="ts">
import { addGoodsApi, deleteGoodsApi, getGoodsListApi, ProductItem, updateGoodsApi } from "@/http/product"
import { ref } from "vue"
import { ElMessage, FormInstance } from "element-plus"

const tableData = ref([])
const dialogVisible = ref(false)
const formRef = ref<FormInstance>()
const initForm: ProductItem = {
  name: '',
  price: null,
  description: '',
}
const form = ref<ProductItem>(initForm)

const getList = async () => {
  const res = await getGoodsListApi()
  console.log(res)
  tableData.value = res.products ?? []
}

getList()

const handleEdit = (row?: ProductItem) => {
  console.log(row)
  dialogVisible.value = true
  form.value = { ...(row || initForm) }
}

const handleClose = () => {
  dialogVisible.value = false
  form.value = initForm
}
const submit = async () => {
  console.log(form.value)
  if (!form.value.id) {
    await addGoodsApi(form.value)
  } else {
    await updateGoodsApi(form.value.id, form.value)
  }
  ElMessage.success(form.value.id ? "编辑成功" : "新增成功")
  handleClose()
  getList()
}

const handleDelete = async (id: number) => {
  await deleteGoodsApi(id)
  ElMessage.success("删除成功")
  getList()
}

</script>

<style scoped>

</style>
