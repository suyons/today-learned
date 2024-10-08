// Layout.tsx
import { useNavigate } from "react-router-dom";
import {
  AppBar,
  Box,
  Button,
  Container,
  Fab,
  Toolbar,
  Typography,
} from "@mui/material";
import CreateIcon from "@mui/icons-material/Create";
import { useAuth } from "../../contexts/AuthContext";

type Props = {
  children: React.ReactNode;
};

const Layout = ({ children }: Props) => {
  const navigate = useNavigate();
  const { isLoggedIn, logout } = useAuth();

  const handlePushHomePage = () => navigate("/");
  const handlePushCartPage = () => navigate("/cart");
  const handlePushLoginPage = () => navigate("/login");
  const handlePushCreatePage = () => navigate("/create");

  const handleLogout = () => {
    logout();
    navigate("/login");
  };

  return (
    <>
      <Box sx={{ flexGrow: 1 }}>
        <AppBar position="static" sx={{ mb: 4 }}>
          <Toolbar sx={{ display: "flex", justifyContent: "space-between" }}>
            <Typography
              variant="h1"
              sx={{ fontSize: 26, fontWeight: "bold", cursor: "pointer" }}
              onClick={handlePushHomePage}
            >
              온라인 쇼핑몰
            </Typography>
            <div>
              <Button color="inherit" onClick={handlePushCartPage}>
                장바구니
              </Button>
              {isLoggedIn ? (
                <Button color="inherit" onClick={handleLogout}>
                  로그아웃
                </Button>
              ) : (
                <Button color="inherit" onClick={handlePushLoginPage}>
                  로그인
                </Button>
              )}
            </div>
          </Toolbar>
        </AppBar>

        <Container fixed>{children}</Container>
      </Box>

      <Box sx={{ position: "fixed", bottom: "16px", right: "16px" }}>
        <Fab color="primary" onClick={handlePushCreatePage}>
          <CreateIcon />
        </Fab>
      </Box>
    </>
  );
};

export default Layout;
