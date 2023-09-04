import { http } from "@/http"

export interface CartItem {
  id?: number|null
  product_id: number|null
  quantity: number|null
}

export const getCartListApi = () => {
  return http.get('/api/cart')
}

export const updateCartApi = (data: CartItem) => {
  return http.post('/api/cart', { data })
}

