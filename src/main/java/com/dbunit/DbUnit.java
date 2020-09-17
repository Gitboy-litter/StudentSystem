package com.dbunit;


import com.alibaba.druid.pool.DruidDataSource;
import com.entity.Page;
import com.entity.Student;

import javax.naming.Name;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @ProjectName: JavaSE
 * @Package: day14_test.test3
 * @ClassName: DbUnit
 * @Author: QT
 * @Description: ${description}
 * @Date: 2020/9/8 16:51
 * @Version: 1.0
 */
public class DbUnit {
    private static DruidDataSource druidDataSource;

    static {
        Properties prop = new Properties();
        try {
//            properties.load(new FileInputStream("d:\\db.properties"));
            prop.load(DbUnit.class.getClassLoader().getResourceAsStream("application.properties"));
            druidDataSource = new DruidDataSource();
            druidDataSource.setUsername(prop.getProperty("USER"));
            druidDataSource.setPassword(prop.getProperty("PASSWORD"));
            druidDataSource.setUrl(prop.getProperty("URL"));
            druidDataSource.setDriverClassName(prop.getProperty("CONNECT"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static DruidDataSource getDataSource() {
        return druidDataSource;
    }

    public static Connection Connet() {
        Connection connection = null;
        try {
            connection = druidDataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void dml(String sql, Object... objects) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DbUnit.Connet();
            statement = connection.prepareStatement(sql);
            for (int i = 0; i < objects.length; i++) {
                statement.setObject(i + 1, objects[i]);
            }
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(connection,statement);
        }
    }


    public static boolean  select(String sql, Object... objects) {
        Connection connection = null;
        PreparedStatement statement = null;
        boolean next=true;
        ResultSet resultSet=null;
        try {
            connection = DbUnit.Connet();
            statement = connection.prepareStatement(sql);
            for (int i = 0; i < objects.length; i++) {
                statement.setObject(i + 1, objects[i]);
            }
             resultSet = statement.executeQuery();
             next = resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(connection,statement);
        }
        return next;
    }

    public static Integer count(String sql,String name) {
        Integer count=0;
        Connection connection = null;
        PreparedStatement statement = null;
        boolean next=true;
        ResultSet resultSet=null;
        try {
            connection = DbUnit.Connet();
            statement = connection.prepareStatement(sql);
            statement.setObject(1,"%"+name+"%");
            resultSet = statement.executeQuery();
            while (resultSet.next()){
            count = resultSet.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(connection,statement);
        }
        return count;
    }

    public static List likeSelect(String sql, String name) {
        ArrayList<Student> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        boolean next=true;
        ResultSet resultSet=null;
        try {
            connection = DbUnit.Connet();
            statement = connection.prepareStatement(sql);
            statement.setObject(1, "%"+name+"%");
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                Student student=new Student(resultSet.getString("sno"),resultSet.getString("sname"),resultSet.getString("ssex"),Integer.valueOf(resultSet.getString("sage")),resultSet.getString("sdept"));
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(connection,statement);
        }
        return list;
    }

    public static List limitStudent(String sql,String name, Page page) {
        ArrayList<Student> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        boolean next=true;
        ResultSet resultSet=null;
        try {
            connection = DbUnit.Connet();
            statement = connection.prepareStatement(sql);
            statement.setObject(1,"%"+name+"%");
            statement.setObject(2, (page.getPageCurren()-1)*page.getPageSize());
            statement.setObject(3, page.getPageSize());
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                Student student=new Student(resultSet.getString("sno"),resultSet.getString("sname"),resultSet.getString("ssex"),Integer.valueOf(resultSet.getString("sage")),resultSet.getString("sdept"));
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(connection,statement);
        }
        return list;
    }


    public static List selectALL(String sql) {
        ArrayList<Student> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        boolean next=true;
        ResultSet resultSet=null;
        try {
            connection = DbUnit.Connet();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
           while (resultSet.next()){
               Student student=new Student(resultSet.getString("sno"),resultSet.getString("sname"),resultSet.getString("ssex"),Integer.valueOf(resultSet.getString("sage")),resultSet.getString("sdept"));
                list.add(student);
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(connection,statement);
        }
        return list;
    }

    public static void close(Connection connection, ResultSet resultSet, Statement statement) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Connection connection, Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
