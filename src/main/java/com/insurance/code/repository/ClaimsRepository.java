package com.insurance.code.repository;

import com.insurance.code.model.ClaimsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClaimsRepository extends JpaRepository<ClaimsModel,Integer> {
    Optional<ClaimsModel> findByClaimsId(Integer id);
}
