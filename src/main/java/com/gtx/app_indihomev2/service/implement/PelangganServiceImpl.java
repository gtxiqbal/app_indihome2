package com.gtx.app_indihomev2.service.implement;

import com.gtx.app_indihomev2.entity.Internet;
import com.gtx.app_indihomev2.entity.Iptv;
import com.gtx.app_indihomev2.entity.Pelanggan;
import com.gtx.app_indihomev2.repository.*;
import com.gtx.app_indihomev2.service.PelangganService;
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
public class PelangganServiceImpl implements PelangganService {

    @Autowired
    private PelangganRepository pelangganRepository;

    @Autowired
    private InternetRepository internetRepository;

    @Autowired
    private IptvRepository iptvRepository;

    @Autowired
    private JdbcTemplate jt;

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
    public Pelanggan update(@Validated UUID pelangganId, @Validated Pelanggan p) {
        Pelanggan pelanggan = pelangganRepository.getPelangganByPelangganId(pelangganId);
        pelanggan.setNama(p.getNama());
        pelanggan.setSlotPort(p.getSlotPort());
        pelanggan.setOnuId(p.getOnuId());
        pelanggan.setSnOnt(p.getSnOnt());
        pelanggan.setPaket(p.getPaket());
        pelanggan.setHarga(p.getHarga());
        pelanggan.setStatus(p.getStatus());

        if (p.getGpon() != null) {
            pelanggan.setGpon(p.getGpon());
        }

        if (p.getPic() != null) {
            pelanggan.setPic(p.getPic());
        }

        if (pelanggan.getInternet() == null && p.getInternet() != null) {
            Internet internet = new Internet(
                    p.getInternet().getNomor(),
                    p.getInternet().getPassword()
            );
            internet.setPelanggan(pelanggan);
            pelanggan.setInternet(internet);
        } else if (pelanggan.getInternet() != null && p.getInternet() != null) {
            pelanggan.getInternet().setNomor(p.getInternet().getNomor());
            pelanggan.getInternet().setPassword(p.getInternet().getPassword());
        }

        List<Iptv> tvList = new ArrayList<>();
        if (pelanggan.getIptv().size() == 0 && p.getIptv() != null) {
            for (Iptv iptv : p.getIptv()) {
                Iptv tv = new Iptv(
                        iptv.getNomor(),
                        iptv.getPassword(),
                        pelanggan
                );
                tvList.add(tv);
            }
            iptvRepository.saveAll(tvList);
        } else if (pelanggan.getIptv().size() > 0 && p.getIptv() != null) {
            for (Iptv iptv : p.getIptv()) {
                List<Iptv> iptvs = iptvRepository.findIptvByIptvId(iptv.getIptvId());
                for (Iptv iptv1 : iptvs) {
                    iptv1.setNomor(iptv.getNomor());
                    iptv1.setPassword(iptv.getPassword());
                    iptvRepository.save(iptv1);
                }
            }
        }

        return pelangganRepository.save(pelanggan);
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

    private void deleteChildPelanggan(List<Pelanggan> pelanggan) {
        for (Pelanggan p : pelanggan) {
            if (p.getInternet() != null) {
                jt.update("delete from internet where pelanggan_id = ?", p.getPelangganId());
            }

            if (p.getIptv().size() > 0) {
                jt.update("delete from iptv where pelanggan_id = ?", p.getPelangganId());
            }

            jt.update("delete from pelanggan where pelanggan_id = ?", p.getPelangganId());
        }
    }

    @Override
    public void delete(@Validated UUID pelangganId) {
        Pelanggan p = pelangganRepository.getPelangganByPelangganId(pelangganId);
        if (p.getInternet() != null) {
            jt.update("delete from internet where pelanggan_id = ?", p.getPelangganId());
        }

        if (p.getIptv().size() > 0) {
            jt.update("delete from iptv where pelanggan_id = ?", p.getPelangganId());
        }

        jt.update("delete from pelanggan where pelanggan_id = ?", p.getPelangganId());
    }

    @Override
    public void deleteByNama(@Validated String nama) {
        Pelanggan p = pelangganRepository.getPelangganByNama(nama);
        if (p.getInternet() != null) {
            jt.update("delete from internet where pelanggan_id = ?", p.getPelangganId());
        }

        if (p.getIptv().size() > 0) {
            jt.update("delete from iptv where pelanggan_id = ?", p.getPelangganId());
        }

        jt.update("delete from pelanggan where pelanggan_id = ?", p.getPelangganId());
    }

    @Override
    public void deleteBySn(@Validated String sn) {
        Pelanggan p = pelangganRepository.getPelangganBySnOnt(sn);
        if (p.getInternet() != null) {
            jt.update("delete from internet where pelanggan_id = ?", p.getPelangganId());
        }

        if (p.getIptv().size() > 0) {
            jt.update("delete from iptv where pelanggan_id = ?", p.getPelangganId());
        }

        jt.update("delete from pelanggan where pelanggan_id = ?", p.getPelangganId());
    }

    @Override
    public void deleteBatch(@Validated UUID[] pelangganId) {
        List<Pelanggan> pelanggan = pelangganRepository.findPelangganByPelangganIdIn(Arrays.asList(pelangganId));

        deleteChildPelanggan(pelanggan);
    }

    @Override
    public void deleteBatchNama(String[] nama) {
        List<Pelanggan> pelanggan = pelangganRepository.findPelangganByNamaIn(Arrays.asList(nama));

        deleteChildPelanggan(pelanggan);
    }

    @Override
    public void deleteBatchSn(@Validated String[] sn) {
        List<Pelanggan> pelanggan = pelangganRepository.findPelangganBySnOntIn(Arrays.asList(sn));

        deleteChildPelanggan(pelanggan);
    }

    @Override
    public void deleteAll() {
        if (internetRepository.count() > 0) {
            jt.update("delete from internet");
        }

        if (iptvRepository.count() > 0) {
            jt.update("delete from iptv");
        }

        jt.update("delete from pelanggan");
    }
}
