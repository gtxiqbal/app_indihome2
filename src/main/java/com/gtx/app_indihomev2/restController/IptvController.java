package com.gtx.app_indihomev2.restController;

import com.gtx.app_indihomev2.service.IptvService;
import com.gtx.app_indihomev2.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/rest/iptv")
public class IptvController {

    @Autowired
    private IptvService iptvService;

    private String service = "Iptv";

    @GetMapping("/nomor/{nomor}")
    public ResponseEntity<Response> getByNama(@PathVariable("nomor") String nomor) {
        /*Informasi Tentang Nama Method*/
        String nameOfCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        /*Memanggil Class Response yang telah dibuat*/
        Response response = new Response();
        response.setService(this.getClass().getName() + nameOfCurrMethod);
        response.setMessage("Berhasil Menampilkan IPTV berdasarkan Nomor");

        /*Set Data Dari Database*/
        response.setData(iptvService.getByNomor(nomor));

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @DeleteMapping("/{iptvId}")
    public ResponseEntity<Response> delete(@PathVariable("iptvId") UUID iptvId) {
        String nameOfCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        /*Memanggil Class Response yang telah dibuat*/
        Response response = new Response();
        response.setService(this.getClass().getName() + nameOfCurrMethod);
        response.setMessage("Berhasil Menghapus IPTV");

        /*Set Data Dari Database*/
        response.setData(iptvService.getByIptvId(iptvId));

        iptvService.deleteByPelangganId(iptvId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
}
