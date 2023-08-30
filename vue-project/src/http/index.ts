import { enumToType, getLocalStorage } from "@/utils/common"
import { ElMessage } from 'element-plus'

enum Methods {
  GET = "get",
  POST = "post",
  PUT = "put",
  DELETE = "delete",
}


const request = (method: ReturnType<typeof enumToType<typeof Methods>>) => {
    return async (url: string, input?: RequestInit & {data: any}) => {
      const { data, headers = {} } = input || {}
      const token = getLocalStorage("token")
      if (!token) {
        return window.location.href = '/login'
      }
      const response = await fetch(url,{
        method,
        body: data as RequestInit["body"],
        headers: {
          'content-type': 'application/json',
          'responseType': 'json',
          ...headers,

        },
      })
      if (response.status >= 200 && response.status < 300) {
        return response.json()
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

