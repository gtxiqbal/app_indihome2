package com.gtx.app_indihomev2.service.implement;

import com.gtx.app_indihomev2.entity.Iptv;
import com.gtx.app_indihomev2.repository.IptvRepository;
import com.gtx.app_indihomev2.service.IptvService;
import com.gtx.app_indihomev2.util.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.UUID;

@Service
public class IptvServiceImpl implements IptvService {

    @Autowired
    private IptvRepository iptvRepository;

    private Check check = new Check();

    @Override
    public List<Iptv> findByIptvId(@Validated UUID iptvId) {
        return null;
    }

    @Override
    public Iptv getByIptvId(@Validated UUID iptvId) {
        return check.getInfiniteIptv(iptvRepository.getIptvByIptvId(iptvId));
    }

    @Override
    public List<Iptv> findByNomor(@Validated String nomor) {
        return null;
    }

    @Override
    public Iptv getByNomor(@Validated String nomor) {
        return check.getInfiniteIptv(iptvRepository.getIptvByNomor(nomor));
    }

    @Override
    public List<Iptv> findByPelangganId(UUID pelangganId) {
        return check.infiniteIptv(iptvRepository.findIptvByPelanggan(pelangganId));
    }

    @Transactional
    @Override
    public void deleteByPelangganId(UUID iptvId) {
        Iptv iptv = iptvRepository.getIptvByIptvId(iptvId);
        iptv.getPelanggan().setIptv(null);
        iptv.setPelanggan(null);
        iptvRepository.deleteById(iptvId);
    }
}
