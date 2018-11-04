export default class BaseService {
  static async fetch(url, options) {
    const response = await fetch(url, options);
    if (!response.ok) {
      throw new Error(`unable to complete request: ${response.status}`);
    }
    return response;
  }
}