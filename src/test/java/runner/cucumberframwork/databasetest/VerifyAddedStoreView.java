package runner.cucumberframwork.databasetest;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.*;

public class VerifyAddedStoreView {

    Statement statement = null;
    ResultSet resultSet = null;
    CachedRowSet cachedRowSet = null;
    boolean isStoreViewExist=false;

    public void getStoreViewInfo(String storeViewName, Connection connection) {

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
        String sqlScriptStore = String.format("select name,group_id , code from mg_core_store where name='%s'", storeViewName);
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

    public boolean verifyStoreViewIsAdded() {
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
                int groupID = cachedRowSet.getInt("group_id");
                String name = cachedRowSet.getString("name");
                String code = cachedRowSet.getString("code");
                System.out.println(String.format("name=%s,code=%s,group_id=%d", name, code, groupID));
                count = cachedRowSet.getRow();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (count >= 1)
         isStoreViewExist=true;
         return isStoreViewExist;


    }
}

