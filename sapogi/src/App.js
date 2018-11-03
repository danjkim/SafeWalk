import React from 'react';
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import logo from './logo.svg';
import './App.css';

import Landing from "./landing/Landing";

class AppRouter extends React.PureComponent {
  render() {
    return (
      <Router>
        <div className="mh5">
          <nav>
            <Link to="/">Home</Link>
            <Link to="/login/">Login</Link>
            <Link to="/signup/">Sign Up</Link>
          </nav>

          <div>
            <Route path="/" exact component={Landing} />
            <Route path="/login/" />
            <Route path="/signup/" />
            <Route path="/safewalk/" />
          </div>
        </div>
      </Router>
    );
  }
}


export default AppRouter;
