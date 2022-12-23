import styled from 'styled-components';
import { ReactComponent as Upicon } from '../image/Upicon.svg';
import { ReactComponent as Downicon } from '../image/Downicon.svg';
import { ReactComponent as Save } from '../image/Save.svg';
import { ReactComponent as Showact } from '../image/Showact.svg';
const Answer = () => {
  return (
    <AnswerWrap>
      <AnswerList>
        <div className="answer-list top">
          <div className="answer-list top-left">
            <p>1 Answer</p>
          </div>
          <div className="answer-list top-right">
            <p>Sorted by:</p>
            <button>
              Highest scre (default)
              {/* <Upicon /> <Downicon /> */}
            </button>
          </div>
        </div>
        <div className="answer-list bottom">
          <div className="answer-list bottom-left">
            {' '}
            <Upicon />
            <div className="count-num">0</div>
            <Downicon />
            <Save />
            <Showact />
          </div>
          <div className="answer-list bottom-right"></div>
        </div>
      </AnswerList>
      <YourWrap>
        <div className="answer-top">
          <p>Your Answer</p>
        </div>
        <div className="answer-top white-card">
          <form>
            <textarea></textarea>
          </form>
          <button className="create-answer">Post Your Answer</button>
          <p>
            {' '}
            Not the answer you&apos;re lokking for? Browse other quesetions
            tagged android reactnative rn-fetch-blob or ask your own questions.{' '}
          </p>
        </div>
      </YourWrap>
    </AnswerWrap>
  );
};
const AnswerList = styled.div`
  display: flex;
  flex-direction: column;
  margin-top: 20px;
  svg {
    margin-top: 5px;
    margin-bottom: 5px;
  }
  .top {
    display: flex;
    justify-content: space-between;
    p {
      padding-top: 2px;
      padding-right: 5px;
    }

    .top-right {
      display: flex;
      flex-direction: row;
      button {
        background-color: white;
        border: 1px solid #dcdfe1;
        font-size: 12px;
        width: 150px;
        height: 35px;
      }
    }
  }

  .bottom {
    margin-top: 15px;
    .bottom-left {
      display: flex;
      flex-direction: column;
      align-items: center;
      width: 50px;
    }
  }
`;
const AnswerWrap = styled.div`
  position: sticky;
  width: 47vw;
  display: flex;
  flex-direction: column;
`;

const YourWrap = styled.div`
  display: flex;
  flex-direction: column;
  width: 100%;
  margin-top: 10px;
  padding-top: 20px;
  border: 1px solid #e3e6e8;
  border-top-width: 1px;
  border-bottom-width: 0;
  border-left-width: 0;
  border-right-width: 0;
  .answer-top {
    font-size: 20px;
  }
  textarea {
    width: 47vw;
    height: 250px;
  }
  button {
    background-color: #0995ff;
    color: white;
    margin-top: 15px;
    border-radius: 5px;
    font-size: 15px;
    height: 42px;
    border: none;
  }
  .white-card {
    p {
      margin-top: 20px;
      font-size: 17px;
    }
  }
`;

export default Answer;
