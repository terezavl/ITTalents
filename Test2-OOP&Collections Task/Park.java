package main;

import main.attraction.Attraction;
import main.beasts.Beast;
import main.beasts.Devil;
import main.beasts.Dragon;
import main.beasts.Mermaid;
import main.clients.Client;

import java.util.*;
import java.util.stream.Collectors;

public class Park {
    private String name;
    private String address;
    private ArrayList<Client> clients=new ArrayList<>();

    private double totalIncomes;
    private int totalSwallowedClients=0;

    private ArrayList<Attraction> attractions=new ArrayList<>();

    //beast type -> price
    private Map<Beast,Double> priceList=new HashMap<>();

    //beastType-> SubType -> incomes
    private Map<Beast.BeastType,Map<Beast.BeastSubType,Double>> beastIncomes=new HashMap<>();


    public Park(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void generatePriceList(){
        for(Attraction attraction: this.attractions) {
            Beast b = attraction.getBeast();
            double price=b.giveShowPrice();

            this.priceList.put(b,price);

        }
        System.out.println("--------- PRICE LIST: ---------");
        for(Map.Entry<Beast, Double> entry: this.priceList.entrySet()){
            System.out.println("Price for "+entry.getKey().getName()+" - "+ entry.getValue());
        }
        System.out.println("-------------------------------");
    }

    public void generateReportBeast(){

        for(Attraction attraction: this.attractions){
            Beast b=attraction.getBeast();
            Beast.BeastType beastType=b.getType();
            Beast.BeastSubType beastSubType=b.getBeastSubType();
            double income=b.getIncomes();

            if(!this.beastIncomes.containsKey(beastType)){
                this.beastIncomes.put(beastType,new HashMap<>());
            }
            if(!this.beastIncomes.get(beastType).containsKey(beastSubType)){
                this.beastIncomes.get(beastType).put(beastSubType,income);
            }
            else{
                double old= this.beastIncomes.get(beastType).get(beastSubType);
                this.beastIncomes.get(beastType).put(beastSubType, old+ income);
            }
        }
        System.out.println("--------- BEAST INCOMES: ---------");
        for(Beast.BeastType type: this.beastIncomes.keySet()){
            System.out.println(type+":");
            for(Map.Entry<Beast.BeastSubType, Double> entry: this.beastIncomes.get(type).entrySet()){
                System.out.println("\t"+entry.getKey()+" - "+entry.getValue()+" incomes");
            }
        }
        System.out.println("----------------------------------");
    }

    public void devilSouls(){
        ArrayList<Beast> beasts=new ArrayList<>();
        for(Attraction attraction: this.attractions) {
            Beast b = attraction.getBeast();
            beasts.add(b);
        }

        List<Client>devilClients=new ArrayList<>();
        beasts.stream()
                .filter(beast -> beast.getBeastSubType().equals(Beast.BeastSubType.DEVIL))
                .map(beast -> ((Devil) beast).getSouls())
                .forEach(clients -> devilClients.addAll(clients));

        long totalWomenSoulsAdults=devilClients.stream()
                .filter(client -> client.getType().equals(Client.ClientType.ADULT) && client.getGender().equals(Client.Gender.FEMALE))

                .count();
        System.out.println("Total adult women's souls: "+totalWomenSoulsAdults);
    }

    public void burnedHumans(){
        System.out.println("Names of retired people who were burnt by dragon: ");
        ArrayList<Beast> beasts=new ArrayList<>();
        for(Attraction attraction: this.attractions) {
            Beast b = attraction.getBeast();
            beasts.add(b);
        }

        List<Client>burned=new ArrayList<>();
        beasts.stream()
                .filter(beast -> beast.getBeastSubType().equals(Beast.BeastSubType.DRAGON))
                .map(beast -> ((Dragon) beast).getBurnedHumans())
                .forEach(clients -> burned.addAll(clients));

        burned.stream()
                .filter(client -> client.getType().equals(Client.ClientType.RETIRED))
                .forEach(client -> System.out.println(client.getName()));

    }

    public void middleAgeOfKidnappedByMermaid(){
        ArrayList<Beast> beasts=new ArrayList<>();
        for(Attraction attraction: this.attractions) {
            Beast b = attraction.getBeast();
            beasts.add(b);
        }

        List<Client>mermaidClients=new ArrayList<>();
        beasts.stream()
                .filter(beast -> beast.getBeastSubType().equals(Beast.BeastSubType.MERMAID))
                .map(beast -> ((Mermaid) beast).getKidnappedClients())
                .forEach(clients -> mermaidClients.addAll(clients));
        if(!mermaidClients.isEmpty()) {
            int totAge = mermaidClients.stream()
                    .map(client -> client.getAge())
                    .reduce(0, (total, number) -> total + number);
            double avgAge = totAge / mermaidClients.size();
            System.out.println("Average age of people kidnapped by mermaid " + avgAge);
        }else{
            System.out.println("No people kidnapped by mermaid ");
        }
    }


    public void incrementSwallowedClients(){
        this.totalSwallowedClients++;
    }

    public void printNumberOfKids(){
        Long count=this.clients.stream()
                .filter(client -> client.getType().equals(Client.ClientType.KID))
                .count();
        System.out.println("Total visited kids in park:" +count);
    }

    public void receiveIncomes(double price){
        this.totalIncomes+= price;
    }

    public void printIncomes(){
        System.out.println("Total incomes "+ this.totalIncomes);
    }

    public void printSwallowedClients(){
        System.out.println("Total swallowed Clients: "+this.totalSwallowedClients);
    }

    public void acceptClient(Client client) {
        this.clients.add(client);

    }

    public List<Client> getClients() {
        return Collections.unmodifiableList(clients);
    }

    public void acceptNewAttraction(Attraction attraction){
        this.attractions.add(attraction);
    }

    public Attraction getRandomAttraction() {
        int chance = new Random().nextInt(this.attractions.size());
        return this.attractions.get(chance);
    }

    public void mostVisitedAttraction(){
        this.attractions.stream()
                .filter(attraction -> attraction.getType().equals(Attraction.AttractionType.NORMAL))
                .sorted((o1, o2) -> o2.getNumberOfClients()-o1.getNumberOfClients())
                .limit(1)
                .forEach(a -> System.out.println("Most visited normal attraction: "+a.getName()+" - "+a.getNumberOfClients()));
        this.attractions.stream()
                .filter(attraction -> attraction.getType().equals(Attraction.AttractionType.DANGEROUS))
                .sorted((o1, o2) -> o2.getNumberOfClients()-o1.getNumberOfClients())
                .limit(1)
                .forEach(a -> System.out.println("Most visited dangerous attraction: "+a.getName()+" - "+a.getNumberOfClients()));

    }
    public void ratioClientsExtremeAttractions(){
        double clients=this.attractions.stream()
                .filter(attraction -> attraction.getType().equals(Attraction.AttractionType.DANGEROUS))
                .map(attraction -> attraction.getNumberOfClients())
                .reduce(0,(num,tot) -> num+tot);
        double ratio=this.totalSwallowedClients/clients;
        System.out.println("Ratio swallowed clients : clients visited dangerous attraction: "+ratio);

    }

}
