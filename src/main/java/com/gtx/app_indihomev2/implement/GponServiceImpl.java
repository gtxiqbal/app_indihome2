package com.gtx.app_indihomev2.implement;

import com.gtx.app_indihomev2.entity.Gpon;
import com.gtx.app_indihomev2.entity.Pic;
import com.gtx.app_indihomev2.repository.GponRepository;
import com.gtx.app_indihomev2.service.GponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class GponServiceImpl implements GponService {

    @Autowired
    private GponRepository gponRepository;

    @Override
    public List<Gpon> findAll() {
        return gponRepository.findAll();
    }

    @Override
    public Gpon getByHostname(@Validated String hostname) {
        return gponRepository.getByHostname(hostname);
    }

    @Override
    public Gpon getByIp(@Validated String ip) {
        return gponRepository.getByIp(ip);
    }

    @Override
    public List<Gpon> findByGponIp(@Validated String[] ip) {
        return gponRepository.findGponByIpIn(Arrays.asList(ip));
    }

    @Override
    public Gpon getByGponId(@Validated UUID gponId) {
        return gponRepository.getByGponId(gponId);
    }

    @Override
    public List<Gpon> findByGponId(@Validated UUID[] gponId) {
        return gponRepository.findGponByGponIdIn(Arrays.asList(gponId));
    }

    @Transactional
    @Override
    public Gpon create(@Validated Gpon gpon) {
        return gponRepository.save(gpon);
    }

    @Transactional
    @Override
    public List<Gpon> createBatch(@Validated List<Gpon> gpon) {
        return gponRepository.saveAll(gpon);
    }

    @Transactional
    @Override
    public Gpon update(@Validated Gpon gpon) {
        Gpon gponSet = gponRepository.getByGponId(gpon.getGponId());
        gponSet.setHostname(gpon.getHostname());
        gponSet.setIp(gpon.getIp());
        gponSet.setVendor(gpon.getVendor());
        gponSet.setVlan(gpon.getVlan());
        return gponRepository.save(gponSet);
    }

    @Transactional
    @Override
    public List<Gpon> updateBatch(@Validated List<Gpon> gpon) {
        List<Gpon> gg = new ArrayList<>();

        for (Gpon g : gpon) {
            Gpon ggg = gponRepository.getByGponId(g.getGponId());
            ggg.setHostname(g.getHostname());
            ggg.setIp(g.getIp());
            ggg.setVendor(g.getVendor());
            ggg.setVlan(g.getVlan());
            gg.add(ggg);
        }

        return gponRepository.saveAll(gg);
    }

    @Transactional
    @Override
    public void delete(@Validated UUID gponId) {
        gponRepository.deleteById(gponId);
    }

    @Transactional
    @Override
    public void deleteByHostname(@Validated String hostname) {
        Gpon gpon_return = gponRepository.getByHostname(hostname);
        gponRepository.delete(gpon_return);
    }

    @Transactional
    @Override
    public void deleteByIp(@Validated String ip) {
        Gpon gpon_return = gponRepository.getByIp(ip);
        gponRepository.delete(gpon_return);
    }

    @Transactional
    @Override
    public void deleteBatch(@Validated UUID[] gponId) {
        gponRepository.deleteGponByGponIdIn(Arrays.asList(gponId));
    }

    @Transactional
    @Override
    public void deleteBatchIp(@Validated String[] ip) {
        gponRepository.deleteGponByIpIn(Arrays.asList(ip));
    }

    @Transactional
    @Override
    public void deleteAll() {
        gponRepository.deleteAll();
    }
}
