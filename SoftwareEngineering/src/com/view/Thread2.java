package com.view;

/**
 * Created by junho on 15. 4. 2..
 */
public class Thread2 implements Runnable {


    @Override
    public void run() {
        for(int i = 0;i<300000;i++) {
            int k = 0;
            for (int j = 0; j < 127; j++) {
                k += i;
            }
            for (int j = 127; j < 254; j++) {
                k += i;
            }
            System.out.println(i);
        }
    }




    public static void main(String args[]){
        Thread2 t2 = new Thread2();
        Thread t1 = new Thread(t2);
        t1.start();

    }
}
