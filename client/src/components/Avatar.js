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
      <img src={image} width={size} height={size} alt="profile" />
    </SAvatar>
  );
};

export default Avatar;
