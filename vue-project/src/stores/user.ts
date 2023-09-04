import { defineStore } from 'pinia'
import { loginApi, logoutApi } from "@/http/user"
import { setLocalStorage } from "@/utils/common"
import { AUTH_TOKEN } from "@/utils/constant"
import { myHistory } from "@/router"

export const useUserStore = defineStore('user', () => {

  const login = async (data: any) => {
    const res = await loginApi(data)
    setLocalStorage(AUTH_TOKEN, res.token)
    myHistory.push("/")
  }
  const logout = async () => {
    await logoutApi()
    myHistory.push("/login")
  }

  return { login, logout }
})
