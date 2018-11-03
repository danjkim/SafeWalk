import React from "react";
import PropTypes from "prop-types";
import classnames from "classnames";

import LinkButton from "../components/LinkButton";

export default class LandingPage extends React.PureComponent {
  render() {
    return (
      <div>
        <h1 className="f-subheadline">Safewalk</h1>
        <p className="mw7 f4 mv4">
          Safewalk is a platform that enables students in UC Berkeley to form or join
          small groups to walk together to destinations safely. Users meet at hot
          spots or can join existing walking parties to navigate through the streets
          of Berkeley at dangerous hours. Click the button below to get started!
        </p>
        <LinkButton label="Get Started"
                    to="/safewalk/"
                    className="f3 bg-dark-blue grow"
                    linkClasses="white" />
      </div>
    );
  }
}
