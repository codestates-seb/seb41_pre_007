import styled from 'styled-components';
import { Sidebar } from '../components/Sidebar';
import { useNavigate } from 'react-router-dom';

export const Home = () => {
  const navigate = useNavigate();
  return (
    <HomeWrap>
      <Sidebar />
      <div id="content" className="top-content">
        <h1 id="top-h1">Top Questions</h1>
        <div>
          <button
            type="button"
            className="btn btn-primary top-btn"
            onClick={() => navigate('/questionPost')}
          >
            Ask Question
          </button>
        </div>
      </div>
    </HomeWrap>
  );
};

const HomeWrap = styled.div`
  display: flex;
  #content {
    max-width: 1100px;
    width: 1100px;
    background-color: white;
    border-radius: 0;
    border: 1px solid gray;
    border-top-width: 0;
    border-bottom-width: 0;
    border-left-width: 1px;
    border-right-width: 0;
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
