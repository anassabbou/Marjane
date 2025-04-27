import axios from "axios";
import { logoutUser } from "./AuthService";
import logError from "../../utils/errorLogger";

const BASE_URL = "http://localhost:9090/api/v1";

export const api = axios.create({
  baseURL: BASE_URL,
  withCredentials: true,
});

export const privateApi = axios.create({
  baseURL: BASE_URL,
  withCredentials: true,
});

const refreshToken = async () => {
  try {
    const response = await api.post("/auth/refresh-token");
    return response.data.accessToken;
  } catch (error) {
    logError(error, "refreshToken");
    return Promise.reject(error);
  }
};

privateApi.interceptors.request.use(
  (config) => {
    const accessToken = localStorage.getItem("authToken");
    if (accessToken) {
      config.headers.Authorization = `Bearer ${accessToken}`;
    }
    return config;
  },
  (error) => {
    logError(error, "privateApi request");
    return Promise.reject(error);
  }
);

privateApi.interceptors.response.use(
  (response) => {
    return response;
  },
  async (error) => {
    const originalRequest = error.config;
    if (error && !originalRequest._retry) {
      originalRequest._retry = true;
      try {
        const newAccessToken = await refreshToken();
        localStorage.setItem("authToken", newAccessToken);
        originalRequest.headers.Authorization = `Bearer ${newAccessToken}`;
        return privateApi(originalRequest);
      } catch (refreshError) {
        logError(refreshError, "refreshToken failure");
        logoutUser();
        return Promise.reject(refreshError);
      }
    }
    logError(error, "privateApi response");
    return Promise.reject(error);
  }
);
