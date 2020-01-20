package com.gtx.app_indihomev2.implement;

import com.gtx.app_indihomev2.entity.Iptv;
import com.gtx.app_indihomev2.repository.IptvRepository;
import com.gtx.app_indihomev2.service.IptvService;
import com.gtx.app_indihomev2.util.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        return null;
    }

    @Override
    public List<Iptv> findByNomor(@Validated String nomor) {
        return null;
    }

    @Override
    public Iptv getByNomor(@Validated String nomor) {
        return check.getInfiniteIptv(iptvRepository.getIptvByNomor(nomor));
    }
}
