import model.EncodeFile;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        if (args.length == 1 && args[0].endsWith("txt")) {
            try {
                EncodeFile encodeFile = new EncodeFile(args[0]);
                encodeFile.createEncodeFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
