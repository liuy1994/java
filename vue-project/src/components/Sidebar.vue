<script setup lang="ts">
  import { routes } from "@/router"

</script>


<template>
  <el-aside width="260px">
    <el-menu
        class="el-menu-vertical-demo"
        default-active="/"
        router
        ref="menu"
    >
      <el-menu-item v-for="route in routes" :index="route.path" :key="route.path">
        <span>{{ route.name }}</span>
      </el-menu-item>
    </el-menu>
  </el-aside>
</template>

<style scoped >
.el-menu-vertical-demo {
  height: 100%;
}
</style>
