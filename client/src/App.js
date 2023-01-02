import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { Home } from './pages/Home';
import { QuestionPost } from './pages/QuestionPost';
import Footer from './components/Footer';
import LoginHeader from './components/LoginHeader';
import LogoutHeader from './components/LogoutHeader';
import { AllQuestions } from './pages/AllQuestions';
import { Tags } from './pages/Tags';
// import { EditProfile } from './pages/EditProfile';
import UsersProfile from './pages/UsersProfile';
import Companies from './pages/Companies';
import Users from './pages/Users';
import QuestionDetail from './pages/QuestionDetail';
import QuestionEdit from './pages/QuestionEdit';
import AnswerEdit from './pages/AnswerEdit';
import { useSelector } from 'react-redux';
import Main from './pages/Main';

const App = () => {
  const isLogin = useSelector((state) => state.login.isLogin);

  return (
    <BrowserRouter>
      {isLogin ? <LoginHeader /> : <LogoutHeader />}
      <Routes>
        <Route path="/" element={isLogin ? <Home /> : <Main />} />
        <Route path="/questions/ask" element={<QuestionPost />} />
        <Route path="/questions" element={<AllQuestions />} />
        <Route path="/tags" element={<Tags />} />
        <Route path="/users/:id" element={<UsersProfile />} />
        <Route path="/companies" element={<Companies />} />
        <Route path="/users" element={<Users />} />
        <Route path="/questions/:questionId" element={<QuestionDetail />} />
        <Route path="/questions/edit/:id" element={<QuestionEdit />} />
        <Route
          path="/questions/:questionId/answers/edit/:answerId"
          element={<AnswerEdit />}
        />
      </Routes>
      <Footer />
    </BrowserRouter>
  );
};

export default App;
