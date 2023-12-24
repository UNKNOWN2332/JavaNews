package uz.shukrullaev.websocket.message;

/**
 * @author Abdulloh
 * @see uz.shukrullaev.websocket.message
 * @since 12/11/2023 10:12 PM
 */

public class HelloMessage {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HelloMessage() {
    }

    public HelloMessage(String name) {
        this.name = name;
    }
}
