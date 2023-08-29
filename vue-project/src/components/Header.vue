<script setup lang="ts">
  const handleCommand = (command: string) => {
    if (command === 'logout') {
      console.log('logout')
    }
  }
</script>

<template>
  <header>
    <div class="left">
      This is a vue3 app
    </div>
    <el-dropdown @command="handleCommand">
      <span class="user-info">
        用户姓名
      </span>
      <template #dropdown>
        <el-dropdown-menu>
          <el-dropdown-item command="logout">Logout</el-dropdown-item>
        </el-dropdown-menu>
      </template>
    </el-dropdown>
  </header>
</template>

<style scoped>
header {
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 0 20px;
  height: 64px;
  box-shadow: #aaa 0 0 10px;
  border-bottom: 1px solid #ddd;
}
</style>
