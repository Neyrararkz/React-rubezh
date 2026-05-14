import { useState } from 'react'
import { Routes, Route, Link} from 'react-router-dom'
import { products } from './data'
import './App.css'
import ProductCard from './components/ProductCard'

const Home = () => (
  <div className='page'>
    <h1>Welcome!</h1>
  </div>
)

const About = () => (
  <div className='page'>
    <h1>About us</h1>
  </div>
)

const ProductsPage = () => {
  const [search, setSearch] = useState("");

  const filteredProducts = products.filter(p =>
    p.name.toLowerCase().includes(search.toLowerCase())
  );

  return (
    <>
    <div className='page'>
      <h1>Products</h1>
      <input 
        className='search-input'
        type='text'
        value={search}
        onChange={(e) => setSearch(e.target.value)}
      />
    </div>
    <div className='products-grid'>
      {filteredProducts.map(item => (
        <ProductCard key={item.id} product={item} />
      ))}
    </div>
    </>
  )
}

function App() {

  return (
    <>
    <div className='app-container'>
      <header className='header'>
        <div className='logo'>MyStore</div>
        <nav className='nav'>
          <Link to="/">Main</Link>
          <Link to="/products">Products</Link>
          <Link to="/about">About</Link>
        </nav>
      </header>

      <main>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/products" element={<ProductsPage />} />
          <Route path="/about" element={<About />} />
        </Routes>
      </main>
    </div>
    </>
  )
}

export default App
