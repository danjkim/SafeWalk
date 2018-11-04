import React from "react";
import PropTypes from "prop-types";
import classnames from "classnames";

class TextField extends React.PureComponent {
  static propTypes = {
    label: PropTypes.string,
    value: PropTypes.string,
    className: PropTypes.string,
    onChange: PropTypes.func,
  };

  static defaultProps = {
    label: "",
    value: "",
    className: "",
    onChange: () => null,
  };



  render() {
    return (
      <label className="flex flex-column white mt1">
        {this.props.label}
        <input type="password" value={this.props.value}
               className={classnames(this.props.className, "br2 bg-white bn mt2")}
               onChange={this.props.onChange} />
      </label>
    );
  }
}

export default TextField;