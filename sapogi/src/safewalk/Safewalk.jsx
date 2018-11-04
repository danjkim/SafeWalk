import React from "react";
import PropTypes from "prop-types";
import Modal from "react-modal";

import Map from "./Map";
import Button from "../components/Button";
import Spinner from "react-spinkit";

import Location from "./Location";
import MapImage from "../map.png";
import RegionService from "../services/RegionService";
import SessionService from "../services/SessionService";


class Session extends React.PureComponent {
  static propTypes = {
    sessionId: PropTypes.any.isRequired,
    dest: PropTypes.string.isRequired,
    numUsers: PropTypes.number.isRequired,
    totalCapacity: PropTypes.number.isRequired,
    onJoin: PropTypes.func,
  };

  static defaultProps = {
    onClick: () => null,
  };

  handleClick = () => {
    this.props.onJoin(this.props.sessionId);
  };

  render() {
    const {dest, numUsers, totalCapacity} = this.props;
    return (
      <p className="flex items-center">
        <span>
          {dest}: {numUsers}/{totalCapacity} slots filled
        </span>
        <Button label="Join" onClick={this.handleClick} className="ml-auto bg-dark-blue white grow" />
      </p>
    );
  }
}

const modalStyle = {
  content: {
    position: "static",
    "marginLeft": "auto",
    "marginRight": "auto",
    "marginTop": "5rem",
    "maxWidth": "48rem",
  }
};

export default class Safewalk extends React.PureComponent {
  static locations = [new Location("Downtown Berkeley", 0, "232,297,258,326"),
                      new Location("RSF", 1, "489,381,518,414"),
                      new Location("West Crescent", 2, "419,197,444,230"),
                      new Location("Soda Hall", 3, "574,35,602,590"),
                      new Location("Sather Gate", 4, "585,273,609,308"),
                      new Location("Moffit Library", 5, "625,179,648,211")];

  constructor(props) {
    super(props);
    this.state = {
      source: null,
      dest: null,
      modalOpen: false,
      loading: false,
      sessions: [],
      regions: [],
      selectedRegion: null,
    };
  }

  async componentDidMount() {
    const rawRegions = await RegionService.getAllRegions();
    this.setState({regions: rawRegions});
  }

  handleRegionClick = (id) => {
    this.setState({
      modalOpen: true,
      selectedRegion: this.state.regions.find(r => r.id === id),
    });
  };

  handleCloseModal = () => {
    this.setState({modalOpen: false});
  };

  handleSessionJoin = async (sessionId) => {
    this.setState({loading: true});
    await SessionService.addToSession(sessionId);
    const newRegions = await RegionService.getAllRegions();
    this.setState({loading: false, regions: newRegions});
    // PUT the request on the server
    // await BatchService.joinBatch(batchId);
    // this.setState({loading: false});
  };

  get spinnerClass() {
    return this.state.loading ? "" : "dn";
  }

  get modalTitle() {
    return this.state.selectedRegion ? this.state.selectedRegion.name : "";
  }

  render() {
    return (
      <div>
        <Map mapImage={MapImage}
             locations={Safewalk.locations}
             onSelect={this.handleRegionClick}/>
        <Modal isOpen={this.state.modalOpen} style={modalStyle}>
          <div className="flex flex-column justify-center">
            <span className="flex w-100">
              <Spinner name="wave" fadeIn="none" className={this.spinnerClass} />
              <button onClick={this.handleCloseModal} className="ml-auto ph0">
                X
              </button>
            </span>
            <h2>{this.modalTitle}</h2>
            <div>
              {this.state.selectedRegion && this.state.selectedRegion.sessions.map(s => {
                return (
                  <Session sessionId={s.id}
                           dest={s.destinationName}
                           numUsers={s.users.length}
                           totalCapacity={8}
                           onJoin={this.handleSessionJoin} />
                );
              })}
            </div>
          </div>
        </Modal>
      </div>
    );
  }
}