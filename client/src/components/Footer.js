import styled from 'styled-components';
import { ReactComponent as StackOverFlowLogo } from '../image/StackOverFlowLogo.svg';
import { ReactComponent as GithubLogo } from '../image/GithubLogo.svg';

const SFooter = styled.footer`
  box-sizing: border-box;
  width: 100vw;
  height: 360px;
  background-color: hsl(210, 8%, 15%);
  color: hsl(210, 8%, 60%);
  font-size: 14px;
  position: relative;
  position: absolute;

  .footer {
    display: flex;
    justify-content: space-between;
    width: 90rem;
    max-width: 1264px;
    height: 360px;
    padding-top: 30px;
    margin: auto;
  }

  .footer-logo {
    padding-right: 10px;
  }

  span {
    cursor: pointer;
  }

  .footer-inner-link-container {
    display: flex;
    flex-direction: column;
    flex-wrap: nowrap;
    align-items: flex-start;
  }

  .footer-title {
    font-weight: bolder;
    padding-bottom: 15px;
  }

  .footer-inner-link {
    padding-bottom: 9px;
  }

  .footer-etc {
    display: flex;
    flex-direction: column;
    width: 35%;
  }

  .footer-outer-link {
    padding-right: 10px;
    font-size: 12px;
  }

  .footer-GithubLogo-container {
    display: flex;
    justify-content: flex-start;
    margin-top: auto;
    margin-bottom: auto;
  }

  .footer-GithubLogo-team {
    display: flex;
    flex-direction: column;
    align-items: center;
    padding-right: 10px;
    font-size: 10px;
  }

  .footer-copyright {
    font-size: 12px;
  }

  a {
    color: hsl(210, 8%, 60%);
    text-decoration: none;
  }
`;

const Footer = () => {
  return (
    <SFooter>
      <div className="footer">
        <StackOverFlowLogo className="footer-logo" />
        <div className="footer-inner-link-container">
          <span className="footer-title">STACK OVERFLOW</span>
          <span className="footer-inner-link">Questions</span>
          <span className="footer-inner-link">Help</span>
        </div>
        <div className="footer-inner-link-container">
          <span className="footer-title">PRODUCTS</span>
          <span className="footer-inner-link">Advertising</span>
          <span className="footer-inner-link">Collectives</span>
          <span className="footer-inner-link">Talent</span>
        </div>
        <div className="footer-inner-link-container">
          <span className="footer-title">COMPANY</span>
          <span className="footer-inner-link">About</span>
          <span className="footer-inner-link">Press</span>
          <span className="footer-inner-link">Work Here</span>
          <span className="footer-inner-link">Legal</span>
          <span className="footer-inner-link">Privacy Policy</span>
          <span className="footer-inner-link">Terms of Service</span>
          <span className="footer-inner-link">Contact Us</span>
          <span className="footer-inner-link">Cookie Settings</span>
          <span className="footer-inner-link">Cookie Policy</span>
        </div>
        <div className="footer-inner-link-container">
          <span className="footer-title">STACK EXCHANGE NETWORK</span>
          <span className="footer-inner-link">Technology</span>
          <span className="footer-inner-link">Culture & recreation</span>
          <span className="footer-inner-link">Life & arts</span>
          <span className="footer-inner-link">Science</span>
          <span className="footer-inner-link">Professional</span>
          <span className="footer-inner-link">Business</span>
          <span className="footer-inner-link">ㅤ</span>
          <span className="footer-inner-link">API</span>
          <span className="footer-inner-link">Data</span>
        </div>
        <div className="footer-etc">
          <div className="footer-outer-link-container">
            <span className="footer-outer-link">Blog</span>
            <span className="footer-outer-link">Facebook</span>
            <span className="footer-outer-link">Twitter</span>
            <span className="footer-outer-link">LinkedIn</span>
            <span className="footer-outer-link">Instagram</span>
          </div>
          <div className="footer-GithubLogo-container">
            <div>
              <a
                className="footer-GithubLogo-team"
                href="https://GithubLogo.com/nayul34"
              >
                <GithubLogo fill="hsl(210, 8%, 60%)" />
                <div>[FE]김나율</div>
              </a>
            </div>
            <div>
              <a
                className="footer-GithubLogo-team"
                href="https://GithubLogo.com/SUBINSON"
              >
                <GithubLogo fill="hsl(210, 8%, 60%)" />
                <div>[FE]손수빈</div>
              </a>
            </div>
            <div>
              <a
                className="footer-GithubLogo-team"
                href="https://GithubLogo.com/djWjfk"
              >
                <GithubLogo fill="hsl(210, 8%, 60%)" />
                <div>[FE]최윤지</div>
              </a>
            </div>
            <div>
              <a
                className="footer-GithubLogo-team"
                href="https://GithubLogo.com/keumbi"
              >
                <GithubLogo fill="hsl(210, 8%, 60%)" />
                <div>[BE]박금비</div>
              </a>
            </div>
            <div>
              <a
                className="footer-GithubLogo-team"
                href="https://GithubLogo.com/YJCMS"
              >
                <GithubLogo fill="hsl(210, 8%, 60%)" />
                <div>[BE]이승현</div>
              </a>
            </div>
            <div>
              <a
                className="footer-GithubLogo-team"
                href="https://GithubLogo.com/hso8706"
              >
                <GithubLogo fill="hsl(210, 8%, 60%)" />
                <div>[BE]하정호</div>
              </a>
            </div>
          </div>
          <p className="footer-copyright">
            Site design / logo © 2022 Stack Exchange Inc; user contributions
            licensed under
            <span>
              <a href="https://stackoverflow.com/help/licensing">CC BY SA</a>
            </span>
            .<span>rev&nbsp;2022.12.19.43125</span>
          </p>
        </div>
      </div>
    </SFooter>
  );
};

export default Footer;
