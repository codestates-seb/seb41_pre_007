import styled from 'styled-components';
import { Sidebar } from '../components/Sidebar';
import { SidebarRight } from '../components/SidebarRight';
import { useNavigate, Link } from 'react-router-dom';
import dummyData from '../db/dummyData.json';

// import { useEffect, useState } from 'react';
// import axios from 'axios';

export const Home = () => {
  // const [questions, setQuestions] = useState([]);
  const navigate = useNavigate();
  // useEffect(() => {
  //   const fetchData = async () => {
  //     try {
  //       const response = await axios.get('https/questions');
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
          <h1 id="top-h1">Top Questions</h1>
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
            <button type="button" className="btn btn-outline-primary">
              Interestion
            </button>
            <button type="button" className="btn btn-outline-primary">
              Bountied
            </button>
            <button type="button" className="btn btn-outline-primary">
              Hot
            </button>
            <button type="button" className="btn btn-outline-primary">
              Week
            </button>
            <button type="button" className="btn btn-outline-primary">
              Month
            </button>
          </div>
        </STopBoxList>
        <SQuestionSummary>
          <div className="singleBoxContainer">
            {dummyData.questions.map((question) => (
              <div className="singleBox" key={question.id}>
                <div>
                  <Link to={`/questions/${question.id}`} className="title">
                    {question.title}
                  </Link>
                  <p>{question.createdAt}</p>
                  <p>{question.userNickname}</p>
                </div>
              </div>
            ))}
          </div>
        </SQuestionSummary>
      </div>
      <SidebarRight />
    </SHomeWrap>
  );
};

export const SHomeWrap = styled.div`
  display: flex;
  justify-content: center;
  width: 100vw;
  .content {
    width: 800px;
    background-color: white;
    border-radius: 0;
    border: 1px solid #ececec;
    border-width: 0 0 0 1px;
  }
  .top-content {
    display: block;
  }
  .top-title {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin: 24px;
  }

  .top-btn {
    height: 40px;
  }
  #top-h1 {
    font-size: 2rem;
    margin: 0 0 1em;
    line-height: 1.3;
    padding: 0;
    border: 0;
  }
`;

export const SQuestionSummary = styled.div`
  .singleBox {
    width: 776px;
  }
  .singleBox {
    border: 1px solid #ececec;
    border-width: 1px 0;
    padding: 20px;
    .title {
      color: #0074cc;
      text-decoration: none;
      &:hover {
        color: #b4d1ef;
      }
    }
  }
`;

export const STopBoxList = styled.div`
  display: flex;
  justify-content: flex-end;
  height: 40px;
  margin-right: 24px;
  margin-bottom: 16px;

  .btn-outline-primary {
    font-size: 13px;
  }
`;
