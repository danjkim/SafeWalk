
const API_ENDPOINT = "http://localhost:8081/api";
function apiUri(resource) {
  return `${API_ENDPOINT}/${resource}`;
}

export default class BaseService {
  static async fetch(url, options) {
    const response = await fetch(apiUri(url), options);
    if (!response.ok) {
      throw new Error(`unable to complete request: ${response.status}`);
    }
    return response;
  }
}