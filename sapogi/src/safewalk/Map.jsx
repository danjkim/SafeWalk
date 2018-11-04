import React from "react";
import classnames from "classnames";
import PropTypes from "prop-types";


export default class Map extends React.PureComponent {
  static propTypes = {
    mapImage: PropTypes.string.isRequired,
    // List of area coordinates in the image
    locations: PropTypes.arrayOf(PropTypes.string),
    // Invoked with the index of the location
    onClick: PropTypes.func,
  };

  static defaultProps = {
    locations: [],
    onClick: () => null,
  };


  render() {
    const {mapImage, onClick, locations} = this.props;
    return (
      <div>
        <img src={mapImage} useMap="#safewalk-map" />
        <map name="safewalk-map" id="safewalk-map">
          {locations.map((loc, key) => <area shape="rect" coords={loc}
                                             className="pointer"
                                             onClick={() => onClick(key)} key={key} />)}
        </map>
      </div>
    );
  }
}