import { Sidebar } from '../components/Sidebar';
import styled from 'styled-components';
import { useNavigate } from 'react-router-dom';
// import dummyData from '../db/dummyData';

const SViewWrap = styled.div`
  display: flex;
  box-sizing: border-box;
`;
const SContent = styled.div`
  width: 65vw;
  display: flex;
  border: 1px solid #e3e6e8;
  border-top-width: 0;
  border-bottom-width: 0;
  border-left-width: 1px;
  border-right-width: 0;
  padding-left: 20px;
  flex-direction: column;
`;
const STopCon = styled.div`
  display: flex;
  height: 20%;
  width: 65vw;
  word-break: break-all;
  border: 1px solid #e3e6e8;
  border-top-width: 0;
  border-bottom-width: 1px;
  border-left-width: 0;
  border-right-width: 0;
  margin-top: 20px;
  padding-left: 20px;
  .top-left {
    width: 84%;
    padding-right: 20px;
    .three {
      color: #6a737c;
      font-size: 13px;
      margin-right: 3px;
    }
    .val {
      font-size: 13px;
      margin-right: 15px;
    }
  }
  .title {
    font-size: 27px;
  }
  .top-right {
    padding-top: 1%;
  }
`;
const SBottomCon = styled.div`
  display: flex;
  flex-direction: row;
  width: 65vw;
  .bottom-left {
    width: 47vw;
  }
  .bottom-right {
    margin-top: 20px;
    display: flex;

    /* ul {
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
      list-style: none;
      background-color: #fdf7e2;
      width: 280px;
      height: 400px;
      padding-left: 0px;
      .top {
        background-color: #fbf3d5;
        height: 30px;
        width: 280px;
        font-size: 14px;
      }
      .bot {
        height: 49px;
      }
    } */
  }
`;

const ViewPage = () => {
  const navigate = useNavigate();
  return (
    <SViewWrap>
      <Sidebar />
      <SContent>
        <STopCon>
          <div className=" top content top-left">
            <span className="title">What do you eat?</span>
            <div>
              <span className="three">Asked</span>
              <span className="val">today</span>
              <span className="three">Modified</span>
              <span className="val">today</span>
              <span className="three">Viewed</span>
              <span className="val">6times</span>
            </div>
          </div>
          <div className="top content top-right">
            <button
              type="button"
              className="btn btn-primary top-btn"
              onClick={() => navigate('/questionPost')}
            >
              Ask Question
            </button>
          </div>
        </STopCon>
        <SBottomCon>
          <div className="bottom content bottom-left"></div>
          <div className="bottom content bottom-right">
            {/* <ul className="yellow-box">
              <li className="yellow top">The Overflow Blog</li>
              <li className="yellow bot">
                I spent tow years trying to do what Backstage does for free
              </li>
              <li className="yellow bot">
                The complete guide to protecting your APIs with OAuth2 (part 1)
              </li>
              <li className="yellow top">Featured on Meta</li>
              <li className="yellow bot">
                Navigation and UI research starting soon
              </li>
              <li className="yellow bot">
                2022 Community Moderator Election Results - now with two more
                mods!
              </li>
              <li className="yellow bot">
                Temporary policy: ChatGPT is banned
              </li>
              <li className="yellow bot">
                I&apos;m standing down as a moderator
              </li>
              <li className="yellow bot">
                Proposing a Community-Specific Closure Reason for non-English
                content
              </li>
            </ul> */}
          </div>
        </SBottomCon>
      </SContent>
    </SViewWrap>
  );
};
export default ViewPage;
