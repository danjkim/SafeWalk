import BaseService from "./BaseService";
import Cookies from "universal-cookie";

export default class LoginService extends BaseService {
  static async login(username, password) {
    let user = {username, password};
    const userResp = await this.fetch("/login/", {
      method: "POST",
      headers: {
        "content-type": "application/json"
      },
      body: JSON.stringify(user),
    });
    const userObj = await userResp.json();
    Cookies.set("userId", userObj.id);
  }
}
