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
        <STopBoxList>
          <div className="top-boxList">
            <button className="top-btnList">Interesting</button>
            <button className="top-btnList">Bountied</button>
            <button className="top-btnList">Hot</button>
            <button className="top-btnList">Week</button>
            <button className="top-btnList">Month</button>
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
  .content {
    max-width: 700px;
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
    width: 300px;
    height: 10vh;
  }
  .top-btn {
    margin-left: 12px;
    width: 10vw;
    transform: translate(500px, -65px);
    margin: 0;
  }
  #top-h1 {
    max-width: 800px;
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

export const SQuestionSummary = styled.div`
  transform: translate(0px, -30px);
  .singleBox {
    width: 50vw;
  }
  .singleBox {
    border: 1px solid #ececec;
    border-width: 1px 0;
    padding: 20px;
  }
`;

export const STopBoxList = styled.div`
  width: 25vw;
  height: 30px;
  transform: translate(310px, -40px);
  /* display: flex; */
  margin-bottom: 16px;
  .top-boxList {
    display: inline-flex;
  }
  .top-btnList {
    font-size: 13px;
    background-color: white;
    border: 0.5px solid gray;
    border-radius: 5px;
    :hover {
      background-color: #ececec;
    }
  }
`;
