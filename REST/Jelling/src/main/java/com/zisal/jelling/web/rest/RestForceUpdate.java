package com.zisal.jelling.web.rest;

import com.zisal.jelling.dto.DTOUpdateLocation;
import com.zisal.jelling.model.ModelForceTracker;
import com.zisal.jelling.service.IServiceLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Ladies Man on 9/26/2016.
 */
@RestController
public class RestForceUpdate {

    @Autowired
    IServiceLocation iServiceLocation;

    @RequestMapping(value = "/rest/update/location", method = RequestMethod.POST)
    @ResponseBody
    public int updateLocation(@RequestBody DTOUpdateLocation p_DTOUpdateLocation){
        return  iServiceLocation.updateLocation(p_DTOUpdateLocation);
    }

    @RequestMapping(value = "/rest/load/location", method = RequestMethod.GET)
    @ResponseBody
    public List<ModelForceTracker> updateLocation(){
        return  iServiceLocation.loadAllForces();
    }
}
