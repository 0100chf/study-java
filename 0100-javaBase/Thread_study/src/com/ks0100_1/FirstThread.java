package com.ks0100_1;

class FirstThread extends Thread{
    
    private int ticket = 10;
    
    private String name;
    public FirstThread(String name){
        this.name =name;
    }
    
    public void run(){
        for(int i =0;i<500;i++){
            if(this.ticket>0){
                System.out.println(this.name+"卖票---->"+(this.ticket--));
            }
        }
    }
    
    public static void main(String[] args) {
    	FirstThread mt1= new FirstThread("一号窗口");
    	FirstThread mt2= new FirstThread("二号窗口");
    	FirstThread mt3= new FirstThread("三号窗口");
        mt1.start();
        mt2.start();
        mt3.start();
    }
}

