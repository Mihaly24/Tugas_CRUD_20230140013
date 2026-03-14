package com.tugas.CRUD.controller;

import com.tugas.CRUD.dto.KtpDto;
import com.tugas.CRUD.model.WebResponse;
import com.tugas.CRUD.service.KtpService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/ktp")
public class KtpController {

    @Autowired
    private KtpService ktpService;
    @PostMapping
    public ResponseEntity<WebResponse<KtpDto>> createKtp(@Valid @RequestBody KtpDto ktpDto) {
        KtpDto createdKtp = ktpService.createKtp(ktpDto);
        WebResponse<KtpDto> response = WebResponse.<KtpDto>builder()
                .code(HttpStatus.CREATED.value())
                .status("CREATED")
                .message("Data KTP berhasil ditambahkan")
                .data(createdKtp)
                .build();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<WebResponse<List<KtpDto>>> getAllKtp() {
        List<KtpDto> ktpList = ktpService.getAllKtp();
        WebResponse<List<KtpDto>> response = WebResponse.<List<KtpDto>>builder()
                .code(HttpStatus.OK.value())
                .status("OK")
                .message("Berhasil mengambil semua data KTP")
                .data(ktpList)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // GET /ktp/{id}: Mengambil data KTP berdasarkan id
    @GetMapping("/{id}")
    public ResponseEntity<WebResponse<KtpDto>> getKtpById(@PathVariable Integer id) {
        KtpDto ktpDto = ktpService.getKtpById(id);
        WebResponse<KtpDto> response = WebResponse.<KtpDto>builder()
                .code(HttpStatus.OK.value())
                .status("OK")
                .message("Berhasil mengambil data KTP")
                .data(ktpDto)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // PUT /ktp/{id}: Memperbarui data KTP berdasarkan id
    @PutMapping("/{id}")
    public ResponseEntity<WebResponse<KtpDto>> updateKtp(@PathVariable Integer id, @Valid @RequestBody KtpDto ktpDto) {
        KtpDto updatedKtp = ktpService.updateKtp(id, ktpDto);
        WebResponse<KtpDto> response = WebResponse.<KtpDto>builder()
                .code(HttpStatus.OK.value())
                .status("OK")
                .message("Data KTP berhasil diperbarui")
                .data(updatedKtp)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // DELETE /ktp/{id}: Menghapus data KTP berdasarkan id
    @DeleteMapping("/{id}")
    public ResponseEntity<WebResponse<String>> deleteKtp(@PathVariable Integer id) {
        ktpService.deleteKtp(id);
        WebResponse<String> response = WebResponse.<String>builder()
                .code(HttpStatus.OK.value())
                .status("OK")
                .message("Data KTP berhasil dihapus")
                .data(null)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
