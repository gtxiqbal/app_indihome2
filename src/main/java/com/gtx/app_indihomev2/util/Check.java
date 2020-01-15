package com.gtx.app_indihomev2.util;

import com.gtx.app_indihomev2.entity.*;

import java.util.List;

public class Check {

    private void pelanggan(Pelanggan p) {
        p.getPic().setPelanggan(null);
        if (p.getInternet() != null) p.getInternet().setPelanggan(null);
        if (p.getIptv().size() > 0) {
            for (Iptv iptv : p.getIptv()) {
                iptv.setPelanggan(null);
            }
        }
    }

    public List<Gpon> infiniteGpon(List<Gpon> repoGpon) {
        List<Gpon> gpon = repoGpon;
        if (gpon.size() > 0) {
            for (Gpon g : gpon) {
                if (g.getPelanggan().size() > 0) {
                    for (Pelanggan p : g.getPelanggan()) {
                        p.setGpon(null);
                        pelanggan(p);
                    }
                }
            }
        }
        return gpon;
    }

    public List<Pic> infinitePic(List<Pic> repoPic) {
        List<Pic> pic = repoPic;
        if (pic.size() > 0) {
            for (Pic pc : pic) {
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
        return pic;
    }

    public Pic getInfinitePic(Pic repoPic) {
        Pic pic = repoPic;
        if (pic != null) {
            List<Pelanggan> pelanggan = pic.getPelanggan();
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
        return pic;
    }

    public List<Pelanggan> infinitePelanggan(List<Pelanggan> repoPelanggan) {
        List<Pelanggan> pelanggan = repoPelanggan;
        if (pelanggan.size() > 0) {
            for (Pelanggan p : pelanggan) {
                p.getGpon().setPelanggan(null);
                pelanggan(p);
            }
        }
        return pelanggan;
    }

    public Pelanggan getInfinitePelanggan(Pelanggan repoPelanggan) {
        Pelanggan pelanggan = repoPelanggan;
        if (pelanggan != null) {
            pelanggan.getGpon().setPelanggan(null);
            pelanggan.getPic().setPelanggan(null);
            Internet inet = pelanggan.getInternet();
            List<Iptv> iptv = pelanggan.getIptv();
            if (inet != null) inet.setPelanggan(null);
            if (iptv.size() > 0) {
                for (Iptv tv : iptv) {
                    tv.setPelanggan(null);
                }
            }
        }
        return pelanggan;
    }

    public List<Internet> infiniteInternet(List<Internet> repoInternet) {
        List<Internet> internet = repoInternet;
        for (Internet inet : internet) {
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
        return internet;
    }

    public List<Iptv> infiniteIptv(List<Iptv> repoIptv) {
        List<Iptv> iptv = repoIptv;
        for (Iptv tv : iptv) {
            tv.getPelanggan().setIptv(null);
            Internet inet = tv.getPelanggan().getInternet();
            if (inet != null) inet.setPelanggan(null);
            tv.getPelanggan().getPic().setPelanggan(null);
            tv.getPelanggan().getGpon().setPelanggan(null);
        }
        return iptv;
    }
}
