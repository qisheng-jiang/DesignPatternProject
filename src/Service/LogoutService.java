package Service;

public class LogoutService implements Service {
    public void execute(){
        System.out.println("Successfully Logout");
    }

    @Override
    public String getName() {
        return "LogoutService";
    }
}
