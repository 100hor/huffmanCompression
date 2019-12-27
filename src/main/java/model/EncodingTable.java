package model;


import java.util.ArrayList;
import java.util.HashMap;

public class EncodingTable {

    //private ArrayList<Table> encodingArray;
    private HashMap<Character, String> encodingArray;


    public EncodingTable() {
        this.encodingArray = new HashMap<>();
    }

    public EncodingTable(EncodingTable encodingTable) {
        this.encodingArray = encodingTable.getEncodingArray();
    }

    public EncodingTable(HashMap<Character, String> encodingArray) {
        this.encodingArray = encodingArray;
    }

    public void fillEncodingArray(HuffmanTree.Node node, String tmpString, String direction) {
        if (node.getLeftNode() == null && node.getRightNode() == null) {
            encodingArray.put(node.getSymbol(), tmpString + direction);
        } else {
            fillEncodingArray(node.getLeftNode(), tmpString + direction, "0");
            fillEncodingArray(node.getRightNode(), tmpString + direction, "1");
        }
    }


    public HashMap<Character, String> getEncodingArray() {
        return encodingArray;
    }

//    static public class Table {
//        private char symbol;
//        private String code;
//
//        public Table(char symbol, String code) {
//            this.symbol = symbol;
//            this.code = code;
//        }
//
//        public char getSymbol() {
//            return symbol;
//        }
//
//        public String getCode() {
//            return code;
//        }
//
//        @Override
//        public String toString() {
//            return symbol + ',' + code + '\n';
//        }
//    }
}
