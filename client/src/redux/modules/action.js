import { createAsyncThunk } from '@reduxjs/toolkit';
import axios from 'axios';

//비동기처리 action 정의
export const loginAction = createAsyncThunk(
  //1.action 이름
  'login/loginAction',
  //2.처리할 비동기함수
  async (payload) => {
    const response = await axios.post('http://localhost8080/user/login', {
      headers: {
        'Content-Type': 'application/json;charset=UTF-8',
        accept: 'application/json,',
      },
      data: payload,
    });

    const getProfile = await axios('http://localhost8080/members/{member-id}', {
      headers: {
        authorization: response.headers.authorization,
      },
    });

    return { ...getProfile.data, token: response.headers.authorization };
  }
);
