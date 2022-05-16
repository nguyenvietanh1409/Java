package DemoCollection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;



public class TestCake {
    public static void main(String[] args){
        List<Cake> cakeList = new ArrayList<>();
        cakeList.add(new Cake("Banh Mi",100,"Viet Nam"));
        cakeList.add(new Cake("Black Forest",300,"Germany"));
        cakeList.add(new Cake("Cheese",200,"America"));
        cakeList.add(new Cake("Victoria Sponge",500,"England"));
        cakeList.add(new Cake("Pavlova",400,"New Zealand"));


        System.out.println("- List of best cake on the world!!!");
        System.out.println(cakeList);
        //access element
        Cake bestCake = cakeList.get(0);
        Cake lastCake = cakeList.get(cakeList.size()-1);

        //remove
        cakeList.remove(cakeList.size()-1);
        System.out.println("- Cake list after remove last index");
        System.out.println(cakeList);

        //iterator
        System.out.println("- Cake list after use iterator:");
        Iterator<Cake> cakeIterator = cakeList.iterator();

        while (cakeIterator.hasNext()){
            Cake cake = cakeIterator.next();
            System.out.println(cake);
        }

        //search
        boolean isThat;
        cakeList.forEach(cake -> {
            if (cake.getName().contains("Banh Mi")){
                System.out.println("- \"Banh Mi\" is in the top of the best cakes in the world");
            }

        });


        //sort
        cakeList.sort(Comparator.comparing(Cake::getPrice));
        System.out.println("- Cake list after sorted by price: \n"+cakeList);
    }
}
