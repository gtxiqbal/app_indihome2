package com.gtx.app_indihomev2.service;

import com.gtx.app_indihomev2.entity.Internet;

import java.util.List;
import java.util.UUID;

public interface InternetService {
    List<Internet> findAll();
    Internet getByInternetId(UUID internetId);
    Internet getByNomor(String nomor);
    Internet create(Internet internet);
    Internet update(UUID internetId, Internet internet);
    void delete(UUID internetId);
}
