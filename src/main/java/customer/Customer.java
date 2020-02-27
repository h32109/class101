package customer;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    public List<Integer> orderList;
    public List<Integer> countList;

    public Customer() {
        orderList = new ArrayList<>();
        countList = new ArrayList<>();
    }

    public void setOrder(int productSeq){
        orderList.add(productSeq);
    }

    public void setCount(int count){
        countList.add(count);
    }

    public void doneOrder(){
        orderList.clear();
        countList.clear();
    }

}
