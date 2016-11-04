package com.zisal.jelling.persistence.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import com.zisal.jelling.ApplicationConstant;
import com.zisal.jelling.persistence.model.ModelDynamicTestConfiguration;
import com.zisal.jelling.persistence.model.ModelUser;
import com.zisal.jelling.persistence.model.impl.ModelPhoneNetwork;
import com.zisal.jelling.persistence.model.impl.ModelUserTracking;


/**
 * Created on 5/27/2015 : 12:09 PM.
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class DAOHelper extends OrmLiteSqliteOpenHelper {

    private Dao<ModelUserTracking, Integer> daoUserTracking = null;
    private Dao<ModelDynamicTestConfiguration, Integer> daoTestConfiguration = null;
    private Dao<ModelUser, Integer> daoUser = null;
    private Dao<ModelPhoneNetwork, Integer> daoPhoneNetwork = null;

    public DAOHelper(Context ctx) {
        super( ctx, ApplicationConstant.Database.DATABASE_NAME, null, ApplicationConstant.Database.DB_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try{
            TableUtils.createTable(connectionSource, ModelUserTracking.class);
            TableUtils.createTable(connectionSource, ModelDynamicTestConfiguration.class);
            TableUtils.createTable(connectionSource, ModelPhoneNetwork.class);
            TableUtils.createTable(connectionSource, ModelUser.class);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, ModelUserTracking.class, true);
            TableUtils.dropTable(connectionSource, ModelDynamicTestConfiguration.class, true);
            TableUtils.dropTable(connectionSource, ModelUser.class, true);
            TableUtils.dropTable(connectionSource, ModelPhoneNetwork.class, true);
            onCreate(database, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Dao<ModelUserTracking, Integer> getDaoUserTracking() {
        if( daoUserTracking == null ){
            try {
                daoUserTracking = getDao(ModelUserTracking.class);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return daoUserTracking;
    }

    public Dao<ModelDynamicTestConfiguration, Integer> getDaoTestConfiguration() {
        if( daoTestConfiguration == null ){
            try {
                daoTestConfiguration = getDao(ModelDynamicTestConfiguration.class);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return daoTestConfiguration;
    }

    public Dao<ModelUser, Integer> getDaoUser() {
        if( daoUser == null ){
            try {
                daoUser = getDao(ModelUser.class);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return daoUser;
    }

    public Dao<ModelPhoneNetwork, Integer> getDaoPhoneNetwork() {
        if( daoPhoneNetwork == null ){
            try {
                daoPhoneNetwork = getDao(ModelPhoneNetwork.class);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return daoPhoneNetwork;
    }

}
