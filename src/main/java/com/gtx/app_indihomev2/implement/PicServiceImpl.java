package com.gtx.app_indihomev2.implement;

import com.gtx.app_indihomev2.entity.Pic;
import com.gtx.app_indihomev2.repository.PicRepository;
import com.gtx.app_indihomev2.service.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    public Pic update(@Validated Pic pic) {
        Pic picSet = picRepository.getByPicId(pic.getPicId());
        picSet.setNama(pic.getNama());
        return picRepository.save(picSet);
    }

    @Override
    public List<Pic> updateBatch(List<Pic> pic) {
        List<Pic> pp = new List<Pic>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Pic> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] ts) {
                return null;
            }

            @Override
            public boolean add(Pic pic) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Pic> collection) {
                return false;
            }

            @Override
            public boolean addAll(int i, Collection<? extends Pic> collection) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> collection) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Pic get(int i) {
                return null;
            }

            @Override
            public Pic set(int i, Pic pic) {
                return null;
            }

            @Override
            public void add(int i, Pic pic) {

            }

            @Override
            public Pic remove(int i) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Pic> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Pic> listIterator(int i) {
                return null;
            }

            @Override
            public List<Pic> subList(int i, int i1) {
                return null;
            }
        }
        for (Pic p : pic) {

        }
        Pic picSet = picRepository.getByPicId(pic.getPicId());
        picSet.setNama(pic.getNama());
        return picRepository.saveAll(pic);
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
