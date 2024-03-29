import styled from 'styled-components';
import { useParams } from 'react-router-dom';
import { Sidebar } from '../components/Sidebar';
import Avatar from '../components/Avatar';
import { EditProfile } from './EditProfile';
import { ReactComponent as Cake } from '../image/Cake.svg';
import { ReactComponent as Time } from '../image/Time.svg';
import { ReactComponent as Location } from '../image/Location.svg';
import { ReactComponent as Pencil } from '../image/Pencil.svg';
import { ReactComponent as Network } from '../image/Network.svg';
import { useState, useEffect } from 'react';
import axios from 'axios';

const SWrapper = styled.div`
  display: flex;
  justify-content: center;
  width: 100vw;
`;

const SProfile = styled.main`
  display: flex;
  flex-direction: column;
  width: 1100px;
  border: 1px solid #ececec;
  border-width: 0 0 0 1px;

  .profile-content-wrapper {
    display: flex;
    justify-content: space-between;
    margin: 30px;
  }

  .profile-content-container {
    display: flex;
  }

  .user-inform-container {
    display: flex;
    flex-direction: column;
    justify-content: center;
    margin: 15px;
  }

  .user-inform-nickname {
    font-size: 32px;
    font-weight: 500;
    margin-bottom: 3px;
  }

  .user-detail-container {
    display: flex;
    align-items: center;
    margin: 4px 0;
  }

  .color-gray {
    color: hsl(210, 8%, 60%);
  }

  .font-size-12 {
    font-size: 12px;
  }

  .user-detail {
    margin: 0 5px;
  }

  .user-button {
    background-color: transparent;
    border: 1px solid hsl(210, 8%, 60%);
    border-radius: 3px;
    padding: 4px 8px;
    margin: 0 3px;
    :hover {
      background-color: hsl(210, 8%, 97.5%);
    }
  }
`;

const UsersProfile = () => {
  const [isEdit, setIsEdit] = useState(false);
  const { id } = useParams(); //현재 접속한 페이지의 url에서 파라미터 값을 가져옴
  const [idData, setIdData] = useState('');

  useEffect(() => {
    axios
      .get(`http://54.180.127.165:8080/members/${id}`)
      .then((res) => {
        setIdData(res.data.data);
      })
      .catch((err) => {
        console.error(err.message);
      });
  }, [idData]);

  return (
    <SWrapper>
      <Sidebar />
      <SProfile>
        <div className="profile-content-wrapper">
          <div className="profile-content-container">
            <div className="user-profile-avatar">
              <Avatar image={idData?.profileImage} size="128" />
            </div>
            <div className="user-inform-container">
              <div className="user-inform-nickname">{idData?.name}</div>
              <div className="user-detail-container">
                <Cake fill="hsl(210,8%,60%)" />
                <div className="user-detail color-gray font-size-12">
                  Member for 1months
                </div>
                <Time fill="hsl(210,8%,60%)" />
                <div className="user-detail color-gray font-size-12">
                  Last seen today
                </div>
              </div>
              <div className="user-detail-container">
                <Location fill="hsl(210,8%,60%)" />
                <div className="user-detail color-gray font-size-12">
                  {idData?.address}
                </div>
              </div>
            </div>
          </div>
          <div className="user-button-container">
            <button
              className="user-button"
              onClick={() => {
                setIsEdit((prev) => !prev);
              }}
            >
              <Pencil fill="hsl(210,8%,60%)" />
              <span className="color-gray font-size-12">Edit profile</span>
            </button>
            <button className="user-button">
              <Network />
              <span className="color-gray font-size-12">Network profile</span>
            </button>
          </div>
        </div>
        {isEdit && <EditProfile image={idData.profileImage} size="164" />}
      </SProfile>
    </SWrapper>
  );
};

export default UsersProfile;
