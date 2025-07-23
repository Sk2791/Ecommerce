import React, { useEffect, useState, useContext } from 'react'; 
import api from '../services/api'; 
import { CartContext } from '../context/CartContext';

const ProductList = () => { 
const [products, setProducts] = useState([]); 
const{addToCart} = useContext(CartContext);
const[quantities,setQuantities]=useState({});

useEffect(() => { 
api.get('/products') 
.then(res => setProducts(res.data)) 
.catch(err => console.error('Error fetching products:', err)); 
}, []);

const handleQuantityChange=(productId,value) => {
    setQuantities(prev=>({...prev,[productId]:parseInt(value)}));
}

return ( 
<div> 
<h2>Available Products</h2> 
{products.length === 0 && <p>No products found.</p>} 
<ul> 
{products.map(product => ( 
<li key={product.id} style={{marginBottom:"20px",borderBottom:"1px solid #ccc",paddingBottom:"10px"}}> 
<h3>{product.name}</h3> 
<p>{product.description}</p> 
<p><b>Price: </b>${product.price}</p> 
<p><b>Stock:</b> {product.stock}</p>

{product.stock === 0 ?(
    <p style={{color:"red"}}><b>Not Available</b></p>
):(
    <>
    <input
    type='number'
    min={1}
    max={product.stock}
    value={quantities[product.id]||1}
    onChange={(e)=>
        handleQuantityChange(product.id,e.target.value)}
        />
        <button onClick={()=> addToCart(product,quantities[product.id] || 1)} style={{marginLeft:"10px"}}>Add to Cart</button> 
    </>
)}
</li>
))}
</ul> 
</div> 
); 
};

export default ProductList;