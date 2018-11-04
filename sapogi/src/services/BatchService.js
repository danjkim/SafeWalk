import BaseService from "./BaseService";

class Batch {
  constructor(id, source, numUsers) {
    this.id = id;
    this.source = source;
    this.numUsers = numUsers;
  }
}

class BatchService extends BaseService {
  static async getAllBatches() {
    
  }
}