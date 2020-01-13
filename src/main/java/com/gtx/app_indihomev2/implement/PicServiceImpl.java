package com.gtx.app_indihomev2.implement;

import com.gtx.app_indihomev2.entity.Pic;
import com.gtx.app_indihomev2.repository.PicRepository;
import com.gtx.app_indihomev2.service.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class PicServiceImpl implements PicService {

    @Autowired
    PicRepository picRepository;

    @Override
    public List<Pic> findAll() {
        return picRepository.findAll();
    }

    @Override
    public Pic getByPicId(@Validated UUID picId) {
        return picRepository.getByPicId(picId);
    }

    @Override
    public Pic getByNama(@Validated String nama) {
        return picRepository.getByNama(nama);
    }

    @Override
    public Pic createPic(@Validated Pic pic) {
        return picRepository.save(pic);
    }

    @Override
    public List<Pic> createBatch(@Validated List<Pic> pic) {
        return picRepository.saveAll(pic);
    }

    @Override
    public Pic updatePic(@Validated Pic pic) {
        pic.getPicId();
        return picRepository.save(pic);
    }

    @Override
    public void deletePic(@Validated UUID pic_id) {
        picRepository.deleteById(pic_id);
    }

    @Override
    public void deletePicByNama(@Validated String nama) {
        Pic pic_return = picRepository.getByNama(nama);
        picRepository.delete(pic_return);
    }
}
