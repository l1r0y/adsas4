import java.util.*;

public class DijkstraSearch<V> implements Search<V> {

    @Override
    public List<Vertex<V>> search(Vertex<V> start, Vertex<V> end) {
        Map<Vertex<V>, Double> distances = new HashMap<>();
        Map<Vertex<V>, Vertex<V>> previous = new HashMap<>();
        PriorityQueue<Vertex<V>> pq = new PriorityQueue<>(Comparator.comparing(distances::get));

        for (Vertex<V> vertex : start.getAdjacentVertices().keySet()) {
            distances.put(vertex, Double.POSITIVE_INFINITY);
        }
        distances.put(start, 0.0);
        pq.add(start);

        while (!pq.isEmpty()) {
            Vertex<V> current = pq.poll();
            if (current.equals(end)) {
                return constructPath(previous, end);
            }
            for (Map.Entry<Vertex<V>, Double> adjacencyPair : current.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = adjacencyPair.getKey();
                double edgeWeight = adjacencyPair.getValue();
                double newDist = distances.get(current) + edgeWeight;

                if (newDist < distances.getOrDefault(neighbor, Double.POSITIVE_INFINITY)) {
                    distances.put(neighbor, newDist);
                    previous.put(neighbor, current);
                    pq.add(neighbor);
                }
            }
        }
        return Collections.emptyList();
    }

    private List<Vertex<V>> constructPath(Map<Vertex<V>, Vertex<V>> previous, Vertex<V> end) {
        List<Vertex<V>> path = new LinkedList<>();
        for (Vertex<V> at = end; at != null; at = previous.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);
        return path;
    }
}