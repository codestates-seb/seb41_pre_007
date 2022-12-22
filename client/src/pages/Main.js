import Footer from '../components/Footer';
import LogoutHeader from '../components/LogoutHeader';
import styled from 'styled-components';

const Body = styled.main`
  .main-content-container {
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 50px;
  }

  .main-content-background {
    display: flex;
    flex-direction: column;
    align-items: center;
    background-color: hsl(210, 8%, 25%);
    border-radius: 10px;
    width: 80vw;
  }

  .main-content-card-container {
    display: flex;
    justify-content: center;
    width: 100%;
    padding: 50px;
  }

  .main-content-card {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    width: 40%;
    height: 15rem;
    border-radius: 10px;
    margin: 0 1rem 0 1rem;
  }

  .card-orange {
    background-color: hsl(27, 95%, 90%);
  }

  .card-blue {
    background-color: hsl(206, 96%, 90%);
  }

  .card-content {
    margin: 1rem;
    text-align: center;
  }

  .card-button {
    width: 60%;
    height: 3rem;
    margin: 1rem;
    border: none;
    border-radius: 5px;
    color: #fff;
  }

  .card-button-orange {
    background-color: #f2740d;
  }

  .card-button-blue {
    background-color: #0a95ff;
  }

  .main-content-p-container {
    height: 25rem;
  }

  p {
    text-align: center;
    font-size: xx-large;
    font-weight: bolder;
    color: #fff;
  }

  .p-orange {
    color: #f2740d;
  }

  .main-content-etc {
    display: flex;
    justify-content: center;
    align-items: center;
    margin-top: 4rem;
  }

  .main-content-etc > div {
    font-size: 20px;
  }

  .main-content-etc > button {
    margin-left: 20px;
    width: 12rem;
    height: 3rem;
    border: none;
    background-color: #fff;
    border: 1px solid #0a95ff;
    color: #0a95ff;
  }
`;

const Main = () => {
  return (
    <>
      <LogoutHeader />
      <Body>
        <div className="main-content-container">
          <div className="main-content-background">
            <div className="main-content-card-container">
              <div className="main-content-card card-orange">
                <div className="card-content">
                  Find the best answer to your techniqual question, help others
                  answer theirs
                </div>
                <button className="card-button card-button-orange">
                  Join the community
                </button>
              </div>
              <div className="main-content-card card-blue">
                <div className="card-content">
                  Want a secure, private space for your technical knowledge?
                </div>
                <button className="card-button card-button-blue">
                  Discover Teams
                </button>
              </div>
            </div>
            <div className="main-content-p-container">
              <p>Every</p>
              <p className="p-orange">Developer</p>
              <p>has a tab open to</p>
              <p>Stack Overflow</p>
            </div>
          </div>
          <div className="main-content-etc">
            <div>
              🔓 Build a private community to share technical or non-technical
              knowledges.
            </div>
            <button>Create a free Team</button>
          </div>
        </div>
      </Body>
      <Footer />
    </>
  );
};

export default Main;
