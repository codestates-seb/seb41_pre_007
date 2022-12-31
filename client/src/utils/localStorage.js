export const getLocalStorage = () => {
  return JSON.parse(localStorage.getItem('Authorization'));
};

export const addLocalStorage = (payload) => {
  return localStorage.setItem('Authorization', JSON.stringify(payload));
};

export const removeLocalStorage = () => {
  return localStorage.removeItem('Authorization');
};
