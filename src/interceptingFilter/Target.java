package interceptingFilter;

//Target对象是请求处理程序接口
//Target object is the request handler interface
public interface Target {
    void execute(String request);
}
