package com.gtx.app_indihomev2.implement;

import com.gtx.app_indihomev2.entity.Pic;
import com.gtx.app_indihomev2.repository.PicRepository;
import com.gtx.app_indihomev2.service.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Pic getByPicId(UUID picId) {
        return picRepository.getByPicId(picId);
    }

    @Override
    public Pic getByNama(String nama) {
        return picRepository.getByNama(nama);
    }

    @Override
    public Pic createPic(Pic pic) {
        return picRepository.save(pic);
    }
}
