import React from "react";
import classnames from "classnames";
import PropTypes from "prop-types";

import Location from "./Location";


class MapArea extends React.PureComponent {
  static propTypes = {
    location: PropTypes.instanceOf(Location).isRequired,
    onLocationClick: PropTypes.func.isRequired,
  };

  handleClick = () => {
    this.props.onLocationClick(this.props.location.id);
  };

  render() {
    const {location} = this.props;
    return <area shape="rect" coords={location.coords} className="pointer"
                 onClick={this.handleClick} />;
  }
}

export default class Map extends React.PureComponent {
  static propTypes = {
    mapImage: PropTypes.string.isRequired,
    // List of area coordinates in the image
    locations: PropTypes.arrayOf(PropTypes.instanceOf(Location)),
    // Invoked with the selected location id
    onSelect: PropTypes.func,
  };

  static defaultProps = {
    locations: [],
    onSelect: () => null,
  };


  render() {
    const {mapImage, onSelect, locations} = this.props;
    return (
      <div>
        <img src={mapImage} useMap="#safewalk-map" />
        <map name="safewalk-map" id="safewalk-map">
          {locations.map((loc, key) => <MapArea location={loc} onLocationClick={onSelect} key={key} />)}
        </map>
      </div>
    );
  }
}