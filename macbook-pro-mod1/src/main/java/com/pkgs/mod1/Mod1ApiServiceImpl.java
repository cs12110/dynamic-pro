package com.pkgs.mod1;

import com.alibaba.fastjson.JSON;
import com.pkgs.api.service.ApiService;
import com.pkgs.api.util.DateUtil;
import com.pkgs.util.JdbcUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO:
 *
 * <p>
 *
 * @author cs12110 create at 2019-03-30 13:47
 * <p>
 * @since 1.0.0
 */
public class Mod1ApiServiceImpl implements ApiService<String, String> {

    @Override
    public String dealWith(String param) {


        usingMysqlToDoSomething();


        String className = this.getClass().getName();

        return DateUtil.format() + " - " + className + " : " + param;
    }


    private void usingMysqlToDoSomething() {

        String url = "jdbc:mysql://192.168.1.101:3306/4fun_db?allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8&rewriteBatchedStatements=true&useCursorFetch=true&useSSL=false";
        String user = "root";
        String password = "root@3306";


        try {
            Connection connection = JdbcUtil.getConnection(url, user, password);
            Statement stm = connection.createStatement();

            ResultSet resultSet = stm.executeQuery("select * from my_t");
            ResultSetMetaData metaData = resultSet.getMetaData();

            while (resultSet.next()) {
                Map<String, Object> map = new HashMap<>();
                for (int index = 1, count = metaData.getColumnCount(); index < count; index++) {
                    String columnName = metaData.getColumnName(index);
                    Object value = resultSet.getObject(columnName);
                    map.put(columnName, value);
                }

                System.out.println(JSON.toJSONString(map, true));
            }

            resultSet.close();
            stm.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Mod1ApiServiceImpl impl = new Mod1ApiServiceImpl();
        impl.usingMysqlToDoSomething();
    }
}
