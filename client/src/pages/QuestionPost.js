import styled from 'styled-components';
import { ReactComponent as Pencil } from '../image/Pencil.svg';

const SWrapper = styled.div`
  box-sizing: border-box;
  background-color: hsl(210, 8%, 95%);
`;

const SContainer = styled.div`
  width: 90rem;
  max-width: 1264px;
  margin: auto;

  h1 {
    font-weight: bold;
    margin-bottom: 50px;
  }
`;

export const QuestionPost = () => {
  return (
    <SWrapper>
      <SContainer>
        <div>
          <h1>Ask a public question</h1>
        </div>
        <div>
          <h5>Writing a good question</h5>
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
        <div>
          <div>
            <h5>Writing a good title</h5>
          </div>
          <div>
            <Pencil />
            <div>
              <p>Your title should summarize the problem.</p>
              <p>
                You might find that you have a better idea of your title after
                writing out the rest of the question.
              </p>
            </div>
          </div>
        </div>
        <div>
          <h5>Title</h5>
          <div>
            Be specific and imagine {`you're`} asking a question to another
            person.
          </div>
          <form>
            <input placeholder="e.g. Is there an R function for finding the index of an element in a vector?"></input>
          </form>
        </div>
        <div>
          <h5>What are the details of your problem?</h5>
          <div>
            Introduce the problem and expand on what you put in the title.
            Minimum 20 characters.
          </div>
          <form>
            <textarea></textarea>
          </form>
        </div>
        <div>
          <h5>What did you try and what were you expecting?</h5>
          <div>
            Describe what you tried, what you expected to happen, and what
            actually resulted. Minimum 20 characters.
          </div>
        </div>
        <div>
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
