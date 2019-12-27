package model;

import file.ByteCodeWriter;
import file.FileUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class EncodeFile {
    private final EncodingTable encodingTable;
    private final String fileContent;
    private final String fileName;

    public EncodeFile(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        FileUtils fileUtils = new FileUtils();
        this.fileContent = fileUtils.read(fileName);
        CharFrequency charFrequency = new CharFrequency().fillCharFrequencies(fileContent);
        HuffmanTree huffmanTree = new HuffmanTree();
        huffmanTree.fillHuffmanTree(charFrequency.getCharFrequencies());
        this.encodingTable = new EncodingTable();
        encodingTable.fillEncodingArray(huffmanTree.getRoot(), "", "");
    }

    public void createEncodeFile() throws IOException {
        StringBuilder huffmanString = new StringBuilder();
        ByteCodeWriter byteCodeWriter = new ByteCodeWriter(fileName);

        for (int i = 0; i < fileContent.length(); i++) {
            huffmanString.append(encodingTable.getEncodingArray().get(fileContent.charAt(i)));
        }
        byte[] code = new byte[huffmanString.length()];
        for (int i = 0; i < huffmanString.length(); i++) {
            code[i] = (byte) huffmanString.charAt(i);
        }

        byteCodeWriter.write(code);

    }
}
