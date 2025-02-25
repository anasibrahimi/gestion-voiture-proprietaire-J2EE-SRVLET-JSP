package com.example.gestionvoitureproprietairej2ee.config;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MyDataSourceFactory {
    public static DataSource getMySQLDataSource() {
        Properties props = new Properties();
        MysqlDataSource mysqlDataSource = null;

        try (InputStream inputStream = MyDataSourceFactory.class.getClassLoader().getResourceAsStream("db.properties")) {
            if (inputStream == null) {
                throw new IOException("Properties file not found");
            }
            props.load(inputStream);
            mysqlDataSource = new MysqlDataSource();
            mysqlDataSource.setURL(props.getProperty("url"));
            mysqlDataSource.setUser(props.getProperty("username"));
            mysqlDataSource.setPassword(props.getProperty("password"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mysqlDataSource;
    }
}