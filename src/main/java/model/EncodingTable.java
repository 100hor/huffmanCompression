package model;

public class EncodingTable {
    private final static int ENCODING_TABLE_SIZE = 127;
    private final int[] charFrequencies;
    private String[] encodingArray;



    public void fillCharFrequencies(String fileContent){
        int [] charFrequencies = new int[ENCODING_TABLE_SIZE];
        for (int i = 0; i < fileContent.length(); i++) {
            charFrequencies[(int)fileContent.charAt(i)]++;
        }

    }

    public void fillEncodingArray(HuffmanTree.Node node, String tmpString, String direction){
        if (node.getLeftNode() == null && node.getRightNode() == null){
            encodingArray[(int)node.getSymbol()] =  tmpString + direction;
        }else {
            fillEncodingArray(node.getLeftNode(), tmpString + direction, "0");
            fillEncodingArray(node.getRightNode(), tmpString + direction, "1");
        }
    }


    public EncodingTable() {
        this.charFrequencies = new int[ENCODING_TABLE_SIZE];
        this.encodingArray = new String[ENCODING_TABLE_SIZE];
    }

    public int[] getCharFrequencies() {
        return charFrequencies;
    }

    public String[] getEncodingArray() {
        return encodingArray;
    }
}
