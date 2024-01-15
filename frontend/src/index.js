import React from 'react';
import ReactDOM from 'react-dom/client';
import './assets/index.css';
import "./assets/dist/output.css"
import './assets/App.css';
import {
  BrowserRouter, Navigate,
  Route,
  Routes
} from "react-router-dom";
import Home from "./views/home";

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <BrowserRouter>
      <Routes>
        <Route path={"/"} element={<Home />} />
        <Route path="*" element={ <Navigate to="/" replace/> } />
      </Routes>
    </BrowserRouter>
  </React.StrictMode>);

