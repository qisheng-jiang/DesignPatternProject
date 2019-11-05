package interceptingFilter;

//日志输出控制器
//Log output controller

public class DebugFilter implements Filter{
    public void execute(String request){
        System.out.println("request log: " + request);
    }
}
