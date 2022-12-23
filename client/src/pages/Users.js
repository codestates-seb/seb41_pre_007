import { Sidebar } from '../components/Sidebar';
import { SidebarRight } from '../components/SidebarRight';
import { ReactComponent as Search } from '../image/Search.svg';
import styled from 'styled-components';

const SWrapper = styled.div`
  display: flex;
`;

const SUsers = styled.main`
  display: flex;
  flex-direction: column;
  max-width: 1100px;
  width: 1100px;
  border: 1px solid #ececec;
  border-width: 0 0 0 1px;

  .users-content-container {
    max-width: 800px;
    margin: 0 0 3em;
    margin-block-start: 0.67em;
    margin-block-end: 0.67em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
    margin-left: 5%;
  }

  .users-title {
    display: block;
    font: inherit;
    font-size: 2rem;
  }

  .users-filter-container {
    display: flex;
    justify-content: space-between;
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

  .users-filter-button {
    background-color: white;
    border: 0.5px solid gray;
    border-radius: 5px;
    :hover {
      background-color: #ececec;
    }
  }

  .users-period-container {
    display: flex;
    justify-content: flex-end;
  }

  .users-period-button {
    border: none;
    background-color: transparent;
    color: #6a737c;
    :hover,
    :active {
      color: #3b4045;
      border-bottom: 1px solid #f48024;
    }
    :active {
      font-weight: bold;
    }
  }
`;

const Users = () => {
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
            <div className="users-filter-button-container">
              <button className="users-filter-button">Reputation</button>
              <button className="users-filter-button">New users</button>
              <button className="users-filter-button">Voters</button>
              <button className="users-filter-button">Editors</button>
              <button className="users-filter-button">Moderators</button>
            </div>
          </div>
          <div className="users-period-container">
            <button className="users-period-button">week</button>
            <button className="users-period-button">month</button>
            <button className="users-period-button">quarter</button>
            <button className="users-period-button">year</button>
            <button className="users-period-button">all</button>
          </div>
        </div>
      </SUsers>
      <SidebarRight />
    </SWrapper>
  );
};

export default Users;
