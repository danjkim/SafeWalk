import React from "react";
import PropTypes from "prop-types";
import classnames from "classnames";

import Button from "../components/Button";
import TextField from "../components/TextField";

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
      <div className="Signup-section">
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
              <TextField label="Password" 
                         onChange= {this.updatePassword.bind(this)}
                         value={this.state.password}/>
          </div>
          <Button label="LOGIN"/>
      </div>
    );
  }
}
