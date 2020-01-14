package com.gtx.app_indihomev2.repository;

import com.gtx.app_indihomev2.entity.Pic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PicRepository extends JpaRepository<Pic, UUID> {
    List<Pic> findPicByPicIdIn(List<UUID> picId);
    Pic getByPicId(UUID picId);
    Pic getByNama(String nama);
    void deletePicByPicIdIn(List<UUID> picId);
}
