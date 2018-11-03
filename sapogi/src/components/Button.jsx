import React from "react";
import PropTypes from "prop-types";
import classnames from "classnames";

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
      <button onClick={this.props.onClick} className={classnames(this.props.className, "br-pill shadow-3 bn ttu pv3 ph4")}>
        {this.props.label}
      </button>
    );
  }
}

export default Button;