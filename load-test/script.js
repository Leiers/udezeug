import http from "k6/http";
import { sleep, check } from "k6";

export const options = {
  vus: 10,
  duration: "10s",
  thresholds: {
    http_req_duration: ["p(95)<10"],
  },
};

const jsonParams = {
  headers: {
    "Content-Type": "application/json",
  },
};

export default function () {
  const searchResponse = http.get(
    "http://localhost:8080/v1/course/search?query=",
    jsonParams,
  );
  check(searchResponse, {
    "search status is 200": (res) => res.status === 200,
  });
  sleep(1);
}
