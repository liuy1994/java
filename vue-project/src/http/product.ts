import { http } from "@/http"

export interface ProductItem {
  id?: number
  name: string
  price: number|null
  description: string
}

export const getGoodsListApi = () => {
  return http.get('/api/products')
}

export const getGoodsDetailApi = (id: ProductItem["id"]) => {
  return http.get(`/api/products/${id}`)
}

export const addGoodsApi = (data: ProductItem) => {
  return http.post('/api/products', { data })
}

export const updateGoodsApi = (id: ProductItem["id"], data: ProductItem) => {
  return http.put(`/api/products/${id}`, { data })
}

export const deleteGoodsApi = (id: ProductItem["id"]) => {
  return http.delete(`/api/products/${id}`)
}
