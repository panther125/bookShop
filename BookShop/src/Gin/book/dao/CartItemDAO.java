package Gin.book.dao;

import Gin.book.pojo.CartItem;
import Gin.book.pojo.User;

import java.util.List;

public interface CartItemDAO {

    // 新增购物车项
    void addCartItem(CartItem cartItem);

    // 修改特定购物车项
    void updateCartItem(CartItem cartItem);

    // 获取特定用户的所有购物测项
    List<CartItem> getCartItemList(User user);

    //删除指定的购物车项
    void delCartItem(CartItem cartItem);
}
