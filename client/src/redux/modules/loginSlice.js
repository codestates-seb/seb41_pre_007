import { createSlice } from '@reduxjs/toolkit';
import { loginAction } from './action';
// import { toast } from 'react-toastify';

const initialState = { user: sessionStorage.getItem('user') };

export const loginSlice = createSlice({
  name: 'loginReducer',
  initialState,
  reducers: {
    logOut: (state) => {
      state.user = null;
      sessionStorage.removeItem('user');
      //   toast('로그아웃이 정상적으로 이루어졌습니다!');
    },
  },
  extraReducers: (builder) => {
    builder.addCase(loginAction.pending, (state) => {
      state.status = 'Loading';
    });
    builder.addCase(loginAction.fulfilled, (state, action) => {
      //fulfilled 되었을 때, 서버에서 받아온 데이터를 state에 넣어준다
      state.user = action.payload;
      sessionStorage.setItem(state.user);
      //   toast(`Hello! ${state.user.displayName}`);
    });
    builder.addCase(loginAction.rejected, (state) => {
      state.status = 'Fail';
      window.alert('이메일 또는 패스워드가 틀립니다!');
    });
  },
});
