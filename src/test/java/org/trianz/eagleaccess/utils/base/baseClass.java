package org.trianz.eagleaccess.utils.base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.sql.SQLException;

import static org.trianz.eagleaccess.utils.sql.sqlBaseHelper.*;

public class baseClass {

    @BeforeSuite
    public static void beforeSuite() {
        System.out.println("Before Suite Got Executed");
        connectDb();
    }

    @AfterSuite
    public static void afterSuite() throws SQLException {
        System.out.println("After Suite Got Executed");
        closeDbConnect();
    }
}
