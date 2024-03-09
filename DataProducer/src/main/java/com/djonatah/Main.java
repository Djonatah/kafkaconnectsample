package com.djonatah;


import com.djonatah.db.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.function.IntFunction;
import java.util.stream.IntStream;

@SpringBootApplication
public class Main {

    @Autowired
    ClientService clientService;

    public static void main(String [] args){
        SpringApplication.run(Main.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void produceData(){
        IntStream.range(0, 10).forEach(i ->{
            clientService.createRandomClient();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Error generating client");
            }
        });
    }
}