import styled from 'styled-components';
import { Sidebar } from '../components/Sidebar';
import dummyData from '../db/dummyData.json';

const Companies = () => {
  return (
    <SViewWrap>
      <Sidebar />
      <SContent>
        <h2>Companies</h2>
        <p>Learn about what it&aps;s like to work at companies</p>
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
        <span className="count-company">142 companies</span>
        <SCompanies>
          <div className="single-company">
            {dummyData.questions.map((question) => (
              <div className="singleBox" key={question.id}>
                <div>
                  <p>{question.company}</p>
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
  box-sizing: border-box;
`;
const SContent = styled.div`
  width: 73vw;
  display: flex;
  border: 1px solid #e3e6e8;
  border-top-width: 0;
  border-bottom-width: 0;
  border-left-width: 1px;
  border-right-width: 0;
  padding-top: 25px;
  flex-direction: column;
  h2 {
    padding-left: 20px;
  }
  p {
    color: #6a737c;
    margin-top: -5px;
    padding-left: 20px;
  }

  .count-company {
    margin-top: 15px;
    padding-left: 20px;
  }
  .searchbox {
    display: flex;
    height: 40px;
    color: #babfc3;
    margin-top: -5px;
    padding-left: 20px;
    .all-search {
      flex-grow: 4;
      margin-right: 2px;
      border: 1px solid #babfc3;
      border-radius: 5px;
      &:focus {
        outline: 4px solid #ddeaf7;
        border: 1px solid#58a4de;
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
        border: 1px solid#58a4de;
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
      flex-grow: 2;
      padding-left: 10px;
      border: 1px solid #babfc3;
      border-top-width: 0;
      border-bottom-width: 0;
      border-left-width: 1px;
      border-right-width: 0;
      & button {
        width: 130px;
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
  .single-company {
    margin-top: 10px;

    .singleBox {
      padding-left: 20px;
      padding-top: 20px;
      border: 1px solid #d6d9dc;
      border-top-width: 1px;
      border-bottom-width: 0;
      border-left-width: 0;
      border-right-width: 0;
    }
  }
`;
export default Companies;
