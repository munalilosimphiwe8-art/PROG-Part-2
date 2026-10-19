package com.mycompany.quickchat_part2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Message {

    private String messageID;
    private int messageNumber;
    private String recipient;
    private String message;

    private static int totalMessages = 0;

    public Message(int messageNumber, String recipient, String message) {
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.message = message;
        generateMessageID();
    }

    private void generateMessageID() {
        Random random = new Random();
        messageID = String.valueOf(100000000 + random.nextInt(900000000));
    }

    public String checkRecipientCell() {
        if (recipient.startsWith("+27") && recipient.length() == 12) {
            return "Cell phone number successfully captured.";
        }
        return "Cell phone number is incorrectly formatted or does not contain an international code.";
    }

    public String checkMessageLength() {
        if (message.length() <= 250) {
            return "Message ready to send.";
        }

        int extra = message.length() - 250;
        return "Message exceeds 250 characters by " + extra + ", please reduce the size.";
    }

    public String createMessageHash() {

        if (message == null || message.trim().isEmpty()) {
            return "Invalid message";
        }

        String[] words = message.trim().split(" ");

        String first = words[0].toUpperCase();
        String last = words[words.length - 1].toUpperCase();

        return messageID.substring(0, 2)
                + ":" + messageNumber
                + ":" + first + last;
    }

    public String sentMessage(int choice) {

        switch (choice) {

            case 1:
                totalMessages++;
                return "Message successfully sent.";

            case 2:
                return "Message disregarded.";

            case 3:
                storeMessage();
                return "Message successfully stored.";

            default:
                return "Invalid option.";
        }
    }

    public String printMessages() {
        return "\nMessage ID: " + messageID +
                "\nHash: " + createMessageHash() +
                "\nRecipient: " + recipient +
                "\nMessage: " + message;
    }

    public static int returnTotalMessages() {
        return totalMessages;
    }

    public static void resetTotalMessages() {
        totalMessages = 0;
    }

    public void storeMessage() {

        try (FileWriter writer = new FileWriter("messages.json", true)) {

            writer.write("{");
            writer.write("\"MessageID\":\"" + messageID + "\",");
            writer.write("\"Recipient\":\"" + recipient + "\",");
            writer.write("\"Message\":\"" + message + "\"");
            writer.write("}\n");

        } catch (IOException e) {
            System.out.println("Error storing message.");
        }
    }
}