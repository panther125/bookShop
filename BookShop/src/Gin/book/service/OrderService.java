package Gin.book.service;

import Gin.book.pojo.OrderBean;
import Gin.book.pojo.User;

import java.util.List;

public interface OrderService {
    void addOrderBean(OrderBean orderBean);

    List<OrderBean> getOrderList(User user);
}
