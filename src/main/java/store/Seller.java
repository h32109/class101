package store;

import customer.Customer;
import proxy.SellProxy;

import java.util.ArrayList;
import java.util.List;

public class Seller extends Store implements Sell{
    private SellProxy sellProxy;
    private List<Product> classList;

    public Seller() {
        sellProxy = new SellProxy();
        classList = new ArrayList<>();
    }

    @Override
    public void getOrder(Customer customer) {
        System.out.println("-------------------------------------------------------------");
        for(int i = 0; i<customer.orderList.size(); i++){
            Product sellProduct = products.get(customer.orderList.get(i));
            int sellCount = customer.countList.get(i);
            int sellStock = sellProduct.stock-sellCount;
            if(sellStock>=0){
                if(sellProduct instanceof Kit){
                    showProduct(sellProduct.name, sellCount);
                    sellProduct.stock = sellStock;
                    products.replace(sellProduct.productSeq,products.get(customer.orderList.get(i)),sellProduct);
                }else if(sellProduct instanceof Class){
                    if(registerClass(sellProduct)){
                        customer.countList.remove(i);
                        customer.orderList.remove(i);
                    }else{
                        customer.countList.set(i, 1);
                        sellCount = 1;
                        showProduct(sellProduct.name, sellCount);
                    }
                    classList.add(sellProduct);
                }
            }else{
                throw new IllegalStateException("재고가 모두 소진되었습니다.");
            }
        }
        System.out.println("-------------------------------------------------------------");
        showBill(customer);
        classList.clear();
    }

    @Override
    public boolean registerClass(Product product) {
        return classList.contains(product);
    }

    @Override
    public void showProduct(String productName, int productCount) {
        System.out.println(String.format("%s - %d개", productName, productCount));
    }

    @Override
    public void showBill(Customer customer) {
        int cost = 0;
        for(int i = 0; i<customer.orderList.size(); i++){
            cost += products.get(customer.orderList.get(i)).price*customer.countList.get(i);
        }
        if(cost<50000){
            System.out.println(String.format("주문금액: %s원\n" +
                            "배송비: %s원\n" +
                            "-------------------------------------------------------------\n" +
                            "지불금액: %s원\n" +
                            "-------------------------------------------------------------"
            , sellProxy.toNumFormat(cost), sellProxy.toNumFormat(5000), sellProxy.toNumFormat(cost+5000)));
        }else{
            System.out.println(String.format("주문금액 : %s원\n" +
                    "-------------------------------------------------------------\n" +
                    "지불금액: %s원\n" +
                    "-------------------------------------------------------------"
            , sellProxy.toNumFormat(cost), sellProxy.toNumFormat(cost)));
        }
    }


}
