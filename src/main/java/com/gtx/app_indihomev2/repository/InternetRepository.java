package com.gtx.app_indihomev2.repository;

import com.gtx.app_indihomev2.entity.Internet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InternetRepository extends JpaRepository<Internet, UUID> {
}
