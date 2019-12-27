package file;

import model.EncodingTable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class EncodeFileParser implements FileParser<EncodingTable> {

    @Override
    public EncodingTable parse(String fileName) {
        try {
            HashMap<Character, String> encodingArray = new HashMap<>();
            FileUtils fileUtils = new FileUtils();
            String stringData = fileUtils.read(fileName);

            for (String code : stringData.split("\n")) {
                encodingArray.put(code.split(",")[0].charAt(0), code.split(",")[1]);
            }

            return new EncodingTable(encodingArray);


        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);

        }
    }


}
