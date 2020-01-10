package com.gtx.app_indihomev2.restController;

import com.gtx.app_indihomev2.entity.Pic;
import com.gtx.app_indihomev2.service.PicService;
import com.gtx.app_indihomev2.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/rest/pic")
public class PicController {

    @Autowired
    PicService picService;

    private String service = "Pic";

    @GetMapping
    public ResponseEntity<Response> findPicAll() {
        /*Informasi Tentang Nama Method*/
        String nameOfCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        /*Memanggil Class Response yang telah dibuat*/
        Response response = new Response();
        response.setService(this.getClass().getName() + nameOfCurrMethod);
        response.setMessage("Berhasil Menampilkan Seluruh Data PIC");

        /*Set Data Dari Database*/
        response.setData(picService.findAll());

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @GetMapping("/{nama}")
    public ResponseEntity<Response> getPicNama(@PathVariable("nama") String nama) {
        /*Informasi Tentang Nama Method*/
        String nameOfCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        /*Memanggil Class Response yang telah dibuat*/
        Response response = new Response();
        response.setService(this.getClass().getName() + nameOfCurrMethod);
        response.setMessage("Berhasil Menampilkan PIC berdasarkan Nama");

        /*Set Data Dari Database*/
        response.setData(picService.getByNama(nama));

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @PostMapping
    public ResponseEntity<Response> createPic(@RequestBody @Validated Pic pic) {
        /*Informasi Tentang Nama Method*/
        String nameOfCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        /*Memanggil Class Response yang telah dibuat*/
        Response response = new Response();
        response.setService(this.getClass().getName() + nameOfCurrMethod);
        response.setMessage("Berhasil Menambah PIC");

        /*Set Data Dari Database*/
        response.setData(picService.createPic(pic));

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
}
