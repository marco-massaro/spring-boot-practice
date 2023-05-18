package com.example.springboot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewController {
    @GetMapping("/info")
    public ResponseEntity<String> exercise3(){
        return ResponseEntity.status(200).body("Cool");
    }

    @GetMapping("/random")
    public ResponseEntity<String> exercise4(){

        if ( Math.random() < 0.5){
            return ResponseEntity.status(400).body("Not cool");
        }
        return ResponseEntity.status(200).body("Very cool");

    }

}
