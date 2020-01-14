package com.gtx.app_indihomev2.service;

import com.gtx.app_indihomev2.entity.Pic;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface PicService {
    List<Pic> findAll();
    Pic getByNama(String nama);
    Pic getByPicId(UUID picId);
    List<Pic> findByPicId(List picId);
    Pic create(Pic pic);
    List<Pic> createBatch(List<Pic> pic);
    Pic update(Pic pic);
    List<Pic> updateBatch(List<Pic> pic);
    void delete(UUID pic_id);
    void deleteByNama(String nama);
    void deleteBatch(List pic_id);
}
