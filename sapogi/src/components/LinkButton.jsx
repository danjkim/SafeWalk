import React from "react";
import PropTypes from "prop-types";
import classnames from "classnames";
import { Link } from "react-router-dom";
import Button from "./Button";

class LinkButton extends React.PureComponent {
  static propTypes = {
    // Label for the link
    label: PropTypes.string,
    // Destination for the link
    to: PropTypes.string,
    // Button classes
    className: PropTypes.string,
    // Link classes
    linkClasses: PropTypes.string,
  };

  static defaultProps = {
    label: "",
    to: "",
    className: "",
    linkClasses: "",
  };

  render() {
    return (
      <Button className={ this.props.className }>
        <Link to={ this.props.to } className={classnames(this.props.linkClasses, "no-underline h-100 db")}>
          {this.props.label}
        </Link>           
      </Button>
    );
  }
}

export default LinkButton;