
export const enumToType = <T extends {[K in keyof T]: string}>(e: T) => {
  return Object.values(e).join('|');
}

export const getLocalStorage = (key: string) => {
  try {
    return JSON.parse(localStorage.getItem(key))
  } catch (error) {
    return null
  }
}

export const setLocalStorage = (key: string, value: any) => {
  return localStorage.setItem(key, JSON.stringify(value))
}

