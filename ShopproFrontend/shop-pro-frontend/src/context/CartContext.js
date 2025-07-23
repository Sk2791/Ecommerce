import React, { createContext, useState } from 'react'; 
export const CartContext = createContext(); 
export const CartProvider = ({ children }) => { 
const [cartItems, setCartItems] = useState([]); 
const addToCart = (product, quantity = 1) => { 
setCartItems(prevItems => { 
const existing = prevItems.find(item => item.id === product.id); 
if (existing) { 
return prevItems.map(item => 
item.id === product.id 
? { ...item, quantity: item.quantity + quantity } 
: item 
); 
} 
return [...prevItems, { ...product, quantity }]; 
}); 
}; 
const clearCart = () => setCartItems([]); 
return ( 
<CartContext.Provider value={{ cartItems, addToCart, clearCart }}> 
{children} 
</CartContext.Provider> 
); 
};