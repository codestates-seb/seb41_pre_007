/* eslint-disable react/prop-types */
import styled from 'styled-components';

const SAvatar = styled.div`
  img {
    border-radius: 5px;
  }
`;
//props로 idData 넘겨줘야함
const Avatar = ({ image, size }) => {
  return (
    <SAvatar>
      {/* src={idData?.profile} */}
      <img src={image} width={size} height={size} alt="profile" />
    </SAvatar>
  );
};

export default Avatar;
