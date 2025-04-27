import React, { Component } from "react";
import RootLayout from "./component/layout/RootLayout";
import Home from "./component/home/Home";
import Products from "./component/product/Products";
import ProductDetails from "./component/product/ProductDetails";
import "react-toastify/dist/ReactToastify.css";
import Cart from "./component/cart/Cart";
import Order from "./component/order/Order";
import AddProduct from "./component/product/AddProduct";
import ProductUpdate from "./component/product/ProductUpdate";
import UserRegistration from "./component/user/UserRegistration";
import Login from "./component/auth/Login";
import ProtectedRoute from "./component/auth/ProtectedRoute";
import Unauthorized from "./component/Unauthorized";
import UserProfile from "./component/user/UserProfile";
import { createBrowserRouter, createRoutesFromElements, Route, RouterProvider } from "react-router-dom";

class ErrorBoundary extends Component {
  constructor(props) {
    super(props);
    this.state = { hasError: false };
  }

  static getDerivedStateFromError(error) {
    // Update state so the next render shows the fallback UI.
    return { hasError: true };
  }

  componentDidCatch(error, errorInfo) {
    // You can also log the error to an error reporting service
    console.error("Uncaught error:", error, errorInfo);
  }

  render() {
    if (this.state.hasError) {
      // You can render any custom fallback UI
      return <h1>Something went wrong.</h1>;
    }

    return this.props.children; 
  }
}

function App() {
  const router = createBrowserRouter(
    createRoutesFromElements(
      <Route path='/' element={<RootLayout />}>
        <Route index element={<Home />} />
        <Route path="/user-profile" element={<UserProfile />} />
        <Route path='/products' element={<Products />} />
        <Route path='/products/:name' element={<Products />} />
        <Route
          path='/products/category/:categoryId/products/'
          element={<Products />}
        />

        <Route
          path='/product/:productId/details'
          element={<ProductDetails />}
        />
        <Route path='/register' element={<UserRegistration />} />
        <Route path='/login' element={<Login />} />
        <Route path='/unauthorized' element={<Unauthorized />} />

        <Route
          element={
            <ProtectedRoute
              useOutlet={true}
              allowedRoles={["ROLE_ADMIN", "ROLE_USER"]}
            />
          }>
          <Route path='/user/:userId/my-cart' element={<Cart />} />
          <Route path='/user/:userId/my-orders' element={<Order />} />
          <Route path='/user-profile/:userId/profile' element={<UserProfile />} />
        </Route>

        <Route
          element={
            <ProtectedRoute useOutlet={true} allowedRoles={["ROLE_ADMIN"]} />
          }>
          <Route path='/add-product' element={<AddProduct />} />
          <Route
            path='/update-product/:productId/update'
            element={<ProductUpdate />}
          />
        </Route>
      </Route>
    ),
    {
      future: {
        v7_startTransition: true,
        v7_relativeSplatPath: true
      }
    }
  );

  return (
    <ErrorBoundary>
      <RouterProvider router={router} />
    </ErrorBoundary>
  );
}

export default App;
