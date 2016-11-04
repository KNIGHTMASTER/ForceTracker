package com.zisal.jelling.repo;

import com.zisal.jelling.model.ModelForceTracker;
import com.zisal.jelling.model.ModelLocation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Ladies Man on 11/29/2015.
 */
public interface IRepoForceTracker extends PagingAndSortingRepository<ModelForceTracker, Integer> {


    @Query("select a from ModelForceTracker a where a.imeiNumber = ?1")
    public List<ModelForceTracker> getImei(String imeiNumber);

}
