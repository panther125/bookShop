package Gin.book.pojo;

import java.util.Map;
import java.util.Set;

public class Cart {

    private Map<Integer,CartItem> cartItemMap;   // 购物车的购物车项
    private Double totalMoney;
    private Integer totalCount;
    private Integer totalBookCount; // 购物从书本总数量

    public Cart(){}

    public Map<Integer, CartItem> getCartItemMap() {
        return cartItemMap;
    }

    public void setCartItemMap(Map<Integer, CartItem> cartItemMap) {
        this.cartItemMap = cartItemMap;
    }

    public Double getTotalMoney() {
        totalMoney = 0.00;

        if( cartItemMap != null && cartItemMap.size() > 0){
            Set<Map.Entry<Integer, CartItem>> entries = cartItemMap.entrySet();
            for(Map.Entry<Integer, CartItem> temp : entries){
                CartItem cartItem = temp.getValue();
                 totalMoney += cartItem.getBook().getPrice() * cartItem.getBuyCount();
            }
        }

        return totalMoney;
    }


    public Integer getTotalCount() {
        totalCount = 0;
        if(cartItemMap != null && cartItemMap.size() > 0){
            totalCount = cartItemMap.size();
        }

        return totalCount;
    }

    public Integer getTotalBookCount() {
        totalBookCount = 0;
        if(cartItemMap != null && cartItemMap.size() > 0){
            for(CartItem cartItem : cartItemMap.values()){
                totalBookCount += cartItem.getBuyCount();
            }
        }
        return totalBookCount;
    }
}
