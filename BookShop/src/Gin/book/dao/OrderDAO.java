package Gin.book.dao;

import Gin.book.pojo.OrderBean;
import Gin.book.pojo.User;

import java.util.List;

public interface OrderDAO {
    // 添加订单
    void addOrderBean(OrderBean orderBean);

    // 查看订单详情
    List<OrderBean> getOrderList(User user);

    //订单详细项数
    Integer getOrderTotalBookCount(OrderBean orderBean);

}
