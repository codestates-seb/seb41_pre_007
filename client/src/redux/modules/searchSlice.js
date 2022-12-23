import { createSlice } from '@reduxjs/toolkit';

const searchSlice = createSlice({
  name: 'searchSlice',
  initialState: { isClicked: false },
  reducers: {
    setIsClicked: (state) => {
      state.isClicked = !state.isClicked;
    },
  },
});

export default searchSlice;
