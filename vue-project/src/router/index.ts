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
    path: '/about',
    name: 'about',
    component: () => import('../views/AboutView.vue')
  },
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/login',
      name: '登录',
      component: () => import('../views/Login/index.vue')
    },
    {
      path: '/',
      name: '/',
      component: Layout,
      children: routes,
    }
  ],
})

export default router
