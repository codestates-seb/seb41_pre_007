import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { AfterLogin } from './pages/AfterLogin';
import { Home } from './pages/Home';
import { QuestionPost } from './pages/QuestionPost';
const App = () => {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/afterLogin" element={<AfterLogin />} />
        <Route path="/home" element={<Home />} />
        <Route path="/questionPost" element={<QuestionPost />} />
      </Routes>
    </BrowserRouter>
  );
};

export default App;
