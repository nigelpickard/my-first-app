package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {

        return ok(index.render("Your new application is ready."));
    }

    public static Result helloWorld() {
        return ok("Hello World!");
    }

    public static Result sayHello(String name) {
        return ok("Hello there " + name + "....");
    }

}
