package com.zisal.jelling.service;

import com.zisal.jelling.dto.DTOUpdateLocation;
import com.zisal.jelling.model.ModelForceTracker;
import com.zisal.jelling.model.ModelLocation;
import com.zisal.jelling.repo.IRepoForceTracker;
import com.zisal.jelling.repo.IRepoLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Ladies Man on 11/29/2015.
 */
@Service
public class ServiceLocationImpl implements IServiceLocation {

    Logger logger = LoggerFactory.getLogger(ServiceLocationImpl.class);

    @Autowired
    IRepoLocation iRepoLocation;

    @Autowired
    IRepoForceTracker iRepoForceTracker;

    @Override
    public List<ModelLocation> loadAllLocation(BigInteger p_UserId) {
        return iRepoLocation.loadAllLocation(p_UserId);
    }

    @Override
    public int updateLocation(DTOUpdateLocation p_DTOUpdateLocation) {
        List<ModelForceTracker> modelForceTrackers = checkImei(p_DTOUpdateLocation.getImei());
        ModelForceTracker modelForceTracker;
        if (modelForceTrackers.size() >= 1){
            logger.info("found ft");
            modelForceTracker = modelForceTrackers.get(0);
            modelForceTracker.setLastLatitude(p_DTOUpdateLocation.getLatitude());
            modelForceTracker.setLastLongitude(p_DTOUpdateLocation.getLongitude());
            modelForceTracker.setAddress(p_DTOUpdateLocation.getAddress());
            iRepoForceTracker.save(modelForceTracker);
            logger.info("update ft");
            return 1;
        }else{
            modelForceTracker = new ModelForceTracker();
            modelForceTracker.setName(p_DTOUpdateLocation.getName());
            modelForceTracker.setPhoneNumber(p_DTOUpdateLocation.getPhoneNumber());
            modelForceTracker.setLastLongitude(p_DTOUpdateLocation.getLongitude());
            modelForceTracker.setLastLatitude(p_DTOUpdateLocation.getLatitude());
            modelForceTracker.setImeiNumber(p_DTOUpdateLocation.getImei());
            modelForceTracker.setImsiNumber(p_DTOUpdateLocation.getImsi());
            logger.info("save new ft");
            iRepoForceTracker.save(modelForceTracker);
            return 0;
        }
    }

    @Override
    public int saveNewLocation(DTOUpdateLocation p_DTOUpdateLocation) {
        return 0;
    }

    @Override
    public List<ModelForceTracker> checkImei(String p_Imei) {
        return iRepoForceTracker.getImei(p_Imei);
    }

    public List<ModelForceTracker> loadAllForces(){
        return (List<ModelForceTracker>) iRepoForceTracker.findAll();
    }
}
