import styled from 'styled-components';
import { ReactComponent as Google } from '../image/Google.svg';
import { ReactComponent as Github } from '../image/Github.svg';
import { ReactComponent as Naver } from '../image/Naver.svg';
// import { useState } from 'react';

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
  height: 650px;
  background-color: #f1f2f3;
  margin: 0px 30px;
  display: flex;
  justify-content: center;
  flex-direction: column;
  align-items: center;
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
  height: 400px;
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
      margin-top: 18px;
    }
    > input {
      height: 28px;
      &:focus {
        outline: 4px solid #ddeaf7;
        border: 1px solid#58a4de;
      }
    }
    > input[type='checkbox'] {
      width: 10px;
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
    > p {
      font-size: 12px;
      margin-top: 10px;
      margin-bottom: 7px;
      color: #6b747d;
    }
  }
`;
export const Check = styled.div`
  display: flex;
  font-size: 12px;

  > input {
    position: relative;
    top: -14px;
    margin-right: 3px;
  }
`;
export const Setc = styled.div`
  margin-top: 30px;
  display: flex;
  justify-content: center;
  flex-direction: column;
  align-items: center;
  font-size: 12px;
  > .up {
    margin-bottom: 10px;
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

const SignUp = () => {
  // const [isOpen, setIsOpen] = useState(false);
  return (
    <>
      {/* <button onClick={() => setIsOpen(true)}>회원가입누르세요</button> */}
      {/* {isOpen === true ? ( */}
      <div>
        <SModalBack>
          {/* <button onClick={() => setIsOpen(false)}>닫아</button> */}
        </SModalBack>
        <SModal>
          <SModalView>
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
                <span>Display name</span>
                <input type="text" className="InputName"></input>
                <span>Email</span>
                <input type="text" className="InputEmail"></input>
                <span>Password</span>
                <input type="text" className="InputPassword"></input>
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
                <button className="signupbtn">Signup</button>
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
      {/* ) : null} */}
    </>
  );
};

export default SignUp;
