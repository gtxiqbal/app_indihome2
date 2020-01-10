package com.gtx.app_indihomev2.service;

import com.gtx.app_indihomev2.entity.Pic;

import java.util.List;
import java.util.UUID;

public interface PicService {
    List<Pic> findAll();
    Pic getByNama(String nama);
    Pic getByPicId(UUID picId);
    Pic createPic(Pic pic);
}
