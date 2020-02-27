package test;

import customer.Customer;
import store.Seller;



public class MultiThreadTest {
    public static void main(String[] args) {
        Thread shopThread = null;
        Seller seller = new Seller();
        String[] names = new String[]{"원종석", "권혜령", "강성조", "김예지", "최강진"};
        while (true){
            for(String name : names) {
                shopThread = new Shopping(name, new Customer(), seller);
                shopThread.start();
            }
        }
    }
}

class Shopping extends Thread {
    String c_name = "";
    Customer customer;
    Seller seller;

    public Shopping(String c_name, Customer customer, Seller seller) {
        this.c_name = c_name;
        this.customer = customer;
        this.seller = seller;
    }


    @Override
    public void run() {
        try {
            while (true) {
                sleep((int) (Math.random() * 2000 + 1));
                int selectRandom = 0;
                int wishProductSeq = 0;
                int wishCount = 0;
                for (int i = 0; i < 3; i++) {
                    selectRandom = (int) (Math.random() * seller.getProductSeqs().size());
                    wishProductSeq = seller.getProductSeqs().get(selectRandom);
                    wishCount = (int) (Math.random() * 5 + 1);
                    customer.setOrder(wishProductSeq);
                    customer.setCount(wishCount);
                    System.out.println(String.format("%s님이 %d상품을 %d개 구매했습니다.",
                            c_name, wishProductSeq, wishCount));
                }
                seller.getOrder(customer);
                customer.doneOrder();
            }
        } catch (Exception e) {
        }
    }
}


