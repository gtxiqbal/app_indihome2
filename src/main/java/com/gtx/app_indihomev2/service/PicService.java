package com.gtx.app_indihomev2.service;

import com.gtx.app_indihomev2.entity.Pic;

import java.util.List;
import java.util.UUID;

public interface PicService {
    List<Pic> findAll();
    Pic getByNama(String nama);
    Pic getByPicId(UUID picId);
    Pic createPic(Pic pic);
    List<Pic> createBatch(List<Pic> pic);
    Pic update(Pic pic);
    List<Pic> updateBatch(List<Pic> pic);
    void deletePic(UUID pic_id);
    void deletePicByNama(String nama);
}
