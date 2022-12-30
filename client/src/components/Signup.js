/* eslint-disable react/prop-types */
import axios from 'axios';
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import styled from 'styled-components';
import { ReactComponent as Google } from '../image/Google.svg';
import { ReactComponent as Github } from '../image/Github.svg';
import { ReactComponent as Naver } from '../image/Naver.svg';

export const SModalBack = styled.div`
  position: fixed;
  top: 0;
  overflow: hidden;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.4);
`;
export const SModal = styled.div`
  position: fixed;
  top: 0;
  overflow: hidden;
  top: 12%;
  left: 39%;
`;
export const SModalView = styled.div`
  width: 350px;
  height: 750px;
  background-color: #f1f2f3;
  margin: 0px 30px;
  display: flex;
  justify-content: center;
  flex-direction: column;
  align-items: center;
  > button {
    margin-left: 320px;
    font-size: 25px;
    background-color: none;
    border: none;
  }
`;
export const SSocialButton = styled.div`
  height: 27%;
  display: flex;
  justify-content: center;
  flex-direction: column;
  > button {
    height: 35px;
    width: 280px;
    margin-bottom: 10px;
    border-radius: 5px;
  }
  > .GoogleLogin {
    border: 0.5px solid darkgrey;
    background-color: white;
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;
    &:hover {
      background-color: #f8f9f9;
    }
    > span {
      margin-left: 8px;
    }
  }
  > .GithubLogin {
    background-color: #2f3337;
    color: white;
    border: darkgrey;
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;
    &:hover {
      background-color: black;
    }
    > span {
      margin-left: 8px;
    }
  }
  > .NaverLogin {
    background-color: #02c73c;
    color: white;
    border: darkgrey;
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;
    > span {
      margin-left: 10px;
    }
    &:hover {
      background-color: #3cb371;
    }
  }
`;
export const SLoginForm = styled.form`
  height: 500px;
  width: 280px;
  background-color: white;
  border: 2px solid #eaebeb;
  border-radius: 8px;
  display: flex;

  > .input-field {
    display: flex;
    justify-content: center;
    flex-direction: column;
    align-items: left;
    width: 240px;
    margin-left: 20px;

    > span {
      font-weight: bold;
      margin-top: 15px;
    }
    > input {
      height: 28px;
      &:focus {
        outline: 4px solid #ddeaf7;
        border: 1px solid #58a4de;
      }
    }
    > input[type='checkbox'] {
      width: 10px;
    }
    > button {
      height: 34px;
      margin-top: 8px;
      background-color: #0995ff;
      color: white;
      border: none;
      border-radius: 5px;
      &:hover {
        background-color: #0074cc;
      }
    }
    > p {
      font-size: 12px;
      margin-top: 10px;
      margin-bottom: 7px;
      color: #6b747d;
    }
    .validationText {
      font-size: 13px;
      font-weight: 700;
      color: red;
      margin-top: 0px;
      margin-bottom: 0px;
    }
  }
`;
export const Check = styled.div`
  display: flex;
  font-size: 12px;

  > input {
    position: relative;
    top: -24px;
    margin-right: 3px;
  }
`;
export const Setc = styled.div`
  margin-top: 20px;
  display: flex;
  justify-content: center;
  flex-direction: column;
  align-items: center;
  font-size: 12px;
  > .up {
    margin-bottom: 8px;
    > .click {
      padding-left: 5px;
      color: #1077cd;
    }
  }
  > .down {
    margin-bottom: 10px;
    > .click {
      padding-left: 5px;
      color: #1077cd;
    }
  }
`;

