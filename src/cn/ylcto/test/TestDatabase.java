package cn.ylcto.test;

import cn.ylcto.util.dbc.DatabaseConnection;

public class TestDatabase {
    public static void main(String[] args) {
        System.out.println(DatabaseConnection.get());
    }
}
