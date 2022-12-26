import styled from 'styled-components';
import { Sidebar } from '../components/Sidebar';
import { ReactComponent as Search } from '../image/Search.svg';
import dummyTags from '../db/dummyTags.json';

export const Tags = () => {
  return (
    <STagsWrap>
      <Sidebar />
      <div id="content" className="snippet-hidden">
        <div id="mainbar-full">
          <h1 className="fs-headline1 mb16">Tags</h1>
          <p className="fs-body2 wmx6 mb16">
            A tag is a keyword or label that categorizes your question with
            other, similar questions. Using the right tags makes it easier for
            others to find and answer your question.
          </p>
          <div className="d-flex fw-wrap gs4 mb24 ai-center">
            <p className="flex--item s-link fs-body1">Show all tag synonyms</p>
          </div>
          <STagsSearchBox className="d-flex fw-wrap">
            <div className="flex--item ps-relative mb12">
              <input
                id="tagfilter"
                className="s-input s-input__search h100 js-tag-filter"
                autoComplete="off"
                name="tagfilter"
                type="text"
                maxLength="35"
                placeholder="Filter by tag name"
              ></input>
              <Search
                className="s-input-icon s-input-icon__search svg-icon iconSearch"
                fill="hsl(210deg 8% 55%)"
              />
            </div>
            <div
              className="btn-group ml-auto mb12 h100"
              role="group"
              aria-label="Basic outlined example"
            >
              <button type="button" className="btn btn-outline-primary">
                Popular
              </button>
              <button type="button" className="btn btn-outline-primary">
                Name
              </button>
              <button type="button" className="btn btn-outline-primary">
                New
              </button>
            </div>
          </STagsSearchBox>
          <STagBoxList>
            <div id="box-row">
              {dummyTags.tags.map((tag) => (
                <div
                  id="tags_list"
                  className="grid--item s-card js-tag-cell d-flex fd-column"
                  key={tag.id}
                >
                  <div className="d-flex jc-space-between ai-center mb12">
                    <p className="font100 post-tag">{tag.label}</p>
                  </div>
                  <div className="flex--item fc-medium mb12 v-truncate4 font100">
                    <p className="font100">{tag.contents}</p>
                  </div>
                </div>
              ))}
            </div>
          </STagBoxList>
        </div>
      </div>
    </STagsWrap>
  );
};

const STagsWrap = styled.div`
  display: flex;
  justify-content: center;
  width: 1680px;
  #content {
    max-width: 1100px;
    width: 1100px;
    background-color: white;
    border-radius: 0;
    border: 1px solid #ececec;
    border-width: 0 0 0 1px;
    padding: 24px;
    box-sizing: border-box;
    font: inherit;
    font-size: 100%;
    vertical-align: baseline;
  }
  .snippet-hidden {
    margin: 0px;
  }
  #mainbar-full {
    width: 100%;
    padding: 0;
    box-sizing: inherit;
    display: block;
  }
  .fs-headline1 {
    font-size: 2rem;
    margin: 0 0 1em;
    line-height: 1.3;
    padding: 0;
    border: 0;
  }
  .mb16 {
    margin-bottom: 16px;
  }
  .fs-body2 {
    font-size: 16px;
  }
  .wmx6 {
    max-width: 48rem;
  }
  .d-flex {
    display: flex;
  }
  .mb24 {
    margin-bottom: 24px !important;
  }
  .ai-center {
    align-items: center;
  }
  .fw-wrap {
    flex-wrap: wrap;
  }
  .gs4 {
    margin: -2px;
  }
  .s-link {
    text-decoration: none;
    color: hsl(206deg 96% 35%);
    cursor: pointer;
    user-select: auto;
    font-size: 13px;
  }
  .ps-relative {
    position: relative;
  }
  .mb12 {
    margin-bottom: 12px;
  }
`;

const STagsSearchBox = styled.div`
  .s-input-icon {
    right: auto;
    left: 0.7em;
    position: absolute;
    top: 50%;
    right: 0.7em;
    margin-top: -9px;
    pointer-events: none;
  }
  .svg-icon {
    vertical-align: bottom;
  }
  .s-input__search {
    padding-left: 32px !important;
  }
  .s-input {
    -webkit-appearance: none;
    width: 100%;
    margin: 0;
    border: 1px solid hsl(210deg 8% 75%);
    border-radius: 3px;
    background-color: white;
    color: hsl(210deg 8% 5%);
    font-size: 13px;
    font-family: inherit;
    padding: 0.6em 0.7em;
  }
  .h100 {
    height: 100% !important;
  }
  .mb12 {
    margin-bottom: 12px !important;
  }
  .ml-auto {
    margin-left: 640px !important;
  }
`;

const STagBoxList = styled.div`
  #tags_list {
    width: 250px;
    height: 170px;
    margin-bottom: 12px;
    margin-right: 12px;
    float: left;
  }
  .fd-column {
    flex-direction: column !important;
    border: 1px solid hsl(210deg 8% 85%);
    background-color: white;
    border-radius: 3px;
    padding: 12px;
  }
  .font100 {
    font-size: 13px;
  }
  .post-tag {
    color: hsl(205deg 47% 42%);
    background-color: hsl(205deg 46% 92%);
    border-color: transparent;
    display: inline-block;
    padding: 0.4em 0.5em;
    margin: 2px;
    line-height: 1;
    white-space: nowrap;
    text-decoration: none;
    text-align: center;
    border-width: 1px;
    border-style: solid;
    border-radius: 3px;
  }
`;
