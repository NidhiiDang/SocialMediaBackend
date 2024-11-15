package com.nidhi.social_media.Controller;


import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class SwaggerController {


        @Hidden //to default routes
        @RequestMapping(value = "/") // here / means ${server.servlet.context-path}
        public void redirect(HttpServletRequest req, HttpServletResponse res) throws IOException {
            res.sendRedirect("swagger-ui/index.html");
        }
}

