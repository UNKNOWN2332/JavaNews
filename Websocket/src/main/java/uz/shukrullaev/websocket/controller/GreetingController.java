package uz.shukrullaev.websocket.controller;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.util.JsonParserDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;
import uz.shukrullaev.websocket.message.Greeting;
import uz.shukrullaev.websocket.message.HelloMessage;

/**
 * @author Abdulloh
 * @see uz.shukrullaev.websocket.controller
 * @since 12/11/2023 10:14 PM
 */

@Controller
public class GreetingController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting hello(HelloMessage helloMessage) throws InterruptedException {
        Thread.sleep(1000);
        JsonEncoding jsonEncoding = JsonEncoding.valueOf("""
                SEND
                destination:/app/hello
                content-length:17

                {"name":"asdasd"}""");
        String javaName = jsonEncoding.getJavaName();
        System.out.println(javaName);
        Greeting greeting = new Greeting("Hello " + HtmlUtils.htmlEscape(helloMessage.getName()) + "!");
        simpMessagingTemplate.convertAndSendToUser(helloMessage.getName(),"/queue/greetings",greeting);
        return greeting;

    }
}
