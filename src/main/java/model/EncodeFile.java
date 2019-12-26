package model;

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

    private byte[] getFileContentByBytes(){
        for (int i = 0; i < fileContent.length(); i++){
            fileContent.charAt(i);
        }




        return new byte[]{};
    }
}
