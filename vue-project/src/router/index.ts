import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Layout from '../components/Layout.vue'

export const routes = [
  {
    path: '/',
    name: '首页',
    component: HomeView
  },
  {
    path: '/goods',
    name: '商品列表',
    component: () => import('../views/Goods.vue')
  },
]

export const myHistory = createWebHistory(import.meta.env.BASE_URL)

const router = createRouter({
  history: myHistory,
  routes: [
    {
      path: '/login',
      name: '登录',
      component: () => import('../views/Login.vue')
    },
    {
      path: '/',
      name: '/',
      component: Layout,
      children: routes,
    },
    {
      path: "/*",
      redirect: "/",
    }
  ],
})

export default router
