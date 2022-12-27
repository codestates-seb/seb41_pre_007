import { configureStore } from '@reduxjs/toolkit';
import searchSlice from './modules/searchSlice';
import { questionSlice } from './modules/questionSlice';

const store = configureStore({
  reducer: {
    search: searchSlice.reducer,
    question: questionSlice.reducer,
  },
});

export default store;
