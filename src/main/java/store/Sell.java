package store;

import customer.Customer;


public interface Sell extends ClassSell{
    public void getOrder(Customer customer);
    public void showBill(Customer customer);
    public void showProduct(String productName, int productCount);
}
