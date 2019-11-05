package patternTest;

import Service.*;

public class ServiceLocatorTest {
    public static void main(String[] args) {
        //test login and logout service
        System.out.println("\n------Service Locator Pattern-------\n");
        Service service = ServiceLocator.getService("LoginService");
        service.execute();
        service = ServiceLocator.getService("LogoutService");
        service.execute();
        service = ServiceLocator.getService("LoginService");
        service.execute();
    }
}
