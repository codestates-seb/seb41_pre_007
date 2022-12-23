// import styled from 'styled-components';
// import { useState } from 'react';
// import dummyData from '../db/dummyData.json';
import { useNavigate } from 'react-router-dom';
import { Sidebar } from '../components/Sidebar';
import { SidebarRight } from '../components/SidebarRight';
import { SHomeWrap, STopBoxList } from '../pages/Home';
// import Pagination from 'react-js-pagination';
// import { useState } from 'react';
import { AllQuestionPageNation } from '../components/AllQuestionPageNation';

export const AllQuestions = () => {
  const navigate = useNavigate();

  return (
    <SHomeWrap>
      <Sidebar />
      <div className="top-content content">
        <div className="top-title">
          <h1 id="top-h1">All Questions</h1>
        </div>
        <div>
          <button
            type="button"
            className="btn btn-primary top-btn"
            onClick={() => navigate('/questionPost')}
          >
            Ask Question
          </button>
        </div>
        <STopBoxList>
          <div className="top-boxList">
            <button className="top-btnList">Newest</button>
            <button className="top-btnList">Active</button>
            <button className="top-btnList">Bountied</button>
            <button className="top-btnList">Unanswered</button>
            <button className="top-btnList">More</button>
          </div>
        </STopBoxList>
        <AllQuestionPageNation />
      </div>
      <SidebarRight />
    </SHomeWrap>
  );
};
