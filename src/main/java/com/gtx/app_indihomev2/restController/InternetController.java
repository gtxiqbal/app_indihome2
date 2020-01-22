package com.gtx.app_indihomev2.restController;

import com.gtx.app_indihomev2.entity.Internet;
import com.gtx.app_indihomev2.service.InternetService;
import com.gtx.app_indihomev2.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/rest/inet")
public class InternetController {

    @Autowired
    private InternetService internetService;

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
        response.setMessage("Berhasil Menampilkan Semua Internet");

        /*Set Data Dari Database*/
        response.setData(internetService.findAll());

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @GetMapping("/{nomor}")
    public ResponseEntity<Response> getNomor(@PathVariable("nomor") String nomor) {
        /*Informasi Tentang Nama Method*/
        String nameOfCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        /*Memanggil Class Response yang telah dibuat*/
        Response response = new Response();
        response.setService(this.getClass().getName() + nameOfCurrMethod);
        response.setMessage("Berhasil Menampilkan Internet Berdasarkan Nomor");

        /*Set Data Dari Database*/
        response.setData(internetService.getByNomor(nomor));

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @PostMapping()
    public ResponseEntity<Response> create(@RequestBody Internet internet) {
        /*Informasi Tentang Nama Method*/
        String nameOfCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        /*Memanggil Class Response yang telah dibuat*/
        Response response = new Response();
        response.setService(this.getClass().getName() + nameOfCurrMethod);
        response.setMessage("Berhasil Menambah Internet");

        Internet inet =  internetService.create(internet);
        /*Set Data Dari Database*/
        response.setData(internetService.getByInternetId(inet.getId()));

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @PutMapping("/{internetId}")
    public ResponseEntity<Response> update(@PathVariable("internetId") UUID internetId, @RequestBody Internet internet) {
        /*Informasi Tentang Nama Method*/
        String nameOfCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        /*Memanggil Class Response yang telah dibuat*/
        Response response = new Response();
        response.setService(this.getClass().getName() + nameOfCurrMethod);
        response.setMessage("Berhasil Menambah Internet");

        Internet inet =  internetService.update(internetId, internet);
        /*Set Data Dari Database*/
        response.setData(internetService.getByInternetId(inet.getId()));

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @DeleteMapping("/{internetId}")
    public ResponseEntity<Response> delete(@PathVariable("internetId") UUID internetId) {
        /*Informasi Tentang Nama Method*/
        String nameOfCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        /*Memanggil Class Response yang telah dibuat*/
        Response response = new Response();
        response.setService(this.getClass().getName() + nameOfCurrMethod);
        response.setMessage("Berhasil Menambah Internet");

        /*Set Data Dari Database*/
        response.setData(internetService.getByInternetId(internetId));

        internetService.delete(internetId);


        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
}
