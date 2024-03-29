import styled from 'styled-components';
import { useNavigate } from 'react-router-dom';
import { ReactComponent as QuestionIcon } from '../image/QuestionIcon.svg';
import { ReactComponent as Collectives } from '../image/Collectives.svg';
import { ReactComponent as Teams } from '../image/Teams.svg';
export const Sidebar = () => {
  const navigate = useNavigate();
  return (
    <SWrap>
      <SSidebarBox>
        <div
          role="presentation"
          onClick={() => {
            navigate('/');
          }}
        >
          <p className="hover_events padding">Home</p>
        </div>
        <div>
          <p className="font_size_small padding">PUBLIC</p>
          <SWrapQuestion
            className="hover_events padding"
            onClick={() => navigate('/questions')}
          >
            <span className="hover_events">
              <QuestionIcon />
              Questions
            </span>
          </SWrapQuestion>
          <p
            className="hover_events padding"
            role="presentation"
            onClick={() => navigate('/tags')}
          >
            Tags
          </p>
          <p
            className="hover_events padding"
            role="presentation"
            onClick={() => navigate('/users')}
          >
            Users
          </p>
          <p
            className="hover_events padding"
            role="presentation"
            onClick={() => navigate('/companies')}
          >
            Companies
          </p>
        </div>
        <div>
          <p className="font_size_small padding ">COLLECTIVES</p>
          <SWrapCollective className="hover_events">
            <span className="padding">
              <Collectives fill="#F48224" />
              Explore Collectives
            </span>
          </SWrapCollective>
        </div>
        <div>
          <p className="font_size_small padding">TEAMS</p>
          <SWrapTeam className="hover_events">
            <span className="padding">
              <Teams fill="#F48224" />
              Create free Team
            </span>
          </SWrapTeam>
        </div>
      </SSidebarBox>
    </SWrap>
  );
};

const SWrap = styled.div`
  z-index: 3;
  border-right: #4e4e4e;
  width: 164px;
  display: block;
  text-align: left;
  transform: translate(0px, 30px);

  .padding {
    padding: 10px;
    margin: 0;
  }

  .font_size_small {
    font-size: 10px;
    color: #4e4e4e;
  }
  .hover_events {
    font-size: 13px;
    cursor: pointer;
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

const SSidebarBox = styled.div`
  position: sticky;
  top: 53px;
  margin-bottom: 40px;
`;
