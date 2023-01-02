import { createAsyncThunk } from '@reduxjs/toolkit';
import axios from 'axios';

//비동기처리 action 정의
export const loginAction = createAsyncThunk(
  //1.action 이름
  'loginSlice/loginAction',
  //2.처리할 비동기 로직
  async ({ email, password }) => {
    const response = await axios(`http://54.180.127.165:8080/members/login`, {
      method: 'post',
      headers: {
        'Content-Type': 'application/json',
      },
      data: { email, password },
    })
      .then((res) => {
        const accessToken = res.headers
          .get('Authorization')
          .replace(/^Bearer\s+/, '');
        return { token: accessToken, memberId: res.data.memberId };
      })
      .catch((err) => {
        console.error(err);
      });
    return response;
  }
);
