package com.tugas.CRUD.mapper;

import com.tugas.CRUD.dto.KtpDto;
import com.tugas.CRUD.entity.Ktp;
import org.springframework.stereotype.Component;

@Component
public class KtpMapper {

    public KtpDto toDto(Ktp ktp) {
        if (ktp == null) {
            return null;
        }
        return new KtpDto(
                ktp.getId(),
                ktp.getNomorKtp(),
                ktp.getNamaLengkap(),
                ktp.getAlamat(),
                ktp.getTanggalLahir(),
                ktp.getJenisKelamin()
        );
    }

    public Ktp toEntity(KtpDto ktpDto) {
        if (ktpDto == null) {
            return null;
        }
        Ktp ktp = new Ktp();
        ktp.setId(ktpDto.getId());
        ktp.setNomorKtp(ktpDto.getNomorKtp());
        ktp.setNamaLengkap(ktpDto.getNamaLengkap());
        ktp.setAlamat(ktpDto.getAlamat());
        ktp.setTanggalLahir(ktpDto.getTanggalLahir());
        ktp.setJenisKelamin(ktpDto.getJenisKelamin());
        return ktp;
    }
}