package Gin.book.service;

import Gin.book.pojo.Cart;
import Gin.book.pojo.CartItem;
import Gin.book.pojo.User;

import java.util.List;

public interface CartItemService {

    void addCartItem(CartItem cartItem);
    void updateCartItem(CartItem cartItem);
    void addOrUpdateCartItem(CartItem cartItem, Cart cart);

    // 获取购物车项列表
    List<CartItem> getCartItemList(User user);

    // 获取指定用户的购物测
    Cart getCart(User user);
}
