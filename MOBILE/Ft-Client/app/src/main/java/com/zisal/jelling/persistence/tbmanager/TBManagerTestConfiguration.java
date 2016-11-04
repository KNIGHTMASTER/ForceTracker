package com.zisal.jelling.persistence.tbmanager;

import android.content.Context;
import android.util.Log;

import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.zisal.jelling.persistence.IBaseDBHandler;
import com.zisal.jelling.persistence.dao.DAOHelper;
import com.zisal.jelling.persistence.model.ModelDynamicTestConfiguration;

import java.sql.SQLException;
import java.util.List;




/**
 * Created on 5/27/2015 : 4:24 PM.
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class TBManagerTestConfiguration implements IBaseDBHandler {

    static private TBManagerTestConfiguration instance;

    static public void init( Context ctx ){
        if( instance == null ){
            instance = new TBManagerTestConfiguration( ctx );
        }
    }

    static public TBManagerTestConfiguration getInstance(){
        return instance;
    }

    private DAOHelper daoHelper;

    public TBManagerTestConfiguration(Context ctx) {
        daoHelper = new DAOHelper( ctx);
    }

    public DAOHelper getDaoHelper() {
        return daoHelper;
    }

    @Override
    public int insertEntity(Object entity) {
        int result = 0;
        try {
            result = getDaoHelper().getDaoTestConfiguration().create((ModelDynamicTestConfiguration) entity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<ModelDynamicTestConfiguration> getAllData() {
        List<ModelDynamicTestConfiguration> result = null;
        try {
            result = (List<ModelDynamicTestConfiguration>) getDaoHelper().getDaoTestConfiguration().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void updateEntity(Object entity) {
        try {
            getDaoHelper().getDaoTestConfiguration().update((ModelDynamicTestConfiguration) entity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEntity(Integer id) {
        try {
            getDaoHelper().getDaoTestConfiguration().deleteById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void executeNativeCommand(String sqlCommand) {
        Log.d("QUERY", sqlCommand);
        try{
            getDaoHelper().getDaoTestConfiguration().executeRaw(sqlCommand);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<ModelDynamicTestConfiguration> getListDataFromQuery(String column, String value) {
        QueryBuilder<ModelDynamicTestConfiguration, Integer> queryBuilder = null;
        PreparedQuery<ModelDynamicTestConfiguration> preparedQuery = null;
        List<ModelDynamicTestConfiguration> result = null;
        try {
            queryBuilder = getDaoHelper().getDaoTestConfiguration().queryBuilder();
            queryBuilder.where().eq(column,value);
            preparedQuery = queryBuilder.prepare();
            result = (List<ModelDynamicTestConfiguration>) getDaoHelper().getDaoTestConfiguration().query(preparedQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (result != null) {
            if(result.size() == 0)
                return null;
        }
        return result;
    }

    @Override
    public Object getADataFromQuery(String column, String value) {
        return getListDataFromQuery(column, value).get(0);
    }
}
