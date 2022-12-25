import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { Home } from './pages/Home';
import { QuestionPost } from './pages/QuestionPost';
import Footer from './components/Footer';
import LoginHeader from './components/LoginHeader';
import { AllQuestions } from './pages/AllQuestions';
import UsersProfile from './pages/UsersProfile';

const App = () => {
  return (
    <BrowserRouter>
      <LoginHeader />
      <Routes>
        <Route path="/users/profile" element={<UsersProfile />} />
        <Route path="/home" element={<Home />} />
        <Route path="/questionPost" element={<QuestionPost />} />
        <Route path="/allQuestions" element={<AllQuestions />} />
      </Routes>
      <Footer />
    </BrowserRouter>
  );
};

export default App;
