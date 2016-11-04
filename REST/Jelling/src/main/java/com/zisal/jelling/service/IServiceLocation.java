package com.zisal.jelling.service;


import com.zisal.jelling.dto.DTOUpdateLocation;
import com.zisal.jelling.model.ModelForceTracker;
import com.zisal.jelling.model.ModelLocation;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Ladies Man on 11/29/2015.
 */
public interface IServiceLocation {

    List<ModelLocation> loadAllLocation(BigInteger p_UserId);

    List<ModelForceTracker> loadAllForces();

    int updateLocation(DTOUpdateLocation p_DTOUpdateLocation);

    int saveNewLocation(DTOUpdateLocation p_DTOUpdateLocation);

    List<ModelForceTracker> checkImei(String p_Imei);
}