const SignUp = ({ handleIsSignOpen }) => {
  // 이름,이메일,비밀번호 전송
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  // const [loading, setLoading] = useState(false);

  //유효성 검사
  const [isValidNameErr, setIsValidNameErr] = useState({
    status: false,
    text: '',
  });
  const [isValidEmailErr, setIsValidEmailErr] = useState({
    status: false,
    text: '',
  });
  const [isValidPasswordErr, setIsValidPasswordErr] = useState({
    status: false,
    text: '',
  });
  //회원가입 성공 시 이동할 화면
  const navigate = useNavigate();

  //base url
  const url = 'http://54.180.127.165:8080';
  //서버에 회원가입 데이터 전송
  const handleSignupAxios = async (e) => {
    e.preventDefault();
    try {
      await axios
        .post(url + '/members', {
          name,
          email,
          password,
        })
        .then(() => {
          handleIsSignOpen(false);
          window.alert('축하드립니다 회원가입에 성공하셨습니다🥳');
          navigate('/');
        });
    } catch (err) {
      // handleIsSignOpen(true);
      window.alert('이미 존재하는 정보입니다. 다시 시도해주세요😭');
    }
  };

  // input값 이벤트 전달
  const handleChangeNickname = (e) => {
    setName(e.target.value);
  };
  const handleChangeEmail = (e) => {
    setEmail(e.target.value);
  };
  const handleChangePassword = (e) => {
    setPassword(e.target.value);
  };

  //유효성 검사 함수 작성
  //1. nickname 유효성 검사
  const handleValidationName = (e) => {
    if (e.target.value.length <= 0) {
      setIsValidNameErr({
        status: true,
        text: '필수 정보입니다',
      });
    } else if (e.target.value.length === 1) {
      setIsValidNameErr({
        status: true,
        text: '올바른 이름을 입력하십시오',
      });
    } else {
      setIsValidNameErr({
        status: false,
        text: '',
      });
    }
  };
  //2. email 유효성 검사
  const handleValidationEmail = (e) => {
    const emailRegex =
      // eslint-disable-next-line
      /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
    if (e.target.value <= 0) {
      setIsValidEmailErr({
        status: true,
        text: '필수 정보입니다',
      });
    } else if (e.target.value.length > 0 && !emailRegex.test(email)) {
      setIsValidEmailErr({
        status: true,
        text: '올바른 형태의 이메일이 아닙니다',
      });
    } else {
      setIsValidEmailErr({
        status: false,
        text: '',
      });
    }
  };
  //3. password 유효성 검사
  const handleValidationPassword = (e) => {
    const passwordRegex =
      /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+]).{8,16}$/;
    if (e.target.value <= 0) {
      setIsValidPasswordErr({
        status: true,
        text: '필수 정보입니다',
      });
    } else if (e.target.value.length > 0 && !passwordRegex.test(password)) {
      setIsValidPasswordErr({
        status: true,
        text: '문자와 숫자를 포함한 8자 이상이어야 합니다.',
      });
    } else {
      setIsValidPasswordErr({
        status: false,
        text: '',
      });
    }
  };

  return (
    <>
      <div>
        <SModalBack onClick={handleIsSignOpen}></SModalBack>
        <SModal>
          <SModalView>
            <button onClick={handleIsSignOpen}>x</button>
            <SSocialButton>
              <button className="GoogleLogin">
                <Google />
                <span>Sign up with Google</span>
              </button>
              <button className="GithubLogin">
                <Github />
                <span>Sign up with Github</span>
              </button>
              <button className="NaverLogin">
                <Naver className="Naver" />
                <span>Sign up with Naver</span>
              </button>
            </SSocialButton>
            <SLoginForm>
              <div className="input-field">
                <span>Display name</span>
                <input
                  type="text"
                  className="InputName"
                  value={name}
                  placeholder="닉네임"
                  onChange={handleChangeNickname}
                  onBlur={handleValidationName}
                ></input>
                {isValidNameErr.status && (
                  <span className="validationText">{isValidNameErr.text}</span>
                )}
                <span>Email</span>
                <input
                  type="text"
                  className="InputEmail"
                  value={email}
                  placeholder="이메일"
                  onChange={handleChangeEmail}
                  onBlur={handleValidationEmail}
                ></input>
                {isValidEmailErr.status && (
                  <span className="validationText">{isValidEmailErr.text}</span>
                )}
                <span>Password</span>
                <input
                  type="text"
                  className="InputPassword"
                  value={password}
                  placeholder="패스워드"
                  onChange={handleChangePassword}
                  onBlur={handleValidationPassword}
                ></input>
                {isValidPasswordErr.status && (
                  <span className="validationText">
                    {isValidPasswordErr.text}
                  </span>
                )}
                <p>
                  Passwords must contain at least eight characters, including at
                  least 1 letter and 1 number.
                </p>
                <Check>
                  <input type="checkbox" />
                  <p>
                    Opt-in to receive occasional product updates, user research
                    invitations, company announcements, and digests.
                  </p>
                </Check>
                <button className="signupbtn" onClick={handleSignupAxios}>
                  Sign up
                </button>
                <p>
                  By clicking &apos;Sign up&apos;, you agree to our terms of
                  service, privacy policy and cookie policy
                </p>
              </div>
            </SLoginForm>
            <Setc>
              <div className="up">
                <span className="unclick">Don`t have an account?</span>
                <span className="click">Sign up</span>
              </div>
              <div className="down">
                <span className="unclick">Are you an employer?</span>
                <span className="click">Sign up on Talent</span>
              </div>
            </Setc>
          </SModalView>
        </SModal>
      </div>
    </>
  );
};

export default SignUp;
