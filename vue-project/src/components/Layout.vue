<script setup lang="ts">
import { RouterView } from 'vue-router'
import Header from "@/components/Header.vue"
import Sidebar from "@/components/Sidebar.vue"
</script>

<template>
  <div class="container">
    <Header />
    <main>
      <Sidebar />
      <main>
        <RouterView />
      </main>
    </main>
  </div>
</template>

<style scoped>

main:has(main) {
  display: flex;
  min-height: calc(100vh -  64px);
}

main main {
  padding: 20px;
  flex-grow: 1;
}
</style>
