package Gin.book.controllers;

import Gin.book.pojo.Cart;
import Gin.book.pojo.User;
import Gin.book.service.CartItemService;
import Gin.book.service.UserService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class UserController {

    private UserService userService;
    private CartItemService cartItemService;

    public String login(String uname , String pwd , HttpSession session){

        User user = userService.login(uname,pwd);

        if(user != null){
            Cart cart = cartItemService.getCart(user);
            user.setCart(cart);

            session.setAttribute("currUser",user);
            return "redirect:book.do";
        }

        return "user/login";
    }

    public String regist(String verifyCode, String uname, String pwd, String email, HttpSession session, HttpServletResponse response) throws IOException {

        Object kpatchaCode = session.getAttribute("KAPTCHA_SESSION_KEY");

        if(kpatchaCode == null || !kpatchaCode.equals(verifyCode)){
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('验证码错误');window.location.href='page.do?operate=page&page=user/regist'</script>");

            //return "user/regist";
            return "";
        }else {
            userService.regist(new User(uname,pwd,email));
            return "user/login";
        }

    }

    public String ckUanme(String name ){

        User user = userService.getUser(name);
        if(user == null){
            // user is available
            return "json:{'uname':'1'}";
        }else{
            // user is not available
            return "json:{'uname':'0'}";
        }

    }

}
