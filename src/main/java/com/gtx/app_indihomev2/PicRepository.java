package com.gtx.app_indihomev2;

import com.gtx.app_indihomev2.entity.Pic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PicRepository extends JpaRepository<Pic, String> {
    List<Pic> findByPicId(String id);
    List<Pic> findByNama(String nama);
}
