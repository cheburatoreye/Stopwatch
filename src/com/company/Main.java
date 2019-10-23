package com.company;

public class Main {

    //метод для огранизации паузы
    static void pauselongtime(int quantity){
        System.out.println("съешь еще этих хрустящих булок //что-то делаем");
        for (int i=0;i<quantity;i++) {
            pausetime();
        }
    }
    //метод для огранизации паузы
    static  void pausetime(){
        for(int i=0;i<100000000;i++){
            if (i==5000000){

                for(int z=0;z<100000000;z++){
                    if (z==5000000){

                    }
                }

            }
        }

    }

    public static void main(String[] args) {

//тест секундомера
        Stopwatch stopwatch = new Stopwatch();

//запускаю секундомер без начального времени и делаю выборки времени
        stopwatch.start();
        pauselongtime(5);
        stopwatch.writetime();
        pauselongtime(5);
        stopwatch.writetime();
        pauselongtime(5);
        stopwatch.writetime();
        pauselongtime(5);
        stopwatch.writetime();

//ставлю секундомер на паузу
        stopwatch.pauseon();

        pauselongtime(5);
        System.out.println(stopwatch.printElapsedTime());
        pauselongtime(5);
        System.out.println(stopwatch.printElapsedTime());
        pauselongtime(5);
        System.out.println(stopwatch.printElapsedTime());
        pauselongtime(5);
        System.out.println(stopwatch.printElapsedTime());
        pauselongtime(5);
        System.out.println(stopwatch.printElapsedTime());

//снимаю с паузы
        stopwatch.pauseoff();

        stopwatch.writetime();
        pauselongtime(5);
        stopwatch.writetime();
        pauselongtime(5);
        stopwatch.writetime();
        pauselongtime(5);
        stopwatch.writetime();
        pauselongtime(5);
        stopwatch.writetime();
        stopwatch.stop();//остановка счета

//запускаю секундомер с запомненого одного из трех последних измерений времени а именно с №1
        stopwatch.start(stopwatch.getMemTime1());
        pauselongtime(5);
        stopwatch.writetime();
        pauselongtime(5);
        stopwatch.writetime();
        pauselongtime(5);
        stopwatch.writetime();
        pauselongtime(5);
        stopwatch.writetime();
        stopwatch.stop();//остановка счета

    }
}
