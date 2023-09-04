import { http } from "@/http"


export interface LoginForm {
  username: string
  password: string
  rePassword?: string
}


export const loginApi = (data: LoginForm) => {
  return http.post('/api/login', { data })
}

export const registerApi = (data: LoginForm) => {
  return http.post('/api/register', { data })
}

export const getCurrentUserApi = () => {
  return http.get('/api/current')
}

export const logoutApi = () => {
  return http.get('/api/logout')
}
