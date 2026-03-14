package com.tugas.CRUD.service.impl;

import com.tugas.CRUD.dto.KtpDto;
import com.tugas.CRUD.entity.Ktp;
import com.tugas.CRUD.mapper.KtpMapper;
import com.tugas.CRUD.repository.KtpRepository;
import com.tugas.CRUD.service.KtpService;
import com.tugas.CRUD.util.DuplicateResourceException;
import com.tugas.CRUD.util.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KtpServiceImpl implements KtpService {

    @Autowired
    private KtpRepository ktpRepository;

    @Autowired
    private KtpMapper ktpMapper;

    @Override
    public KtpDto createKtp(KtpDto ktpDto) {
        if (ktpRepository.existsByNomorKtp(ktpDto.getNomorKtp())) {
            throw new DuplicateResourceException("Nomor KTP " + ktpDto.getNomorKtp() + " sudah terdaftar!");
        }

        Ktp ktp = ktpMapper.toEntity(ktpDto);
        Ktp savedKtp = ktpRepository.save(ktp);
        return ktpMapper.toDto(savedKtp);
    }

    @Override
    public List<KtpDto> getAllKtp() {
        List<Ktp> ktpList = ktpRepository.findAll();
        return ktpList.stream()
                .map(ktpMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public KtpDto getKtpById(Integer id) {
        Ktp ktp = ktpRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Data KTP dengan ID " + id + " tidak ditemukan"));
        return ktpMapper.toDto(ktp);
    }

    @Override
    public KtpDto updateKtp(Integer id, KtpDto ktpDto) {
        Ktp existingKtp = ktpRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Data KTP dengan ID " + id + " tidak ditemukan"));

        if (!existingKtp.getNomorKtp().equals(ktpDto.getNomorKtp()) &&
                ktpRepository.existsByNomorKtp(ktpDto.getNomorKtp())) {
            throw new DuplicateResourceException("Nomor KTP " + ktpDto.getNomorKtp() + " sudah terdaftar!");
        }

        existingKtp.setNomorKtp(ktpDto.getNomorKtp());
        existingKtp.setNamaLengkap(ktpDto.getNamaLengkap());
        existingKtp.setAlamat(ktpDto.getAlamat());
        existingKtp.setTanggalLahir(ktpDto.getTanggalLahir());
        existingKtp.setJenisKelamin(ktpDto.getJenisKelamin());

        Ktp updatedKtp = ktpRepository.save(existingKtp);
        return ktpMapper.toDto(updatedKtp);
    }

    @Override
    public void deleteKtp(Integer id) {
        Ktp existingKtp = ktpRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Data KTP dengan ID " + id + " tidak ditemukan"));
        ktpRepository.delete(existingKtp);
    }
}
