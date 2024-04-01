package com.jay.hctlast.repo;

import com.jay.hctlast.entity.Cust_Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Cust_AddressRepo extends JpaRepository<Cust_Address,Long> {


}
