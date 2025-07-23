import React, { useContext, useState } from 'react'; 
import { CartContext } from '../context/CartContext';
import api from '../services/api'; 

const Cart = () => { 
const { cartItems, clearCart } = useContext(CartContext); 
const [message, setMessage]= useState(``);
//const [order,setOrder]=useState(null);

const totalPrice = cartItems.reduce( 
(sum, item) => sum + item.price * item.quantity, 0 
); 

const handleCheckout = async() => {
    const userId=1;
    try{
        for(const item of cartItems){
            await api.post("/cart/add",{
                user:{id:userId},
                product:{id:item.id},
                quantity:item.quantity
            });
        }
    
    const res= await api.post(`/orders/place/${userId}`);
    console.log("Order placed",res.data);
    //setOrder(res.data);
    setMessage('Order placed successfully');
    clearCart();
    }
    catch(err){
        console.error('Checkout error :', err);
        setMessage('Failed to place order');
    }};

return ( 
<div style={{marginTop:"30px"}}> 
<h2>Your Cart</h2> 
{cartItems.length === 0 && <p>Cart is empty.</p>}
{cartItems.length>0 && (
    <>
    <ul> 
    {cartItems.map(item => ( 
    <li key={item.id}> 
    {item.name} — Qty: {item.quantity} — ${item.price * item.quantity} 
    </li> 
))} 
</ul>
<h3>Total: ${totalPrice.toFixed(2)}</h3> 
<button onClick={clearCart}>Clear Cart</button>
<button style={{marginLeft:"10px"}} onClick={handleCheckout}>Checkout</button>
</>
)} 
 
{message && <p>{message}</p>}



</div> 
); 
}; 
export default Cart;