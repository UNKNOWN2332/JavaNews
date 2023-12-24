package uz.shukrullaev.websocket.message;

/**
 * @author Abdulloh
 * @see uz.shukrullaev.websocket.message
 * @since 12/11/2023 10:13 PM
 */

public class Greeting {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Greeting() {
    }

    public Greeting(String content) {
        this.content = content;
    }
}
