package com.gtx.app_indihomev2.repository;

import com.gtx.app_indihomev2.entity.Pelanggan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PelangganRepository extends JpaRepository<Pelanggan, UUID> {
    List<Pelanggan> findByPelangganId(UUID id);
    List<Pelanggan> findByNama(String nama);
    List<Pelanggan> findByPicIdNama(String picNama);
    List<Pelanggan> findByInternetIdNomor(String nomor);
    List<Pelanggan> findByIptvIdNomor(String nomor);
    List<Pelanggan> findBySnOnt(String snOnt);
    List<Pelanggan> findByStatus(String status);
}
