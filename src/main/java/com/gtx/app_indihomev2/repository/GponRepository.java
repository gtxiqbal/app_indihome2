package com.gtx.app_indihomev2.repository;

import com.gtx.app_indihomev2.entity.Gpon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface GponRepository extends JpaRepository<Gpon, UUID> {
    List<Gpon> findGponByGponIdIn(List<UUID> gponId);
    Gpon getByGponId(UUID gponId);
    Gpon getByHostname(String hostname);
    Gpon getByIp(String ip);
    List<Gpon> findGponByIpIn(List<String> ip);
    void deleteGponByGponIdIn(List<UUID> gponId);
    void deleteGponByIpIn(List<String> ip);
}
