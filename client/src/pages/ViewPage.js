import { Sidebar } from '../components/Sidebar';
import styled from 'styled-components';
import { useNavigate } from 'react-router-dom';
import { SidebarRight } from '../components/SidebarRight';
import { ReactComponent as Upicon } from '../image/Upicon.svg';
import { ReactComponent as Downicon } from '../image/Downicon.svg';
import { ReactComponent as Save } from '../image/Save.svg';
import { ReactComponent as Showact } from '../image/Showact.svg';
import Answer from '../components/Answer';
import dummyData from '../db/dummyData.json';
import Avatar from '../components/Avatar';

const SViewWrap = styled.div`
  display: flex;
  box-sizing: border-box;
`;
const SContent = styled.div`
  width: 73vw;
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
  width: 73vw;
  word-break: break-all;
  border: 1px solid #e3e6e8;
  border-top-width: 0;
  border-bottom-width: 1px;
  border-left-width: 0;
  border-right-width: 0;
  margin-top: 20px;
  padding-left: 20px;
  .top-left {
    width: 80%;

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
    padding-top: 0.3%;
  }
`;
const SBottomCon = styled.div`
  display: flex;
  flex-direction: row;
  width: 65vw;
  height: 100%;
  .bottom-content-left {
    display: flex;
    flex-direction: column;
  }
  .top {
    display: flex;
    .btop-left {
      display: flex;
      flex-direction: column;
      align-items: center;
      padding-top: 16px;
      height: 200px;
      svg {
        margin-top: 5px;
        margin-bottom: 5px;
      }
    }
    .btop-right {
      width: 47vw;
      display: flex;
      flex-direction: column;
      padding-left: 30px;

      .body {
        margin-top: 20px;

        height: 80%;
      }
      .tag-zone {
        button {
          border: none;
          margin-right: 10px;
          background-color: #e1ecf4;
          color: #4a7fa5;
          border-radius: 4px;
        }
      }
      .guide-zone {
        display: flex;

        justify-content: space-between;
        span {
          margin-right: 10px;
          font-size: 14px;
          color: #6f7881;
        }
        .box {
          display: flex;
          background-color: #d9e9f7;
          width: 170px;
          height: 60px;
          margin-left: -10px;
          align-items: center;
          padding-left: 15px;

          .user-name {
            margin-left: 10px;
            color: #237ed0;
          }
        }
      }
    }
  }

  .right {
    display: flex;
    width: 300px;
    transform: translate(100px, 0px);
    margin-left: -140px;
  }
`;

const ViewPage = () => {
  const navigate = useNavigate();
  const filteredData = dummyData.questions.filter(
    (questions) => questions.id === 1
  );

  return (
    <SViewWrap>
      <Sidebar />
      <SContent>
        <STopCon>
          <div className=" top content top-left">
            <span className="title">{filteredData[0].title}</span>
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
          <div className="bottom-content-left">
            <div className="bottom-content top">
              <div className="bottom-content btop-left">
                <Upicon />
                <div className="count-num">0</div>
                <Downicon />
                <Save />
                <Showact />
              </div>
              <div className="bottom content btop-right">
                <div className="body">{filteredData[0].content}</div>
                <div className="tag-zone">
                  <button>flutter</button>
                  <button>dart</button>
                </div>
                <div className="guide-zone">
                  <div className="guide-zone left">
                    <span>Edit</span>
                    <span>Delete</span>
                  </div>
                  <div className="guide-zone right">
                    <div className="profil box">
                      <div className="user-picture">
                        <Avatar image={filteredData[0].avatar} size="48" />
                      </div>
                      <div className="user-name">
                        {filteredData[0].userNickname}
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div className="bottom-content bottom">
              <div className="answer">
                <Answer />
              </div>
            </div>
          </div>
          <div className="bottom-content right">
            <SidebarRight />
          </div>
        </SBottomCon>
      </SContent>
    </SViewWrap>
  );
};
export default ViewPage;
