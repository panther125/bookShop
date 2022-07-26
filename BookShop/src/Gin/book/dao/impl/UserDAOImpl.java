package Gin.book.dao.impl;

import Gin.book.dao.UserDAO;
import Gin.book.pojo.User;
import Gin.myssm.basedao.BaseDAO;

public class UserDAOImpl extends BaseDAO<User> implements UserDAO {

    @Override
    public User getUser(String uname, String pwd) {
        String sql = "select * from t_user where uname=? and pwd=?";
        return load(sql,uname,pwd);
    }

    @Override
    public void addUser(User user) {
        String sql = "insert into t_user values(0,?,?,?,0)";
        executeUpdate(sql,user.getUname(),user.getPwd(),user.getEmail());
    }

    @Override
    public User getUser(String uname) {
        String sql = "select * from t_user where uname=?";
        return load(sql,uname);
    }
}
