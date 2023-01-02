/* eslint-disable react/prop-types */
import styled from 'styled-components';
import Pagination from 'react-js-pagination';
import { useState, useEffect } from 'react';
import { SQuestionSummary } from '../pages/Home';
import { Link, useNavigate } from 'react-router-dom';
import axios from 'axios';

export const AllQuestionPageNation = ({ handlePageClick, sortQuestions }) => {
  const [page, setPage] = useState(1);
  const [questions, setQuestions] = useState([]);
  const items = 10;
  const navigate = useNavigate();

  const handlePageChange = (page) => {
    setPage(page);
  };

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get(
          `http://54.180.127.165:8080/questions?page=${page}&size=${items}`
        );
        setQuestions(response.data.data);
        handlePageClick(response.data.data);
      } catch {
        window.alert('오류가 발생했습니다.');
      }
    };
    fetchData();
  }, [page]);

  return (
    <div>
      <SQuestionSummary>
        <div className="singleBoxContainer">
          {sortQuestions
            ? sortQuestions.slice(0, 10).map((data) => (
                <div className="singleBox" key={data.questionId}>
                  <div>
                    <Link
                      to={`/questions/${data.questionId}`}
                      className="title"
                    >
                      {data.title}
                    </Link>
                    <p>{new Date(data.createdAt).toLocaleString()}</p>
                    <p
                      className="username"
                      role="presentation"
                      onClick={() => navigate(`/users/${data.memberId}`)}
                    >
                      {data.name}
                    </p>
                  </div>
                </div>
              ))
            : questions.slice(0, 10).map((data) => (
                <div className="singleBox" key={data.questionId}>
                  <div>
                    <Link
                      to={`/questions/${data.questionId}`}
                      className="title"
                    >
                      {data.title}
                    </Link>
                    <p>{new Date(data.createdAt).toLocaleString()}</p>
                    <p
                      className="username"
                      role="presentation"
                      onClick={() => navigate(`/users/${data.memberId}`)}
                    >
                      {data.name}
                    </p>
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
