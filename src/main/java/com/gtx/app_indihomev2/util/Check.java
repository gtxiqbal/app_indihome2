package com.gtx.app_indihomev2.util;

import com.gtx.app_indihomev2.entity.*;

import java.util.List;

public class Check {

    public List<Gpon> infiniteGpon(List<Gpon> repoGpon) {
        if (repoGpon.size() > 0) {
            for (Gpon g : repoGpon) {
                if (g.getPelanggan().size() > 0) {
                    for (Pelanggan p : g.getPelanggan()) {
                        p.setGpon(null);
                        p.getPic().setPelanggan(null);
                        if (p.getInternet() != null) p.getInternet().setPelanggan(null);
                        if (p.getIptv() != null) {
                            for (Iptv iptv : p.getIptv()) {
                                iptv.setPelanggan(null);
                            }
                        }
                    }
                }
            }
        }
        return repoGpon;
    }

    public Gpon getInfiniteGpon(Gpon repoGpon) {
        if (repoGpon != null) {
            List<Pelanggan> pelanggan = repoGpon.getPelanggan();
            for (Pelanggan p : pelanggan) {
                p.setGpon(null);
                p.getPic().setPelanggan(null);
                if (p.getInternet() != null) p.getInternet().setPelanggan(null);
                if (p.getIptv().size() > 0) {
                    for (Iptv iptv : p.getIptv()) {
                        iptv.setPelanggan(null);
                    }
                }
            }
        }
        return repoGpon;
    }

    public List<Pic> infinitePic(List<Pic> repoPic) {
        if (repoPic.size() > 0) {
            for (Pic pc : repoPic) {
                if (pc.getPelanggan().size() > 0) {
                    for (Pelanggan p : pc.getPelanggan()) {
                        p.setPic(null);
                        p.getGpon().setPelanggan(null);
                        if (p.getInternet() != null) p.getInternet().setPelanggan(null);
                        if (p.getIptv().size() > 0) {
                            for (Iptv iptv : p.getIptv()) {
                                iptv.setPelanggan(null);
                            }
                        }
                    }
                }
            }
        }
        return repoPic;
    }

    public Pic getInfinitePic(Pic repoPic) {
        if (repoPic != null) {
            List<Pelanggan> pelanggan = repoPic.getPelanggan();
            if (pelanggan.size() > 0 ) {
                for (Pelanggan p : pelanggan) {
                    p.setPic(null);
                    p.getGpon().setPelanggan(null);
                    if (p.getInternet() != null) p.getInternet().setPelanggan(null);
                    if (p.getIptv().size() > 0) {
                        for (Iptv tv : p.getIptv()) {
                            tv.setPelanggan(null);
                        }
                    }
                }
            }
        }
        return repoPic;
    }

    public List<Pelanggan> infinitePelanggan(List<Pelanggan> repoPelanggan) {
        if (repoPelanggan.size() > 0) {
            for (Pelanggan p : repoPelanggan) {
                p.getGpon().setPelanggan(null);
                p.getPic().setPelanggan(null);
                if (p.getInternet() != null) p.getInternet().setPelanggan(null);
                if (p.getIptv().size() > 0) {
                    for (Iptv iptv : p.getIptv()) {
                        iptv.setPelanggan(null);
                    }
                }
            }
        }
        return repoPelanggan;
    }

    public Pelanggan getInfinitePelanggan(Pelanggan repoPelanggan) {
        if (repoPelanggan != null) {
            repoPelanggan.getGpon().setPelanggan(null);
            repoPelanggan.getPic().setPelanggan(null);
            if (repoPelanggan.getInternet() != null && repoPelanggan.getIptv() == null) {
                repoPelanggan.getInternet().setPelanggan(null);
                repoPelanggan.setIptv(null);
            } else if (repoPelanggan.getInternet() != null && repoPelanggan.getIptv() != null) {
                repoPelanggan.getInternet().setPelanggan(null);
                repoPelanggan.getIptv().forEach(iptv -> iptv.setPelanggan(null));
            }
        }
        return repoPelanggan;
    }

    public List<Internet> infiniteInternet(List<Internet> repoInternet) {
        for (Internet inet : repoInternet) {
            inet.getPelanggan().setInternet(null);
            inet.getPelanggan().getGpon().setPelanggan(null);
            inet.getPelanggan().getPic().setPelanggan(null);
            List<Iptv> iptv = inet.getPelanggan().getIptv();
            if (iptv.size() > 0) {
                for (Iptv tv : iptv) {
                    tv.setPelanggan(null);
                }
            }
        }
        return repoInternet;
    }

    public Internet getInfiniteInternet(Internet repoInternet) {
        repoInternet.getPelanggan().setInternet(null);
        repoInternet.getPelanggan().getPic().setPelanggan(null);
        repoInternet.getPelanggan().getGpon().setPelanggan(null);
        List<Iptv> iptv = repoInternet.getPelanggan().getIptv();
        if (iptv.size() > 0) {
            for (Iptv tv : iptv) {
                tv.setPelanggan(null);
            }
        }
        return repoInternet;
    }

    public List<Iptv> infiniteIptv(List<Iptv> repoIptv) {
        for (Iptv tv : repoIptv) {
            tv.getPelanggan().setIptv(null);
            Internet inet = tv.getPelanggan().getInternet();
            if (inet != null) inet.setPelanggan(null);
            tv.getPelanggan().getPic().setPelanggan(null);
            tv.getPelanggan().getGpon().setPelanggan(null);
        }
        return repoIptv;
    }

    public Iptv getInfiniteIptv(Iptv repoIptv) {
        repoIptv.getPelanggan().setIptv(null);
        Internet inet = repoIptv.getPelanggan().getInternet();
        if (inet != null) inet.setPelanggan(null);
        repoIptv.getPelanggan().getPic().setPelanggan(null);
        repoIptv.getPelanggan().getGpon().setPelanggan(null);

        return repoIptv;
    }
}
