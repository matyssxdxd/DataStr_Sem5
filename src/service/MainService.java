package service;

import DataStr.MyGraph;

public class MainService {

    public static void main(String[] args) {
        MyGraph<String> testGraph = new MyGraph<>();

        try {
            testGraph.addVertice("Riga");
            testGraph.addVertice("Talsi");
            testGraph.addVertice("Ventspils");
            testGraph.addVertice("Kuldiga");
            testGraph.addVertice("Tukums");

            testGraph.addEdge("Ventspils", "Riga", 189);
            testGraph.addEdge("Ventspils", "Kuldiga", 56.49f);
            testGraph.addEdge("Ventspils", "Talsi", 64f);
            testGraph.addEdge("Tukums", "Riga", 58);
            testGraph.addEdge("Riga", "Kuldiga", 148.88f);

            testGraph.print();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
