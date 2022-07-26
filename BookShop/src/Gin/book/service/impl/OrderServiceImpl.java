package Gin.book.service.impl;

import Gin.book.dao.CartItemDAO;
import Gin.book.dao.OrderDAO;
import Gin.book.dao.OrderItemDAO;
import Gin.book.pojo.CartItem;
import Gin.book.pojo.OrderBean;
import Gin.book.pojo.OrderItem;
import Gin.book.pojo.User;
import Gin.book.service.OrderService;

import java.util.List;
import java.util.Map;

public class OrderServiceImpl implements OrderService {

    private OrderDAO orderDAO;
    private OrderItemDAO orderItemDAO;
    private CartItemDAO cartItemDAO;

    @Override
    public void addOrderBean(OrderBean orderBean) {
        orderDAO.addOrderBean(orderBean);

        User currUser = orderBean.getOrderUser();
        Map<Integer, CartItem> cartItemMap = currUser.getCart().getCartItemMap();
        for(CartItem cartItem : cartItemMap.values()){
            OrderItem orderItem = new OrderItem();
            orderItem.setBook(cartItem.getBook());
            orderItem.setBuyCount(cartItem.getBuyCount());
            orderItem.setOrderBean(orderBean);

            orderItemDAO.addOrderItem(orderItem);

        }

        for(CartItem cartItem : cartItemMap.values()){
            cartItemDAO.delCartItem(cartItem);
        }
    }

    @Override
    public List<OrderBean> getOrderList(User user) {
        List<OrderBean> orderBeanList =  orderDAO.getOrderList(user);

        for(OrderBean orderBean : orderBeanList){
            Integer totalBookCount = orderDAO.getOrderTotalBookCount(orderBean);
            orderBean.setTotalBookCount(totalBookCount);
        }

        return orderBeanList;
    }
}
