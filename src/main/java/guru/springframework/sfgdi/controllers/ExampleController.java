package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.ExampleService;
import org.springframework.stereotype.Controller;

/**
 * Just a regular Controller Bean to demonstrate where it
 * will show up in the Lifecycle process.
 */
@Controller
public class ExampleController {

    private final ExampleService exampleService;

    public ExampleController(ExampleService exampleService) {
        System.out.println("## I'm in the ExampleController Constructor!");
        this.exampleService = exampleService;
    }

    public String doSomething(){
        return exampleService.doTheThing();
    }
}
