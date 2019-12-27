package file;

import model.EncodingTable;

import java.util.HashMap;
import java.util.Map;

public class EncodeFileWriter {

    private final EncodingTable encodingTable;

    public EncodeFileWriter(EncodingTable encodingTable) {
        this.encodingTable = encodingTable;
    }


    public void writeEncodeTable(String fileName) {
        FileUtils fileUtils = new FileUtils();

        for (Map.Entry<Character, String> pair: encodingTable.getEncodingArray().entrySet()){
            fileUtils.write(fileName, pair.getKey() + ',' + pair.getValue() +'\n');
        }

    }


}
