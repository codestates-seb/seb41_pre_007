import styled from 'styled-components';
import { useNavigate } from 'react-router-dom';
import { ReactComponent as QuestionIcon } from '../image/QuestionIcon.svg';
import { ReactComponent as Collectives } from '../image/Collectives.svg';
import { ReactComponent as Teams } from '../image/Teams.svg';
export const Sidebar = () => {
  const navigate = useNavigate();
  return (
    <SWrap>
      <div
        role="presentation"
        onClick={() => {
          navigate('/home');
        }}
      >
        <p className="hover_events padding px-padding10">Home</p>
      </div>
      <div>
        <p className="font_size_small px-padding10">PUBLIC</p>
        <SWrapQuestion className="hover_events px-padding10">
          <p>
            <QuestionIcon />
          </p>
          <span role="presentation" onClick={() => navigate('/allQuestions')}>
            Questions
          </span>
        </SWrapQuestion>
        <p className="hover_events padding px-padding10">Tags</p>
        <p className="hover_events padding px-padding10">Users</p>
        <p className="hover_events padding px-padding10">Companies</p>
      </div>

      <div>
        <p className="font_size_small px-padding10">COLLECTIVES</p>
        <SWrapCollective className="hover_events">
          <p>
            <Collectives fill="#F48224" />
          </p>
          <span className="px-padding10">Explore Collectives</span>
        </SWrapCollective>
      </div>

      <div>
        <p className="font_size_small">TEAMS</p>
        <SWrapTeam className="hover_events">
          <p>
            <Teams fill="#F48224" />
          </p>
          <span>Create free Team</span>
        </SWrapTeam>
      </div>
    </SWrap>
  );
};

const SWrap = styled.div`
  position: sticky;
  top: 0px;
  z-index: 3;
  border-right: #4e4e4e;
  width: 250px;
  display: block;
  text-align: left;
  margin-left: 100px;
  position: sticky;
  /* box-sizing: border-box; */
  /* border: 0.5px solid #f1f2f3; */
  /* transform: translateZ(0); */
  /* flex-shrink: 0; */
  /* position: relative !important; */
  .padding {
    padding: 1rem;
    margin: 0;
  }
  .px-padding10 {
    padding-right: 50px;
  }
  .font_size_small {
    font-size: 10px;
    color: #4e4e4e;
  }
  .hover_events {
    font-size: 13px;
  }

  .hover_events:hover {
    background-color: #f1f2f3;
    font-weight: bold;
  }
`;

const SWrapQuestion = styled.div`
  display: flex;
  align-items: center;
`;

const SWrapCollective = styled.div`
  display: flex;
  align-items: center;
`;

const SWrapTeam = styled.div`
  display: flex;
  align-items: center;
`;
