package model;

public class DecodeFile {
    private final EncodingTable encodingTable;
    private final String byteMessage;

    public DecodeFile(EncodingTable encodingTable, String byteMessage) {
        this.encodingTable = encodingTable;
        this.byteMessage = byteMessage;
    }
}
