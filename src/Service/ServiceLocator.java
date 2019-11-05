package Service;

public class ServiceLocator {
    private static Cache cache;

    static {
        cache = new Cache();
    }

    //If there is one in the cache, locate it directly. Otherwise, add the service to the cache.
    public static Service getService(String jndiName){

        Service service = cache.getService(jndiName);

        if(service != null){
            return service;
        }

        InitialContext context = new InitialContext();
        Service service1 = (Service)context.lookup(jndiName);
        cache.addService(service1);
        return service1;
    }
}
