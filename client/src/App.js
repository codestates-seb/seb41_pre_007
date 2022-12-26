import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { Home } from './pages/Home';
import { QuestionPost } from './pages/QuestionPost';
import Footer from './components/Footer';
import LoginHeader from './components/LoginHeader';
import { AllQuestions } from './pages/AllQuestions';
import { Tags } from './pages/Tags';
import { EditProfile } from './pages/EditProfile';
import UsersProfile from './pages/UsersProfile';
import Companies from './pages/Companies';

const App = () => {
  return (
    <BrowserRouter>
      <LoginHeader />
      <Routes>
        <Route path="/home" element={<Home />} />
        <Route path="/questionPost" element={<QuestionPost />} />
        <Route path="/allQuestions" element={<AllQuestions />} />
        <Route path="/tags" element={<Tags />} />
        <Route path="/editProfile" element={<EditProfile />} />
        <Route path="/users/profile" element={<UsersProfile />} />
        <Route path="/Companies" element={<Companies />} />
      </Routes>
      <Footer />
    </BrowserRouter>
  );
};

export default App;
