package com.gtx.app_indihomev2.service;

import com.gtx.app_indihomev2.entity.Iptv;

import java.util.List;
import java.util.UUID;

public interface IptvService {
    List<Iptv> findAll();
    List<Iptv> findByNomor(String nomor);
    Iptv getByIptvId(UUID iptvId);
    Iptv getByNomor(String nomor);
    List<Iptv> findByPelangganId(UUID pelangganId);
    Iptv create(Iptv iptv);
    Iptv update(UUID iptvId, Iptv iptv);
    void deleteByIptvId(UUID pelangganId);
    void deleteAll();
}
