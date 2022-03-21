import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class City {
    private Map<Intersection, List<Street>> cityMap;

    public City() {
        this.cityMap = new HashMap<>();
    }

    public City(Map<Intersection, List<Street>> cityMap) {
        this.cityMap = new HashMap<>();
        this.cityMap = cityMap;
    }

    public Map<Intersection, List<Street>> getCityMap() {
        return cityMap;
    }

    public void setCityMap(Map<Intersection, List<Street>> cityMap) {
        this.cityMap = cityMap;
    }

    public int endsSum(Street e) {
        Intersection[] streetEnds = e.getEnds();
        return cityMap.get(streetEnds[0]).size() + cityMap.get(streetEnds[1]).size() - 2;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityMap=" + cityMap +
                '}';
    }
}