package main.products;

public abstract class Product implements Comparable <Product> {

    public enum ProductType{MEAL, DRINK}

    private String name;
    private int price;
    private ProductType productType;
    private ProductSubType subType;

    public Product(String name, int price, ProductType productType, ProductSubType subType) {
        this.name = name;
        this.price = price;
        this.productType = productType;
        this.subType = subType;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public ProductType getProductType() {
        return productType;
    }

    public ProductSubType getSubType() {
        return subType;
    }

    @Override
    public int compareTo(Product other) {
        if(other.price -this.price ==0){
            return 1;
        }
        return other.price -this.price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name:'" + name + '\'' +
                ", price:" + price +
                ", productType:" + productType +
                ", subType:" + subType +
                '}';
    }
}
