import { useNavigate } from 'react-router-dom';
import { Sidebar } from '../components/Sidebar';
import { SidebarRight } from '../components/SidebarRight';
import { SHomeWrap, STopBoxList } from '../pages/Home';
import { AllQuestionPageNation } from '../components/AllQuestionPageNation';
import { useState } from 'react';

export const AllQuestions = () => {
  const [questions, setQuestions] = useState([]);
  const navigate = useNavigate();

  const handlePageClick = (question) => {
    setQuestions(question);
  };
  const handleOldest = () => {
    const newArr = [...questions];
    const OldestResult = newArr.sort((a, b) => {
      return a.questionId - b.questionId;
    });
    setQuestions(OldestResult);
  };
  const handleNewest = () => {
    const newArr = [...questions];
    const newestResult = newArr.sort((a, b) => {
      return b.questionId - a.questionId;
    });
    setQuestions(newestResult);
  };
  return (
    <SHomeWrap>
      <Sidebar />
      <div className="top-content content">
        <div className="top-title">
          <h1 id="top-h1">All Questions</h1>
          <button
            type="button"
            className="btn btn-primary top-btn"
            onClick={() => navigate('/questions/ask')}
          >
            Ask Question
          </button>
        </div>
        <STopBoxList>
          <div
            className="btn-group"
            role="group"
            aria-label="Basic outlined example"
          >
            <button
              type="button"
              className="btn btn-outline-primary"
              onClick={handleNewest}
            >
              Newest
            </button>
            <button
              type="button"
              className="btn btn-outline-primary"
              onClick={handleOldest}
            >
              Active
            </button>
            <button type="button" className="btn btn-outline-primary">
              Bountied
            </button>
            <button type="button" className="btn btn-outline-primary">
              Unanswered
            </button>
            <button type="button" className="btn btn-outline-primary">
              More
            </button>
          </div>
        </STopBoxList>
        {/*question={question} 적기*/}
        <AllQuestionPageNation
          handlePageClick={handlePageClick}
          sortQuestions={questions}
        />
      </div>
      <SidebarRight />
    </SHomeWrap>
  );
};
