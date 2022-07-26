package Gin.book.controllers;

import Gin.book.pojo.Book;
import Gin.book.pojo.Cart;
import Gin.book.pojo.CartItem;
import Gin.book.pojo.User;
import Gin.book.service.CartItemService;
import com.google.gson.Gson;

import javax.servlet.http.HttpSession;

public class CartController {

    private CartItemService cartItemService;

    // 加载当前用户的购物车信息
    public String index(HttpSession session){
        User currUser = (User)session.getAttribute("currUser");
        Cart cart = cartItemService.getCart(currUser);
        currUser.setCart(cart);
        session.setAttribute("currUser",currUser);

        return "cart/cart";
    }

    public String addCart(Integer bookId, HttpSession session){

        User user = (User)session.getAttribute("currUser");
        CartItem cartItem = new CartItem(new Book(bookId),1,user);

        cartItemService.addOrUpdateCartItem(cartItem,user.getCart());

        return "redirect:cart.do";
    }

    public String editCart(Integer cartItemId , Integer buyCount){
        cartItemService.updateCartItem(new CartItem(cartItemId,buyCount));

        return "";

    }

    public String cartInfo(HttpSession session){

        User user = (User)session.getAttribute("currUser");
        Cart cart = cartItemService.getCart(user);
        // 需要先行获取书本总金额的值和总件数的值
        cart.getTotalMoney();
        cart.getTotalBookCount();

        Gson gson = new Gson();
        String cartJSonStr = gson.toJson(cart);

        return "json:"+cartJSonStr;
    }
}
