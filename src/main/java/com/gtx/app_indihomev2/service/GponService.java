package com.gtx.app_indihomev2.service;

import com.gtx.app_indihomev2.entity.Gpon;

import java.util.List;
import java.util.UUID;

public interface GponService {
    List<Gpon> findAll();
    Gpon getByHostname(String hostname);
    Gpon getByIp(String ip);
    List<Gpon> findByGponIp(String[] ip);
    Gpon getByGponId(UUID gponId);
    List<Gpon> findByGponId(UUID[] gponId);

    Gpon create(Gpon gpon);
    List<Gpon> createBatch(List<Gpon> gpon);
    Gpon update(Gpon gpon);
    List<Gpon> updateBatch(List<Gpon> gpon);

    void delete(UUID gponId);
    void deleteByHostname(String hostname);
    void deleteByIp(String ip);
    void deleteBatch(UUID[] gponId);
    void deleteBatchIp(String[] ip);
    void deleteAll();
}
