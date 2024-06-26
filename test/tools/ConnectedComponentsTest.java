package tools;


import main.DuplicateTagException;
import main.UnDiGraph;
import main.Vertex;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;


class ConnectedComponentsTest {

    @Test
    void testFind4AGraphOfOneNode() throws DuplicateTagException {
        UnDiGraph g = new UnDiGraph();
        g.addVertex("A");
        ConnectedComponents ccFinder = new ConnectedComponents(g);
        Map<Vertex,Integer> cc = ccFinder.find();
        assertEquals(1,ccFinder.getMaxConnectedComponentNumber());
        assertEquals(1,cc.size());
        assertEquals(1,cc.get(g.getVertex("A")));
    }
    @Test
    void find4AGraphOfTwoNodes() throws DuplicateTagException {
        UnDiGraph g = new UnDiGraph();
        Vertex a = g.addVertex("A");
        Vertex b = g.addVertex("B");
        ConnectedComponents ccFinder = new ConnectedComponents(g);
        Map<Vertex,Integer> cc = ccFinder.find();
        assertEquals(2,ccFinder.getMaxConnectedComponentNumber());
        assertEquals(2,cc.size());
        assertNotEquals(cc.get(g.getVertex("B")),cc.get(g.getVertex("A")), "they should not be in the same connected component");
        //We add an edge between A and B
        g.addEdge(a,b);
        ccFinder = new ConnectedComponents(g);
        cc = ccFinder.find();
        assertEquals(1,ccFinder.getMaxConnectedComponentNumber());
        assertEquals(2,cc.size());
        assertEquals(1,cc.get(g.getVertex("A")));
        assertEquals(1,cc.get(g.getVertex("B")), "they should be in the same connected component");
    }


    @Test
    void find4AGraphU1() {
        UnDiGraph g = GraphReader.unDiGraph("A B C D C E D E E F G H G K H I H J H K I J");
        ConnectedComponents ccFinder = new ConnectedComponents(g);
        Map<Vertex,Integer> cc = ccFinder.find();
        assertEquals(3,ccFinder.getMaxConnectedComponentNumber());
        assertEquals(11,cc.size());
        assertEquals(cc.get(g.getVertex("A")),cc.get(g.getVertex("B")));
        List<Vertex> vertices = new ArrayList<>();
            vertices.add(g.getVertex("D"));
            vertices.add(g.getVertex("E"));
            vertices.add(g.getVertex("F"));
        vertices.parallelStream().forEach(v -> assertEquals(cc.get(g.getVertex("C")),cc.get(v)));
        vertices = new ArrayList<>() {{
            add(g.getVertex("H"));
            add(g.getVertex("I"));
            add(g.getVertex("J"));
            add(g.getVertex("K"));
        }};
        vertices.parallelStream().forEach(v -> assertEquals(cc.get(g.getVertex("G")),cc.get(v)));

    }

    @Test
    void find4AGraphU2() {
        UnDiGraph g = GraphReader.unDiGraph("A D A E A J B C B F B G B I C F C G C H D E D F G H");
        ConnectedComponents ccFinder = new ConnectedComponents(g);
        Map<Vertex,Integer> cc = ccFinder.find();
        assertEquals(1,ccFinder.getMaxConnectedComponentNumber());
        List<Vertex> vertices= new ArrayList<>() {{
            add(g.getVertex("A"));
            add(g.getVertex("B"));
            add(g.getVertex("C"));
            add(g.getVertex("D"));
            add(g.getVertex("E"));
            add(g.getVertex("F"));
            add(g.getVertex("G"));
            add(g.getVertex("H"));
            add(g.getVertex("I"));
        }};
        vertices.parallelStream().forEach(v -> assertEquals(1,cc.get(v)));

    }

    /*
        * Test the method getConnectedComponentsTo
        * a -- b
        * c -- d  d-- e c--e
        *
     */
    @Test
    void testgetConnectedComponentsTo(){
        UnDiGraph g = GraphReader.unDiGraph("A B  C D C E D E");
        ConnectedComponents ccFinder = new ConnectedComponents(g);
        ccFinder.find();
        Set<Vertex> vertices = ccFinder.getConnectedComponentsTo(g.getVertex("C"));
        Logger.getGlobal().info("Vertices: " + vertices);
        assertEquals(3,vertices.size());
        assertTrue(vertices.contains(g.getVertex("C")));
        assertTrue(vertices.contains(g.getVertex("D")));
        assertTrue(vertices.contains(g.getVertex("E")));

        vertices = ccFinder.getConnectedComponentsTo(g.getVertex("A"));
        assertEquals(2,vertices.size());
        assertTrue(vertices.contains(g.getVertex("A")));
        assertTrue(vertices.contains(g.getVertex("B")));

    }
}