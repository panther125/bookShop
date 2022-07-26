package Gin.book.dao.impl;

import Gin.book.dao.OrderItemDAO;
import Gin.book.pojo.OrderItem;
import Gin.myssm.basedao.BaseDAO;

public class OrderItemDAOImpl extends BaseDAO<OrderItem> implements OrderItemDAO {

    @Override
    public void addOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item values(0,?,?,?)";
        super.executeUpdate(sql, orderItem.getBook().getId(),orderItem.getBuyCount(),orderItem.getOrderBean().getId());
    }
}
