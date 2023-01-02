export const getLocalStorage = () => {
  return JSON.parse(localStorage.getItem('Authorization'));
};

export const getLocalMemberId = () => {
  return JSON.parse(localStorage.getItem('memberId'));
};

export const addLocalStorage = (payload) => {
  return localStorage.setItem('Authorization', JSON.stringify(payload));
};

export const addLocalMemberId = (payload) => {
  return localStorage.setItem('memberId', JSON.stringify(payload));
};

export const removeLocalStorage = () => {
  return localStorage.removeItem('Authorization');
};

export const removerLocalMemberId = () => {
  return localStorage.removeItem('memberId');
};
