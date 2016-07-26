import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

/**
 * Created by Daniel Solo on 26.07.2016.
 */
public class Bootstrap {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        Bootstrap bootstrap = applicationContext.getBean("bootstrap", Bootstrap.class);
        bootstrap.execute();
    }

    public void execute(){
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        ParserImpl parser = new ParserImpl();
        Provider provider = new Provider();
        Multiply multiply = new Multiply();
        Divide divide = new Divide();

        provider.initialize();
        provider.initExtraOperation(multiply);
        provider.initExtraOperation(divide);
        provider.getAllOperations();
        calculator.setOperations(provider.getAllOperations());
        calculator.setParser(parser);

        System.out.println("Please enter numbers you want yo count in this format:(number/operator/number)");
        String task = scanner.nextLine();

        System.out.println("Result: " + task + '=' + calculator.calculate(task));
    }
}
