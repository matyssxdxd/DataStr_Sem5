package DataStr;

import DataStr.nodes.MyEdgeNode;
import DataStr.nodes.MyVerticeNode;

public class MyGraph<T> {
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

    public void addVertice(T element) throws Exception {
        if (element == null) throw new Exception("Element must not be null");
        if (isFull()) resize();
        if (findVerticeByElement(element) != -1) throw new Exception("Element already exists");

        vertices[counter++] = new MyVerticeNode<>(element);
    }

    private int findVerticeByElement(T element){

        for (int i = 0; i < counter; i++) {
            if (vertices[i].getElement().equals(element)) {
                return i;
            }
        }

        return -1;
    }

    public void addEdge(T from, T to, float weight) throws Exception {
        if (from == null || to == null) throw new Exception("from and to must not be null");
        if (weight <= 0 || weight >= 41000) throw new Exception("weight must be between 1 and 40999");
        if (from.equals(to)) throw new Exception("from and to must not be the same");

        int fromIndex = findVerticeByElement(from);
        int toIndex = findVerticeByElement(to);

        if (fromIndex == -1 || toIndex == -1) throw new Exception("Element not found in vertices");

       MyEdgeNode newEdge = new MyEdgeNode(toIndex, weight);

       if (vertices[fromIndex].getFirstEdgeNode() == null) {
           vertices[fromIndex].setFirstEdgeNode(newEdge);
        } else {
           newEdge.setNext(vertices[fromIndex].getFirstEdgeNode());
           vertices[fromIndex].getFirstEdgeNode().setPrev(newEdge);
           vertices[fromIndex].setFirstEdgeNode(newEdge);
       }
    }

    public void print() throws Exception {
        if (isEmpty()) throw new Exception("No elements");

        for (int i = 0; i < counter; i++) {
            System.out.println(vertices[i]);
            MyEdgeNode temp = vertices[i].getFirstEdgeNode();
            while (temp != null) {
                System.out.println(temp + " " + temp.getIndexOfNeighbour());
                temp = temp.getNext();
            }
            System.out.println();
        }
    }
}