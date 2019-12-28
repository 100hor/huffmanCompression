package com.huffmanCompression;

import com.huffmanCompression.file.ByteCodeParser;
import com.huffmanCompression.file.EncodeFileParser;
import com.huffmanCompression.model.DecodeFile;
import com.huffmanCompression.model.EncodeFile;

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
        }else if (args.length == 2 && args[0].endsWith("hf")){
            ByteCodeParser byteCodeParser = new ByteCodeParser();
            EncodeFileParser encodeFileParser = new EncodeFileParser();
            DecodeFile decodeFile = new DecodeFile(encodeFileParser.parse(args[0]), byteCodeParser.parse(args[1]));

        }
    }
}
