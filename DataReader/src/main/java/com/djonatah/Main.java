package com.djonatah;

import com.djonatah.db.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class Main {

    @Autowired
    ClientRepository clientRepository;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void process() throws InterruptedException {
        while(true){
            clientRepository.findAll().forEach(System.out::println);
            Thread.sleep(1000);
        }
    }
}