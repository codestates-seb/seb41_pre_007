import styled from 'styled-components';
import { ReactComponent as Pencil } from '../image/Pencil.svg';
import { ReactComponent as StackOver } from '../image/StackOver.svg';

export const SidebarRight = () => {
  return (
    <SSidebarRightWrap>
      <div className="s-sidebarWidget">
        <ul id="d-block">
          <li className="s-sidebarWidget--header px12-15">The Overflow Blog</li>
          <li className="s-sidebarWidget--item d-flex px16">
            <Pencil className="flex--item1 fl-shrink0" />
            Best practices to increase the speed for Next.js apps
          </li>
          <li className="s-sidebarWidget--item d-flex px16">
            <Pencil className="flex--item1 fl-shrink0" /> I spent two years
            trying to do what Backstage does for free
          </li>

          <li className="s-sidebarWidget--header px12-15">Featured on Meta</li>
          <li className="s-sidebarWidget--item px16">
            <StackOver width="14" height="14" />
            Navigation and UI research starting soon
          </li>
          <li className="s-sidebarWidget--item px16">
            <StackOver width="14" height="14" />
            2022 Community Moderator Election Results - now with two more mods!
          </li>
          <li className="s-sidebarWidget--item px16">
            <StackOver width="14" height="14" />
            Temporary policy: ChatGPT is banned
          </li>
          <li className="s-sidebarWidget--item px16">
            <StackOver width="14" height="14" />
            Im standing down as a moderator
          </li>
          <li className="s-sidebarWidget--item px16 px-bottom-10">
            <StackOver width="14" height="14" />
            Proposing a Community-Specific Closure Reason for non-English
            content
          </li>
        </ul>
      </div>
    </SSidebarRightWrap>
  );
};

const SSidebarRightWrap = styled.div`
  width: 300px;
  height: 436px; // 삭제해도 됨
  position: relative;
  font-size: 13px;
  transform: translate(80px, 30px);
  .s-sidebarWidget {
    margin-bottom: 16px;
    box-shadow: 1px 1px 5px gray;
  }
  #d-block {
    list-style: none;
    background-color: #fcf8ea;
    padding: 0;
  }
  .s-sidebarWidget--header {
    font-size: 12px;
    font-weight: bold;
    background-color: hsl(47deg 83% 91%);
    border-top-left-radius: 3px;
    border-top-right-radius: 3px;
  }
  .s-sidebarWidget--item {
    margin: 12px;
  }
  .d-flex {
    display: flex;
  }
  .px16 {
    padding-left: 3px;
    padding-right: 3px;
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
