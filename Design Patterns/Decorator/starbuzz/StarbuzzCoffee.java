package main.DPBook.decorator.starbuzz;

public class StarbuzzCoffee {
    public static void main(String[] args) {
        Beverage.Size small= Beverage.Size.SMALL;
        Beverage.Size medium= Beverage.Size.MEDIUM;
        Beverage.Size large= Beverage.Size.LARGE;
        //Espresso
        Beverage beverage= new Espresso(small);
        System.out.println(beverage.getDescription()+" $"+ beverage.cost());

        //Dark roast double mocha
        Beverage darkRoast=new DarkRoast(medium);
        Beverage mocha1=new Mocha(medium,darkRoast);
        Beverage mocha2=new Mocha(medium,mocha1);
        Beverage whip = new Whip(medium,mocha2);
        System.out.println(whip.getDescription()+" $"+ whip.cost());

        //House blend with Soy, Mocha and Whip
        Beverage houseBlend = new HouseBlend(large);
        Beverage soy = new Soy(large,houseBlend);
        Beverage mocha = new Mocha(large,soy);
        Beverage whip2 = new Whip(large,mocha);
        System.out.println(whip2.getDescription()+" $"+whip2.cost());
    }
}
