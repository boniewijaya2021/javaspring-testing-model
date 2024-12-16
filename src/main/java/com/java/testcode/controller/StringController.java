package com.java.testcode.controller;

import com.java.testcode.dto.MessageModel;
import com.java.testcode.service.StringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testing-tentang-string")
public class StringController {

    @Autowired
    private StringService sService;

    @PostMapping("/reverse")
    public String reverseString(@RequestBody String input) {
        //contoh dengan direct respon
        return new StringBuilder(input).reverse().toString();
    }

    @PostMapping("/membalikan-kata")
    public ResponseEntity<MessageModel> reverseStringV2(@RequestBody String input){
        String hasilBalik = sService.textdibalik(input);
        return ResponseEntity.ok(new MessageModel(hasilBalik));
    }

    @PostMapping("/membalikan-kata-tanpa-rubah-urutan-kata")
    public ResponseEntity<MessageModel> reverseStringV3(@RequestBody String input){
        String hasilBalik = sService.balikkataurutantetap(input);
        return ResponseEntity.ok(new MessageModel(hasilBalik));
    }

}
