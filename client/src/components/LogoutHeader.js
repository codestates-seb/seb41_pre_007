import styled from 'styled-components';
import { ReactComponent as StackOverFlow } from '../image/StackOverFlow.svg';
import { ReactComponent as Search } from '../image/Search.svg';

const SWrapper = styled.div`
  position: sticky;
  top: 0;
`;

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
    height: 2.2rem;
    padding: 0.6em 2rem;
    border: 1px solid #dcdcdc;
    border-radius: 3px;
    cursor: text;
  }

  .header-bottom-ls-button {
    width: 68px;
    height: 32px;
    border-radius: 3px;
    margin: 2px;
  }

  .header-bottom-login {
    color: #39739d;
    border: 1px solid rgb(122, 167, 199);
    background-color: #e1ecf4;
    box-shadow: rgb(255 255 255 / 70%) 0px 1px 0px 0px inset;
  }

  .header-bottom-signup {
    color: #fff;
    border: 1px solid rgb(10, 149, 255);
    background-color: hsl(206, 100%, 52%);
    box-shadow: rgb(255 255 255 / 40%) 0px 1px 0px 0px inset;
  }

  .header-bottom-login:hover {
    background-color: hsl(205, 57%, 81%);
  }

  .header-bottom-signup:hover {
    background-color: hsl(205, 46%, 32%);
  }
`;

const LogoutHeader = () => {
  return (
    <SWrapper>
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
              <div>About</div>
            </button>
            <button className="header-bottom-navigation header-bottom-pointer">
              <div>Products</div>
            </button>
            <button className="header-bottom-navigation header-bottom-pointer">
              <div>For Teams</div>
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
          <div>
            <button className="header-bottom-ls-button header-bottom-login header-bottom-pointer">
              Log in
            </button>
            <button className="header-bottom-ls-button header-bottom-signup header-bottom-pointer">
              Sign up
            </button>
          </div>
        </div>
      </SHeader>
    </SWrapper>
  );
};

export default LogoutHeader;
