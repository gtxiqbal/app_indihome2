package com.gtx.app_indihomev2.repository;

import com.gtx.app_indihomev2.entity.Pelanggan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PelangganRepository extends JpaRepository<Pelanggan, UUID> {
    Pelanggan getPelangganByPelangganId(UUID id);
    Pelanggan getPelangganByNama(String nama);
    List<Pelanggan> findPelangganByPicNama(String picNama);
    Pelanggan getPelangganByInternetNomor(String nomor);
    Pelanggan getPelangganByIptvNomor(String nomor);
    Pelanggan getPelangganBySnOnt(String snOnt);
    Pelanggan findPelangganByStatus(String status);
}
