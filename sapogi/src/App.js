import React from 'react';
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import logo from './logo.svg';
import Landing from "./landing/Landing";
import Safewalk from "./safewalk/Safewalk";
import Login from "./login/Login";
import Signup from "./signup/Signup";

class AppRouter extends React.PureComponent {
  render() {
    return (
      <Router>
        <div className="mh5 mv3">
          <nav className="flex justify-end" style={{position:"relative", left:"45px"}}>
            <Link to="/" className="ml5 f3">Home</Link>
            <Link to="/login/" className="ml5 f3">Login</Link>
            {/*<Link to="/signup/" className="ml5 f3">Sign Up</Link>*/}
          </nav>

          <div style={{float: "left", width: "70%"}}>
            <Route path="/" exact component={Landing} />
          </div>
          <div>
            <Route path="/safewalk/" component={Safewalk} />
            <Route path="/signup/" exact component={Signup} />
          </div>
          <Route path="/" exact component={Login}/>
        </div>
      </Router>
    );
  }
}


export default AppRouter;
