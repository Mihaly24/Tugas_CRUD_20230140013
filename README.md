📚 Dokumentasi REST API
Semua respons dari API ini dibungkus dalam format standar WebResponse dengan struktur: code, status, message, dan data.

1. Tambah Data KTP Baru
Endpoint: POST /ktp

Request Body (JSON):

```JSON
{
  "nomorKtp": "1234567887654321",
  "namaLengkap": "Orang",
  "alamat": "Indo",
  "tanggalLahir": "2026-03-11",
  "jenisKelamin": "Laki-laki"
}
```
Success Response (201 CREATED):

```JSON
{
  "code": 201,
  "status": "CREATED",
  "message": "Data KTP berhasil ditambahkan",
  "data": {
    "id": 1,
    "nomorKtp": "1234567887654321",
    "namaLengkap": "Orang",
    "alamat": "Indo",
    "tanggalLahir": "2026-03-11",
    "jenisKelamin": "Laki-laki"
  }
}
```
2. Ambil Seluruh Data KTP
Endpoint: GET /ktp

Success Response (200 OK):

```JSON
{
  "code": 200,
  "status": "OK",
  "message": "Berhasil mengambil semua data KTP",
  "data": [
    {
      "id": 1,
      "nomorKtp": "1234567887654321",
      "namaLengkap": "Orang",
      "alamat": "Indo",
      "tanggalLahir": "2026-03-11",
      "jenisKelamin": "Laki-laki"
    }
  ]
}
```
3. Ambil Data KTP Berdasarkan ID
Endpoint: GET /ktp/{id}

Success Response (200 OK): Mengembalikan objek KTP spesifik di dalam properti data.

Error Response (404 NOT FOUND): Jika ID tidak ada di database.

4. Perbarui Data KTP
Endpoint: PUT /ktp/{id}

Request Body (JSON): Sama seperti format POST.

Success Response (200 OK):

```JSON
{
  "code": 200,
  "status": "OK",
  "message": "Data KTP berhasil diperbarui",
  "data": { ...data_terbaru... }
}
```
Error Response (409 CONFLICT): Jika mengubah nomorKtp menjadi nomor yang sudah dipakai data lain.

5. Hapus Data KTP
Endpoint: DELETE /ktp/{id}

Success Response (200 OK):

```JSON
{
  "code": 200,
  "status": "OK",
  "message": "Data KTP berhasil dihapus",
  "data": null
}
```

SS tampilan web: 
