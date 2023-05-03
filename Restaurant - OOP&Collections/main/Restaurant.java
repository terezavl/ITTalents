package main;

import main.clients.Client;
import main.products.*;

import java.util.*;

public class Restaurant {
    private String name;
    private String address;
    private int cash;

    private Set<Waiter> waiters = new HashSet<>();

    private ArrayList<Client> clients=new ArrayList<>();

    private Map<Product.ProductType, Map<ProductSubType, TreeSet<Product>>> menu=new HashMap<>();


    public Restaurant(String name, String address, int cash) {
        this.name = name;
        this.address = address;
        this.cash = cash;
        this.createMealsAndDrinks();
    }
    public void hireWaiter(Waiter waiter){
        this.waiters.add(waiter);
    }

    public void acceptClient(Client client){
        this.clients.add(client);
    }
    public void createMealsAndDrinks(){
        for (int i = 0; i < 10; i++) {
            Salad salad=new Salad("Salad "+(i+1));
            MainDish main=new MainDish("Main Dish "+(i+1));
            Dessert dessert=new Dessert("Dessert "+(i+1));
            this.addToMenu(salad);
            this.addToMenu(main);
            this.addToMenu(dessert);
        }
        for (int i = 0; i < 20; i++) {
            Alcohol alcohol=new Alcohol("Alcohol drink "+(i+1));
            NonAlcohol nonAlcohol=new NonAlcohol("Non Alcohol drink "+(i+1));
            this.addToMenu(alcohol);
            this.addToMenu(nonAlcohol);
        }
    }

    public void addToMenu(Product p){
        if(!this.menu.containsKey(p.getProductType())){
            this.menu.put(p.getProductType(), new HashMap<>());
        }
        if(!this.menu.get(p.getProductType()).containsKey(p.getSubType())){
            this.menu.get(p.getProductType()).put(p.getSubType(), new TreeSet<>());
        }
        this.menu.get(p.getProductType()).get(p.getSubType()).add(p);
    }

    public void printMenu(){
        System.out.println("---------MENU---------");
        for (Product.ProductType productType : menu.keySet()) {
            System.out.println(productType+"S : ");
            for(Map.Entry<ProductSubType,TreeSet<Product>> entry: menu.get(productType).entrySet()){
                System.out.print("\t"+entry.getKey()+" - "+entry.getValue().size()+" portions");
                System.out.println();
            }
            System.out.println();
        }
    }

    public void startDay(){
        for(Client client: this.clients){
            client.makeOrder();
        }
    }

    public void printCurrentMoney(){
        System.out.println("Current money at restaurant: "+this.cash);
    }

    public void printWaitersByTips(){
        System.out.println("Waiters sorted by tip:");
        this.waiters.stream()
                .sorted((o1, o2) -> Double.compare(o2.getTips(),o1.getTips()))
                .forEach(waiter -> System.out.println(waiter.getName()+" - "+waiter.getTips()));
    }

    public void printMostRichWaiter(){
        System.out.println("Most rich waiter:");
        Waiter waiter=this.waiters.stream()
                .max((o1, o2) -> Double.compare(o1.getTips(),o2.getTips())).get();
        System.out.println(waiter.getName()+" - "+waiter.getTips());
    }

    public void receiveMoney(int money){
        this.cash+=money;
    }
    public Product getProduct(Product.ProductType type, ProductSubType subType) {
        if(this.menu.containsKey(type)){
            if(this.menu.get(type).containsKey(subType)){
                return this.menu.get(type).get(subType).pollFirst();
            }
        }
        System.out.println("Sorry we don't have any of "+type+" - "+subType);
        return null;
    }

    public Waiter getRandomWaiter() {
        int rand=new Random().nextInt(this.waiters.size());
        int counter=0;
        for (Waiter waiter: this.waiters){
            if(counter++==rand){
                return waiter;
            }
        }
        return null;
    }
}
