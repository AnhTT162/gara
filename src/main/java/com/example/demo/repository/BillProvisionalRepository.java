package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.BillProvisional;

public interface BillProvisionalRepository extends JpaRepository<BillProvisional, Long>{
	@Query(value = "SELECT sum(total_money) FROM bill_provisional b "
			+ "WHERE MONTH(b.date_created) = ?1 "
			+ "AND YEAR(b.date_created) = ?2",nativeQuery = true)
	Float findTotalMoneyByMonth(Integer month,Integer year);
	
}
