package Model;

public class Dish {
    public String id;
    public String name;
    public String price;
    public String rating;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Dish(String id, String name, String price, String rating) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }
}
