package com.gtx.app_indihomev2.repository;

import com.gtx.app_indihomev2.entity.Internet;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface InternetRepository extends JpaRepository<Internet, UUID> {
    List<Internet> findInternetByPelangganIn(UUID[] internetId);
    Internet getInternetByPelanggan(UUID internetId);
    List<Internet> findInternetByNomorIn(String[] nomor);
    Internet getInternetByNomor(String nomor);

}
