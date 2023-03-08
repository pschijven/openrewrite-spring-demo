package pietschijven.openrewritespringdemo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloController {

    private final static String base_message = "Hello request";

    @GetMapping("/hello")
    public String hello(ServletRequest servletRequest){
        String semicolon = String.valueOf(": ");;
        if ((servletRequest != null) == true) {
            return getString((HttpServletRequest) servletRequest, semicolon, base_message);
        }
        return "no request";
    }

    private static final String getString(HttpServletRequest servletRequest, String semicolon, String Message) {
        return Message + semicolon + servletRequest
                .getRequestURI();
    }

}
