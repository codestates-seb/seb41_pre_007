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
  justify-content: center;
`;

const SContent = styled.div`
  width: 1100px;
  display: flex;
  border: 1px solid #e3e6e8;
  border-width: 0 0 0 1px;
  flex-direction: column;
`;

const STopCon = styled.div`
  padding: 24px 24px 0 24px;

  .top-title-container {
    display: flex;
    justify-content: space-between;
    border: 1px solid #e3e6e8;
    border-width: 0 0 1px 0;
  }

  .top-left {
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

  .top-content-inform {
    padding-bottom: 20px;
  }

  button {
    width: max-content;
  }
`;

const SBottomCon = styled.div`
  display: flex;
  width: 1100px;
  margin: 24px;

  .bottom-content-left {
    width: 752px;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
  }
  .top {
    display: flex;
    .btop-left {
      display: flex;
      flex-direction: column;
      align-items: center;
      height: 200px;
      svg {
        margin-top: 5px;
        margin-bottom: 5px;
      }
    }
    .btop-right {
      display: flex;
      width: 100%;
      flex-direction: column;
      margin: 24px;

      .body {
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
          margin-top: 24px;
          margin-right: 10px;
          font-size: 14px;
          color: #6f7881;
        }
        .box {
          display: flex;
          background-color: #d9e9f7;
          width: 170px;
          height: 60px;
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
          <div className="top-title-container">
            <div className=" top content top-left">
              <span className="title">{filteredData[0].title}</span>
              <div className="top-content-inform">
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
              <Answer />
            </div>
          </div>
          <SidebarRight />
        </SBottomCon>
      </SContent>
    </SViewWrap>
  );
};
export default ViewPage;
