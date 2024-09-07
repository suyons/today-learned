import {
  Box,
  Button,
  ButtonGroup,
  CircularProgress,
  Container,
  Dialog,
  DialogActions,
  DialogContent,
  DialogContentText,
  DialogTitle,
  Typography,
  TextField,
} from "@mui/material";
import { useState } from "react";
import { useNavigate, useParams } from "react-router-dom";

import Edit from "@mui/icons-material/Edit";
import Delete from "@mui/icons-material/Delete";
import axios from "axios";
import { useCart } from "../hooks";
import { deleteProduct, getProduct, createProduct } from "../utils/api";
import useAsync from "../hooks/useAsync";
import { NotFoundPage } from ".";
import { API_SERVER_DOMAIN } from "../constants";
import ThumbnailUploader from "../components/create/ThumbnailUploader";

const ProductPage = () => {
  const navigate = useNavigate();
  const { productId } = useParams<{ productId: string }>();
  const { addCarts } = useCart();

  const { loading: getProductLoading, data } = useAsync(() =>
    getProduct(productId!)
  );
  const { request: deleteProductRequest, loading: deleteProductLoading } =
    useAsync(() => deleteProduct(productId!), { initialRequest: false });

  const [isCartModalOpen, setIsCartModalOpen] = useState(false);
  const [isDeleteModalOpen, setIsDeleteModalOpen] = useState(false);
  const [isUpdateModalOpen, setIsUpdateModalOpen] = useState(false);

  const [name, setName] = useState("");
  const [price, setPrice] = useState(0);
  const [explanation, setExplanation] = useState("");
  const [thumbnail, setThumbnail] = useState<File | null>(null);

  const handleAddCart = () => {
    if (product) {
      addCarts(product.id);
      setIsCartModalOpen(true);
    }
  };

  const handlePushPurchasePage = () => {
    if (productId) {
      navigate(`/purchase/${productId}`);
    }
  };

  const handlePushHomePage = () => {
    navigate(`/`);
  };

  const handlePushCartPage = () => {
    navigate(`/cart`);
  };

  const handleDeleteProduct = async () => {
    setIsDeleteModalOpen(false);
    await deleteProductRequest();
    handlePushHomePage();
  };

  const handleUpdateProduct = async (event: any) => {
    event.preventDefault();

    // FormData 객체 생성
    const formData = new FormData();
    formData.append("name", name);
    formData.append("price", price.toString());
    formData.append("explanation", explanation);

    if (thumbnail) {
      formData.append("thumbnail", thumbnail);
    }

    try {
      // API 호출
      const response = await axios.patch(`/product/${productId}`, formData, {
        headers: {
          "Content-Type": "multipart/form-data",
        },
      });

      if (response.status === 204) {
        alert("상품이 성공적으로 업데이트되었습니다.");
        setIsUpdateModalOpen(false);
      } else {
        alert("상품 업데이트에 실패했습니다.");
      }
    } catch (error) {
      alert("상품 업데이트 중 오류가 발생했습니다:");
      console.log(error);
    }
  };

  if (!productId || !data) return <NotFoundPage />;
  if (getProductLoading || deleteProductLoading) return <CircularProgress />;

  const product = data.data;

  return (
    <>
      <Container maxWidth="sm">
        <Box sx={{ display: "flex", justifyContent: "center", mb: 4 }}>
          {product?.thumbnail && (
            <img
              src={`${API_SERVER_DOMAIN}/${product.thumbnail}`}
              alt={product?.name}
              style={{ width: "100%", maxWidth: 400 }}
            />
          )}
        </Box>
        <Box
          sx={{
            display: "flex",
            alignItems: "center",
            justifyContent: "space-between",
            marginBottom: 2,
          }}
        >
          <Typography variant="h4" sx={{ fontWeight: "bold" }}>
            {product?.name}
          </Typography>
          <ButtonGroup orientation="horizontal">
            <Button
              variant="text"
              onClick={() => setIsDeleteModalOpen(true)}
              color="error"
            >
              <Delete />
            </Button>
            <Button
              variant="text"
              onClick={() => setIsUpdateModalOpen(true)}
              color="info"
            >
              <Edit />
            </Button>
          </ButtonGroup>
        </Box>
        <Typography variant="h6" sx={{ marginBottom: 4 }}>
          {product?.price.toLocaleString("KO-kr")}원
        </Typography>
        <Typography variant="body1" sx={{ marginBottom: 4 }}>
          {product?.explanation}
        </Typography>

        <ButtonGroup orientation="vertical" fullWidth>
          <Button variant="outlined" onClick={handleAddCart}>
            장바구니 담기
          </Button>
          <Button variant="contained" onClick={handlePushPurchasePage}>
            구매하기
          </Button>
        </ButtonGroup>
      </Container>

      <Dialog
        open={isDeleteModalOpen}
        onClose={() => setIsDeleteModalOpen(false)}
        aria-labelledby="responsive-dialog-title"
      >
        <DialogTitle id="responsive-dialog-title">
          상품을 정말로 삭제하시겠습니까?
        </DialogTitle>
        <DialogContent>
          <DialogContentText>이 작업은 되돌릴 수 없습니다.</DialogContentText>
        </DialogContent>
        <DialogActions>
          <Button onClick={() => setIsDeleteModalOpen(false)}>아니요</Button>
          <Button autoFocus onClick={handleDeleteProduct}>
            네
          </Button>
        </DialogActions>
      </Dialog>

      <Dialog
        open={isUpdateModalOpen}
        onClose={() => setIsUpdateModalOpen(false)}
        aria-labelledby="responsive-dialog-title"
      >
        <DialogTitle id="responsive-dialog-title">상품 수정</DialogTitle>
        <DialogContent>
          <Container maxWidth="sm">
            <Typography variant="h4" align="center" gutterBottom>
              상품 정보
            </Typography>
            <form onSubmit={handleUpdateProduct}>
              <TextField
                label="상품 이름"
                fullWidth
                value={name}
                onChange={(e) => setName(e.target.value)}
                margin="normal"
              />
              <TextField
                label="가격"
                type="number"
                fullWidth
                value={price}
                onChange={(e) => setPrice(Number(e.target.value))}
                margin="normal"
              />
              <TextField
                label="상품 설명"
                fullWidth
                multiline
                rows={4}
                value={explanation}
                onChange={(e) => setExplanation(e.target.value)}
                margin="normal"
              />
              <ThumbnailUploader
                value={thumbnail}
                onChange={(file) => setThumbnail(file)}
              />
              <Button
                type="submit"
                variant="contained"
                color="primary"
                fullWidth
                sx={{ marginTop: 6 }}
              >
                수정
              </Button>
            </form>
          </Container>
        </DialogContent>
        <DialogActions>
          <Button onClick={() => setIsUpdateModalOpen(false)}>취소</Button>
          <Button autoFocus onClick={handleUpdateProduct}>
            확인
          </Button>
        </DialogActions>
      </Dialog>

      <Dialog
        open={isCartModalOpen}
        onClose={() => setIsCartModalOpen(false)}
        aria-labelledby="responsive-dialog-title"
      >
        <DialogTitle id="responsive-dialog-title">
          장바구니에 성공적으로 추가하였습니다.
        </DialogTitle>
        <DialogContent>
          <DialogContentText>
            장바구니 페이지로 이동하시겠습니까?
          </DialogContentText>
        </DialogContent>
        <DialogActions>
          <Button onClick={() => setIsCartModalOpen(false)}>아니요</Button>
          <Button onClick={handlePushCartPage} autoFocus>
            네
          </Button>
        </DialogActions>
      </Dialog>
    </>
  );
};

export default ProductPage;
