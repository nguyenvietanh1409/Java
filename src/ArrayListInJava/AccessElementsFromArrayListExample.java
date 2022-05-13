package ArrayListInJava;

import java.util.ArrayList;
import java.util.List;

public class AccessElementsFromArrayListExample {
    public static void main(String[] args){
        List<String> topCompanies = new ArrayList<>();
        System.out.println("Is the topCompanies list emty?: "+ topCompanies.isEmpty());

        topCompanies.add("Google");
        topCompanies.add("Apple");
        topCompanies.add("Microsoft");
        topCompanies.add("Amazone");
        topCompanies.add("Facebook");

        System.out.println("Here are the top "+topCompanies.size()+ " companies in the world");
        System.out.println(topCompanies);

        String bestCompany = topCompanies.get(0);
        String secondCompany = topCompanies.get(1);
        String lastCompany = topCompanies.get(topCompanies.size() - 1);

        System.out.println("Best company: "+ bestCompany);
        System.out.println("Second company: "+ secondCompany);
        System.out.println("Last company: "+ lastCompany);

        topCompanies.set(4,"Walmart");
        System.out.println("Modified top companies list: "+ topCompanies);

    }
}
