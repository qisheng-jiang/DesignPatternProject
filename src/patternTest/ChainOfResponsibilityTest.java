package patternTest;

import leave.*;

public class ChainOfResponsibilityTest {

    public static void chainOfResponsibilityTest() {
        System.out.println("\n------Chain of Responsibility Pattern------\n");
        for (int i = 1; i <= 3; ++i) {
            leaveRequestTest(i); // Handle leave request, Chain of Reponsibility Patten Test
        }
    }

    public static void leaveRequestTest(int index) {
        System.out.println("Test Index:" + index);

        RequestHandler directorHandler = new DirectorHandler("DD");
        RequestHandler managerHandler = new ManagerHandler("MM");
        RequestHandler bossHandler = new BossHandler("BB");

        LeaveRequest leaveRequest = new LeaveRequest("Rookie", 10);

        directorHandler.setNext(managerHandler);
        managerHandler.setNext(bossHandler);

        directorHandler.process(leaveRequest);
    }

    public static void main(String[] args) {
        chainOfResponsibilityTest();
    }
}
