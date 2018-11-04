import React from "react";
import PropTypes from "prop-types";
import classnames from "classnames";
import { Link } from "react-router-dom";

class Button extends React.PureComponent {
  static propTypes = {
    label: PropTypes.string,
    onClick: PropTypes.func,
    className: PropTypes.string,
  };

  static defaultProps = {
    label: "",
    onClick: () => null,
    className: "",
  };

  render() {
    return (
      <button onClick={this.props.onClick} className={classnames(this.props.className, "br-pill shadow-3 bn ttu pv2 ph4")}>
        <Link to={ "/safewalk/" }>
            {this.props.label}
        </Link>
        {this.props.children}
      </button>
    );
  }
}

export default Button;
