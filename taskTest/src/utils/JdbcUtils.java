package utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;

public class JdbcUtils {
    private static DataSource dataSource;
    static {
        dataSource= new ComboPooledDataSource();
    }
    public static DataSource getDataSource(){
        return dataSource;
    }

    //dbUtil
    public static QueryRunner getQuerrRunner() {
        return new QueryRunner(dataSource);
    }
}
