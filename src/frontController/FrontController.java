package frontController;

import interceptingFilter.Target;

//前端控制器,处理应用程序所有类型请求的单个处理程序
//Front-end controller, a single handler that handles all types of application requests
public class FrontController implements Target {
    private Dispatcher dispatcher;

    public FrontController(){
        dispatcher = new Dispatcher();
    }

    public void execute(String request){
        dispatcher.dispatch(request);
    }

}
