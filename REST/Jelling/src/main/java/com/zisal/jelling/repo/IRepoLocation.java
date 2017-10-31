package com.zisal.jelling.repo;

import com.zisal.jelling.dto.DTOUpdateLocation;
import com.zisal.jelling.model.ModelLocation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Ladies Man on 11/29/2015.
 */
public interface IRepoLocation extends PagingAndSortingRepository<ModelLocation, BigInteger> {

    @Query("select a from ModelLocation a where a.userId = ?1")
    List<ModelLocation> loadAllLocation(BigInteger p_UserId);

}
