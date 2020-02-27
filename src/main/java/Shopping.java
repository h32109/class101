import customer.Customer;
import store.Seller;

import java.util.Scanner;

public class Shopping {
    public static void main(String[] args) {
        Customer customer = new Customer();
        Seller seller = new Seller();
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("입력(o[order]: 주문, q[quit] 종료) : ");
            switch (scanner.nextLine()){
                case "o" :
                    seller.showProductList();
                    while (true){
                        System.out.print("상품번호 : ");
                        String command = scanner.nextLine();
                        if(command.equals(" ")){
                            seller.getOrder(customer);
                            customer.doneOrder();
                            break;
                        }else{
                            customer.setOrder(Integer.parseInt(command));
                            System.out.print("수량 : ");
                            customer.setCount(Integer.parseInt(scanner.nextLine()));
                        }
                    }
                    break;
                case "q" :
                    System.out.print("고객님의 주문 감사드립니다.");
                    return;

            }
        }

    }
}
