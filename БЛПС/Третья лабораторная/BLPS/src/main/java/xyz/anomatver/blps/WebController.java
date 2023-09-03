package xyz.anomatver.blps;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @GetMapping(value = "/link", produces = MediaType.TEXT_HTML_VALUE)
    public String link() {
        return """
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <title>Link Telegram Account</title>
            </head>
            <body>
          <script async src="https://telegram.org/js/telegram-widget.js?22" data-telegram-login="blps_bot" data-size="large" data-auth-url="http://127.0.0.1:80/api/users/link" data-request-access="write"></script>
            </body>
            </html>
        """;
    }
}