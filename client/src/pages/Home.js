import styled from 'styled-components';
import { Sidebar } from '../components/Sidebar';
import { useNavigate } from 'react-router-dom';
import dummyData from '../db/dummyData.json';

export const Home = () => {
  const navigate = useNavigate();
  return (
    <SHomeWrap>
      <Sidebar />
      {/* top */}
      <div id="content" className="top-content content">
        <div id="top-h1">
          <h1>Top Questions</h1>
        </div>
        <div>
          <button
            type="button"
            className="btn btn-primary top-btn"
            onClick={() => navigate('/questionPost')}
          >
            Ask Question
          </button>
        </div>
        {/* bottum */}
        <hr></hr>
        <SQuestionSummary>
          <div className="singleBoxContainer">
            {dummyData.questions.map((question) => (
              <div className="singleBox" key={question.id}>
                <div>{question.title}</div>
                <p>{question.createdAt}</p>
                <p>{question.userNickname}</p>
              </div>
            ))}
          </div>
        </SQuestionSummary>
      </div>
    </SHomeWrap>
  );
};

const SHomeWrap = styled.div`
  display: flex;
  .content {
    max-width: 1100px;
    width: 1100px;
    background-color: white;
    border-radius: 0;
    border: 1px solid #ececec;
    border-width: 0 0 0 1px;
  }
  .top-content {
    display: flex;
  }
  .top-btn {
    margin-left: 12px;
    width: 10vw;
    transform: translate(500px, 30px);
    margin: 0;
  }
  #top-h1 {
    display: block;
    font: inherit;
    font-size: 2rem;
    margin: 0 0 3em;
    margin-block-start: 0.67em;
    margin-block-end: 0.67em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
    margin-left: 5%;
  }
`;

const SQuestionSummary = styled.div`
  transform: translate(-300px, 120px);
  .singleBox {
    border: 1px solid #ececec;
    border-width: 1px 0;
    width: 50vw;
  }
`;
