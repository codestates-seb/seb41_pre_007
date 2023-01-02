/* eslint-disable react/prop-types */
import { useDispatch, useSelector } from 'react-redux';
import { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import styled from 'styled-components';
import { ReactComponent as StackOver } from '../image/StackOver.svg';
import { ReactComponent as Google } from '../image/Google.svg';
import { ReactComponent as Github } from '../image/Github.svg';
import { ReactComponent as Naver } from '../image/Naver.svg';
import { loginAction } from '../redux/modules/action';

export const SModalBack = styled.div`
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.4);
  position: fixed;
  top: 0;
  overflow: hidden;
`;
export const SModal = styled.div`
  position: fixed;
  top: 0;
  overflow: hidden;
  top: 15%;
  left: 39%;
`;
export const SModalView = styled.div`
  width: 350px;
  height: 600px;
  background-color: #f1f2f3;
  display: flex;
  justify-content: center;
  flex-direction: column;
  align-items: center;
  > button {
    margin-left: 320px;
    margin-top: -50px;
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
  height: 220px;
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
    > button {
      height: 34px;
      margin-top: 15px;
      background-color: #0995ff;
      color: white;
      border: none;
      border-radius: 5px;
      &:hover {
        background-color: #0074cc;
      }
    }
  }
`;
export const Setc = styled.div`
  padding-top: 40px;
  display: flex;
  justify-content: center;
  flex-direction: column;
  align-items: center;
  font-size: 12px;
  > .up {
    margin-bottom: 15px;
    > .click {
      padding-left: 5px;
      color: #1077cd;
    }
  }
  > .down {
    > .click {
      padding-left: 5px;
      color: #1077cd;
    }
  }
`;

const Login = ({ handleIsOpen }) => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const navigate = useNavigate();
  const dispatch = useDispatch();

  const user = useSelector((state) => state.user);

  useEffect(() => {
    if (user) {
      navigate('/');
    }
  }, [user]);

  const handleChangeUsername = (e) => {
    setEmail(e.target.value);
  };

  const handleChangePassword = (e) => {
    setPassword(e.target.value);
  };

  const handleClickLogin = (e) => {
    e.preventDefault();
    if (
      email === '' ||
      email === ' ' ||
      email === null ||
      password === '' ||
      password === ' ' ||
      password === null
    ) {
      window.alert('아이디 또는 비밀번호를 모두 입력하세요!');
    } else {
      dispatch(loginAction({ email, password }))
        .then((res) => {
          console.log(res);
          window.alert('로그인에 성공했습니다');
          navigate('/');
        })
        .catch(() => {
          window.alert('로그인에 실패했습니다 다시 시도해주세요.');
        });
    }
  };

  return (
    <>
      <div>
        <SModalBack onClick={handleIsOpen}></SModalBack>

        <SModal>
          <SModalView>
            <button onClick={handleIsOpen}>x</button>
            <StackOver />
            <SSocialButton>
              <button className="GoogleLogin">
                <Google />
                <span>Log in with Google</span>
              </button>
              <button className="GithubLogin">
                <Github />
                <span>Log in with Github</span>
              </button>
              <button className="NaverLogin">
                <Naver className="Naver" />
                <span>Log in with Naver</span>
              </button>
            </SSocialButton>
            <SLoginForm>
              <div className="input-field">
                <span>Email</span>
                <input
                  type="text"
                  value={email}
                  className="InputEmail"
                  // ref={usernameRef}
                  onChange={handleChangeUsername}
                ></input>
                <span>Password</span>
                <input
                  type="text"
                  value={password}
                  className="InputPassword"
                  // ref={passwordRef}
                  onChange={handleChangePassword}
                ></input>
                <button onClick={handleClickLogin}>Login</button>
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

export default Login;
