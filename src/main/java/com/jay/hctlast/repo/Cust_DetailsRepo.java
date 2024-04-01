package com.jay.hctlast.repo;

import com.jay.hctlast.entity.Cust_Details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Cust_DetailsRepo extends JpaRepository<Cust_Details,Long> {


}
