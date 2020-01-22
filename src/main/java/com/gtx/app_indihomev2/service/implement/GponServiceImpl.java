package com.gtx.app_indihomev2.service.implement;

import com.gtx.app_indihomev2.entity.Gpon;
import com.gtx.app_indihomev2.entity.Pelanggan;
import com.gtx.app_indihomev2.repository.GponRepository;
import com.gtx.app_indihomev2.service.GponService;
import com.gtx.app_indihomev2.util.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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

    @Autowired
    private JdbcTemplate jt;

    private Check check = new Check();

    @Override
    public List<Gpon> findAll() {
        return check.infiniteGpon(gponRepository.findAll());
    }

    @Override
    public Gpon getByHostname(@Validated String hostname) {
        return check.getInfiniteGpon(gponRepository.getByHostname(hostname));
    }

    @Override
    public Gpon getByIp(@Validated String ip) {
        return check.getInfiniteGpon(gponRepository.getByIp(ip));
    }

    @Override
    public List<Gpon> findByGponIp(@Validated String[] ip) {
        return check.infiniteGpon(gponRepository.findGponByIpIn(Arrays.asList(ip)));
    }

    @Override
    public Gpon getByGponId(@Validated UUID gponId) {
        return check.getInfiniteGpon(gponRepository.getByGponId(gponId));
    }

    @Override
    public List<Gpon> findByGponId(@Validated UUID[] gponId) {
        return check.infiniteGpon(gponRepository.findGponByGponIdIn(Arrays.asList(gponId)));
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

    @Override
    public void delete(@Validated UUID gponId) {
        Gpon g = gponRepository.getByGponId(gponId);
        if (g.getPelanggan().size() > 0) {
            for (Pelanggan p : g.getPelanggan()) {
                if (p.getInternet() != null)
                    jt.update("delete from internet where pelanggan_id = ?", p.getPelangganId());

                if (p.getIptv().size() > 0)
                    jt.update("delete from iptv where pelanggan_id = ?", p.getPelangganId());
            }
            jt.update("delete from pelanggan where gpon_id = ?", g.getGponId());
        }
        //jt.update("delete from gpon where gpon_id = ?", g.getGponId());
        gponRepository.deleteById(g.getGponId());
    }

    @Override
    public void deleteByHostname(@Validated String hostname) {
        Gpon g = gponRepository.getByHostname(hostname);
        if (g.getPelanggan().size() > 0) {
            for (Pelanggan p : g.getPelanggan()) {
                if (p.getInternet() != null)
                    jt.update("delete from internet where pelanggan_id = ?", p.getPelangganId());

                if (p.getIptv().size() > 0)
                    jt.update("delete from iptv where pelanggan_id = ?", p.getPelangganId());
            }
            jt.update("delete from pelanggan where gpon_id = ?", g.getGponId());
        }
        //jt.update("delete from gpon where gpon_id = ?", g.getGponId());
        gponRepository.deleteById(g.getGponId());
    }

    @Override
    public void deleteByIp(@Validated String ip) {
        Gpon g = gponRepository.getByIp(ip);
        if (g.getPelanggan().size() > 0) {
            for (Pelanggan p : g.getPelanggan()) {
                if (p.getInternet() != null)
                    jt.update("delete from internet where pelanggan_id = ?", p.getPelangganId());

                if (p.getIptv().size() > 0)
                    jt.update("delete from iptv where pelanggan_id = ?", p.getPelangganId());
            }
            jt.update("delete from pelanggan where gpon_id = ?", g.getGponId());
        }
        //jt.update("delete from gpon where gpon_id = ?", g.getGponId());
        gponRepository.deleteById(g.getGponId());
    }

    @Override
    public void deleteBatch(@Validated UUID[] gponId) {
        gponRepository.deleteGponByGponIdIn(Arrays.asList(gponId));
    }

    @Override
    public void deleteBatchIp(@Validated String[] ip) {
        gponRepository.deleteGponByIpIn(Arrays.asList(ip));
    }

    @Override
    public void deleteAll() {
        List<Gpon> g = gponRepository.findAll();
        for (Gpon gpon : g) {
            if (gpon.getPelanggan().size() > 0) {
                for (Pelanggan p : gpon.getPelanggan()) {
                    if (p.getInternet() != null)
                        jt.update("delete from internet where pelanggan_id = ?", p.getPelangganId());

                    if (p.getIptv().size() > 0)
                        jt.update("delete from iptv where pelanggan_id = ?", p.getPelangganId());
                }
            }
        }
    }
}
