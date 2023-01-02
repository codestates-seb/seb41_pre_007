import styled from 'styled-components';
import { useState, useEffect } from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';
import { Sidebar } from '../components/Sidebar';
import SidebarEdit from '../components/SidebarEdit';
import ToastEditor from '../components/ToastEditor';
import axios from 'axios';
import ToastViewer from '../components/ToastViewer';
import { getLocalStorage } from '../utils/localStorage';

const SWrapper = styled.div`
  display: flex;
  justify-content: center;
  box-sizing: border-box;
  width: 100vw;
`;

const SContent = styled.main`
  display: flex;
  width: 1100px;
  border: 1px solid #ececec;
  border-width: 0 0 0 1px;
  padding: 24px;

  .fl-cl {
    display: flex;
    flex-direction: column;
  }

  .w-800 {
    width: 800px;
  }

  .w-100p {
    width: 100%;
  }

  .mg-t-12 {
    margin-top: 12px;
  }

  .mg-t-24 {
    margin-top: 24px;
  }

  .mg-r-12 {
    margin-right: 12px;
  }

  .pd-10 {
    padding: 10px;
  }

  .pd-r-24 {
    padding-right: 24px;
  }

  .pd-lr-12 {
    padding-left: 12px;
    padding-right: 12px;
  }

  .fs-12 {
    font-size: 12px;
  }

  .fw-600 {
    font-weight: 600;
  }

  .bd-n {
    border: none;
  }

  .bd-r-3 {
    border-radius: 3px;
  }

  .yellow-box {
    font-size: 14px;
    padding: 12px;
    background-color: hsl(47, 87%, 94%);
    border: 1px solid hsl(47, 69%, 69%);
  }

  .warning-content {
    margin: 0;
  }

  .input-style {
    height: 36px;
    border: 1px solid #dcdcdc;
  }

  .save-edits-button {
    color: #fff;
    border: 1px solid rgb(10, 149, 255);
    background-color: hsl(206, 100%, 52%);
    box-shadow: rgb(255 255 255 / 40%) 0px 1px 0px 0px inset;
    :hover {
      background-color: hsl(205, 46%, 32%);
    }
  }

  .cancel-button {
    color: hsl(206, 100%, 52%);
    background-color: transparent;
    :hover {
      background-color: hsl(206, 100%, 97%);
    }
  }

  .add-comment-button {
    background-color: transparent;
    color: gray;
  }
`;

const AnswerEdit = () => {
  const navigate = useNavigate();
  const params = useParams();

  const url = 'http://54.180.127.165:8080/answers/' + [params.answerId];
  const [answerData, setAnswerData] = useState([]);
  const [questionData, setQuestionData] = useState([]);
  const [editContent, setEditContent] = useState('');

  useEffect(() => {
    const fetchData = async () => {
      try {
        const answerResponse = await axios.get(url);
        const questionResponse = await axios.get(
          `http://54.180.127.165:8080/questions/${params.questionId}`
        );
        setAnswerData(answerResponse.data.data);
        setQuestionData(questionResponse.data.data);
      } catch (err) {
        window.alert('오류가 발생했습니다.');
        return err;
      }
    };
    fetchData();
  }, []);

  const patchAnswer = async () => {
    try {
      await axios(`http://54.180.127.165:8080/answers/${params.answerId}`, {
        method: 'patch',
        headers: {
          'Content-Type': 'application/json',
          Authorization: `Bearer ${getLocalStorage()}`,
        },
        data: {
          answerContent: editContent,
        },
      }).then(navigate(`/questions/${params.questionId}`));
    } catch (err) {
      console.log(err);
    }
  };

  return (
    <SWrapper>
      <Sidebar />
      <SContent>
        <div className="fl-cl w-800 pd-r-24">
          <div className="bd-r-3 yellow-box">
            <p className="warning-header">
              Your edit will be placed in a queue until it is peer reviewed.
            </p>
            <p className="warning-content">
              We welcome edits that make post easier to understand and more
              valuable for readers. Because community memnbers review edits,
              please try to make the post substantially better than how you
              found it, for example, by fixing grammer or adding additional
              resources and hyperlinks.
            </p>
          </div>
          <form>
            <div className="mg-t-12 fw-600">
              <Link to={`/quesetions/${params.questionId}`}>
                {questionData.title}
              </Link>
              <ToastViewer contents={questionData.content} />
            </div>
            <div className="mg-t-12 fw-600">Answer</div>
            <ToastEditor
              onChangeHandler={setEditContent}
              value={answerData.answerContent}
            />
            <div className="mg-t-12 fw-600">Tags</div>
            <input className="w-100p pd-lr-12 fs-12 bd-r-3 input-style" />
            <div className="mg-t-12 fw-600">Edit Summery</div>
            <input
              className="w-100p pd-lr-12 fs-12 bd-r-3 input-style"
              placeholder="briefly explain your changes (corrected spelling, fixed grammer, improved formatting)"
            />
          </form>
          <div className="mg-t-24">
            <button
              className="mg-r-12 pd-10 bd-n bd-r-3 save-edits-button"
              onClick={() => patchAnswer()}
            >
              Save edits
            </button>
            <button className="pd-10 bd-n bd-r-3 cancel-button">Cancel</button>
          </div>
          <div className="mg-t-24">
            <button className="bd-n add-comment-button">Add a comment</button>
          </div>
        </div>
        <SidebarEdit />
      </SContent>
    </SWrapper>
  );
};

export default AnswerEdit;
