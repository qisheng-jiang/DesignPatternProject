package Service;

public class InitialContext {
    public Object lookup(String jndiName){
        if(jndiName.equalsIgnoreCase("LOGINSERVICE")){
            System.out.println("Looking up and creating a new LoginService object");
            return new LoginService();
        }
        else if (jndiName.equalsIgnoreCase("LOGOUTSERVICE")){
            System.out.println("Looking up and creating a new LogoutService object");
            return new LogoutService();
        }
        return null;
    }
}
