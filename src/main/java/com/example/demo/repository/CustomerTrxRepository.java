package com.example.demo.repository;

import com.example.demo.models.CustomerTrx;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
@RepositoryRestResource(collectionResourceRel = "custTrx", path = "custTrx")
public interface CustomerTrxRepository extends PagingAndSortingRepository<CustomerTrx, Long> {

    Slice<CustomerTrx> findByCustId(@Param("custId") String custId, Pageable pageable);
    Slice<CustomerTrx> findByAccNumber(@Param("accNumber") String accNumber, Pageable pageable);
}