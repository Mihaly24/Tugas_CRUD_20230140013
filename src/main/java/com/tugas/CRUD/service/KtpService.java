package com.tugas.CRUD.service;

import com.tugas.CRUD.dto.KtpDto;
import java.util.List;

public interface KtpService {
    KtpDto createKtp(KtpDto ktpDto);
    List<KtpDto> getAllKtp();
    KtpDto getKtpById(Integer id);
    KtpDto updateKtp(Integer id, KtpDto ktpDto);
    void deleteKtp(Integer id);
}
