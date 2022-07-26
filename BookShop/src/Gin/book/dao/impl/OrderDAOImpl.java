package Gin.book.dao.impl;

import Gin.book.dao.OrderDAO;
import Gin.book.pojo.OrderBean;
import Gin.book.pojo.User;
import Gin.myssm.basedao.BaseDAO;

import java.math.BigDecimal;
import java.util.List;

public class OrderDAOImpl extends BaseDAO<OrderBean> implements OrderDAO {
    @Override
    public void addOrderBean(OrderBean orderBean) {
        String sql = "insert into t_order values(0,?,?,?,?,?)";
        int orderId = super.executeUpdate(sql,orderBean.getOrderNo(),orderBean.getOrderDate(),orderBean.getOrderUser().getId(),orderBean.getOrderMoney(),orderBean.getOrderStatus());
        orderBean.setId(orderId);
    }

    @Override
    public List<OrderBean> getOrderList(User user) {
        return executeQuery("select * from t_order where id=?",user.getId());
    }

    @Override
    public Integer getOrderTotalBookCount(OrderBean orderBean) {
        String sql = "select sum(t3.buyCount) as totalBookCount,t3.orderBean from\n" +
                "(select t1.id,t2.buyCount,t2.orderBean from t_order t1 inner join \n" +
                "t_order_item t2 on t1.id = t2.orderBean where t1.orderUser = ?)\n" +
                "t3 where t3.orderBean = ? group by t3.orderBean;";

        return ((BigDecimal)executeComplexQuery(sql,orderBean.getOrderUser().getId(),orderBean.getId())[0]).intValue();
    }
}
