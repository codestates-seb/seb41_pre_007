import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { Home } from './pages/Home';
import { QuestionPost } from './pages/QuestionPost';
import Footer from './components/Footer';
import LoginHeader from './components/LoginHeader';
import { AllQuestions } from './pages/AllQuestions';
import { Tags } from './pages/Tags';
// import { EditProfile } from './pages/EditProfile';
import UsersProfile from './pages/UsersProfile';
import Companies from './pages/Companies';
import Users from './pages/Users';
import QuestionDetail from './pages/QuestionDetail';
import QuestionEdit from './pages/QuestionEdit';

const App = () => {
  return (
    <BrowserRouter>
      <LoginHeader />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/questions/ask" element={<QuestionPost />} />
        <Route path="/questions" element={<AllQuestions />} />
        <Route path="/tags" element={<Tags />} />
        {/* <Route path="/editProfile" element={<EditProfile />} /> */}
        <Route path="/users/:id" element={<UsersProfile />} />
        <Route path="/companies" element={<Companies />} />
        <Route path="/users" element={<Users />} />
        <Route path="/questions/:id" element={<QuestionDetail />} />
        <Route path="/questions/edit/:id" element={<QuestionEdit />} />
      </Routes>
      <Footer />
    </BrowserRouter>
  );
};

export default App;
