package interceptingFilter;

import frontController.FrontController;

//Client 是向 Target 对象发送请求的对象。
//Client is the object that sends the request to the Target object.
public class Client {

    FilterManager filterManager;

    private static Client ourInstance = new Client();

    public static Client getInstance() {
        return ourInstance;
    }

    public void setFilterManager(FilterManager filterManager){
        this.filterManager = filterManager;
    }

    public void sendRequest(String request){
        filterManager.filterRequest(request);
    }

    private Client() {
    }

    public static void main(String[] args) {
        //处理请求为场景切换，因而使用FrontContoller作为target对象，处理请求
        FilterManager filterManager = new FilterManager(new FrontController());
        filterManager.setFilter(new AuthenticationFilter());
        filterManager.setFilter(new DebugFilter());

        Client client = Client.getInstance();
        client.setFilterManager(filterManager);
        client.sendRequest("HOME");
        client.sendRequest("FARM");
        client.sendRequest("RANCH");
    }
}
