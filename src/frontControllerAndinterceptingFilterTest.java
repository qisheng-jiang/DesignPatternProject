import frontController.FrontController;
import interceptingFilter.AuthenticationFilter;
import interceptingFilter.Client;
import interceptingFilter.DebugFilter;
import interceptingFilter.FilterManager;

public class frontControllerAndinterceptingFilterTest {
    public static void frontControllerAndinterceptingFilterTest(){

        //Processing the request is scene switching, so frontcontroller is used as the target object to process the request
        //test Front Controller and interceptingFilter
        System.out.println("\n------Front Controller Pattern and Intercepting Filter Pattern-------\n");
        FilterManager filterManager = new FilterManager(new FrontController());
        filterManager.setFilter(new AuthenticationFilter());
        filterManager.setFilter(new DebugFilter());
        Client client = Client.getInstance();
        client.setFilterManager(filterManager);
        //Make initial page request (front controller mode)
        client.sendRequest("HOME");
        //Make farm page request (front controller mode)
        client.sendRequest("FARM");
        //Make ranch page request (front controller mode)
        client.sendRequest("RANCH");
        //Make staff page request (front controller mode)
        client.sendRequest("STAFF");

    }
}
