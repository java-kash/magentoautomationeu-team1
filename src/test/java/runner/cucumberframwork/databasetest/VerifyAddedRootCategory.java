package runner.cucumberframwork.databasetest;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VerifyAddedRootCategory {
    Statement statement = null;
    ResultSet resultSet = null;
    CachedRowSet cachedRowSet = null;
    boolean isStoreViewExist = false;

    public void getRootCategoryInfo(String rootCategoryName, Connection connection) {

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
        String sqlScriptStore = String.format("select value_id,entity_type_id,value from mg_catalog_category_entity_varchar where value ='%s'", rootCategoryName);
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

    public boolean verifyRootCategoryIsAdded() {
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
                int value_id = cachedRowSet.getInt("value_id");
                int entity_type_id = cachedRowSet.getInt("entity_type_id");
                String value = cachedRowSet.getString("value");
                System.out.printf("value_id=%s,entity_type_id=%s,value=%s", value_id, entity_type_id, value);
                count = cachedRowSet.getRow();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (count >= 1)
            isStoreViewExist = true;
        return isStoreViewExist;
    }
}
