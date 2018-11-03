import React from "react";
import PropTypes from "prop-types";
import classnames from "classnames";

import Button from "../components/Button";

export default class LandingPage extends React.PureComponent {
  render() {
    return (
      <div>
        <p>
          Safewalk is a platform that enables students in UC Berkeley to form or join
          small groups to walk together to destinations safely. Users meet at hot
          spots or can join existing walking parties to navigate through the streets
          of Berkeley at dangerous hours. Click the button below to get started!
        </p>
        <Button label="Get Started" className="f2 bg-dark-blue white" />
      </div>
    );
  }
}
