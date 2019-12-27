package model;

import java.util.ArrayList;

public class EncodeFile {
    private EncodingTable encodingTable;
    private String fileContent;

    public EncodeFile(String fileContent) {
        this.fileContent = fileContent;
        CharFrequency charFrequency = new CharFrequency().fillCharFrequencies(fileContent);
        HuffmanTree huffmanTree = new HuffmanTree();
        huffmanTree.fillHuffmanTree(charFrequency.getCharFrequencies());
        this.encodingTable = new EncodingTable();
        encodingTable.fillEncodingArray(huffmanTree.getRoot(),"", "");
    }

    private String getFileContentInString(){
        StringBuilder huffmanString = new StringBuilder();

        for (int i = 0; i < fileContent.length(); i++){
            huffmanString.append(encodingTable.getEncodingArray().get( fileContent.charAt(i)));
        }





        return huffmanString.toString();
    }
}
