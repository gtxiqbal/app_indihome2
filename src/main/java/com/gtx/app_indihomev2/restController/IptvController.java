package com.gtx.app_indihomev2.restController;

import com.gtx.app_indihomev2.entity.Iptv;
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

    @GetMapping
    public ResponseEntity<Response> findAll() {
        /*Informasi Tentang Nama Method*/
        String nameOfCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        /*Memanggil Class Response yang telah dibuat*/
        Response response = new Response();
        response.setService(this.getClass().getName() + nameOfCurrMethod);
        response.setMessage("Berhasil Menampilkan Semua IPTV");

        /*Set Data Dari Database*/
        response.setData(iptvService.findAll());

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @GetMapping("/{iptvId}")
    public ResponseEntity<Response> getByIptvId(@PathVariable("iptvId") UUID iptvId) {
        /*Informasi Tentang Nama Method*/
        String nameOfCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        /*Memanggil Class Response yang telah dibuat*/
        Response response = new Response();
        response.setService(this.getClass().getName() + nameOfCurrMethod);
        response.setMessage("Berhasil Menampilkan IPTV berdasarkan ID");

        /*Set Data Dari Database*/
        response.setData(iptvService.getByIptvId(iptvId));

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @GetMapping("/nomor/{nomor}")
    public ResponseEntity<Response> getByNomor(@PathVariable("nomor") String nomor) {
        /*Informasi Tentang Nama Method*/
        String nameOfCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        /*Memanggil Class Response yang telah dibuat*/
        Response response = new Response();
        response.setService(this.getClass().getName() + nameOfCurrMethod);
        response.setMessage("Berhasil Menampilkan IPTV berdasarkan Nomor");

        /*Set Data Dari Database*/
        response.setData(iptvService.findByNomor(nomor));

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @PostMapping
    public ResponseEntity<Response> create(@RequestBody Iptv iptv) {
        /*Informasi Tentang Nama Method*/
        String nameOfCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        /*Memanggil Class Response yang telah dibuat*/
        Response response = new Response();
        response.setService(this.getClass().getName() + nameOfCurrMethod);
        response.setMessage("Berhasil Menambah IPTV");

        /*Set Data Dari Database*/
        response.setData(iptvService.create(iptv));

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @PutMapping("/{iptvId}")
    public ResponseEntity<Response> update(@PathVariable("iptvId") UUID iptvId, @RequestBody Iptv iptv) {
        /*Informasi Tentang Nama Method*/
        String nameOfCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        /*Memanggil Class Response yang telah dibuat*/
        Response response = new Response();
        response.setService(this.getClass().getName() + nameOfCurrMethod);
        response.setMessage("Berhasil Update IPTV");

        /*Set Data Dari Database*/
        response.setData(iptvService.update(iptvId, iptv));

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

        iptvService.deleteByIptvId(iptvId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
}
