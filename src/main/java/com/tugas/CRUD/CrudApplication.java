package com.tugas.CRUD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class CrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudApplication.class, args);
    }

    // Method ini akan otomatis dieksekusi tepat setelah server Spring Boot berhasil menyala
    @EventListener(ApplicationReadyEvent.class)
    public void printStartupMessage() {
        System.out.println("\n=======================================================");
        System.out.println("✅ SERVER BERHASIL DIJALANKAN!");
        System.out.println("💻 Aplikasi Frontend CRUD KTP siap digunakan.");
        System.out.println("➡️  Klik atau buka URL ini di browser Anda: http://localhost:8080/");
        System.out.println("=======================================================\n");
    }

}
