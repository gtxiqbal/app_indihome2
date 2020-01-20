package com.gtx.app_indihomev2.service;

import com.gtx.app_indihomev2.entity.Iptv;

import java.util.List;
import java.util.UUID;

public interface IptvService {
    List<Iptv> findByIptvId(UUID iptvId);
    Iptv getByIptvId(UUID iptvId);
    List<Iptv> findByNomor(String nomor);
    Iptv getByNomor(String nomor);
}
