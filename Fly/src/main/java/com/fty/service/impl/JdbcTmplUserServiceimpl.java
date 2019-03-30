package com.fty.service.impl;

import com.fty.entity.User;
import com.fty.enumeration.SexEnum;
import com.fty.service.JdbcTmplUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.StatementCallback;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class JdbcTmplUserServiceimpl implements JdbcTmplUserService {
    @Autowired
    private JdbcTemplate jdbcTemplate = null;

    //创建映射关系
    private RowMapper<User> getUserMapper() {
        RowMapper<User> userRowMapper = (ResultSet rs, int rownum) -> {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setUserName(rs.getString("user_name"));
            int sexId = rs.getInt("sex");
            SexEnum sexEnum = SexEnum.getEnumById(sexId);
            user.setSex(sexEnum);
            user.setNote(rs.getString("note"));
            return user;
        };
        return userRowMapper;
    }

    //    private  RowMapper<User> getUserMapper1() throws SQLException {
//        RowMapper<User> userRowMapper = new RowMapper<User>() {
//            @Override
//            public User mapRow(ResultSet rs, int rownum) throws SQLException {
//                User user = new User();
//                user.setId(rs.getLong("id"));
//                user.setUserName(rs.getString("user_name"));
//                int sexId = rs.getInt("sex");
//                SexEnum sexEnum = SexEnum.getEnumById(sexId);
//                user.setSex(sexEnum);
//                user.setNote(rs.getString("note"));
//                return user;
//
//            }
//        };
//      return  userRowMapper;
//    }
    @Override
    public User getUser(long id) {
        String sql = "select id,user_name,sex,note from t_user where id = ?";
        Object[] params = new Object[]{id};
        User user = jdbcTemplate.queryForObject(sql, params, getUserMapper());
        return user;
    }

    @Override
    public List<User> findUsers(String userName, String note) {
        String sql = "select id,user_name,sex,note from t_user where user_name like concat('%',?,'%')"
                + " and note like like concat('%',?,'%')";
        Object[] params = {userName, note};
        List<User> users = jdbcTemplate.query(sql, params, getUserMapper());
        return users;
    }

    @Override
    public int inserUser(User user) {
        String sql = "insert into t_user (user_name,sex,note) values(? ,? ,?) ";
        return jdbcTemplate.update(sql, user.getUserName(), user.getSex().getId(), user.getNote());
    }

    @Override
    public int updateUser(User user) {
        String sql = "update t_user set user_name = ? , sex = ? , note = ? where id = ?";
        return jdbcTemplate.update(sql, user.getUserName(), user.getSex().getId(), user.getNote(), user.getId());
    }

    @Override
    public int deleteUser(long id) {
        String sql = " delete t_user where id = ?";
        return jdbcTemplate.update(sql, id);
    }
    public User getUser2(long id){
        User result;
//        result = this.jdbcTemplate.execute((Statement stmt) -> {
//            String sql1 = "select count(*) total from t_user where id =" + id;
//            ResultSet rs1 = stmt.executeQuery(sql1);
//            while (rs1.next()){
//                int total = rs1.getInt("total");
//                System.out.println(total);
//            }
//            String sql2 = " select id,user_name,note,sex from t_user where id = "+id;
//            ResultSet rs2 = stmt.executeQuery(sql2);
//            User user = null;
//            while (rs2.next()){
//                int rowNum = rs2.getRow();
//                user = getUserMapper().mapRow(rs2, rowNum);
//            }
//            return user;
//        });
        result = jdbcTemplate.execute(new StatementCallback<User>() {
            @Override
            public User doInStatement(Statement stmt) throws SQLException, DataAccessException {
                String sql1 = "select count(*) total from t_user where id =" + id;
                ResultSet rs1 = stmt.executeQuery(sql1);
                while (rs1.next()) {
                    int total = rs1.getInt("total");
                    System.out.println(total);
                }
                String sql2 = " select id,user_name,note,sex from t_user where id = " + id;
                ResultSet rs2 = stmt.executeQuery(sql2);
                User user = null;
                while (rs2.next()) {
                    int rowNum = rs2.getRow();
                    user = getUserMapper().mapRow(rs2, rowNum);
                }
                return user;
            }
        });
        return result;
    }
}
