import { createSlice } from '@reduxjs/toolkit';
export const questionSlice = createSlice({
  name: 'question',
  initialState: { id: 0, title: '', content: '' },
  reducers: {
    addQuestion: (state, question) => {
      console.log(question);
      return {
        ...question,
        id: state.id,
      };
    },
    addQuestionAsync: (state, { payload }) => {
      console.log(payload);
      // deburgger;
      return {
        ...state,
        id: payload.id,
      };
    },
  },
});
export const questionReducers = questionSlice.reducer;
export const questionActions = questionSlice.actions;
