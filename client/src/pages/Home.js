import styled from 'styled-components';
import { Sidebar } from '../components/Sidebar';
import { SidebarRight } from '../components/SidebarRight';
import { useNavigate } from 'react-router-dom';
import dummyData from '../db/dummyData.json';

export const Home = () => {
  const navigate = useNavigate();
  return (
    <SHomeWrap>
      <Sidebar />
      <div className="top-content content">
        <div className="top-title">
          <h1 id="top-h1">Top Questions</h1>
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
                  <div>{question.title}</div>
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
  .content {
    width: 700px;
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
    margin: 30px;
  }

  .top-btn {
    height: 40px;
  }
  #top-h1 {
    max-width: 700px;
    display: block;
    font: inherit;
    font-size: 2rem;
  }
`;

export const SQuestionSummary = styled.div`
  .singleBox {
    width: 670px;
  }
  .singleBox {
    border: 1px solid #ececec;
    border-width: 1px 0;
    padding: 20px;
  }
`;

export const STopBoxList = styled.div`
  display: flex;
  justify-content: flex-end;
  height: 40px;
  margin-right: 30px;
  margin-bottom: 16px;

  .btn-outline-primary {
    font-size: 13px;
  }
`;
