package Service;

import java.util.ArrayList;
import java.util.List;

public class Cache {

    private List<Service> services;

    public Cache(){
        services = new ArrayList<Service>();
    }

    //Get the service. If the service is in the cache, get it directly
    public Service getService(String serviceName){
        for (Service service : services) {
            if(service.getName().equalsIgnoreCase(serviceName)){
                System.out.println("Returning cached "+serviceName+" object");
                return service;
            }
        }
        return null;
    }

    //Add service to cache
    public void addService(Service newService){
        boolean exists = false;
        for (Service service : services) {
            if(service.getName().equalsIgnoreCase(newService.getName())){
                exists = true;
            }
        }
        if(!exists){
            services.add(newService);
        }
    }
}