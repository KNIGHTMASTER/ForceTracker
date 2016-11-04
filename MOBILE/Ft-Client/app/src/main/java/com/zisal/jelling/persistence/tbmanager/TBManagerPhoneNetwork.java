package com.zisal.jelling.persistence.tbmanager;

import android.content.Context;
import android.util.Log;

import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.zisal.jelling.persistence.IBaseDBHandler;
import com.zisal.jelling.persistence.dao.DAOHelper;
import com.zisal.jelling.persistence.model.impl.ModelPhoneNetwork;

import java.sql.SQLException;
import java.util.List;


/**
 * Created on 5/27/2015 : 4:24 PM.
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class TBManagerPhoneNetwork implements IBaseDBHandler {

    static private TBManagerPhoneNetwork instance;

    static public void init( Context ctx ){
        if( instance == null ){
            instance = new TBManagerPhoneNetwork( ctx );
        }
    }

    static public TBManagerPhoneNetwork getInstance(){
        return instance;
    }

    private DAOHelper daoHelper;

    public TBManagerPhoneNetwork(Context ctx) {
        daoHelper = new DAOHelper( ctx);
    }

    public DAOHelper getDaoHelper() {
        return daoHelper;
    }

    @Override
    public int insertEntity(Object entity) {
        int result = 0;
        try {
            result = getDaoHelper().getDaoPhoneNetwork().create((ModelPhoneNetwork) entity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<ModelPhoneNetwork> getAllData() {
        List<ModelPhoneNetwork> result = null;
        try {
            result = (List<ModelPhoneNetwork>) getDaoHelper().getDaoPhoneNetwork().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void updateEntity(Object entity) {
        try {
            getDaoHelper().getDaoPhoneNetwork().update((ModelPhoneNetwork) entity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEntity(Integer id) {
        try {
            getDaoHelper().getDaoPhoneNetwork().deleteById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void executeNativeCommand(String sqlCommand) {
        Log.d("QUERY", sqlCommand);
        try{
            getDaoHelper().getDaoPhoneNetwork().executeRaw(sqlCommand);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<ModelPhoneNetwork> getListDataFromQuery(String column, String value) {
        QueryBuilder<ModelPhoneNetwork, Integer> queryBuilder = null;
        PreparedQuery<ModelPhoneNetwork> preparedQuery = null;
        List<ModelPhoneNetwork> result = null;
        try {
            queryBuilder = getDaoHelper().getDaoPhoneNetwork().queryBuilder();
            queryBuilder.where().eq(column,value);
            preparedQuery = queryBuilder.prepare();
            result = (List<ModelPhoneNetwork>) getDaoHelper().getDaoPhoneNetwork().query(preparedQuery);
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
