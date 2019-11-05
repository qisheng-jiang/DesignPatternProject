package interceptingFilter;

//过滤器在请求处理程序执行请求之前或之后，执行某些任务
//filter performs certain tasks before or after the request handler executes the request
public interface Filter {
    void execute(String request);
}
