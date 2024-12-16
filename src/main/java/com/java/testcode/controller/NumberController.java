package com.java.testcode.controller;

import com.java.testcode.dto.MessageModel;
import com.java.testcode.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/testing-tentang-angka")
public class NumberController {

    @Autowired
    private NumberService nService;


    @PostMapping("/angka-kedua-terbesar")
    private ResponseEntity<MessageModel> findSecondLargestNumber(@RequestBody int[] numbers) {
        // Validasi input
        if (numbers == null || numbers.length < 2) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new MessageModel("Input tidak valid: array harus memiliki setidaknya dua elemen."));
        }

        // Panggil metode findSecondLargest di service
        int secondLargest = nService.findSecondLargest(numbers);

        if (secondLargest == -1) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new MessageModel("Tidak ditemukan angka kedua terbesar."));
        }

        return ResponseEntity.ok(new MessageModel("Angka kedua terbesar adalah: " + secondLargest));
    }




}
