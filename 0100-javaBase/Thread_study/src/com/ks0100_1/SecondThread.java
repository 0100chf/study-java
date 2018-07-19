package com.ks0100_1;


class SecondThread implements Runnable{
    private int ticket =10;
    private String name;
    public void run(){
        for(int i =0;i<500;i++){
            if(this.ticket>0){
                System.out.println(Thread.currentThread().getName()+"卖票---->"+(this.ticket--));
            }
        }
    }
    
    public static void main(String[] args) {
        //设计三个线程
    	SecondThread mt = new SecondThread();
         Thread t1 = new Thread(mt,"一号窗口");
         Thread t2 = new Thread(mt,"二号窗口");
         Thread t3 = new Thread(mt,"三号窗口");
//         MyThread1 mt2 = new MyThread1();
//         MyThread1 mt3 = new MyThread1();
         t1.start();
         t2.start();
         t3.start();
    }
}
