import { createAsyncThunk } from '@reduxjs/toolkit';
import axios from 'axios';

//비동기처리 action 정의
export const loginAction = createAsyncThunk(
  //1.action 이름
  'login/loginAction',
  //2.처리할 비동기 로직
  async (payload) => {
    console.log(payload);
    const response = await axios
      .post('http://54.180.127.165:8080/members/login', {
        headers: {
          'Content-Type': 'application/json;charset=UTF-8',
          accept: 'application/json,',
        },
        data: payload,
      })
      .then((res) => {
        console.log(res.data.data);
      })
      .catch((err) => {
        console.error(err);
      });

    // const getProfile = await axios('http://localhost8080/members/{member-id}', {
    //   headers: {
    //     authorization: response.headers.authorization,
    //   },
    // });

    //...getProfile.data,
    return { token: response.headers.authorization };
  }
);
