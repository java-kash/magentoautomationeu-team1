package runner.cucumberframwork.databasetest;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VerifyAddedTexRuleAtDB {
    Statement statement = null;
    ResultSet resultSet = null;
    CachedRowSet cachedRowSet = null;

    public void getTaxRuleInfo(String taxRule, Connection connection) {
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
        String sqlScriptStore = String.format("select code,tax_calculation_rule_id from mg_tax_calculation_rule where code='%s'", taxRule);
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

    public boolean verifyTexRuleIsAdded() {
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
                int id = cachedRowSet.getInt("tax_calculation_rule_id");
                String code = cachedRowSet.getString("code");
                System.out.println(String.format("code=%s,tax_calculation_rule_id=%d", code, id));
                count = cachedRowSet.getRow();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (count >= 1)
            return true;
        else
            return false;


    }
}
