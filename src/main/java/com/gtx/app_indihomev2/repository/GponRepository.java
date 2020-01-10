package com.gtx.app_indihomev2.repository;

import com.gtx.app_indihomev2.entity.Gpon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GponRepository extends JpaRepository<Gpon, UUID> {
}
