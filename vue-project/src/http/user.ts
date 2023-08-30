import { http } from "@/http"

interface LoginForm {
  username: string,
  password: string
}

interface RegisterForm {
  username: string,
  password: string
}

export const loginApi = (data: LoginForm) => {
  return http.post('/api/login', { data })
}

export const registerApi = (data: RegisterForm) => {
  return http.post('/api/register', { data })
}

export const getCurrentUserApi = () => {
  return http.get('/api/currentUser')
}

export const logoutApi = () => {
  return http.get('/api/logout')
}
