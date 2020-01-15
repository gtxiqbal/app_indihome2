package com.gtx.app_indihomev2.implement;

import com.gtx.app_indihomev2.entity.Pelanggan;
import com.gtx.app_indihomev2.repository.PelangganRepository;
import com.gtx.app_indihomev2.service.PelangganService;
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

    @Override
    public List<Pelanggan> findAll() {
        return pelangganRepository.findAll();
    }

    @Override
    public Pelanggan getByNama(@Validated String nama) {
        return pelangganRepository.getPelangganByNama(nama);
    }

    @Override
    public Pelanggan getBySn(@Validated String sn) {
        return pelangganRepository.getPelangganBySnOnt(sn);
    }

    @Override
    public List<Pelanggan> findBySn(@Validated String[] sn) {
        return pelangganRepository.findPelangganBySnOntIn(Arrays.asList(sn));
    }

    @Override
    public List<Pelanggan> findByNama(@Validated String[] nama) {
        return pelangganRepository.findPelangganByNamaIn(Arrays.asList(nama));
    }

    @Override
    public Pelanggan getByPelangganId(@Validated UUID pelangganId) {
        return pelangganRepository.getPelangganByPelangganId(pelangganId);
    }

    @Override
    public List<Pelanggan> findByPelangganId(@Validated UUID[] pelangganId) {
        return pelangganRepository.findPelangganByPelangganIdIn(Arrays.asList(pelangganId));
    }

    @Override
    public List<Pelanggan> findByStatus(@Validated String status) {
        return pelangganRepository.findPelangganByStatus(status);
    }

    @Transactional
    @Override
    public Pelanggan create(@Validated Pelanggan pelanggan) {
        return pelangganRepository.save(pelanggan);
    }

    @Transactional
    @Override
    public List<Pelanggan> createBatch(@Validated List<Pelanggan> pelanggan) {
        return pelangganRepository.saveAll(pelanggan);
    }

    @Transactional
    @Override
    public Pelanggan update(@Validated Pelanggan pelanggan) {
        Pelanggan pelSet = pelangganRepository.getPelangganByPelangganId(pelanggan.getPelangganId());
        pelSet.setNama(pelanggan.getNama());
        pelSet.setSlotPort(pelanggan.getSlotPort());
        pelSet.setOnuId(pelanggan.getOnuId());
        pelSet.setSnOnt(pelanggan.getSnOnt());
        pelSet.setPaket(pelanggan.getPaket());
        pelSet.setHarga(pelanggan.getHarga());
        pelSet.setStatus(pelanggan.getStatus());
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
