import React from 'react';
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import logo from './logo.svg';
import './App.css';

import Landing from "./landing/Landing";
import Login from "./login/Login";
import Signup from "./signup/Signup";

class AppRouter extends React.PureComponent {
  render() {
    return (
      <Router>
        <div className="mh5 mv3">
          <nav className="flex justify-end">
            <Link to="/" className="ml5 f3">Home</Link>
            <Link to="/login/" className="ml5 f3">Login</Link>
            <Link to="/signup/" className="ml5 f3">Sign Up</Link>
          </nav>

          <div>
            <Route path="/" exact component={Landing} />
            <Route path="/login/" exact component={Login}/>
            <Route path="/signup/" exact component={Signup} />
            <Route path="/safewalk/" />
          </div>
        </div>
      </Router>
    );
  }
}


export default AppRouter;
