package com.gtx.app_indihomev2.service;

import com.gtx.app_indihomev2.entity.Pelanggan;

import java.util.List;
import java.util.UUID;

public interface PelangganService {
    List<Pelanggan> findAll();
    Pelanggan getByNama(String nama);
    List<Pelanggan> findByNama(String[] nama);
    Pelanggan getBySn(String sn);
    List<Pelanggan> findBySn(String[] sn);
    Pelanggan getByPelangganId(UUID pelangganId);
    List<Pelanggan> findByPelangganId(UUID[] pelangganId);
    List<Pelanggan> findByStatus(String status);

    Pelanggan create(Pelanggan p);
    List<Pelanggan> createBatch(List<Pelanggan> pelanggan);
    Pelanggan update(Pelanggan p);
    List<Pelanggan> updateBatch(List<Pelanggan> pelanggan);

    void delete(UUID pelangganId);
    void deleteByNama(String nama);
    void deleteBySn(String sn);
    void deleteBatch(UUID[] pelangganId);
    void deleteBatchNama(String[] nama);
    void deleteBatchSn(String[] sn);
    void deleteAll();
}
