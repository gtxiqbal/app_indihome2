package com.gtx.app_indihomev2.repository;

import com.gtx.app_indihomev2.entity.IpGpon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IpGponRepository extends JpaRepository<IpGpon, UUID> {
}
