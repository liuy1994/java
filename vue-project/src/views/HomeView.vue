<script setup lang="ts">

import { onMounted } from "vue"
import { getCurrentUserApi } from "@/http/user"

onMounted(() => {
  getCurrentUserApi()
})
</script>

<template>
  <ul>
    <li>
      <h1>前端页面随便写写，基于Vue3 + Element-Plus</h1>
    </li>
    <li>
      <h1>后端服务基于Maven + SpringBoot + Mysql</h1>
    </li>
    <li>
      <h1>每个用户拥有一个购物车，可以把商品添加到购物车</h1>
    </li>
    <li>
      <h1>可以在购物车中选择商品，然后新增一条订单</h1>
    </li>
  </ul>

</template>
<style scoped>
h1 {
  margin-block-start: 0.67em;
  margin-block-end: 0.67em;
}
</style>
