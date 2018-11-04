import BaseService from "./BaseService";
import Cookies from "universal-cookie";


export default class SessionService extends BaseService {
  static async getAllSessions() {
    const sessions = await this.fetch("sessions");
    return sessions.json();
  }

  static async getSessionById(sessionId) {
    const session = await this.fetch(`sessions/${sessionId}`);
    return session.json();
  }

  static async addToSession(sessionId, userId) {
    // const user = Cookies.get("userId");
    var data = {};
    data["userId"] = userId;
    await this.fetch(`sessions/` + sessionId, {
      method: "PUT",
      headers: {
        "content-type": "application/json",
      },
      body: JSON.stringify(data),
    });
  }
}