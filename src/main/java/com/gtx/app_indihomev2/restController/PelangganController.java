package com.gtx.app_indihomev2.restController;

import com.gtx.app_indihomev2.entity.Gpon;
import com.gtx.app_indihomev2.entity.Pelanggan;
import com.gtx.app_indihomev2.service.PelangganService;
import com.gtx.app_indihomev2.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/rest/pelanggan")
public class PelangganController {

    @Autowired
    private PelangganService pelangganService;

    private String service = "Pelanggan";

    @GetMapping
    public ResponseEntity<Response> findAll() {
        /*Informasi Tentang Nama Method*/
        String nameOfCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        /*Memanggil Class Response yang telah dibuat*/
        Response response = new Response();
        response.setService(this.getClass().getName() + nameOfCurrMethod);
        response.setMessage("Berhasil Menampilkan Seluruh Data Pelanggan");

        /*Set Data Dari Database*/
        response.setData(pelangganService.findAll());

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @GetMapping("/nama/{nama}")
    public ResponseEntity<Response> getByNama(@PathVariable("nama") String nama) {
        /*Informasi Tentang Nama Method*/
        String nameOfCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        /*Memanggil Class Response yang telah dibuat*/
        Response response = new Response();
        response.setService(this.getClass().getName() + nameOfCurrMethod);
        response.setMessage("Berhasil Menampilkan Pelanggan berdasarkan Nama");

        /*Set Data Dari Database*/
        response.setData(pelangganService.getByNama(nama));

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @GetMapping("/id/{pelangganId}")
    public ResponseEntity<Response> getById(@PathVariable("pelangganId") UUID pelangganId) {
        /*Informasi Tentang Nama Method*/
        String nameOfCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        /*Memanggil Class Response yang telah dibuat*/
        Response response = new Response();
        response.setService(this.getClass().getName() + nameOfCurrMethod);
        response.setMessage("Berhasil Menampilkan Pelanggan berdasarkan ID");

        /*Set Data Dari Database*/
        response.setData(pelangganService.getByPelangganId(pelangganId));

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @GetMapping("/sn/{sn}")
    public ResponseEntity<Response> getBySn(@PathVariable("sn") String sn) {
        /*Informasi Tentang Nama Method*/
        String nameOfCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        /*Memanggil Class Response yang telah dibuat*/
        Response response = new Response();
        response.setService(this.getClass().getName() + nameOfCurrMethod);
        response.setMessage("Berhasil Menampilkan Pelanggan berdasarkan Serial Number ONT");

        /*Set Data Dari Database*/
        response.setData(pelangganService.getBySn(sn));

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<Response> getByStatus(@PathVariable("status") String status) {
        /*Informasi Tentang Nama Method*/
        String nameOfCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        /*Memanggil Class Response yang telah dibuat*/
        Response response = new Response();
        response.setService(this.getClass().getName() + nameOfCurrMethod);
        response.setMessage("Berhasil Menampilkan Pelanggan berdasarkan Status");

        /*Set Data Dari Database*/
        response.setData(pelangganService.findByStatus(status));

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @PostMapping
    public ResponseEntity<Response> create(@RequestBody Pelanggan pelanggan) {
        /*Informasi Tentang Nama Method*/
        String nameOfCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        /*Memanggil Class Response yang telah dibuat*/
        Response response = new Response();
        response.setService(this.getClass().getName() + nameOfCurrMethod);
        response.setMessage("Berhasil Menambah Pelanggan");

        Pelanggan pp = pelangganService.create(pelanggan);

        /*Set Data Dari Database*/
        response.setData(pelangganService.getByPelangganId(pp.getPelangganId()));

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @PostMapping("/batch")
    public ResponseEntity<Response> createBatch(@RequestBody List<Pelanggan> pelanggan) {
        /*Informasi Tentang Nama Method*/
        String nameOfCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        /*Memanggil Class Response yang telah dibuat*/
        Response response = new Response();
        response.setService(this.getClass().getName() + nameOfCurrMethod);
        response.setMessage("Berhasil Menambah Batch Pelanggan");

        List<Pelanggan> pp = pelangganService.createBatch(pelanggan);

        /*Set Data Dari Database*/
        response.setData(pelangganService.findByPelangganId(pelangganService.loopAfterBatch(pp)));

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @PutMapping("/update/{pelangganId}")
    public ResponseEntity<Response> update(@RequestBody Pelanggan pelanggan, @PathVariable("pelangganId") UUID pelangganId) {
        /*Informasi Tentang Nama Method*/
        String nameOfCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        /*Memanggil Class Response yang telah dibuat*/
        Response response = new Response();
        response.setService(this.getClass().getName() + nameOfCurrMethod);
        response.setMessage("Berhasil Update Pelanggan");

        Pelanggan pp = pelangganService.update(pelangganId, pelanggan);

        /*Set Data Dari Database*/
        response.setData(pelangganService.getByPelangganId(pelangganId));

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @PutMapping("/batch")
    public ResponseEntity<Response> updateBatch(@RequestBody List<Pelanggan> pelanggan) {
        /*Informasi Tentang Nama Method*/
        String nameOfCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        /*Memanggil Class Response yang telah dibuat*/
        Response response = new Response();
        response.setService(this.getClass().getName() + nameOfCurrMethod);
        response.setMessage("Berhasil Update Batch Pelanggan");

        List<Pelanggan> pp = pelangganService.updateBatch(pelanggan);

        /*Set Data Dari Database*/
        response.setData(pelangganService.findByPelangganId(pelangganService.loopAfterBatch(pp)));

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @DeleteMapping("/{pelangganId}")
    public ResponseEntity<Response> delete(@PathVariable("pelangganId") UUID pelangganId) {
        String nameOfCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        /*Memanggil Class Response yang telah dibuat*/
        Response response = new Response();
        response.setService(this.getClass().getName() + nameOfCurrMethod);
        response.setMessage("Berhasil Menghapus Pelanggan");

        /*Set Data Dari Database*/
        response.setData(pelangganService.getByPelangganId(pelangganId));

        pelangganService.delete(pelangganId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @DeleteMapping("/nama/{nama}")
    public ResponseEntity<Response> deleteByNama(@PathVariable("nama") String nama) {
        String nameOfCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        /*Memanggil Class Response yang telah dibuat*/
        Response response = new Response();
        response.setService(this.getClass().getName() + nameOfCurrMethod);
        response.setMessage("Berhasil Menghapus Pelanggan");

        /*Set Data Dari Database*/
        response.setData(pelangganService.getByNama(nama));

        pelangganService.deleteByNama(nama);

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @DeleteMapping("/sn/{sn}")
    public ResponseEntity<Response> deleteBySn(@PathVariable("sn") String sn) {
        String nameOfCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        /*Memanggil Class Response yang telah dibuat*/
        Response response = new Response();
        response.setService(this.getClass().getName() + nameOfCurrMethod);
        response.setMessage("Berhasil Menghapus Pelanggan");

        /*Set Data Dari Database*/
        response.setData(pelangganService.getBySn(sn));

        pelangganService.deleteBySn(sn);

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @DeleteMapping("/batch/{pelangganId}")
    public ResponseEntity<Response> deleteBatch(@PathVariable("pelangganId") UUID[] pelangganId) {
        String nameOfCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        /*Memanggil Class Response yang telah dibuat*/
        Response response = new Response();
        response.setService(this.getClass().getName() + nameOfCurrMethod);
        response.setMessage("Berhasil Menghapus Batch Pelanggan");

        /*Set Data Dari Database*/
        response.setData(pelangganService.findByPelangganId(pelangganId));

        pelangganService.deleteBatch(pelangganId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @DeleteMapping("/batch/nama/{nama}")
    public ResponseEntity<Response> deleteBatchNama(@PathVariable("nama") String[] nama) {
        String nameOfCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        /*Memanggil Class Response yang telah dibuat*/
        Response response = new Response();
        response.setService(this.getClass().getName() + nameOfCurrMethod);
        response.setMessage("Berhasil Menghapus Batch Pelanggan");

        /*Set Data Dari Database*/
        response.setData(pelangganService.findByNama(nama));

        pelangganService.deleteBatchNama(nama);

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @DeleteMapping("/batch/sn/{sn}")
    public ResponseEntity<Response> deleteBatchSn(@PathVariable("sn") String[] sn) {
        String nameOfCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        /*Memanggil Class Response yang telah dibuat*/
        Response response = new Response();
        response.setService(this.getClass().getName() + nameOfCurrMethod);
        response.setMessage("Berhasil Menghapus Batch Pelanggan");

        /*Set Data Dari Database*/
        response.setData(pelangganService.findBySn(sn));

        pelangganService.deleteBatchSn(sn);

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
        response.setMessage("Berhasil Menghapus Semua Data Pelanggan");

        /*Set Data Dari Database*/
        response.setData(pelangganService.findAll());

        pelangganService.deleteAll();

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
}
