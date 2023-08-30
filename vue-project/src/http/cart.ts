import { http } from "@/http"

export const getCartListApi = () => {
  return http.get('/api/cart')
}

interface CartItem {
  id?: number
  goods_id: number
  count: number
}

export const updateCartApi = (data: CartItem) => {
  return http.post('/api/cart', { data })
}

