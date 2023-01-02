import styled from 'styled-components';
import { Sidebar } from '../components/Sidebar';
import { SidebarRight } from '../components/SidebarRight';
import { useNavigate, Link } from 'react-router-dom';
import { useEffect, useState } from 'react';
import axios from 'axios';

export const Home = () => {
  const [questions, setQuestions] = useState([]);
  const navigate = useNavigate();
  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get(
          'http://54.180.127.165:8080/questions?page=1&size=10'
        );
        setQuestions(response.data.data);
      } catch (err) {
        window.alert('오류가 발생했습니다.');
        return err;
      }
    };
    fetchData();
  }, []);

  //정렬
  const handleOldest = () => {
    let newArr = [...questions];
    let newestResult = newArr.sort((a, b) => {
      return a.questionId - b.questionId;
    });
    setQuestions(newestResult);
  };
  const handleNewest = () => {
    let newArr = [...questions];
    let newestResult = newArr.sort((a, b) => {
      return b.questionId - a.questionId;
    });
    setQuestions(newestResult);
  };

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
            <button
              type="button"
              className="btn btn-outline-primary"
              onClick={handleOldest}
            >
              Interestion
            </button>
            <button
              type="button"
              className="btn btn-outline-primary"
              onClick={handleNewest}
            >
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
            {questions.map((question) => (
              <div className="singleBox" key={question.questionId}>
                <div>
                  <Link
                    to={`/questions/${question.questionId}`}
                    className="title"
                  >
                    {question.title}
                  </Link>
                  <p>{new Date(question.createdAt).toLocaleString()}</p>
                  <p
                    className="username"
                    role="presentation"
                    onClick={() => navigate(`/users/${question.memberId}`)}
                  >
                    {question.name}
                  </p>
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
    border: 1px solid #ececec;
    border-width: 1px 0;
    padding: 20px;
    width: 776px;
    .title {
      font-size: 18px;
      color: #0074cc;
      text-decoration: none;
      &:hover {
        color: #b4d1ef;
      }
    }
    p {
      margin-bottom: 0px;
      font-size: 14px;
    }
    .username {
      cursor: pointer;
      color: black;
      &:hover {
        color: gray;
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
