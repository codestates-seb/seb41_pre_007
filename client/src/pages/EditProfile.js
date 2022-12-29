/* eslint-disable react/prop-types */
import styled from 'styled-components';
import { useEffect, useState } from 'react';
import axios from 'axios';
import { useNavigate, useParams } from 'react-router-dom';

export const EditProfile = ({ image, size }) => {
  const [idData, setIdData] = useState(null);
  const [name, setName] = useState('');
  const [address, setAddress] = useState('');
  const [profileImage, setProfileImage] = useState(idData?.profileImage);
  const navigate = useNavigate();
  const { memberId } = useParams();

  const handleChangeName = (e) => {
    setName(e.target.value);
  };
  const handleChangeAddress = (e) => {
    setAddress(e.target.value);
  };
  const handleChangeAbout = (e) => {
    setProfileImage(e.target.value);
  };

  const url = 'http://54.180.127.165:8080/';
  const handleClickSubmit = () => {
    axios
      .patch(url + `${memberId}`, {
        name,
        address,
        profileImage,
      })
      .then((res) => {
        if (!res.ok) {
          console.log(res);
          if (res.status === 400) {
            window.alert('Fill in the blanks');
            throw Error('could not fetch the data for that resource');
          }
        }
        if (res.status === 200) {
          alert('축하합니다🎉 프로필 수정이 정상적으로 처리 되었습니다!');
          navigate(`/users/:id/${memberId}`);
          return location.reload();
        }
        return res;
      })
      .catch((error) => {
        console.log(error.message);
      });
  };

  useEffect(() => {
    axios
      .get(url + `${memberId}`)
      .then((res) => {
        if (!res.ok) {
          throw Error('이미지를 불러오는데 실패했습니다😢');
        }
        return res.json();
      })
      .then((data) => {
        setProfileImage(data?.profileImage);
        setIdData(data);
      })
      .catch((err) => {
        console.error(err.message);
      });
  }, []);

  return (
    <SEditProfileWrap className="edit-profile">
      <div className="s-page-title mg-b-24">
        <h1 className="title-header">Edit your profile</h1>
      </div>
      <div className="fs-26">Public information</div>
      <div className="pd-24 bd-r-3 user-edit-container">
        <div id="user-edit-form">
          <div className="fw-600">Profile image</div>
          <img
            src={image}
            width={size}
            height={size}
            alt="change profile"
            onChange={handleChangeAbout}
          />
          <form>
            <div className="mb-3">
              <label htmlFor="formFileSm" className="form-label pt-15">
                ⬇️⬇️ 변경할 프로필을 업로드 해주세요!
              </label>
              <input
                className="form-control form-control-sm pd-r-12 input-style-50p"
                id="formFileSm"
                type="file"
              />
            </div>
          </form>
          <div className="mg-t-12 fw-600">Display name</div>
          <input
            className="pd-l-12 pd-r-12 bd-r-3 fs-12 input-style input-style-50p"
            value={name}
            onChange={handleChangeName}
          />
          <div className="mg-t-12 fw-600">Address</div>
          <input
            className="pd-1-12 pd-r-12 bd-r-3 fs-12 input-style input-style-50p"
            value={address}
            onChange={handleChangeAddress}
          />
        </div>
      </div>
      <div className="mg-t-36 fs-26">Links</div>
      <div className="pd-24 bd-r-3 fl-row user-edit-container">
        <div className="fl-g-1 pd-r-16">
          <div className="fw-600">Full name</div>
          <input className="pd-l-12 pd-r-12 bd-r-3 fs-12 input-style input-style-100p" />
        </div>
        <div className="fl-g-1 pd-l-8 pd-r-8">
          <div className="fw-600">Twitter</div>
          <input className="pd-l-12 pd-r-12 bd-r-3 fs-12 input-style input-style-100p" />
        </div>
        <div className="fl-g-1 pd-l-16">
          <div className="fw-600">Github link or username</div>
          <input className="pd-l-12 pd-r-12 bd-r-3 fs-12 input-style input-style-100p" />
        </div>
      </div>
      <div className="mg-t-36 fs-26">
        Private information
        <span className="pd-l-12 fs-12">Not shown publicly</span>
      </div>
      <div className="pd-24 bd-r-3 user-edit-container">
        <div className="fw-600">Full name</div>
        <input className="pd-l-12 pd-r-12 bd-r-3 fs-12 input-style input-style-50p" />
      </div>
      <div className="mg-t-36">
        <button
          className="mg-r-12 pd-10 bd-n bd-r-3 save-profile-button"
          onClick={handleClickSubmit}
        >
          Save profile
        </button>
        <button className="pd-10 bd-n bd-r-3 cancel-button">Cancel</button>
      </div>
    </SEditProfileWrap>
  );
};

const SEditProfileWrap = styled.div`
  width: 100%;
  padding: 24px;

  .mg-t-12 {
    margin-top: 12px;
  }

  .mg-t-36 {
    margin-top: 36px;
  }

  .mg-b-24 {
    margin-bottom: 24px;
  }

  .mg-r-12 {
    margin-right: 12px;
  }

  .pd-10 {
    padding: 10px;
  }

  .pd-24 {
    padding: 24px;
  }

  .pd-l-8 {
    padding-left: 8px;
  }

  .pd-l-12 {
    padding-left: 12px;
  }

  .pd-l-16 {
    padding-left: 16px;
  }

  .pd-r-8 {
    padding-right: 8px;
  }

  .pd-r-12 {
    padding-right: 12px;
  }

  .pd-r-16 {
    padding-right: 16px;
  }

  .bd-n {
    border: none;
  }

  .bd-r-3 {
    border-radius: 3px;
  }

  .fl-row {
    display: flex;
  }

  .fl-g-1 {
    flex-grow: 1;
  }

  .fs-12 {
    font-size: 12px;
  }

  .fs-26 {
    font-size: 26px;
  }

  .fw-600 {
    font-weight: 600;
  }

  .s-page-title {
    align-items: flex-end;
    flex-direction: row;
    border-bottom: 1px solid hsl(210deg 8% 85%);
    display: flex;
    justify-content: space-between;
    padding-bottom: 16px;
    width: 100%;
  }

  .title-header {
    font-size: 2rem;
  }

  .user-edit-container {
    border: 1px solid hsl(210deg 8% 85%);

    .input-style {
      height: 36px;
      border: 1px solid #dcdcdc;
    }

    .input-style-50p {
      width: 50%;
    }

    .input-style-100p {
      width: 100%;
    }
  }

  .save-profile-button {
    color: #fff;
    border: 1px solid rgb(10, 149, 255);
    background-color: hsl(206, 100%, 52%);
    box-shadow: rgb(255 255 255 / 40%) 0px 1px 0px 0px inset;
    :hover {
      background-color: hsl(205, 46%, 32%);
    }
  }

  .cancel-button {
    color: hsl(206, 100%, 52%);
    background-color: transparent;
    :hover {
      background-color: hsl(206, 100%, 97%);
    }
  }
  .pt-15 {
    padding-top: 15px;
  }
`;
