package org.example;

import java.util.Random;

public class Threads implements Runnable {
    /*
    We want to create a multithreading application.

    The main thread must generate a random number (use java.util.Random) between 0 and 100.
    That main thread must create ten threads whose job is to guess the number generated by
    the main thread.

    To perform their tasks all threads must share an object of the HiddenNumber class.
    The HiddenNumber class must have a method int numberGuess(int num) that has to return
    the following values:

    -1 if the game is over because one thread has guessed the number
    1 if the proposed number (num) is the hidden number
    0 otherwise
    Follow the given specifications to create the application.
     */

    HiddenNumber hn;

    public Threads(HiddenNumber hn) {
        this.hn = hn;
    }

    @Override
    public void run() {
            int res = hn.numberGuess(new Random().nextInt(100));

            System.out.println(Thread.currentThread().getName() + ": "+res);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
    }
}
