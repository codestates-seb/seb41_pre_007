import { useNavigate } from 'react-router-dom';
import { Sidebar } from '../components/Sidebar';
import { SidebarRight } from '../components/SidebarRight';
import { SHomeWrap, STopBoxList } from '../pages/Home';
import { AllQuestionPageNation } from '../components/AllQuestionPageNation';
// import { useEffect, useState } from 'react';
// import axios from 'axios';

export const AllQuestions = () => {
  // const [questions, setQuestions] = useState([]);
  const navigate = useNavigate();
  // useEffect(() => {
  //   const fetchData = async () => {
  //     try {
  //       const response = await axios.get(
  //         'https/questions?page={page}&size={size}'
  //       );
  //       setQuestions(response.data);
  //     } catch {
  //       window.alert('오류가 발생했습니다.');
  //     }
  //   };
  //   fetchData();
  // }, []);

  return (
    <SHomeWrap>
      <Sidebar />
      <div className="top-content content">
        <div className="top-title">
          <h1 id="top-h1">All Questions</h1>
          <button
            type="button"
            className="btn btn-primary top-btn"
            onClick={() => navigate('/questionPost')}
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
            <button type="button" className="btn btn-outline-primary">
              Newest
            </button>
            <button type="button" className="btn btn-outline-primary">
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
        <AllQuestionPageNation />
      </div>
      <SidebarRight />
    </SHomeWrap>
  );
};
