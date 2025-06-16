
	package com.hulkhire.repository;

	import com.hulkhire.entity.SumEntity;
	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

	@Repository
	public interface SumRepository extends JpaRepository<SumEntity, Long> {
	}


