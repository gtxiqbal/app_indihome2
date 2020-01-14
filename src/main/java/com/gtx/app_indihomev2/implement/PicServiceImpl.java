package com.gtx.app_indihomev2.implement;

import com.gtx.app_indihomev2.entity.Pic;
import com.gtx.app_indihomev2.repository.PicRepository;
import com.gtx.app_indihomev2.service.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.lang.reflect.Array;
import java.util.*;

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
    public List<Pic> findByPicId(@Validated List picId) {
        List<Pic> pp = new ArrayList<>();
        for (Object p : picId) {
            pp.add((Pic) picRepository.findPicByPicId((UUID) p));
        }
        return pp;
    }

    @Override
    public Pic getByNama(@Validated String nama) {
        return picRepository.getByNama(nama);
    }

    @Override
    @Transactional
    public Pic create(@Validated Pic pic) {
        return picRepository.save(pic);
    }

    @Override
    @Transactional
    public List<Pic> createBatch(@Validated List<Pic> pic) {
        return picRepository.saveAll(pic);
    }

    @Override
    @Transactional
    public Pic update(@Validated Pic pic) {
        Pic picSet = picRepository.getByPicId(pic.getPicId());
        picSet.setNama(pic.getNama());
        return picRepository.save(picSet);
    }

    @Override
    @Transactional
    public List<Pic> updateBatch(List<Pic> pic) {
        List<Pic> pp = new ArrayList<>();

        for (Pic p : pic) {
            Pic ppp = picRepository.getByPicId(p.getPicId());
            ppp.setNama(p.getNama());
            pp.add(ppp);
        }

        return picRepository.saveAll(pp);
    }

    @Override
    @Transactional
    public void delete(@Validated UUID pic_id) {
        picRepository.deleteById(pic_id);
    }

    @Override
    @Transactional
    public void deleteByNama(@Validated String nama) {
        Pic pic_return = picRepository.getByNama(nama);
        picRepository.delete(pic_return);
    }

    @Override
    @Transactional
    public void deleteBatch(@Validated List pic_id) {
        picRepository.deleteInBatch(pic_id);
    }
}
