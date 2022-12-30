import { configureStore } from '@reduxjs/toolkit';
import searchSlice from './modules/searchSlice';
import { questionSlice } from './modules/questionSlice';
import { loginSlice } from './modules/loginSlice';

const store = configureStore({
  reducer: {
    search: searchSlice.reducer,
    question: questionSlice.reducer,
    login: loginSlice.reducer,
  },
});

export default store;
