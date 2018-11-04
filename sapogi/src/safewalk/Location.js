export default class Location {
  constructor(name, id, coords) {
    this.id = id;
    this.coords = coords;
    this.name = name;
    Object.freeze(this);
  }
}