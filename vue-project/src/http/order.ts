import { http } from "@/http"

export const getOrderListApi = () => {
  return http.get('/api/order')
}

interface OrderItem {
  id?: number
  goods_id: number
  count: number
}

export const addOrderApi = (data: OrderItem[]) => {
  return http.post('/api/order', { data })
}

export const deleteOrderApi = (id: OrderItem["id"]) => {
  return http.delete(`/api/order/${id}`)
}
