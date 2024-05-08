package DataStr;

import DataStr.nodes.MyVerticeNode;

public class MyGraph {
    private MyVerticeNode[] vertices;
    private final int GRAPH_DEFAULT_SIZE = 10;
    private int size = GRAPH_DEFAULT_SIZE;
    private int counter = 0;

    public MyGraph() {
        vertices = new MyVerticeNode[size];
    }

    public MyGraph(int inputSize) {
        if (inputSize > 0) {
            size = inputSize;
        }

        vertices = new MyVerticeNode[size];
    }

    public boolean isEmpty() {
        return counter == 0;
    }

    public boolean isFull() {
        return counter == size;
    }

    public int howManyElements() {
        return counter;
    }

    private void resize() {
        int newSize = (counter > 100) ? (int)(size * 1.5) : size * 2;

        MyVerticeNode[] verticesNew = new MyVerticeNode[newSize];

        System.arraycopy(vertices, 0, verticesNew, 0, counter);

        vertices = verticesNew;

        System.gc();

        size = newSize;
    }
}
