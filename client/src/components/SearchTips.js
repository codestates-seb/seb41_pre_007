import { useDispatch } from 'react-redux';
import styled from 'styled-components';
import searchSlice from '../redux/modules/searchSlice';

const STips = styled.div`
  position: absolute;
  height: 100vh;
  left: 0;
  right: 0;
  top: 40px;
  z-index: 2000;

  .search-tips-container::before {
    content: '';
    width: 10px;
    height: 10px;
    top: 3.5px;
    left: 50%;
    background: hsl(210, 8%, 85%);
    transform: rotate(45deg) translateX(-50%);
    display: block;
    position: absolute;
  }

  .search-tips-container::after {
    content: '';
    width: 10px;
    height: 10px;
    top: 5px;
    left: 50%;
    background: #fff;
    transform: rotate(45deg) translateX(-50%);
    display: block;
    position: absolute;
  }

  .search-tips-container {
    display: flex;
    flex-direction: column;
    min-width: fit-content;
    max-width: 100%;
    background-color: #fff;
    border: 1px solid hsl(210, 8%, 85%);
    border-radius: 5px;
    box-shadow: 0 1px 3px hsla(0, 0%, 0%, 0.06), 0 2px 6px hsla(0, 0%, 0%, 0.06),
      0 3px 8px hsla(0, 0%, 0%, 0.09);
    margin-top: 5px;
  }

  .search-tips-text-container {
    display: flex;
    justify-content: flex-start;
  }

  .search-tips-text-column {
    display: flex;
    flex-direction: column;
    width: 50%;
    margin: 20px;
  }

  .search-tips-text-howto {
    font-size: 14px;
    font-weight: bold;
    margin: 5px;
  }

  .search-tips-text-inform {
    font-size: 12px;
  }

  .search-tips-help-container {
    border-top: 1px solid hsl(210, 8%, 85%);
    padding: 15px;
  }

  .search-tips-help {
    display: flex;
    justify-content: space-between;
  }

  .search-tips-help-button {
    font-size: 12px;
    color: #39739d;
    border: 1px solid rgb(122, 167, 199);
    border-radius: 3px;
    background-color: #e1ecf4;
    box-shadow: rgb(255 255 255 / 70%) 0px 1px 0px 0px inset;
  }

  .search-tips-help-anchor {
    font-size: 12px;
  }
`;

const SearchTips = () => {
  const dispatch = useDispatch();

  const handleSearch = () => {
    dispatch(searchSlice.actions.setIsClicked());
  };

  return (
    <STips onClick={handleSearch}>
      <div className="search-tips-container">
        <div className="search-tips-text-container">
          <div className="search-tips-text-column">
            <div className="search-tips-text">
              <span className="search-tips-text-howto">[tag]</span>
              <span className="search-tips-text-inform">
                search with in a tag
              </span>
            </div>
            <div className="search-tips-text">
              <span className="search-tips-text-howto">user:1234</span>
              <span className="search-tips-text-inform">search by author</span>
            </div>
            <div className="search-tips-text">
              <span className="search-tips-text-howto">{`"words here"`}</span>
              <span className="search-tips-text-inform">exact phrase</span>
            </div>
            <div className="search-tips-text">
              <span className="search-tips-text-howto">
                collective:{`"Name"`}
              </span>
              <span className="search-tips-text-inform">
                collective cocntent
              </span>
            </div>
          </div>
          <div className="search-tips-text-column">
            <div className="search-tips-text">
              <span className="search-tips-text-howto">answers:0</span>
              <span className="search-tips-text-inform">
                unanswered questions
              </span>
            </div>
            <div className="search-tips-text">
              <span className="search-tips-text-howto">score:3</span>
              <span className="search-tips-text-inform">
                posts with a 3+ score
              </span>
            </div>
            <div className="search-tips-text">
              <span className="search-tips-text-howto">is:question</span>
              <span className="search-tips-text-inform">type of post</span>
            </div>
            <div className="search-tips-text">
              <span className="search-tips-text-howto">isaccepted:yes</span>
              <span className="search-tips-text-inform">
                search within status
              </span>
            </div>
          </div>
        </div>
        <div className="search-tips-help-container">
          <div className="search-tips-help">
            <button className="search-tips-help-button">Ask a question</button>
            <a href="https://stackoverflow.com/help/searching">
              <span className="search-tips-help-anchor">Search help</span>
            </a>
          </div>
        </div>
      </div>
    </STips>
  );
};

export default SearchTips;
