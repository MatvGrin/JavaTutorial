package org.introduction_of_collections_second;

public class FtpArtworkSender implements ArtworkSender{

    @Override
    public void sendArtwork(String artworkPath, Recipient recipient) {
        // здесь следует логика обмена данными
        //по сетевому протоколу FTP ...
        System.out.println("Connecting to FTP server...");
//        System.out.println("Authenticating as user: " + recipient.getName());
//        System.out.println("Uploading file: " + artworkPath + " to recipient at " + recipient.getEmail());
        System.out.println("Transfer complete.");
    }

    @Override
    public String getFriendlyName() {
        return "File Traпsfer Protocol";
    }

    @Override
    public String getShortName() {
        return "ftp";
    }
}
