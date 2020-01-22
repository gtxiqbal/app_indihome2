package com.gtx.app_indihomev2.service.implement;

import com.gtx.app_indihomev2.entity.Iptv;
import com.gtx.app_indihomev2.repository.IptvRepository;
import com.gtx.app_indihomev2.service.IptvService;
import com.gtx.app_indihomev2.util.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.UUID;

@Service
public class IptvServiceImpl implements IptvService {

    @Autowired
    private IptvRepository iptvRepository;

    @Autowired
    private JdbcTemplate jt;

    private Check check = new Check();

    @Override
    public List<Iptv> findAll() {
        return check.infiniteIptv(iptvRepository.findAll());
    }

    @Override
    public Iptv getByIptvId(@Validated UUID iptvId) {
        return check.getInfiniteIptv(iptvRepository.getIptvByIptvId(iptvId));
    }

    @Override
    public List<Iptv> findByNomor(@Validated String nomor) {
        return check.infiniteIptv(iptvRepository.findIptvByNomorLike(nomor));
    }

    @Override
    public Iptv getByNomor(@Validated String nomor) {
        return check.getInfiniteIptv(iptvRepository.getIptvByNomor(nomor));
    }

    @Override
    public List<Iptv> findByPelangganId(@Validated UUID pelangganId) {
        return check.infiniteIptv(iptvRepository.findIptvByPelanggan(pelangganId));
    }

    @Transactional
    @Override
    public Iptv create(@Validated Iptv iptv) {
        return iptvRepository.save(iptv);
    }

    @Transactional
    @Override
    public Iptv update(@Validated UUID iptvId, @Validated Iptv iptv) {
        Iptv tv = iptvRepository.getIptvByIptvId(iptvId);
        tv.setNomor(iptv.getNomor());
        tv.setPassword(iptv.getPassword());
        tv.setPelanggan(iptv.getPelanggan());
        return iptvRepository.save(tv);
    }

    @Override
    public void deleteByIptvId(@Validated UUID iptvId) {
        Iptv iptv = iptvRepository.getIptvByIptvId(iptvId);
        if (iptv.getPelanggan() == null) {
            jt.update("delete from iptv where iptv_id = ?", iptvId);
        }
    }

    @Override
    public void deleteAll() {
        jt.update("delete from iptv where");
    }
}
