import React from "react";
import PropTypes from "prop-types";
import classnames from "classnames";

import Button from "../components/Button";
import TextField from "../components/TextField";
import PasswordField from "../components/PasswordField";

export default class SignupPage extends React.PureComponent {
  constructor() {
      super();
      this.state = {
          email: "",
          password: ""
      }
  }

  updateEmail(event) {
      this.setState({
          email: event.target.value
      });
  }

  updatePassword(event) {
      this.setState({
          password: event.target.value
      });
  }

  render() {
    return (
      <div className="bg-dark-blue vh-100-m w-30 min-vh-100 ph3" style={{zIndex:"-1", paddingTop:"100px", float: "right", position: "absolute", right: "0", top: "0"}}>
          <h1 className="flex">
              Login
          </h1>
          <p style={{color: '#FFFFFF'}}>
              Join a safewalk today
          </p>
          <div>
              <TextField label="Email Address" 
                         onChange={this.updateEmail.bind(this)}
                         value={this.state.email}/>
          </div>
          <div>
              <PasswordField label="Password" 
                         onChange= {this.updatePassword.bind(this)}
                         value={this.state.password}/>
          </div>
          <Button label="LOGIN" className="grow mt3"/>
      </div>
    );
  }
}
