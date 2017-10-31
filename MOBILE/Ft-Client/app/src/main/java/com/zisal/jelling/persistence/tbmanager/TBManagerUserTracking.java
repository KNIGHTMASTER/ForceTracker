package com.zisal.jelling.persistence.tbmanager;

import android.content.Context;
import android.util.Log;

import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.List;

import com.zisal.jelling.persistence.dao.DAOHelper;
import com.zisal.jelling.persistence.IBaseDBHandler;
import com.zisal.jelling.persistence.model.impl.ModelUserTracking;


/**
 * Created on 5/27/2015 : 4:24 PM.
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class TBManagerUserTracking implements IBaseDBHandler {

    static private TBManagerUserTracking instance;

    static public void init( Context ctx ){
        if( instance == null ){
            instance = new TBManagerUserTracking( ctx );
        }
    }

    static public TBManagerUserTracking getInstance(){
        return instance;
    }

    private DAOHelper daoHelper;

    public TBManagerUserTracking(Context ctx) {
        daoHelper = new DAOHelper( ctx);
    }

    public DAOHelper getDaoHelper() {
        return daoHelper;
    }

    @Override
    public int insertEntity(Object entity) {
        int result = 0;
        try {
            result = getDaoHelper().getDaoUserTracking().create((ModelUserTracking) entity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<ModelUserTracking> getAllData() {
        List<ModelUserTracking> result = null;
        try {
            result = (List<ModelUserTracking>) getDaoHelper().getDaoUserTracking().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void updateEntity(Object entity) {
        try {
            getDaoHelper().getDaoUserTracking().update((ModelUserTracking) entity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEntity(Integer id) {
        try {
            getDaoHelper().getDaoUserTracking().deleteById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void executeNativeCommand(String sqlCommand) {
        Log.d("QUERY", sqlCommand);
        try{
            getDaoHelper().getDaoUserTracking().executeRaw(sqlCommand);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<ModelUserTracking> getListDataFromQuery(String column, String value) {
        QueryBuilder<ModelUserTracking, Integer> queryBuilder = null;
        PreparedQuery<ModelUserTracking> preparedQuery = null;
        List<ModelUserTracking> result = null;
        try {
            queryBuilder = getDaoHelper().getDaoUserTracking().queryBuilder();
            queryBuilder.where().eq(column,value);
            preparedQuery = queryBuilder.prepare();
            result = (List<ModelUserTracking>) getDaoHelper().getDaoUserTracking().query(preparedQuery);
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
