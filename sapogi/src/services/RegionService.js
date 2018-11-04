import BaseService from "./BaseService";


export default class RegionService extends BaseService {
  static async getAllRegions() {
    const regions = await this.fetch("regions");
    return regions.json();
  }
}