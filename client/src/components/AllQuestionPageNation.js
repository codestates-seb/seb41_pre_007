/* eslint-disable react/prop-types */
// import axios from 'axios';
import styled from 'styled-components';
import Pagination from 'react-js-pagination';
import dummyData from '../db/dummyData.json';
import { useState } from 'react';
import { SQuestionSummary } from '../pages/Home';
//props로 questions 받아오기
export const AllQuestionPageNation = () => {
  const [page, setPage] = useState(1);
  const data = dummyData.allQuestions;
  // const question = questions.data;
  const items = 10;

  //서버에서 메소드 받아오면 구현할 코드!
  //   const getClick = () => {
  //     axios.get('').then((res) => setData(res.data));
  //   };
  const handlePageChange = (page) => {
    setPage(page);
  };

  //   console.log(items * (page - 1), items * (page - 1) + items);

  return (
    <div>
      <SQuestionSummary>
        <div className="singleBoxContainer">
          {data
            .slice(items * (page - 1), items * (page - 1) + items)
            .map((data) => (
              <div className="singleBox" key={data.id}>
                <div>
                  <div>{data.title}</div>
                  <p>{data.createdAt}</p>
                  <p>{data.userNickname}</p>
                </div>
              </div>
            ))}
        </div>
      </SQuestionSummary>
      <PaginationBox>
        <Pagination
          activePage={page} //현재페이지
          itemsCountPerPage={10} //한 페이지당 보여줄 리스트 아이템의 개수
          totalItemsCount={40} //총 아이템의 개수
          pageRangeDisplayed={40} //Paginator 내에서 보여줄 페이지의 범위
          prevPageText={'‹'} //"이전"을 나타낼 텍스트
          nextPageText={'›'} //"다음"을 나타낼 텍스트
          onChange={handlePageChange} //페이지가 바뀔 때 핸들링해줄 함수
        />
      </PaginationBox>
    </div>
  );
};

//Pagination라이브러리에서 기본 제공하는 스타일 코드
const PaginationBox = styled.div`
  .pagination {
    display: flex;
    justify-content: center;
    margin-top: 15px;
  }
  ul {
    list-style: none;
    padding: 0;
  }
  ul.pagination li {
    display: inline-block;
    width: 30px;
    height: 30px;
    border: 1px solid #e2e2e2;
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: 1rem;
  }
  ul.pagination li:first-child {
    border-radius: 5px 0 0 5px;
  }
  ul.pagination li:last-child {
    border-radius: 0 5px 5px 0;
  }
  ul.pagination li a {
    text-decoration: none;
    color: #337ab7;
    font-size: 1rem;
  }
  ul.pagination li.active a {
    color: white;
  }
  ul.pagination li.active {
    background-color: #337ab7;
  }
  ul.pagination li a:hover,
  ul.pagination li a.active {
    color: blue;
  }
`;
