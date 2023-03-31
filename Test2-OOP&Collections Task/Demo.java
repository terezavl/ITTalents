package main;

import main.attraction.Attraction;
import main.attraction.DangerousAttraction;
import main.attraction.NormalAttraction;
import main.beasts.*;
import main.clients.Adult;
import main.clients.Client;
import main.clients.Kid;
import main.clients.Retired;

import java.util.List;
import java.util.Random;

public class Demo {

    public static void main(String[] args) {
        Park park=new Park("Krasi`s Fantastic Beasts","Sofia");
        Beast.park=park;
        Attraction.park=park;
        Client.park=park;

        for (int i = 0; i < 3; i++) {
            Dwarf dwarf=new Dwarf(new Random().nextInt(40)+18);
            NormalAttraction attraction1=new NormalAttraction("Dwarf Attraction "+(i+1), dwarf);

            Gryphon gryphon=new Gryphon(new Random().nextInt(40)+20,10,"blue",5);
            NormalAttraction attraction2=new NormalAttraction("Gryphon Attraction "+(i+1), gryphon);

            Kraken kraken=new Kraken(100,50,20);
            NormalAttraction attraction3=new NormalAttraction("Kraken Attraction "+(i+1), kraken);
            
            park.acceptNewAttraction(attraction1);
            park.acceptNewAttraction(attraction2);
            park.acceptNewAttraction(attraction3);
        }

        for (int i = 0; i < 2; i++) {
            Dragon dragon=new Dragon(new Random().nextInt(4000)+1800,300);
            DangerousAttraction attraction1=new DangerousAttraction("Dragon Attr", dragon);

            Devil devil=new Devil(new Random().nextInt(400)+180);
            DangerousAttraction attraction2=new DangerousAttraction("Devil Attr", devil);

            Mermaid mermaid=new Mermaid(new Random().nextInt(400)+180,100,"Brown");
            DangerousAttraction attraction3=new DangerousAttraction("Mermaid Attr", mermaid);
            park.acceptNewAttraction(attraction1);
            park.acceptNewAttraction(attraction2);
            park.acceptNewAttraction(attraction3);
        }

        park.generatePriceList();

        for (int i = 0; i < 100; i++) {
            Client client;
            Client.Gender gender=new Random().nextBoolean()? Client.Gender.MALE: Client.Gender.FEMALE;
            int chance = new Random().nextInt(3);
            switch ( chance){
                case 0:
                    client=new Kid("Kid "+i, new Random().nextInt(13)+5,gender);
                    break;
                case 1:
                    client=new Adult("Adult "+i, new Random().nextInt(40)+18,gender);
                    break;
                default:
                    client=new Retired("Retired "+i, new Random().nextInt(40)+60,gender);
                    break;
            }
            park.acceptClient(client);
        }


        List<Client> clients=park.getClients();
        for(Client client: clients){
            for (int i = 0; i < 2; i++) {
                client.visitAttraction();
            }
        }

        park.printIncomes();
        park.printNumberOfKids();
        park.printSwallowedClients();
        park.generateReportBeast();
        park.devilSouls();
        park.burnedHumans();
        park.middleAgeOfKidnappedByMermaid();
        park.mostVisitedAttraction();
        park.ratioClientsExtremeAttractions();
    }
}
