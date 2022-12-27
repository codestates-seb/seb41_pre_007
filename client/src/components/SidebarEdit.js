import styled from 'styled-components';

const SidebarEdit = () => {
  return (
    <SSidebarRightWrap>
      <div className="s-sidebarWidget">
        <ul id="d-block">
          <div className="s-sidebarWidget--header px12-15">How to Edit</div>
          <li className="s-sidebarWidget--item first">
            Correct minor typos or mistakes
          </li>
          <li className="s-sidebarWidget--item">
            Clarify meaning without changing it
          </li>
          <li className="s-sidebarWidget--item">
            Add related resources or links
          </li>
          <li className="s-sidebarWidget--item">
            Always respect the {`author's`} intent
          </li>
          <li className="s-sidebarWidget--item">
            {`Don't`} use edits to reply to the author
          </li>
        </ul>
      </div>
    </SSidebarRightWrap>
  );
};

const SSidebarRightWrap = styled.div`
  width: 300px;
  position: relative;
  font-size: 13px;
  .s-sidebarWidget {
    margin-bottom: 16px;
    box-shadow: 1px 1px 5px gray;
  }
  #d-block {
    background-color: #fcf8ea;
    padding: 0;
  }
  .s-sidebarWidget--header {
    font-size: 12px;
    font-weight: bold;
    margin-top: 30px;
    background-color: hsl(47deg 83% 91%);
    border-top-left-radius: 3px;
    border-top-right-radius: 3px;
  }
  .s-sidebarWidget--item {
    margin-left: 30px;
    padding-bottom: 15px;
  }
  .first {
    margin-top: 15px;
  }
  .px-bottom-10 {
    padding-bottom: 16px;
  }
  .fl-shrink0 {
    flex-shrink: 0;
  }
  .flex--item1 {
    flex-basis: 8.33333333%;
  }
  .px12-15 {
    padding: 12px 15px 12px 15px;
  }
`;

export default SidebarEdit;
