package com.gtx.app_indihomev2.service;

import com.gtx.app_indihomev2.entity.Pic;

import java.util.List;

public interface PicService {
    List<Pic> findAll();
    List<Pic> findPicByNama(String nama);
}
