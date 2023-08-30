import { http } from "@/http"

interface GoodsItem {
  id?: number
  name: string
  price: number
  desc: string
}

export const getGoodsListApi = () => {
  return http.get('/api/goods')
}

export const getGoodsDetailApi = (id: GoodsItem["id"]) => {
  return http.get(`/api/goods/${id}`)
}

export const addGoodsApi = (data: GoodsItem) => {
  return http.post('/api/goods', { data })
}

export const updateGoodsApi = (id: GoodsItem["id"], data: GoodsItem) => {
  return http.put(`/api/goods/${id}`, { data })
}

export const deleteGoodsApi = (id: GoodsItem["id"]) => {
  return http.delete(`/api/goods/${id}`)
}
