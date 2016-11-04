package com.tripoin.tripoin_dao.impl;

import android.content.Context;

import com.tripoin.tripoin_dao.base.ABaseGenericDAO;
import com.tripoin.tripoin_model.ModelForce;

/**
 * Created on 10/11/2015 : 4:50 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class DAOForce extends ABaseGenericDAO {

    public DAOForce(Context ctx) {
        super(ctx);
    }

    @Override
    public Class getModelClass() {
        return ModelForce.class;
    }
}
