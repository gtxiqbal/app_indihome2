package com.gtx.app_indihomev2.repository;

import com.gtx.app_indihomev2.entity.Iptv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface IptvRepository extends JpaRepository<Iptv, UUID> {
    List<Iptv> findIptvByIptvId(UUID iptvId);
    Iptv getIptvByIptvId(UUID iptvId);
    List<Iptv> findIptvByNomor(String nomor);
    Iptv getIptvByNomor(String nomor);
    List<Iptv> findIptvByPelanggan(UUID pelangganId);
}
