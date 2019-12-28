package com.huffmanCompression.model;

public class CharFrequency {
    private final static int ENCODING_TABLE_SIZE = 127;
    private final int[] charFrequencies;


    public CharFrequency() {
        this.charFrequencies = new int[ENCODING_TABLE_SIZE];
    }

    public CharFrequency(int[] charFrequencies) {
        if (charFrequencies.length == ENCODING_TABLE_SIZE)
            this.charFrequencies = charFrequencies;
        else throw new RuntimeException("different table size");
    }

    public CharFrequency fillCharFrequencies(String fileContent) {
        int[] tmp = new int[ENCODING_TABLE_SIZE];
        for (int i = 0; i < fileContent.length(); i++) {
            tmp[(int) fileContent.charAt(i)]++;
        }//end of file
        return new CharFrequency(tmp);
    }

    public int[] getCharFrequencies() {
        return charFrequencies;
    }
}
