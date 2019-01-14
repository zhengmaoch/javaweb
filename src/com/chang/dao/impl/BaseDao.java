package com.chang.dao.impl;

import com.chang.utils.ConfigManager;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDao {
    Connection connection = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;

    public boolean getConnection() {

        try {
            Class.forName(ConfigManager.getInstance().getString("driver"));
            String url = ConfigManager.getInstance().getString("url");
            String username = ConfigManager.getInstance().getString("username");
            String password = ConfigManager.getInstance().getString("password");

            connection = DriverManager.getConnection(url, username, password);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public int executeUpdate(String sql, Object[] params){
        int row = 0;

        if(getConnection()){
            try {
                pstm = connection.prepareStatement(sql);
                for(int i = 0; i < params.length; i++){
                    pstm.setObject(i+1, params[i]);
                }
                row = pstm.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return row;
    }

    public ResultSet executeQuery(String sql, Object[] params) {
        if(getConnection()){
            try {
                pstm = connection.prepareStatement(sql);
                for(int i = 0; i < params.length; i++){
                    pstm.setObject(i+1, params[i]);
                }
                rs = pstm.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rs;
    }



    public List ConvertToList(ResultSet rs, Class clazz) throws SQLException, IllegalAccessException, InstantiationException {
        ResultSetMetaData rsmd = rs.getMetaData();
        int colCount = rsmd.getColumnCount();
        List list = new ArrayList();

        Field[] fields = clazz.getDeclaredFields();
        while (rs.next()){
            Object obj = clazz.newInstance();
            for(int i=1; i<= colCount; i++){
                Object value = rs.getObject(i);
                for(int j=0; j<fields.length; j++){
                    Field f = fields[j];

                    if(f.getName().equalsIgnoreCase(rsmd.getColumnName(i))){
                        boolean flag = f.isAccessible();
                        f.setAccessible(true);
                        f.set(obj, value);
                        f.setAccessible(flag);
                    }
                }
            }
            list.add(obj);
        }

        return list;
    }

    public void closeAllResource(){
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(pstm != null){
            try {
                pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
