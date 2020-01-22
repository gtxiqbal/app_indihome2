package com.gtx.app_indihomev2.service.implement;

import com.gtx.app_indihomev2.entity.Internet;
import com.gtx.app_indihomev2.repository.InternetRepository;
import com.gtx.app_indihomev2.service.InternetService;
import com.gtx.app_indihomev2.util.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.UUID;

@Service
public class InternetServiceImpl implements InternetService {

    @Autowired
    private InternetRepository internetRepository;

    @Autowired
    private JdbcTemplate jt;

    private Check check = new Check();

    @Override
    public List<Internet> findAll() {
        return check.infiniteInternet(internetRepository.findAll());
    }

    @Override
    public Internet getByInternetId(@Validated UUID internetId) {
        return check.getInfiniteInternet(internetRepository.getInternetByPelanggan(internetId));
    }

    @Override
    public Internet getByNomor(@Validated String nomor) {
        return check.getInfiniteInternet(internetRepository.getInternetByNomor(nomor));
    }

    @Transactional
    @Override
    public Internet create(Internet internet) {
        return internetRepository.save(internet);
    }

    @Transactional
    @Override
    public Internet update(@Validated UUID internetId, @Validated Internet internet) {
        Internet inet = internetRepository.getInternetByPelanggan(internetId);
        inet.setNomor(internet.getNomor());
        inet.setPassword(internet.getPassword());
        return internetRepository.save(inet);
    }

    @Override
    public void delete(@Validated UUID internetId) {
        jt.update("delete from internet where internet_id = ?", internetId);
    }
}
