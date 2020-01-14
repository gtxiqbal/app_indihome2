package com.gtx.app_indihomev2.restController;

import com.gtx.app_indihomev2.entity.Gpon;
import com.gtx.app_indihomev2.entity.Pic;
import com.gtx.app_indihomev2.service.GponService;
import com.gtx.app_indihomev2.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/rest/gpon")
public class GponController {

    @Autowired
    private GponService gponService;

    private String service = "Gpon";

    @GetMapping
    public ResponseEntity<Response> findAll() {
        /*Informasi Tentang Nama Method*/
        String nameOfCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        /*Memanggil Class Response yang telah dibuat*/
        Response response = new Response();
        response.setService(this.getClass().getName() + nameOfCurrMethod);
        response.setMessage("Berhasil Menampilkan Seluruh Data GPON");

        /*Set Data Dari Database*/
        response.setData(gponService.findAll());

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @GetMapping("/hostname/{hostname}")
    public ResponseEntity<Response> getByHostname(@PathVariable("hostname") String hostname) {
        /*Informasi Tentang Nama Method*/
        String nameOfCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        /*Memanggil Class Response yang telah dibuat*/
        Response response = new Response();
        response.setService(this.getClass().getName() + nameOfCurrMethod);
        response.setMessage("Berhasil Menampilkan GPON berdasarkan Hostname");

        /*Set Data Dari Database*/
        response.setData(gponService.getByHostname(hostname));

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @GetMapping("/ip/{ip}")
    public ResponseEntity<Response> getByIp(@PathVariable("ip") String ip) {
        /*Informasi Tentang Nama Method*/
        String nameOfCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        /*Memanggil Class Response yang telah dibuat*/
        Response response = new Response();
        response.setService(this.getClass().getName() + nameOfCurrMethod);
        response.setMessage("Berhasil Menampilkan GPON berdasarkan IP GPON");

        /*Set Data Dari Database*/
        response.setData(gponService.getByIp(ip));

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @PostMapping
    public ResponseEntity<Response> create(@RequestBody Gpon gpon) {
        /*Informasi Tentang Nama Method*/
        String nameOfCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        /*Memanggil Class Response yang telah dibuat*/
        Response response = new Response();
        response.setService(this.getClass().getName() + nameOfCurrMethod);
        response.setMessage("Berhasil Menambah GPON");

        /*Set Data Dari Database*/
        response.setData(gponService.create(gpon));

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @PostMapping("/batch")
    public ResponseEntity<Response> createBatch(@RequestBody List<Gpon> gpon) {
        /*Informasi Tentang Nama Method*/
        String nameOfCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        /*Memanggil Class Response yang telah dibuat*/
        Response response = new Response();
        response.setService(this.getClass().getName() + nameOfCurrMethod);
        response.setMessage("Berhasil Menambah Batch GPON");

        /*Set Data Dari Database*/
        response.setData(gponService.createBatch(gpon));

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @PutMapping
    public ResponseEntity<Response> update(@RequestBody Gpon gpon) {
        /*Informasi Tentang Nama Method*/
        String nameOfCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        /*Memanggil Class Response yang telah dibuat*/
        Response response = new Response();
        response.setService(this.getClass().getName() + nameOfCurrMethod);
        response.setMessage("Berhasil Update GPON");

        /*Set Data Dari Database*/
        response.setData(gponService.update(gpon));

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @PutMapping("/batch")
    public ResponseEntity<Response> updateBatch(@RequestBody List<Gpon> gpon) {
        /*Informasi Tentang Nama Method*/
        String nameOfCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        /*Memanggil Class Response yang telah dibuat*/
        Response response = new Response();
        response.setService(this.getClass().getName() + nameOfCurrMethod);
        response.setMessage("Berhasil Update Batch GPON");

        /*Set Data Dari Database*/
        response.setData(gponService.updateBatch(gpon));

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @DeleteMapping("/{gponId}")
    public ResponseEntity<Response> delete(@PathVariable("gponId") UUID gponId) {
        String nameOfCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        /*Memanggil Class Response yang telah dibuat*/
        Response response = new Response();
        response.setService(this.getClass().getName() + nameOfCurrMethod);
        response.setMessage("Berhasil Menghapus GPON");

        /*Set Data Dari Database*/
        response.setData(gponService.getByGponId(gponId));

        gponService.delete(gponId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @DeleteMapping("/hostname/{hostname}")
    public ResponseEntity<Response> deleteByHostname(@PathVariable("hostname") String hostname) {
        String nameOfCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        /*Memanggil Class Response yang telah dibuat*/
        Response response = new Response();
        response.setService(this.getClass().getName() + nameOfCurrMethod);
        response.setMessage("Berhasil Menghapus GPON");

        /*Set Data Dari Database*/
        response.setData(gponService.getByHostname(hostname));

        gponService.deleteByHostname(hostname);

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @DeleteMapping("/ip/{ip}")
    public ResponseEntity<Response> deleteByIp(@PathVariable("ip") String ip) {
        String nameOfCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        /*Memanggil Class Response yang telah dibuat*/
        Response response = new Response();
        response.setService(this.getClass().getName() + nameOfCurrMethod);
        response.setMessage("Berhasil Menghapus GPON");

        /*Set Data Dari Database*/
        response.setData(gponService.getByIp(ip));

        gponService.deleteByIp(ip);

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @DeleteMapping("/batch/{gponId}")
    public ResponseEntity<Response> deleteBatch(@PathVariable("gponId") UUID[] gponId) {
        String nameOfCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        /*Memanggil Class Response yang telah dibuat*/
        Response response = new Response();
        response.setService(this.getClass().getName() + nameOfCurrMethod);
        response.setMessage("Berhasil Menghapus Batch GPON");

        /*Set Data Dari Database*/
        response.setData(gponService.findByGponId(gponId));

        gponService.deleteBatch(gponId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @DeleteMapping("/batch/ip/{ip}")
    public ResponseEntity<Response> deleteBatchIp(@PathVariable("ip") String[] ip) {
        String nameOfCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        /*Memanggil Class Response yang telah dibuat*/
        Response response = new Response();
        response.setService(this.getClass().getName() + nameOfCurrMethod);
        response.setMessage("Berhasil Menghapus Batch GPON");

        /*Set Data Dari Database*/
        response.setData(gponService.findByGponIp(ip));

        gponService.deleteBatchIp(ip);

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @DeleteMapping("/all")
    public ResponseEntity<Response> deleteAll() {
        String nameOfCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        /*Memanggil Class Response yang telah dibuat*/
        Response response = new Response();
        response.setService(this.getClass().getName() + nameOfCurrMethod);
        response.setMessage("Berhasil Menghapus Semua Data GPON");

        /*Set Data Dari Database*/
        response.setData(gponService.findAll());

        gponService.deleteAll();

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
}
