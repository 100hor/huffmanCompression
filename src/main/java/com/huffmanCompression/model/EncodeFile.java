package com.huffmanCompression.model;

import com.huffmanCompression.file.ByteCodeWriter;
import com.huffmanCompression.file.EncodeFileWriter;

import static com.huffmanCompression.file.FileUtils.read;
import static com.huffmanCompression.model.HuffmanTree.fillHuffmanTree;


import java.io.FileNotFoundException;
import java.io.IOException;

public class EncodeFile {
    private final EncodingTable encodingTable;
    private final String fileContent;
    private final String fileName;

    public EncodeFile(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        //FileUtils fileUtils = new FileUtils();
        this.fileContent = read(fileName);
        CharFrequency charFrequency = new CharFrequency().fillCharFrequencies(fileContent);
        HuffmanTree huffmanTree = new HuffmanTree();
        huffmanTree = fillHuffmanTree(charFrequency.getCharFrequencies());
        this.encodingTable = new EncodingTable();
        encodingTable.fillEncodingArray(huffmanTree.getRoot(), "", "");
    }

    public void createEncodeFile() throws IOException {
        StringBuilder huffmanString = new StringBuilder();
        ByteCodeWriter byteCodeWriter = new ByteCodeWriter("D:\\testfilehf.hf");
        EncodeFileWriter encodeFileWriter = new EncodeFileWriter(encodingTable);
        encodeFileWriter.writeEncodeTable("D:\\testfilehfEncodeTable.txt");

        for (int i = 0; i < fileContent.length(); i++) {
            huffmanString.append(encodingTable.getEncodingArray().get(fileContent.charAt(i)));
        }
        String huffmanCodeString = huffmanString.toString();
        byte[] code = new byte[huffmanCodeString.length()];
        for (int i = 0; i < huffmanCodeString.length(); i++) {
            if (huffmanCodeString.charAt(i) == '0')
            code[i] = 0;
            else code[i] = 1;
        }

        byteCodeWriter.write(code);

    }
}
