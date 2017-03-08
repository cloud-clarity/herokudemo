package com.example;

import java.sql.SQLException;

public interface Repository {
    Hello getHello(long blogId) throws Exception;
    String testDb() throws SQLException;
}
