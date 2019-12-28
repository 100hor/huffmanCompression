package com.huffmanCompression.file;

import com.huffmanCompression.model.EncodingTable;

import java.util.Map;

public class EncodeFileWriter {

    private final EncodingTable encodingTable;

    public EncodeFileWriter(EncodingTable encodingTable) {
        this.encodingTable = encodingTable;
    }


    public void writeEncodeTable(String fileName) {
        StringBuilder encodingMap = new StringBuilder();
        for (Map.Entry<Character, String> pair : encodingTable.getEncodingArray().entrySet()) {
            encodingMap.append(pair.getKey()).append(',').append(pair.getValue());
        }
        FileUtils.write(fileName, encodingMap.toString());

    }


}
