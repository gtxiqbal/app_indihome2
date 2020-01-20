package com.gtx.app_indihomev2.repository;

import com.gtx.app_indihomev2.entity.Iptv;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface IptvRepository extends JpaRepository<Iptv, UUID> {
    List<Iptv> findIptvByIptvId(UUID iptvId);
    Iptv getIptvByIptvId(UUID iptvId);
    List<Iptv> findAllByNomor(String nomor);
    Iptv getIptvByNomor(String nomor);
}
