import styled from 'styled-components';
import { Sidebar } from '../components/Sidebar';
import { useNavigate } from 'react-router-dom';
export const Home = () => {
  const navigate = useNavigate();
  return (
    <HomeWrap>
      <button onClick={() => navigate(-1)}>뒤로가기</button>
      <Sidebar />
      <div>Home클릭시 보이는 페이지입니다</div>
    </HomeWrap>
  );
};

const HomeWrap = styled.div``;
