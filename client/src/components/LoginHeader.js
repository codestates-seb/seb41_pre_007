import styled from 'styled-components';
import { ReactComponent as StackOverFlow } from '../image/StackOverFlow.svg';
import { ReactComponent as Search } from '../image/Search.svg';
import { ReactComponent as Inbox } from '../image/Inbox.svg';
import { ReactComponent as Achievements } from '../image/Achievements.svg';
import { ReactComponent as Help } from '../image/Help.svg';
import { ReactComponent as WinterBash } from '../image/WinterBash.svg';
import { ReactComponent as Logout } from '../image/Logout.svg';

const SHeaderTop = styled.div`
  width: 100vw;
  .header-top {
    background-color: #f48024;
    height: 3px;
  }
`;

const SHeader = styled.header`
  box-sizing: border-box;
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100vw;
  height: 50px;
  background-color: #fff;
  box-shadow: rgb(0 0 0 / 5%) 0px 1px 2px, rgb(0 0 0 / 5%) 0px 1px 4px,
    rgb(0 0 0 / 5%) 0px 2px 8px;

  .header-bottom {
    display: flex;
    justify-content: center;
    align-items: center;
    width: 90rem;
    max-width: 1264px;
    height: 50px;
  }

  .header-bottom-pointer {
    cursor: pointer;
  }

  .header-bottom-logo-container {
    display: flex;
    justify-content: center;
    align-items: center;
    width: 165px;
    height: 50px;
  }

  .header-bottom-logo-container:hover {
    background-color: #dcdcdc;
  }

  .header-bottom-navigation-container {
    display: flex;
  }

  .header-bottom-navigation {
    border: none;
    background-color: transparent;
    height: 30px;
    margin: 10px;
  }

  .header-bottom-navigation:hover {
    background-color: #dcdcdc;
    border-radius: 1000px;
  }

  form {
    position: relative;
    display: flex;
    flex-wrap: nowrap;
    align-items: center;
    min-width: 184px;
    flex-grow: 1;
    padding-right: 8px;
  }

  .header-bottom-search-icon {
    position: absolute;
    left: 10px;
  }

  .header-bottom-search {
    width: 100%;
    padding: 0.6em 2rem;
    border: 1px solid #dcdcdc;
    border-radius: 3px;
    cursor: text;
  }

  .header-bottom-profile-container {
    display: flex;
    justify-content: center;
    align-items: center;
    width: 40px;
    height: 50px;
  }

  .header-bottom-profile-container:hover {
    background-color: #dcdcdc;
    width: 40px;
    height: 50px;
  }

  .header-bottom-profile {
    width: 24px;
    height: 24px;
    border-radius: 5px;
  }

  .header-bottom-topbar-container {
    display: flex;
    align-items: center;
    height: 50px;
  }

  .header-bottom-topbar-background {
    display: flex;
    align-items: center;
    height: 50px;
  }

  .header-bottom-topbar-background:hover {
    background-color: #dcdcdc;
  }

  .header-bottom-topbar {
    padding: 0 10px 0 10px;
  }
`;

const LoginHeader = () => {
  return (
    <>
      <SHeaderTop>
        <div className="header-top"></div>
      </SHeaderTop>
      <SHeader>
        <div className="header-bottom">
          <div className="header-bottom-logo-container header-bottom-pointer">
            <StackOverFlow />
          </div>
          <div className="header-bottom-navigation-container">
            <button className="header-bottom-navigation header-bottom-pointer">
              <div>Products</div>
            </button>
          </div>
          <form>
            <Search className="header-bottom-search-icon" fill="#808080" />
            <input
              className="header-bottom-search"
              type="search"
              placeholder="Search..."
            ></input>
          </form>
          <div className="header-bottom-profile-container">
            <img
              className="header-bottom-profile header-bottom-pointer"
              src="https://avatars.githubusercontent.com/u/111413253?v=4"
              alt="my profile"
            />
          </div>
          <div className="header-bottom-topbar-container">
            <div className="header-bottom-topbar-background">
              <Inbox
                className="header-bottom-pointer header-bottom-topbar"
                fill="#404040"
              />
            </div>
            <div className="header-bottom-topbar-background">
              <Achievements
                className="header-bottom-pointer header-bottom-topbar"
                fill="#404040"
              />
            </div>
            <div className="header-bottom-topbar-background">
              <Help
                className="header-bottom-pointer header-bottom-topbar"
                fill="#404040"
              />
            </div>
            <div className="header-bottom-topbar-background">
              <WinterBash
                className="header-bottom-pointer header-bottom-topbar"
                fill="#404040"
              />
            </div>
            <div className="header-bottom-topbar-background">
              <Logout
                className="header-bottom-pointer header-bottom-topbar"
                fill="#404040"
              />
            </div>
          </div>
        </div>
      </SHeader>
    </>
  );
};

export default LoginHeader;
