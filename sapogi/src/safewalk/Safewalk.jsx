import React from "react";
import PropTypes from "prop-types";
import Modal from "react-modal";

import Map from "./Map";


export default class Safewalk extends React.PureComponent {
  static locations = ["0,100, 100, 0"];

  constructor(props) {
    super(props);
    this.state = {
      source: null,
      dest: null,
      modalOpen: false,
    };
  }

  handleLocationClick = index => {
    this.setState({modalOpen: true});
    console.log("clicked");
  };

  render() {
    return (
      <div>
        <Map mapImage="https://comps.canstockphoto.com/businessman-ready-to-commit-suicide-stock-photos_csp8557263.jpg"
             location={Safewalk.locations}
             onClick={this.handleLocationClick}/>
        <Modal isOpen={this.state.modalOpen}>
        </Modal>
      </div>

    );
  }
}