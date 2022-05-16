package DemoCollection;

public class Cake{
    String name;
    int price;
    String country;

    public Cake(String name, int price, String country){
        this.name = name;
        this.price = price;
        this.country = country;
    }
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "["+name+", "+price+", "+ country+"]";
    }
}
