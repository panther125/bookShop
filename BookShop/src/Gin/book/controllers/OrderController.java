package Gin.book.controllers;

import Gin.book.pojo.OrderBean;
import Gin.book.pojo.User;
import Gin.book.service.OrderService;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class OrderController {

    private OrderService orderService;

    // 结账
    public String checkout(HttpSession session){

        OrderBean orderBean = new OrderBean();
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowStr = sdf.format(now);
//        String[] nowSplit = nowStr.split("-");
//        String[] tempSplit = nowSplit[2].split(" ");
//        String[] timeSplit = tempSplit[1].split(":");

        // 获取时间数码
        String temp = UUID.randomUUID().toString()+nowStr;
        char[] chars = new char[46];
        int index = 0;
        for( int i =0; i < temp.length() - 1; i++){
            if(temp.charAt(i) == '-' || temp.charAt(i) == ' ' || temp.charAt(i) == ':'){
                continue;
            }
            chars[index] = temp.charAt(i);
            index++;
        }
        // 获取全球唯一码 + 当前时间组成订单号
        orderBean.setOrderNo(new String(chars));
        orderBean.setOrderDate(now);

        User user = (User)session.getAttribute("currUser");
        orderBean.setOrderUser(user);
        orderBean.setOrderMoney(user.getCart().getTotalMoney());
        orderBean.setOrderStatus(0);

        orderService.addOrderBean(orderBean);

        return "index";
    }

    public String getOrderList(HttpSession session){
        User user = (User)session.getAttribute("currUser");

        List<OrderBean> orderList = orderService.getOrderList(user);
        user.setOrderList(orderList);

        session.setAttribute("currUser",user);


        return "order/order";
    }
}
