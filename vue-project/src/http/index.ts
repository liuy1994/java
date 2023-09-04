import { enumToType, getLocalStorage } from "@/utils/common"
import { ElMessage } from 'element-plus'
import { AUTH_TOKEN } from "@/utils/constant"

enum Methods {
  GET = "get",
  POST = "post",
  PUT = "put",
  DELETE = "delete",
}


const request = (method: ReturnType<typeof enumToType<typeof Methods>>) => {
    return async (url: string, input?: RequestInit & {data: any}) => {
      const { data, headers = {} } = input || {}
      const token = getLocalStorage(AUTH_TOKEN)
      console.log({ token })
      if (!token && !url.includes("/login")) {
        return window.location.href = '/login'
      }
      const response = await fetch(url,{
        method,
        body: JSON.stringify(data),
        headers: {
          'content-type': 'application/json',
          'responseType': 'json',
          'session_token': token,
          ...headers,

        },
      })
      if (response.status >= 200 && response.status < 300) {
        try {
          const json = await response.json()
          if (json.code !== 200) {
            ElMessage.error(json.msg || '未知错误')
            throw new Error(json.msg || '未知错误')
          }
          return json.data
        } catch (e) {
          return "success"
        }
      }
      if (response.status === 401) {
        return window.location.href = '/login'
      }
      ElMessage.error(response.statusText)
      throw new Error(response.statusText)
    }
}

export const http = Object.values(Methods).reduce((prev, method) => {
  return {
    ...prev,
    [method]: request(method),
  }
}, {})


