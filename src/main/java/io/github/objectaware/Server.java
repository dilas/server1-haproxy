package io.github.objectaware;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.ModelAndView;
import spark.Request;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Server {
    static Logger logger = LoggerFactory.getLogger(Server.class);

    // utility method to log requests
    private static String requestInfoToString(Request request) {
        StringBuilder sb = new StringBuilder();
        sb.append(request.ip() + " - ");
        sb.append(request.requestMethod());
        sb.append(" " + request.url());
        sb.append(" " + request.body());
        return sb.toString();
    }

    // utility method to render templates
    private static String render(Map<String, Object> model, String templatePath) {
        return new FreeMarkerEngine().render(new ModelAndView(model, templatePath));
    }

    public static void main(String[] args) {
        // starts the server on specified port
        port(Integer.parseInt(args[0]));

        // log every request
        before((request, response) -> {
            logger.info(requestInfoToString(request));
        });

        // default route
        get("/", (request, response) -> {
            Map<String, Object>  model = new HashMap<>();
            model.put("serverPort", port());
            model.put("request", request);
            return render(model, "request.ftl");
        });

        get("/app1", (request, response) -> {
            Map<String, Object>  model = new HashMap<>();
            model.put("serverPort", port());
            model.put("request", request);
            return render(model, "app1.ftl");
        });

        get("/app2", (request, response) -> {
            Map<String, Object>  model = new HashMap<>();
            model.put("serverPort", port());
            model.put("request", request);
            return render(model, "app2.ftl");
        });

        get("/appX", (request, response) -> "Application X");
    }
}
