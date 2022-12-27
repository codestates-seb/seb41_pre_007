import { createSlice } from '@reduxjs/toolkit';
export const questsionSlice = createSlice({
  name: 'questionReducer',
  initialState: { render: false },
  reducers: {
    rendering: (state) => {
      state.render = !state.render;
    },
  },
});
export default questsionSlice;
export const { rendering } = questsionSlice.actions;
