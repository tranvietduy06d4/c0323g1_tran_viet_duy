import logo from './logo.svg';
import './App.css';
import { BookList } from './components/BookList';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { BookCreate } from './components/BookCreate';
import { BookEdit } from './components/BookEdit';

function App() {
  return (
    <>
    <BrowserRouter>
    <Routes>
      <Route path='/create' element={<BookCreate />}/>
      <Route path='/edit/:id' element={<BookEdit/>} />
      <Route path='/' element={<BookList />} />
    </Routes>
    </BrowserRouter>
    </>
  );
}

export default App;
