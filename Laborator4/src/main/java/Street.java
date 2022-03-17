import java.util.Arrays;

public class Street implements Comparable<Street> {
    private String name;
    private int length;
    private Intersection[] ends;

    public Street() {
        this.name = "";
        this.length = 0;
        this.ends = new Intersection[2];
    }

    public Street(String name, int length, Intersection e1, Intersection e2) {
        this.name = name;
        this.length = length;
        this.ends = new Intersection[2];
        ends[0] = e1;
        ends[1] = e2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Intersection[] getEnds() {
        return ends;
    }

    public void setEnds(Intersection[] ends) {
        this.ends = ends;
    }

    @Override
    public String toString() {
        return "Street{" +
                "name='" + name + '\'' +
                ", length=" + length +
                ", ends=" + Arrays.toString(ends) +
                '}';
    }

    @Override
    public int compareTo(Street other) {
        if (this.getName() != null && other.getName() != null)
            return this.name.compareTo(other.name);
        else {
            System.out.println("Null name!");
            return 0;
        }
    }
}
