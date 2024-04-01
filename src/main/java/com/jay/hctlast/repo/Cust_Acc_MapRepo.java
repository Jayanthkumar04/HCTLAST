package com.jay.hctlast.repo;

import com.jay.hctlast.entity.Cust_Acc_Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Cust_Acc_MapRepo extends JpaRepository<Cust_Acc_Map,Long> {

    ;

    @Query(value = "select * from Cust_Acc_Map cam where cam.cust_id=:id " ,nativeQuery = true)
    Cust_Acc_Map findByCustId(long id);
}
