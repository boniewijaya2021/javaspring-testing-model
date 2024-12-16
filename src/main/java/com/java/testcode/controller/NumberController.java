package com.java.testcode.controller;

import com.java.testcode.dto.BinaryTarget;
import com.java.testcode.dto.MessageModel;
import com.java.testcode.service.NumberService;
import io.swagger.models.auth.In;
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

    @PostMapping("/mencari-urutan-angka-yang-hilang")
    public ResponseEntity<MessageModel> findMissingNumber(@RequestBody int[] nums){
        int cekUrutan = nService.findMissingNumber(nums);
        return ResponseEntity.ok(new MessageModel("Angka yang hilang adalah: " + cekUrutan));
    }

    @PostMapping("/mencari-urutan-angka-yang-hilang-dimulaidari-0")
    public ResponseEntity<MessageModel> findMissingNumberFromZero(@RequestBody int[] nums){
        int angkaHilang = nService.findMissingNumberFromzero(nums);
        return ResponseEntity.ok(new MessageModel("Angka yang hilang adalah: " + angkaHilang));
    }

    @PostMapping("/mencari-beberapa-angka-duplikat-dalamarray")
    public ResponseEntity<MessageModel> findDuplicatesnumbes(@RequestBody int[] nums){
        List<Integer> angkaDuplikat = nService.findDuplicates(nums);
        return ResponseEntity.ok(new MessageModel("Angka yang duplikat adalah: " + angkaDuplikat));
    }

    @PostMapping("/mencari-jumlah-terbesar-subarray")
    public ResponseEntity<MessageModel> maxSubArraySum(@RequestBody int[] nums){
        int sumArray = nService.maxSubArraySum(nums);
        return ResponseEntity.ok(new MessageModel("Jumlah terbesar subarray adalah: " + sumArray));
    }

    @PostMapping("/mencari-binary-target")
    public ResponseEntity<MessageModel> binarySearch(@RequestBody BinaryTarget binaryTarget){
        int arrayKe = nService.binarySearch(binaryTarget.getNums(), binaryTarget.getTarget());

        if (arrayKe != -1) {
           // System.out.println("Target found at index: " + arrayKe);
            return ResponseEntity.ok(new MessageModel("target ada di array ke :" + arrayKe));
        } else {
            //System.out.println("Target not found.");
            return ResponseEntity.ok(new MessageModel("target tidak di temukan"));
        }

    }


}
