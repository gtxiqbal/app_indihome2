package com.gtx.app_indihomev2.repository;

import com.gtx.app_indihomev2.entity.Iptv;
import com.gtx.app_indihomev2.entity.Pelanggan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PelangganRepository extends JpaRepository<Pelanggan, UUID> {
    Pelanggan getPelangganByPelangganId(UUID id);
    Pelanggan getPelangganByNama(String nama);
    List<Pelanggan> findPelangganByPic_Nama(String picNama);
    Pelanggan getPelangganByInternet_Nomor(String nomor);
    Pelanggan getPelangganByIptvBy_Nomor(String nomor);
    Pelanggan getPelangganBySnOnt(String snOnt);
    Pelanggan findPelangganByStatus(String status);
}
