import React from "react";
import { useSelector } from "react-redux";
import { useLocation, Navigate, Outlet } from "react-router-dom";

const ProtectedRoute = ({ children, allowedRoles = [], useOutlet = false }) => {
  const location = useLocation();
  const isAuthenticated = useSelector((state) => state.auth.isAuthenticated);
  const userRoles = useSelector((state) => state.auth.roles);

  if (!isAuthenticated) {
    return <Navigate to='/login' state={{ from: location }} replace />;
  }

  // Normalize roles by removing "ROLE_" prefix and converting to lowercase
  const normalizeRole = (role) =>
    role.toLowerCase().startsWith("role_") ? role.slice(5).toLowerCase() : role.toLowerCase();

  const userRolesNormalized = userRoles.map(normalizeRole);
  const allowedRolesNormalized = allowedRoles.map(normalizeRole);

  const isAuthorized = userRolesNormalized.some((userRole) =>
    allowedRolesNormalized.includes(userRole)
  );

  if (isAuthorized) {
    return useOutlet ? <Outlet /> : children;
  } else {
    return <Navigate to='/unauthorized' state={{ from: location }} replace />;
  }
};

export default ProtectedRoute;
