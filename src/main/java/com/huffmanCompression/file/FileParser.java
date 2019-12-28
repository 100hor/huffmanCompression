package com.huffmanCompression.file;

public interface FileParser<T> {

    T parse(String fileName);

}

