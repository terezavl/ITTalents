package main.clients;

import main.Order;
import main.Restaurant;
import main.Waiter;
import main.products.Product;
import main.products.ProductSubType;

import java.util.Random;
 public abstract class Client {
    public static Restaurant restaurant;

    private String name;
    private int money;

    public Client(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public void makeOrder(){
        int productsCount=new Random().nextInt(3)+1;

        Order order=new Order(this);
        int helpPrice=0;
        for (int i = 0; i < productsCount; i++) {
            Product.ProductType type= getRandomProductType();
            ProductSubType subType=getRandomSubType(type);

            Product p = restaurant.getProduct(type, subType);
            if(p == null){
                continue;
            }
            helpPrice+=p.getPrice();
            if(helpPrice<= this.money*0.9) {
                order.addToOrder(p);
            }
        }

        Waiter waiter=restaurant.getRandomWaiter();
        waiter.acceptOrder(order);
        waiter.giveInfoForOrder(order);
        //payment
        pay(order.getOrderPrice(), waiter);
    }

    private void pay(int price, Waiter w){
        int chanceTip= new Random().nextInt(100);
        if(chanceTip<80){
            double tipPercentage=new Random().nextInt(11)+5;
            double tip = tipPercentage*price/100;
            w.acceptTip(tip);
        }
        restaurant.receiveMoney(price);
    }
    private Product.ProductType getRandomProductType(){
        if(new Random().nextBoolean()){
            return Product.ProductType.DRINK;
        }
        return Product.ProductType.MEAL;
    }

    protected abstract ProductSubType getRandomSubType(Product.ProductType type);

    public String getName() {
        return this.name;
    }

}
