import styled from 'styled-components';

const SWrapper = styled.div`
  box-sizing: border-box;
  width: 100vw;
  background-color: hsl(210, 8%, 95%);
`;

const SContainer = styled.div`
  width: 90rem;
  max-width: 1264px;
  margin: auto;
  padding: 30px;

  h3 {
    margin-bottom: 50px;
  }

  h3,
  h6 {
    font-weight: bold;
  }

  p {
    font-size: 15px;
    line-height: 0.3;
  }

  ul {
    margin: 0;
  }

  .question-card {
    width: 70%;
    border-radius: 3px;
    padding: 25px;
    margin-bottom: 10px;
  }

  .blue-card {
    background-color: hsl(206, 100%, 97%);
    border: 1px solid hsl(206, 85%, 57.5%);
  }

  .white-card {
    background-color: #fff;
    border: 1px solid hsl(210, 8%, 90%);
  }

  input,
  textarea {
    width: 100%;
  }

  button {
    border: none;
    border-radius: 3px;
    padding: 10px;
    margin-right: 10px;
  }

  .question-upload-button {
    color: #fff;
    border: 1px solid rgb(10, 149, 255);
    background-color: hsl(206, 100%, 52%);
    box-shadow: rgb(255 255 255 / 40%) 0px 1px 0px 0px inset;
  }

  .question-draft-button {
    color: #c22e32;
    background-color: transparent;
  }

  .question-upload-button:hover {
    background-color: hsl(205, 46%, 32%);
  }

  .question-draft-button:hover {
    background-color: hsl(358, 75%, 97%);
  }
`;

export const QuestionPost = () => {
  return (
    <SWrapper>
      <SContainer>
        <div>
          <h3>Ask a public question</h3>
        </div>
        <div className="question-card blue-card">
          <h5>Writing a good question</h5>
          <p>
            You’re ready to ask a programming-related question and this form
            will help guide you through the process.
          </p>
          <p id="p2">
            Looking to ask a non-programming question? See the topics here to
            find a relevant site.
          </p>
          <h6>Steps</h6>
          <ul>
            <li>Summarize your problem in a one-line title.</li>
            <li>Describe your problem in more detail.</li>
            <li>Describe what you tried and what you expected to happen.</li>
            <li>
              Add {`"tags"`} which help surface your question to members of the
              community.
            </li>
            <li>Review your question and post it to site.</li>
          </ul>
        </div>
        <div className="question-card white-card">
          <h6>Title</h6>
          <p>
            Be specific and imagine {`you're`} asking a question to another
            person.
          </p>
          <form>
            <input placeholder="e.g. Is there an R function for finding the index of an element in a vector?"></input>
          </form>
        </div>
        <div className="question-card white-card">
          <h6>What are the details of your problem?</h6>
          <p>
            Introduce the problem and expand on what you put in the title.
            Minimum 20 characters.
          </p>
          <form>
            <textarea></textarea>
          </form>
        </div>
        <div className="question-card white-card">
          <h6>What did you try and what were you expecting?</h6>
          <p>
            Describe what you tried, what you expected to happen, and what
            actually resulted. Minimum 20 characters.
          </p>
          <form>
            <textarea></textarea>
          </form>
        </div>
        <div className="question-card white-card">
          <h6>Tags</h6>
          <p>
            Add up to 5 tags to describe what your question is about. Start
            typing to see suggestions.
          </p>
          <form>
            <input placeholder="e.g. (css sql-server asp.net-mvc)"></input>
          </form>
        </div>
        <div>
          <button className="question-upload-button">
            Review your question
          </button>
          <button className="question-draft-button">Discard draft</button>
        </div>
      </SContainer>
    </SWrapper>
  );
};
