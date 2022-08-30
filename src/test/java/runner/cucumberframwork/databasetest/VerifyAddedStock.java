package runner.cucumberframwork.databasetest;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VerifyAddedStock {
    Statement statement = null;
    ResultSet resultSet = null;
    CachedRowSet cachedRowSet = null;
    boolean isstockrExist=false;

    public void getStockInfo(int Stock_id, Connection connection) {
        try {
            cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sqlScriptStore = String.format("select product_id,stock_id,stock_status from mg_cataloginventory_stock_status where stock_status='%d'", Stock_id);
        try {
            resultSet = statement.executeQuery(sqlScriptStore);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (resultSet == null) {
            System.out.println("No records Found");
        } else {
            try {
                cachedRowSet.populate(resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public boolean verifystockIsAdded() {
        int count = 0;
        while (true) {
            try {
                if (!cachedRowSet.next()) {
                    break;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                int product_id1 = cachedRowSet.getInt("product_id");
                int  stock_id = cachedRowSet.getInt("stock_id");
                int  stock_status= cachedRowSet.getInt("stock_status");
                System.out.println(String.format("product_id=%d,stock_id=%d, stock_status=%d",product_id1,stock_id,stock_status));
                count = cachedRowSet.getRow();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (count >= 1)
            isstockrExist = true;
        return isstockrExist;
    }

}
