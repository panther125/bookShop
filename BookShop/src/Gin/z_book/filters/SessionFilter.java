//package Gin.z_book.filters;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.annotation.WebInitParam;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.List;
//
//@WebFilter(urlPatterns={"*.do","*.html"},initParams={
//        @WebInitParam(name = "whlite",
//                value = "/BookShop/page.do?operate=page&page=user/login,/BookShop/user.do?null")
//})
//public class SessionFilter implements Filter {
//
//    private List<String> whliteList = null;
//
//    @Override
//    public void init(FilterConfig config) throws ServletException {
//        String whlite = config.getInitParameter("whlite");
//        String[] strings = whlite.split(",");
//        whliteList = Arrays.asList(strings);
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest)servletRequest;
//        HttpServletResponse response = (HttpServletResponse)servletResponse;
//
//
//        String requestURI = request.getRequestURI();
//        String QueryStr = request.getQueryString();
//
//        String url = requestURI + "?" + QueryStr;
//
//        if(whliteList.contains(url)){
//            // 如果地址在白名单中直接放行
//            filterChain.doFilter(request,response);
//            //return;
//        }else{
//            HttpSession session = request.getSession();
//            Object currUser = session.getAttribute("currUser");
//
//            if(currUser == null)
//                response.sendRedirect("page.do?operate=page&page=user/login");
//            else
//                filterChain.doFilter(request,response);
//
//        }
//
//
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
