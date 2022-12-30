import { createSlice } from '@reduxjs/toolkit';
import { loginAction } from './action';
import {
  getLocalStorage,
  addLocalStorage,
  removeLocalStorage,
} from '../../utils/localStorage';
// import { toast } from 'react-toastify';

const initialState = {
  user: getLocalStorage() ? getLocalStorage() : null,
};

export const loginSlice = createSlice({
  name: 'loginReducer',
  initialState: initialState,
  reducers: {
    logOut: (state) => {
      state.user = null;
      removeLocalStorage();
      //   toast('로그아웃이 정상적으로 이루어졌습니다!');
      window.alert('로그아웃되었습니다.');
    },
  },
  // login: (state, action) => {
  //   state.loginAction = action.payload.data;
  // },
  extraReducers: (builder) => {
    builder.addCase(loginAction.pending, (state) => {
      state.status = 'Loading';
    });
    builder.addCase(loginAction.fulfilled, (state, action) => {
      //fulfilled 되었을 때, 서버에서 받아온 데이터를 state에 넣어준다
      state.user = action.payload;
      addLocalStorage();
      //   toast(`Hello! ${state.user.displayName}`);
    });
    builder.addCase(loginAction.rejected, (state) => {
      state.status = 'Fail';
      window.alert('이메일 또는 패스워드가 틀립니다!');
    });
  },
});
