package dev.dolly.ProductService.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ScheduleService {

    //at every 10 seconds
    @Scheduled(fixedRate = 10000)
    public void displayHelloWorld(){
        System.out.println("Hello World "+ LocalDateTime.now());
    }

    @Scheduled(cron="0 * * * * *")// 0th second of every min,hour,day,week,month
    public void displayCRON(){
        System.out.println("Display CRON: "+LocalDateTime.now());
    }

    @Scheduled(cron="0 2 12 * * *")// 12:02 PM everyday
    public void displayCRON2(){
        System.out.println("Display CRON2: "+LocalDateTime.now());
    }
}
/*
CRON Format: second minute hour day month day-of-week
Example:"0 0 12 * * ?" -> Every day at 12 PM
 */
