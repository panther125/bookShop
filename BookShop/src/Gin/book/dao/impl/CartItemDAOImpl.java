package Gin.book.dao.impl;

import Gin.book.dao.CartItemDAO;
import Gin.book.pojo.CartItem;
import Gin.book.pojo.User;
import Gin.myssm.basedao.BaseDAO;

import java.util.List;

public class CartItemDAOImpl extends BaseDAO<CartItem> implements CartItemDAO {

    @Override
    public void addCartItem(CartItem cartItem) {
        String sql = "insert into t_cart_item values(0,?,?,?)";
        executeUpdate(sql,cartItem.getBook().getId(),cartItem.getBuyCount(),cartItem.getUserBean().getId());
    }

    @Override
    public void updateCartItem(CartItem cartItem) {
        String sql = "update t_cart_item set buyCount=? where id = ?";
        executeUpdate(sql,cartItem.getBuyCount(),cartItem.getId());
    }

    @Override
    public List<CartItem> getCartItemList(User user) {
        return executeQuery("select * from t_cart_item where userBean=?",user.getId());
    }

    @Override
    public void delCartItem(CartItem cartItem) {
        super.executeUpdate("delete from t_cart_item where id = ?",cartItem.getId());
    }
}
