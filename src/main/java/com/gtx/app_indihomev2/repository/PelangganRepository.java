package com.gtx.app_indihomev2.repository;

import com.gtx.app_indihomev2.entity.Pelanggan;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PelangganRepository extends JpaRepository<Pelanggan, UUID> {
    Pelanggan getPelangganByPelangganId(UUID id);
    List<Pelanggan> findPelangganByPelangganIdIn(List<UUID> pelangganId);
    Pelanggan getPelangganByNama(String nama);
    List<Pelanggan> findPelangganByNamaIn(List<String> nama);
    List<Pelanggan> findPelangganByPicNama(String picNama);
    Pelanggan getPelangganByInternetNomor(String nomor);
    Pelanggan getPelangganByIptvNomor(String nomor);
    Pelanggan getPelangganBySnOnt(String snOnt);
    List<Pelanggan> findPelangganBySnOntIn(List<String> sn);
    List<Pelanggan> findPelangganByStatus(String status);
}
