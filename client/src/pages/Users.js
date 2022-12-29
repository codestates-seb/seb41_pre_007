import { Sidebar } from '../components/Sidebar';
import { ReactComponent as Search } from '../image/Search.svg';
import styled from 'styled-components';
import { useNavigate } from 'react-router-dom';
import dummyUsers from '../db/dummyUsers.json';
import Avatar from '../components/Avatar';

const SWrapper = styled.div`
  display: flex;
  justify-content: center;
  width: 100vw;
`;

const SUsers = styled.main`
  display: flex;
  flex-direction: column;
  width: 1100px;
  border: 1px solid #ececec;
  border-width: 0 0 0 1px;

  .users-content-container {
    margin: 24px;
  }

  .users-title {
    font-size: 2rem;
    margin: 0 0 1em;
    line-height: 1.3;
    padding: 0;
    border: 0;
    margin-bottom: 30px;
  }

  .users-filter-container {
    display: flex;
    justify-content: space-between;
    margin-bottom: 30px;
  }

  .users-filter-search-form {
    position: relative;
    display: flex;
    flex-wrap: nowrap;
    align-items: center;
    min-width: 184px;
    flex-grow: 1;
    padding-right: 8px;
  }

  .users-filter-search-icon {
    position: absolute;
    left: 10px;
  }

  .users-filter-search {
    height: 2.2rem;
    padding: 0.6em 2rem;
    border: 1px solid #dcdcdc;
    border-radius: 3px;
    cursor: text;
  }

  .users-period-container {
    display: flex;
    justify-content: flex-end;
    margin-bottom: 20px;
  }

  .users-period-button {
    border: none;
    background-color: transparent;
    height: 40px;
    color: #6a737c;
    :hover {
      color: #3b4045;
      border-bottom: 1px solid #f48024;
    }
  }
`;

const SUsersContainer = styled.div`
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  grid-column-gap: 20px;
  grid-row-gap: 20px;

  .users-inform-container {
    display: flex;
  }

  .users-inform-avatar {
    margin: 10px;
  }

  .users-inform {
    display: flex;
    flex-direction: column;
  }

  .users-inform-nickname {
    font-size: 15px;
    cursor: pointer;
  }

  .users-inform-region,
  .users-inform-reputation,
  .users-inform-tags {
    font-size: 12px;
    color: #6a737c;
  }

  .users-inform-reputation {
    font-weight: bold;
  }

  .users-inform-tags-container {
    display: flex;
  }

  .users-inform-tags {
    padding-right: 4px;
  }
`;

const Users = () => {
  const navigate = useNavigate();
  return (
    <SWrapper>
      <Sidebar />
      <SUsers>
        <div className="users-content-container">
          <div className="users-title-container">
            <h1 className="users-title">Users</h1>
          </div>
          <div className="users-filter-container">
            <form className="users-filter-search-form">
              <Search className="users-filter-search-icon" fill="#808080" />
              <input
                className="users-filter-search"
                type="search"
                placeholder="Filter by user"
              ></input>
            </form>
            <div
              className="btn-group ml-auto mb12 h100"
              role="group"
              aria-label="Basic outlined example"
            >
              <button type="button" className="btn btn-outline-primary">
                Reputation
              </button>
              <button type="button" className="btn btn-outline-primary">
                New users
              </button>
              <button type="button" className="btn btn-outline-primary">
                Voters
              </button>
              <button type="button" className="btn btn-outline-primary">
                Editors
              </button>
              <button type="button" className="btn btn-outline-primary">
                Moderators
              </button>
            </div>
          </div>
          <div className="users-period-container">
            <button className="users-period-button">week</button>
            <button className="users-period-button">month</button>
            <button className="users-period-button">quarter</button>
            <button className="users-period-button">year</button>
            <button className="users-period-button">all</button>
          </div>
          <SUsersContainer>
            {dummyUsers.users.map((user) => (
              <div className="users-inform-container" key={user.id}>
                <div className="users-inform-avatar">
                  <Avatar image={user.avatar} size="48" />
                </div>
                <div className="users-inform">
                  <div
                    className="users-inform-nickname"
                    role="presentation"
                    onClick={() => navigate('/users/:id')}
                  >
                    {user.userNickname}
                  </div>
                  <div className="users-inform-region">{user.userRegion}</div>
                  <div className="users-inform-reputation">
                    {user.reputation}
                  </div>
                  <div className="users-inform-tags-container">
                    {user.tags.map((tag, idx) => (
                      <div key={idx} className="users-inform-tags">
                        {tag}
                      </div>
                    ))}
                  </div>
                </div>
              </div>
            ))}
          </SUsersContainer>
        </div>
      </SUsers>
    </SWrapper>
  );
};

export default Users;
