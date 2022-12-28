import { createSlice } from '@reduxjs/toolkit';
export const questionSlice = createSlice({
  name: 'questionReducer',
  initialState: { render: false },
  reducers: {
    rendering: (state) => {
      state.render = !state.render;
    },
  },
});
export default questionSlice;
export const { rendering } = questionSlice.actions;
