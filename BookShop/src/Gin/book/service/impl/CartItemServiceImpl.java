package Gin.book.service.impl;

import Gin.book.dao.CartItemDAO;
import Gin.book.pojo.Book;
import Gin.book.pojo.Cart;
import Gin.book.pojo.CartItem;
import Gin.book.pojo.User;
import Gin.book.service.BookService;
import Gin.book.service.CartItemService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartItemServiceImpl implements CartItemService {

    private CartItemDAO cartItemDAO;
    private BookService bookService;

    @Override
    public void addCartItem(CartItem cartItem) {
        cartItemDAO.addCartItem(cartItem);
    }

    @Override
    public void updateCartItem(CartItem cartItem) {
        cartItemDAO.updateCartItem(cartItem);
    }

    @Override
    public void addOrUpdateCartItem(CartItem cartItem, Cart cart) {
        // 判断当前用户的购物车中是否有CartItem 有 update 无 add
        if(cart != null){
            Map<Integer, CartItem> cartItemMap = cart.getCartItemMap();
            if(cartItem == null){
                cartItemMap = new HashMap<>();
            }

            if(cartItemMap.containsKey(cartItem.getBook().getId())){
                CartItem cartItemTemp = cartItemMap.get(cartItem.getBook().getId());
                cartItemTemp.setBuyCount(cartItemTemp.getBuyCount()+1);
                updateCartItem(cartItemTemp);
            }else{
                addCartItem(cartItem);
            }
        }else{
            addCartItem(cartItem);
        }

    }

    @Override
    public List<CartItem> getCartItemList(User user) {
        List<CartItem> cartItemList = cartItemDAO.getCartItemList(user);
        for(CartItem cartItem : cartItemList){
            Book book = bookService.getBook(cartItem.getBook().getId());
            cartItem.setBook(book);
            cartItem.getXj();
        }

        return cartItemList;
    }

    @Override
    public Cart getCart(User user){
        List<CartItem> cartItemList = getCartItemList(user);
        Map<Integer, CartItem> cartItemMap = new HashMap<>();
        for(CartItem cartItem : cartItemList){
            cartItemMap.put(cartItem.getBook().getId(),cartItem);
        }

        Cart cart = new Cart();
        cart.setCartItemMap(cartItemMap);
        return cart ;
    }
}


