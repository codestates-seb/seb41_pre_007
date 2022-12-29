import styled from 'styled-components';
import { ReactComponent as Upicon } from '../image/Upicon.svg';
import { ReactComponent as Downicon } from '../image/Downicon.svg';
import { ReactComponent as Save } from '../image/Save.svg';
import { ReactComponent as Showact } from '../image/Showact.svg';
import ToastEditor from './ToastEditor';
import axios from 'axios';
import { useState } from 'react';

const Answer = () => {
  const [answer, setAnswer] = useState('');
  const requestBody = { answerContent: answer };

  const postAnswer = () => {
    axios
      .post(`http://54.180.127.165:8080/answers`, requestBody)
      .then((res) => console.log(res))
      .catch((err) => console.log(err));
  };
  console.log(answer);
  return (
    <AnswerWrap>
      <AnswerList>
        <div className="answer-list top">
          <div className="answer-list top-left">
            <p>1 Answer</p>
          </div>
          <div className="answer-list top-right">
            <p>Sorted by:</p>
            <button>Highest score (default)</button>
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
          <div className="answer-list bottom-right">
            <div className="body">hiiiiii</div>
            <div className="guide-zone">
              <div className="guide-zone left">
                <span>Share</span>
                <span>Edit</span>
                <span>Follow</span>
              </div>
            </div>
          </div>
        </div>
      </AnswerList>
      <YourWrap>
        <div className="answer-top">
          <p>Your Answer</p>
        </div>
        <div className="answer-top white-card">
          <form>
            <ToastEditor onChangeHandler={setAnswer} />
          </form>
          <button className="create-answer" onClick={postAnswer}>
            Post Your Answer
          </button>
          <p>
            {' '}
            Not the answer you&apos;re looking for? Browse other quesetions
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
  border: 1px solid #e3e6e8;
  border-width: 0 0 1px 0;
  margin-right: 24px;
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
    padding-bottom: 24px;
    display: flex;
    .bottom-left {
      display: flex;
      flex-direction: column;
      align-items: center;
    }
    .bottom-right {
      margin-left: 20px;
      margin-top: 10px;
      .body {
        height: 80%;
      }
      .guide-zone {
        display: flex;
        justify-content: space-between;
        span {
          margin-right: 10px;
          font-size: 12px;
          color: #6f7881;
        }
      }
    }
  }
`;
const AnswerWrap = styled.div`
  width: 752px;
  display: flex;
  flex-direction: column;
`;

const YourWrap = styled.div`
  display: flex;
  flex-direction: column;
  margin-top: 30px;
  margin-right: 24px;
  padding-top: 20px;
  .answer-top {
    font-size: 20px;
  }
  textarea {
    width: 100%;
    height: 250px;
  }
  .create-answer {
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
