package com.huffmanCompression.file;

import java.io.FileInputStream;
import java.io.IOException;

public class ByteCodeParser implements FileParser<String> {


    @Override
    public String parse(String fileName) {
        try (FileInputStream fin = new FileInputStream(fileName)) {
            StringBuilder code = new StringBuilder();
            int i = -1;
            while ((i = fin.read()) != -1) {
                code.append((char)i);
            }
            return code.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
