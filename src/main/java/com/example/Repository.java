package com.example;

import java.sql.SQLException;
import java.util.List;

public interface Repository {
    Hello getHello(long blogId) throws Exception;
    List<Hello> listHellos() throws Exception;
    String testDb() throws SQLException;
}
