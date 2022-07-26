package Gin.book.pojo;

public class OrderItem {
    // 所有订单集合
    private Integer id;
    private Book book;      //  一个订单详情存在多本书
    private Integer buyCount;
    private OrderBean orderBean;

    public OrderItem(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    public OrderBean getOrderBean() {
        return orderBean;
    }

    public void setOrderBean(OrderBean orderBean) {
        this.orderBean = orderBean;
    }
}
