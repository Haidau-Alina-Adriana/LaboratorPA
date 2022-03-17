
public class Intersection {
    private String name;

    public Intersection() {
        this.name = "";
    }

    public Intersection(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Intersection{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Intersection)) {
            return false;
        }
        if (this == obj) return true;
        Intersection other = (Intersection) obj;
        return name.equals(other.name);
    }

}
