import { Route, Routes } from "react-router-dom";
import { Layout } from "./components/shared";
import {
  CartPage,
  HomePage,
  NotFoundPage,
  ProductCreatePage,
  ProductPage,
  PurchasePage,
  LoginPage,
  JoinPage,
} from "./pages";
import { AuthProvider } from "./contexts/AuthContext";

function App() {
  return (
    <AuthProvider>
      <Layout>
        <Routes>
          <Route index element={<HomePage />} />
          <Route path="create" element={<ProductCreatePage />} />
          <Route path="cart" element={<CartPage />} />
          <Route path="login" element={<LoginPage />} />
          <Route path="join" element={<JoinPage />} />
          <Route path="product/:productId" element={<ProductPage />} />
          <Route path="purchase/:productId" element={<PurchasePage />} />
          <Route path="*" element={<NotFoundPage />} />
        </Routes>
      </Layout>
    </AuthProvider>
  );
}

export default App;
