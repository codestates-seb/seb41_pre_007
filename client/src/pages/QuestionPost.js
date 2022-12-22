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

  h1 {
    margin-bottom: 50px;
  }

  h1,
  h5 {
    font-weight: bold;
  }

  .question-card {
    width: 70%;
    border-radius: 3px;
  }

  .blue-card {
    background-color: hsl(206, 100%, 97%);
    border: 1px solid hsl(206, 85%, 57.5%);
  }

  .white-card {
    background-color: #fff;
    border: 1px solid hsl(210, 8%, 90%);
  }

  .question-title-container {
    display: flex;
    align-items: flex-start;
  }

  input,
  textarea {
    width: 100%;
  }
`;

export const QuestionPost = () => {
  return (
    <SWrapper>
      <SContainer>
        <div>
          <h1>Ask a public question</h1>
        </div>
        <div className="question-card blue-card">
          <h2>Writing a good question</h2>
          <p>
            You’re ready to ask a programming-related question and this form
            will help guide you through the process.
          </p>
          <p>
            Looking to ask a non-programming question? See the topics here to
            find a relevant site.
          </p>
          <h5>Steps</h5>
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
          <h5>Title</h5>
          <div>
            Be specific and imagine {`you're`} asking a question to another
            person.
          </div>
          <form>
            <input placeholder="e.g. Is there an R function for finding the index of an element in a vector?"></input>
          </form>
        </div>
        <div className="question-card white-card">
          <h5>What are the details of your problem?</h5>
          <div>
            Introduce the problem and expand on what you put in the title.
            Minimum 20 characters.
          </div>
          <form>
            <textarea></textarea>
          </form>
        </div>
        <div className="question-card white-card">
          <h5>What did you try and what were you expecting?</h5>
          <div>
            Describe what you tried, what you expected to happen, and what
            actually resulted. Minimum 20 characters.
          </div>
          <form>
            <textarea></textarea>
          </form>
        </div>
        <div className="question-card white-card">
          <h5>Tags</h5>
          <div>
            Add up to 5 tags to describe what your question is about. Start
            typing to see suggestions.
          </div>
          <form>
            <input placeholder="e.g. (css sql-server asp.net-mvc)"></input>
          </form>
        </div>
        <div>
          <button>Review your question</button>
          <button>Discard draft</button>
        </div>
      </SContainer>
    </SWrapper>
  );
};
