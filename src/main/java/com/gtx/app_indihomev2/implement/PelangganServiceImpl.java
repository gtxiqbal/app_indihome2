package com.gtx.app_indihomev2.implement;

import com.gtx.app_indihomev2.entity.Internet;
import com.gtx.app_indihomev2.entity.Iptv;
import com.gtx.app_indihomev2.entity.Pelanggan;
import com.gtx.app_indihomev2.repository.PelangganRepository;
import com.gtx.app_indihomev2.service.PelangganService;
import com.gtx.app_indihomev2.util.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class PelangganServiceImpl implements PelangganService {

    @Autowired
    private PelangganRepository pelangganRepository;

    private Check check = new Check();

    @Override
    public List<Pelanggan> findAll() {
        return check.infinitePelanggan(pelangganRepository.findAll());
    }

    @Override
    public Pelanggan getByNama(@Validated String nama) {
        return check.getInfinitePelanggan(pelangganRepository.getPelangganByNama(nama));
    }

    @Override
    public Pelanggan getBySn(@Validated String sn) {
        return check.getInfinitePelanggan(pelangganRepository.getPelangganBySnOnt(sn));
    }

    @Override
    public List<Pelanggan> findBySn(@Validated String[] sn) {
        return check.infinitePelanggan(pelangganRepository.findPelangganBySnOntIn(Arrays.asList(sn)));
    }

    @Override
    public List<Pelanggan> findByNama(@Validated String[] nama) {
        return check.infinitePelanggan(pelangganRepository.findPelangganByNamaIn(Arrays.asList(nama)));
    }

    @Override
    public Pelanggan getByPelangganId(@Validated UUID pelangganId) {
        return check.getInfinitePelanggan(pelangganRepository.getPelangganByPelangganId(pelangganId));
    }

    @Override
    public List<Pelanggan> findByPelangganId(@Validated UUID[] pelangganId) {
        return check.infinitePelanggan(pelangganRepository.findPelangganByPelangganIdIn(Arrays.asList(pelangganId)));
    }

    @Override
    public List<Pelanggan> findByStatus(@Validated String status) {
        return check.infinitePelanggan(pelangganRepository.findPelangganByStatus(status));
    }

    @Transactional
    @Override
    public Pelanggan create(@Validated Pelanggan p) {
        Pelanggan pelanggan = new Pelanggan(
                p.getNama(),
                p.getPaket(),
                p.getHarga(),
                p.getStatus(),
                p.getPic(),
                p.getGpon(),
                p.getSlotPort(),
                p.getOnuId(),
                p.getSnOnt()
        );

        if (p.getInternet() != null) {
            Internet internet = new Internet(
                    p.getInternet().getNomor(),
                    p.getInternet().getPassword()
            );
            internet.setPelanggan(pelanggan);
            pelanggan.setInternet(internet);
        }

        if (p.getIptv() != null) {
            List<Iptv> tvList = new ArrayList<>();
            for (Iptv iptv : p.getIptv()) {
                Iptv tv = new Iptv(
                        iptv.getNomor(),
                        iptv.getPassword()
                );
                tv.setPelanggan(pelanggan);
                tvList.add(tv);
            }
            pelanggan.setIptv(tvList);
        }

        return pelangganRepository.save(pelanggan);
    }

    @Transactional
    @Override
    public List<Pelanggan> createBatch(@Validated List<Pelanggan> pelanggan) {
        return pelangganRepository.saveAll(pelanggan);
    }

    @Transactional
    @Override
    public Pelanggan update(@Validated Pelanggan p) {
        Pelanggan pelSet = pelangganRepository.getPelangganByPelangganId(p.getPelangganId());
        pelSet.setNama(p.getNama());
        pelSet.setSlotPort(p.getSlotPort());
        pelSet.setOnuId(p.getOnuId());
        pelSet.setSnOnt(p.getSnOnt());
        pelSet.setPaket(p.getPaket());
        pelSet.setHarga(p.getHarga());
        pelSet.setStatus(p.getStatus());
        return pelangganRepository.save(pelSet);
    }

    @Transactional
    @Override
    public List<Pelanggan> updateBatch(@Validated List<Pelanggan> pelanggan) {
        List<Pelanggan> pp = new ArrayList<>();

        for (Pelanggan p : pelanggan) {
            Pelanggan ppp = pelangganRepository.getPelangganByPelangganId(p.getPelangganId());
            ppp.setNama(p.getNama());
            ppp.setSlotPort(p.getSlotPort());
            ppp.setOnuId(p.getOnuId());
            ppp.setSnOnt(p.getSnOnt());
            ppp.setPaket(p.getPaket());
            ppp.setHarga(p.getHarga());
            ppp.setStatus(p.getStatus());
            pp.add(ppp);
        }
        return pelangganRepository.saveAll(pp);
    }

    @Transactional
    @Override
    public void delete(@Validated UUID pelangganId) {
        /*Pelanggan p = pelangganRepository.getPelangganByPelangganId(pelangganId);
        p.setGpon(null);
        p.setPic(null);
        if (p.getInternet() != null && p.getIptv().size() < 0) {
            p.setInternet(null);
        } else if (p.getInternet() != null && p.getIptv().size() > 0) {
            p.setInternet(null);
            p.setIptv(null);
        }
        pelangganRepository.delete(p);*/
        pelangganRepository.deleteById(pelangganId);
    }

    @Transactional
    @Override
    public void deleteByNama(@Validated String nama) {
        Pelanggan p = pelangganRepository.getPelangganByNama(nama);
        pelangganRepository.delete(p);
    }

    @Transactional
    @Override
    public void deleteBySn(@Validated String sn) {
        Pelanggan p = pelangganRepository.getPelangganBySnOnt(sn);
        pelangganRepository.delete(p);
    }

    @Transactional
    @Override
    public void deleteBatch(@Validated UUID[] pelangganId) {
        pelangganRepository.deletePelangganByPelangganIdIn(Arrays.asList(pelangganId));
    }

    @Override
    public void deleteBatchNama(String[] nama) {
        pelangganRepository.deletePelangganByNamaIn(Arrays.asList(nama));
    }

    @Transactional
    @Override
    public void deleteBatchSn(@Validated String[] sn) {
        pelangganRepository.deletePelangganBySnOntIn(Arrays.asList(sn));
    }

    @Transactional
    @Override
    public void deleteAll() {
        pelangganRepository.deleteAll();
    }
}
