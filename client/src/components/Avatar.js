/* eslint-disable react/prop-types */
import styled from 'styled-components';

const SAvatar = styled.div`
  img {
    border-radius: 5px;
  }
`;

const Avatar = ({ image, size }) => {
  return (
    <SAvatar>
      <img
        src={image || 'https://avatars.githubusercontent.com/u/111413253?v=4'} //기본이미지 설정
        width={size}
        height={size}
        alt="profile"
      />
    </SAvatar>
  );
};

export default Avatar;
