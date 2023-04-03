package com.insurance.code.services;

import com.insurance.code.dto.ClaimsDTO;
import com.insurance.code.model.ClaimsModel;

import java.util.List;
import java.util.Optional;

public interface IClaimsService {
    List<ClaimsModel> getAllClaims();

    Optional<ClaimsModel> getClaimsById(Integer id);
    ClaimsModel createClaims(ClaimsDTO claimsDTO);
    ClaimsModel updateClaimsById(Integer id,ClaimsDTO claimsDTO);
    Optional<ClaimsModel> deleteClaimsById(Integer id);
}
