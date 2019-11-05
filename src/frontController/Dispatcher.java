package frontController;

//调度器,前端控制器可能使用一个调度器对象来调度请求到相应的具体处理程序
//Scheduler, the front controller may use a scheduler object to dispatch requests to the appropriate handler
public class Dispatcher {
    private RanchView ranchView;
    private FarmView farmView;
    private HomeView homeView;
    private StaffView staffView;
    public Dispatcher(){
        ranchView = new RanchView();
        farmView = new FarmView();
        homeView = new HomeView();
        staffView = new StaffView();
    }

    public void dispatch(String request){
        if (request.equalsIgnoreCase("FARM")){
            farmView.show();
        } else if (request.equalsIgnoreCase("Ranch")){
            ranchView.show();
        } else if (request.equalsIgnoreCase("staff")){
            staffView.show();
        } else{
            homeView.show();
        }
    }
}
