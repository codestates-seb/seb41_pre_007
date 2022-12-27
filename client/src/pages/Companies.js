import styled from 'styled-components';
import { Sidebar } from '../components/Sidebar';
import dummyData from '../db/dummyCompanies.json';
import Avatar from '../components/Avatar';
import { ReactComponent as Location } from '../image/Location.svg';

const Companies = () => {
  return (
    <SViewWrap>
      <Sidebar />
      <SContent>
        <div className="content">
          <h2>Companies</h2>
          <p>Learn about what it&apos;s like to work at companies</p>
          <div className="searchbox">
            <input
              className="all-search"
              type="search"
              placeholder="Search all companies"
            ></input>
            <input
              className="location-search"
              type="search"
              placeholder="Search company by location"
            ></input>
            <button className="search-button">Search</button>
            <div className="right-line">
              <button>Filter by tag</button>
            </div>
          </div>
          <div className="count-company">
            {dummyData.companies.length} companies
          </div>
        </div>
        <SCompanies>
          <div className="company-list">
            {dummyData.companies.map((companies) => (
              <div className="singleBox" key={companies.id}>
                <div className="companies-logo">
                  <Avatar image={companies.logo} size="80" />
                </div>
                <div className="companies-info">
                  <span className="name">{companies.companyName}</span>
                  <div className="location">
                    <Location fill="RGB(208, 211, 213)" />
                    <p>{companies.companyRegion}</p>
                  </div>
                  <span className="explain">{companies.explanation}</span>
                  <button>{companies.tags}</button>
                </div>
              </div>
            ))}
          </div>
        </SCompanies>
      </SContent>
    </SViewWrap>
  );
};

const SViewWrap = styled.div`
  display: flex;
  justify-content: center;
  width: 100vw;
`;

const SContent = styled.div`
  width: 1100px;
  display: flex;
  flex-direction: column;
  border-radius: 0;
  border: 1px solid #ececec;
  border-width: 0 0 0 1px;

  .content {
    margin: 24px 24px 0 24px;
  }

  p {
    color: #6a737c;
    margin-top: -5px;
  }

  .count-company {
    padding-top: 10px;
  }
  .searchbox {
    display: flex;
    height: 40px;
    color: #babfc3;
    margin-top: -5px;
    .all-search {
      flex-grow: 4;
      margin-right: 2px;
      border: 1px solid #babfc3;
      border-radius: 5px;
      &:focus {
        outline: 4px solid #ddeaf7;
        border: 1px solid #58a4de;
      }
    }
    .location-search {
      flex-grow: 4;
      margin-left: 2px;
      margin-right: 2px;
      border: 1px solid #babfc3;
      border-radius: 5px;
      &:focus {
        outline: 4px solid #ddeaf7;
        border: 1px solid #58a4de;
      }
    }
    .search-button {
      flex-grow: 0.5;
      margin-left: 2px;
      margin-right: 10px;
      background-color: #0995ff;
      color: white;
      border: none;
      border-radius: 5px;
    }
    .right-line {
      padding-left: 10px;
      border: 1px solid #babfc3;
      border-top-width: 0;
      border-bottom-width: 0;
      border-left-width: 1px;
      border-right-width: 0;
      & button {
        background-color: white;
        border: 1px solid #babfc3;
        height: 40px;
        border-radius: 5px;
        color: #6a737c;
      }
    }
  }
`;

const SCompanies = styled.div`
  .company-list {
    margin-top: 10px;

    .singleBox {
      display: flex;
      padding-left: 20px;
      padding-top: 20px;
      margin-bottom: 20px;
      width: 1076px;
      border: 1px solid #d6d9dc;
      border-top-width: 1px;
      border-bottom-width: 0;
      border-left-width: 0;
      border-right-width: 0;
      .companies-info {
        display: flex;
        flex-direction: column;
        margin-left: 20px;
        .name {
          color: #0074cc;
          font-size: 1.1rem;
        }
        .location {
          color: #6a737c;
          font-size: 0.9rem;
          display: flex;
          margin-top: 2px;

          p {
            padding-left: 5px;
            padding-top: 3px;
          }
        }
      }
      .explain {
        font-size: 0.9rem;
        margin-top: -10px;
        margin-bottom: 5px;
      }
      button {
        border: none;
        width: fit-content;
        border-radius: 4px;
        background-color: #e1ecf4;
        color: #5485a9;
        font-size: 0.8rem;
      }
    }
  }
`;
export default Companies;
