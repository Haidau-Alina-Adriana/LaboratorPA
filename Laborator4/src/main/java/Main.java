import com.github.javafaker.Faker;
import org.jgrapht.Graph;
import org.jgrapht.alg.spanning.PrimMinimumSpanningTree;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        var nodes = IntStream.rangeClosed(0, 8)
                .mapToObj(i -> new Intersection("v" + i))
                .toArray(Intersection[]::new);

        List<Street> streets = new LinkedList<>();
        streets.add(new Street("s0", 2, nodes[0], nodes[1]));
        streets.add(new Street("s1", 2, nodes[0], nodes[2]));
        streets.add(new Street("s2", 2, nodes[0], nodes[3]));
        streets.add(new Street("s3", 2, nodes[1], nodes[2]));
        streets.add(new Street("s4", 1, nodes[2], nodes[3]));
        streets.add(new Street("s5", 3, nodes[1], nodes[4]));
        streets.add(new Street("s6", 2, nodes[2], nodes[6]));
        streets.add(new Street("s7", 2, nodes[2], nodes[5]));
        streets.add(new Street("s8", 3, nodes[3], nodes[5]));
        streets.add(new Street("s9", 1, nodes[4], nodes[5]));
        streets.add(new Street("s10", 1, nodes[4], nodes[7]));
        streets.add(new Street("s11", 2, nodes[4], nodes[8]));
        streets.add(new Street("s12", 3, nodes[5], nodes[8]));
        streets.add(new Street("s13", 1, nodes[6], nodes[7]));
        streets.add(new Street("s14", 1, nodes[6], nodes[8]));
        streets.add(new Street("s15", 1, nodes[7], nodes[8]));

        Collections.sort(streets, Comparator.comparing(Street::getLength));

        Set<Intersection> intersections = new HashSet<>();
        intersections.addAll(Arrays.asList(nodes));

        for (Intersection i : intersections) {
            for (Intersection j : intersections) {
                if (!i.equals(j) && i.getName().equals(j.getName()))
                    System.out.println("Duplicates: " + i + " " + j);
            }
        }

        Map<Intersection, List<Street>> city = new HashMap<>();
        for (Intersection i : intersections) {
            List<Street> adjacentStreets = new ArrayList<>();
            for (Street s : streets) {
                Intersection[] streetsEnds = s.getEnds();
                if (streetsEnds[0].equals(i) || streetsEnds[1].equals(i)) {
                    adjacentStreets.add(s);
                }
            }
            city.put(i, adjacentStreets);
        }

        Faker faker = new Faker();
        for (Street s : streets) {
            s.setName(faker.name().lastName());
        }
        for (Intersection i : intersections) {
            i.setName(faker.name().lastName());
        }
        City cityMap = new City(city);

        streets.stream()
                .filter(s -> s.getLength() > 1)
                .filter(s -> cityMap.endsSum(s) > 6)
                .forEach(System.out::println);


        Graph<Intersection, DefaultWeightedEdge> graph = createGraph(cityMap);

        PrimMinimumSpanningTree<Intersection, DefaultWeightedEdge> spanningTree = new PrimMinimumSpanningTree<>(graph);
        System.out.println("Solution : " + spanningTree.getSpanningTree());
    }

    private static Graph<Intersection, DefaultWeightedEdge> createGraph(City city) {
        SimpleWeightedGraph<Intersection, DefaultWeightedEdge> g = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
        Map<Intersection, List<Street>> getCity = city.getCityMap();
        for (Intersection i : getCity.keySet()) {
            g.addVertex(i);
        }
        Set<Street> addedStreets = new HashSet<>();
        for (Map.Entry<Intersection, List<Street>> it : getCity.entrySet()) {
            for (int i = 0; i < it.getValue().size(); i++) {
                if (!addedStreets.contains(it.getValue().get(i))) {
                    addedStreets.add(it.getValue().get(i));
                    DefaultWeightedEdge edge = g.addEdge(it.getValue().get(i).getEnds()[0], it.getValue().get(i).getEnds()[1]);
                    g.setEdgeWeight(edge, it.getValue().get(i).getLength());
                }
            }
        }
        return g;
    }
}
