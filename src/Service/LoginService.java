package Service;

public class LoginService implements Service{
    public void execute(){
        System.out.println("Successfully Login");
    }

    @Override
    public String getName() {
        return "LoginService";
    }
}
