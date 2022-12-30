export const getLocalStorage = () => {
  return JSON.parse(localStorage.getItem('user'));
};

export const addLocalStorage = (payload) => {
  return localStorage.setItem('user', JSON.stringify(payload));
};

export const removeLocalStorage = () => {
  return localStorage.removeItem('user');
};
