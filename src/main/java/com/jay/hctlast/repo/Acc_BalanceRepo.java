package com.jay.hctlast.repo;

import com.jay.hctlast.entity.Acc_Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Acc_BalanceRepo extends JpaRepository<Acc_Balance,Long> {


}
