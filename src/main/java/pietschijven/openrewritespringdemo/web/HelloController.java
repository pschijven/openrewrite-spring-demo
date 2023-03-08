package pietschijven.openrewritespringdemo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HelloController {

    private final String baseMessage = "Hello request";

    @GetMapping("/hello")
    public String hello(ServletRequest servletRequest){
        String semicolon = ": ";
        if ((servletRequest != null)) {
            return getString((HttpServletRequest) servletRequest, semicolon, baseMessage);
        }
        return "no request";
    }

    private static String getString(HttpServletRequest servletRequest, String semicolon, String message) {
        return message + semicolon + servletRequest
                .getRequestURI();
    }

}
