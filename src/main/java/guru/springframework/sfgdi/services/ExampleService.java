package guru.springframework.sfgdi.services;

import org.springframework.stereotype.Service;

/**
 * Just a regular Service Bean the will be injected into
 * the Controller, to demonstrate where it  will show up
 * in the Lifecycle process.
 */
@Service
public class ExampleService implements IExampleService {

    public ExampleService() {
        System.out.println("## I'm in the ExampleService Constructor!");
    }

    @Override
    public String doTheThing() {
        return "Hello World - From the Example Bean!";
    }
}
