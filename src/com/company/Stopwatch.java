package com.company;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Objects;


public class Stopwatch {

    //Выполняю инициализацию
    private   String pattern = "mm:ss:SSS";//HH:mm:ss//mm:ss:SSS
    private   SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    private   Duration duration1=Duration.ZERO;
    private   Duration duration2=Duration.ZERO;
    private   Duration duration3=Duration.ZERO;
    private   Duration mainDuration=Duration.ZERO;
    private   Duration startedDuration=Duration.ZERO;
    private   Instant startsample;
    private Instant pauseonsample = Instant.now();
    private Instant pauseofsample=Instant.now();
    private   String zero="zero";
    private   int samplecounter=1;
    private   boolean started=false;
    private   boolean pauseon=false;

    //Метод считает общее время от старта измерения с учетом возможного введенного заданного времени минус диапазон пауз за время измерения
    private Duration calculateduration(){
        return mainDuration=startedDuration.plus(Duration.between(startsample,Instant.now()).minus(Duration.between(pauseonsample,pauseofsample)));
    }
    //Форматирование вывода данных по форме mm:ss:SSS
    private  void typeElapsedTime(){
        System.out.println(simpleDateFormat.format(mainDuration.toMillis()));
    }
    //Форматирование вывода данных по форме mm:ss:SSS
    private  String formatetime(){
        return simpleDateFormat.format(mainDuration.toMillis());
    }

    //стартую секундомер
    void start(){
        startsample=Instant.now();
        started=true;
        duration1=Duration.ZERO;
        duration2=Duration.ZERO;
        duration3=Duration.ZERO;
        System.out.println("Stopwatch started!");
    }

    //стартую секундомер с запомненым ранее временем
    void start(Duration memDuration){
        if (Objects.isNull(memDuration)){
            System.out.println("start memtime is null");
        }
        else {
            System.out.println("Stopwatch started!");
            startsample=Instant.now();
            pauseonsample=Instant.now();
            pauseofsample=Instant.now();
            startedDuration=memDuration;
            started=true;
            duration1=Duration.ZERO;
            duration2=Duration.ZERO;
            duration3=Duration.ZERO;
        }
    }

    //установка паузы
    void pauseon(){
        if (!pauseon){
            pauseonsample = Instant.now();
            System.out.println("stopwatch paused on!");
        }
        else {
            System.out.println("already paused on!");
        }
        pauseon=true;
    }

    //снятие с паузы
    void pauseoff(){
        pauseofsample=Instant.now();
        System.out.println("stopwatch paused off!");
        pauseon=false;
    }

    //метод записи 3-х выборок времени
    String writetime(){

        if (started){
            switch (samplecounter){
                case 1:{
                    if (!pauseon){
                        if (duration1==Duration.ZERO){
                            duration1=calculateduration();
                            samplecounter=2;
                            typeElapsedTime();
                            return  formatetime();
                        }
                    }
                    else {
                        System.out.println("stopwatch paused!");
                    }

                }
                case 2:{
                    if (!pauseon){
                        if(duration2==Duration.ZERO){
                            duration2=calculateduration();
                            samplecounter=3;
                            typeElapsedTime();
                            return  formatetime();
                        }
                    }
                    else {
                        System.out.println("stopwatch paused!");
                    }

                }
                case 3:{
                    if (!pauseon){
                        if (duration3==Duration.ZERO){
                            duration3=calculateduration();
                            samplecounter=1;
                            typeElapsedTime();
                            return  formatetime();
                        }
                        else {
                            duration1=duration2;
                            duration2=duration3;
                            duration3=calculateduration();
                            samplecounter=1;
                            typeElapsedTime();
                            return  formatetime();
                        }
                    }
                    else {
                        System.out.println("stopwatch paused!");
                    }

                }
            }
        }
        else {
            System.out.println("first choice start");
        }
        return zero;
    }

    //стоп секундомера
    void stop(){
        if (started){
            System.out.println(simpleDateFormat.format(mainDuration.toMillis())+" final duration");
            started=false;
            samplecounter=1;
            System.out.println("Stopwatch stopped!");
        }
        else {
            System.out.println("first choice start");
        }
    }


    public Duration getMemTime1() {
        return duration1;
    }
    public Duration getMemTime2() {
        return duration2;
    }
    public Duration getMemTime3() {
        return duration3;
    }
    public String  printMemTime1(){
        return simpleDateFormat.format(duration1.toMillis());
    }
    public String printMemTime2(){
        return simpleDateFormat.format(duration2.toMillis());
    }
    public String printprintMemTime3(){
        return simpleDateFormat.format(duration3.toMillis());
    }
    public String printElapsedTime(){
        return  simpleDateFormat.format(mainDuration.toMillis());
    }

}




