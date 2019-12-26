package model;

import java.util.ArrayList;
import java.util.HashMap;

public class EncodingTable {

    private HashMap<Character, String> encodingArray;


    public EncodingTable() {
        this.encodingArray = new HashMap<>();
    }


    public void fillEncodingArray(HuffmanTree.Node node, String tmpString, String direction) {
        if (node.getLeftNode() == null && node.getRightNode() == null) {
            encodingArray.put(node.getSymbol(), tmpString + direction);
        } else {
            fillEncodingArray(node.getLeftNode(), tmpString + direction, "0");
            fillEncodingArray(node.getRightNode(), tmpString + direction, "1");
        }
    }

    @Override
    public String toString() {
        return "EncodingTable{" +
                "encodingArray=" + encodingArray +
                '}';
    }

    public HashMap<Character, String> getEncodingArray() {
        return encodingArray;
    }


}
