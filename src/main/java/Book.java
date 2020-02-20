public class Book {

    int id;

    int weight;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", weight=" + weight +
                '}';
    }
}
