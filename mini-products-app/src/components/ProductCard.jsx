const ProductCard = ({ product }) => {
  return (
    <div className="product-card">
      <h3>{product.name}</h3>
      <p>Category: {product.category}</p>
      <p>Price: {product.price.toLocaleString()}</p>
      <button className="detail-btn">More</button>
    </div>
  )
}
export default ProductCard;