import axios from "axios";

const BASE_API_URL = "http://localhost:8080/api/v1";

const http = {
  get: function (url, params = {}) {
    return axios.get(
      BASE_API_URL + url,
      {
        params: { ...params }
      }
    );
  },
  post: function (url, body) {
    return axios.post(
      BASE_API_URL + url,
      body
    )
  },
  delete: function (url) {
    return axios.delete(BASE_API_URL + url);
  }
}

export default http;
