package DataStr.nodes;

public class MyEdgeNode {

    private int indexOfNeighbour;
    private float weight;
    private MyEdgeNode next = null;
    private MyEdgeNode prev = null;

    public int getIndexOfNeighbour() {
        return indexOfNeighbour;
    }

    public float getWeight() {
        return weight;
    }

    public MyEdgeNode getNext() {
        return next;
    }

    public MyEdgeNode getPrev() {
        return prev;
    }

    public void setIndexOfNeighbour(int indexOfNeighbour) {
        if (indexOfNeighbour > 0)
            this.indexOfNeighbour = indexOfNeighbour;
        else
            this.indexOfNeighbour = -1;
    }

    public void setWeight(float weight) {
        if (weight > 0 && weight < 50000)
            this.weight = weight;
        else
            this.weight = 0;
    }

    public void setNext(MyEdgeNode next) {
        this.next = next;
    }

    public void setPrev(MyEdgeNode prev) {
        this.prev = prev;
    }

    public MyEdgeNode(int indexOfNeighbour, float weight) {
        setIndexOfNeighbour(indexOfNeighbour);
        setWeight(weight);
    }
}
