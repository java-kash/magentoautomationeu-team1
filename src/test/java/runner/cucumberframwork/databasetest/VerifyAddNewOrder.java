package runner.cucumberframwork.databasetest;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VerifyAddNewOrder {

    public boolean getOrder(int entity_id , Connection connection){
        boolean isOrderExist=false;
        Statement statement=null;
        ResultSet resultSet=null;
        CachedRowSet cachedRowSet=null;

        try {
            cachedRowSet= RowSetProvider.newFactory().createCachedRowSet();   //ResultSet ni store(sahlaydighan) cachedRowSet kuriwalduk.
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String newOrderSqlScript=String.format("select entity_id, protect_code from mg_sales_flat_order where entity_id='%s'",entity_id);
        try {
            resultSet=statement.executeQuery(newOrderSqlScript);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(resultSet==null){
            System.out.println("no records found");
            return isOrderExist;
        }else{
            try {
                cachedRowSet.populate(resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            int count=0;
            while (true){
                try {
                    if(!cachedRowSet.next()){
                        break;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    int entity_id1 = cachedRowSet.getInt("entity_id");
                    String protect_code = cachedRowSet.getString("protect_code");
                    System.out.println(String.format("entity_id=%d protect_code=%s",entity_id1,protect_code));
                    count = cachedRowSet.getRow();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
            if(count>=1)
                isOrderExist=true;
            return isOrderExist;
        }
    }

}

