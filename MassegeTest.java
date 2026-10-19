package TestClasses;

import com.mycompany.quickchat_part2.Message;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MassegeTest {

    // Test message length success
    @Test
    public void testMessageLengthSuccess() {

        Message msg = new Message(
                1,
                "+27718693002",
                "Hi Mike, can you join us for dinner tonight?"
        );

        assertEquals(
                "Message ready to send.",
                msg.checkMessageLength()
        );
    }

    // Test recipient success
    @Test
    public void testRecipientSuccess() {

        Message msg = new Message(
                1,
                "+27718693002",
                "Hello"
        );

        assertEquals(
                "Cell phone number successfully captured.",
                msg.checkRecipientCell()
        );
    }

    // Test recipient failure
    @Test
    public void testRecipientFailure() {

        Message msg = new Message(
                1,
                "0812345678",
                "Hello"
        );

        assertEquals(
                "Cell phone number is incorrectly formatted or does not contain an international code.",
                msg.checkRecipientCell()
        );
    }

    // Test message hash
    @Test
    public void testMessageHash() {

        Message msg = new Message(
                1,
                "+27718693002",
                "Hi Mike can you join us tonight"
        );

        String hash = msg.createMessageHash();

        assertTrue(hash.contains(":1:"));
    }

    // Test send message
    @Test
    public void testSendMessage() {

        Message msg = new Message(
                1,
                "+27718693002",
                "Hello"
        );

        assertEquals(
                "Message successfully sent.",
                msg.sentMessage(1)
        );
    }

    // Test total messages
    @Test
    public void testReturnTotalMessages() {

        Message.resetTotalMessages();

        Message msg = new Message(
                1,
                "+27718693002",
                "Hello"
        );

        msg.sentMessage(1);

        assertEquals(1, Message.returnTotalMessages());
    }
}