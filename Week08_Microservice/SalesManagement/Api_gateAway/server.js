const express = require('express');
const cors = require('cors');
const dotenv = require('dotenv');
const { createProxyMiddleware } = require('http-proxy-middleware');

dotenv.config();

const app = express();
app.use(cors());
app.use(express.json());

// Proxy configurations for each service
const customerProxy = createProxyMiddleware({
  target: 'http://localhost:3001',
  changeOrigin: true,
});

const orderProxy = createProxyMiddleware({
  target: 'http://localhost:3002',
  changeOrigin: true,
});

const productProxy = createProxyMiddleware({
  target: 'http://localhost:3003',
  changeOrigin: true,
});

// Route requests to respective services
app.use('/api/customers', customerProxy);
app.use('/api/orders', orderProxy);
app.use('/api/products', productProxy);

// Health check endpoint for the gateway
app.get('/health', (req, res) => {
  res.status(200).json({ status: 'API Gateway is running' });
});

const PORT = process.env.GATEWAY_PORT || 3000;
app.listen(PORT, () => {
  console.log(`API Gateway running on port ${PORT}`);
});