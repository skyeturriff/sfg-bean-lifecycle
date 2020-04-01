package guru.springframework.sfgdi;

import guru.springframework.sfgdi.controllers.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgBeanLifecycleDemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SfgBeanLifecycleDemoApplication.class, args);

		System.out.println("## SfgDiApplication - Requesting the ExampleController from the Context!");
		ExampleController exampleController = (ExampleController) ctx.getBean("exampleController");
		System.out.println(exampleController.doSomething());
	}

}
