import styled from 'styled-components';
import UsersProfile from '../pages/UsersProfile';

export const EditProfile = () => {
  return (
    <div>
      <UsersProfile />
      <SEditProfileWrap className="edit-profile">
        <div className="s-page-title mb24">
          <h1 className="s-page-title--header m0 baw0 p0">Edit your profile</h1>
        </div>
        <form id="user-edit-form">
          <div className="fs-title mb8">Public information </div>
          <div className="bg-white d:bg-black-025 bar-md ba bc-black-075 mb48 p24 sm:p12">
            <div className="d-flex gs12 gsy fd-column">
              <div className="flex--item">
                <div className="d-flex ai-center">
                  <div className="flex--item s-label js-change-picture">
                    Profile image
                  </div>
                </div>
              </div>
            </div>
          </div>
        </form>
      </SEditProfileWrap>
    </div>
  );
};

const SEditProfileWrap = styled.div`
  margin: 0;
  padding: 0;
  transform: translate(300px, -250px);
  .mb24 {
    margin-bottom: 24px;
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
`;
