import styled from 'styled-components';
import { ReactComponent as StackOverFlow } from '../image/StackOverFlow.svg';
import { ReactComponent as Search } from '../image/Search.svg';
import { ReactComponent as Inbox } from '../image/Inbox.svg';
import { ReactComponent as Achievements } from '../image/Achievements.svg';
import { ReactComponent as Help } from '../image/Help.svg';
import { ReactComponent as WinterBash } from '../image/WinterBash.svg';
import { ReactComponent as Logout } from '../image/Logout.svg';
import { useNavigate } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';
import { useState, useEffect } from 'react';
import searchSlice from '../redux/modules/searchSlice';
import SearchTips from './SearchTips';
import Avatar from './Avatar';
import axios from 'axios';
import { loginSlice } from '../redux/modules/loginSlice';

const SWrapper = styled.div`
  position: sticky;
  top: 0;
  z-index: 5;
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
    border: none;
    background-color: transparent;
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

  .header-bottom-profile-container {
    display: flex;
    justify-content: center;
    align-items: center;
    width: 60px;
    height: 50px;
    cursor: pointer;
  }

  .header-bottom-profile-container:hover {
    background-color: #dcdcdc;
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
    justify-content: center;
    width: 40px;
    height: 50px;
  }

  .header-bottom-topbar-background:hover {
    background-color: #dcdcdc;
  }
`;

const LoginHeader = () => {
  const [idData, setIdData] = useState('');
  const navigate = useNavigate();
  const dispatch = useDispatch();
  // const { id } = useParams();

  const handleClickHome = () => {
    navigate(`/`);
  };
  const handleSearch = () => {
    dispatch(searchSlice.actions.setIsClicked());
  };

  const memberId = useSelector((state) => state.login.memberId);
  const isClicked = useSelector((state) => state.search.isClicked);

  const handleLogout = () => {
    dispatch(loginSlice.actions.logOut());
    navigate(`/`);
  };

  useEffect(() => {
    axios
      .get(`http://54.180.127.165:8080/members/${memberId}`)
      .then((res) => {
        // console.log(res.data.data);
        setIdData(res.data.data);
      })
      .catch((err) => {
        console.error(err.message);
      });
  }, []);

  return (
    <>
      <SWrapper>
        <SHeaderTop>
          <div className="header-top"></div>
        </SHeaderTop>
        <SHeader>
          <div className="header-bottom">
            <button
              className="header-bottom-logo-container header-bottom-pointer"
              onClick={handleClickHome}
            >
              <StackOverFlow />
            </button>
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
                onClick={handleSearch}
              ></input>
              {isClicked && <SearchTips />}
            </form>
            <div
              className="header-bottom-profile-container"
              onClick={() => navigate(`/users/${idData.memberId}`)}
              aria-hidden="true"
            >
              <Avatar
                image="https://avatars.githubusercontent.com/u/111413253?v=4"
                size="24"
              />
            </div>
            <div className="header-bottom-topbar-container">
              <div className="header-bottom-topbar-background">
                <Inbox className="header-bottom-pointer" fill="#404040" />
              </div>
              <div className="header-bottom-topbar-background">
                <Achievements
                  className="header-bottom-pointer"
                  fill="#404040"
                />
              </div>
              <div className="header-bottom-topbar-background">
                <Help className="header-bottom-pointer" fill="#404040" />
              </div>
              <div className="header-bottom-topbar-background">
                <WinterBash className="header-bottom-pointer" fill="#404040" />
              </div>
              <div
                className="header-bottom-topbar-background"
                onClick={handleLogout}
                role="presentation"
              >
                <Logout className="header-bottom-pointer" fill="#404040" />
              </div>
            </div>
          </div>
        </SHeader>
      </SWrapper>
    </>
  );
};

export default LoginHeader;
