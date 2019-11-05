package interceptingFilter;

//权限验证控制器
//Authority verification controller
public class AuthenticationFilter implements Filter{
    public void execute(String request){
        System.out.println("Authenticating request: " + request);
    }
}
