import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { Home } from './pages/Home';
import { QuestionPost } from './pages/QuestionPost';
import Footer from './components/Footer';
import LoginHeader from './components/LoginHeader';
import { AllQuestions } from './pages/AllQuestions';
import { Tags } from './pages/Tags';

const App = () => {
  return (
    <BrowserRouter>
      <LoginHeader />
      <Routes>
        <Route path="/home" element={<Home />} />
        <Route path="/questionPost" element={<QuestionPost />} />
        <Route path="/allQuestions" element={<AllQuestions />} />
        <Route path="/tags" element={<Tags />} />
      </Routes>
      <Footer />
    </BrowserRouter>
  );
};

export default App;
