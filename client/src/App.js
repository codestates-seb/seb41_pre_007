import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { AfterLogin } from './pages/AfterLogin';
import { Home } from './pages/Home';
const App = () => {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/afterLogin" element={<AfterLogin />} />
        <Route path="/home" element={<Home />} />
      </Routes>
    </BrowserRouter>
  );
};

export default App;
