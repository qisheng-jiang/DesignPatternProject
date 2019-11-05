package patternTest;

import farm.Farmer;
import farm.Owner;
import financial.PayProxy;

public class ProxyTest {
    public static void proxyTest() {
        System.out.println("\n------Proxy Pattern------\n");

        Owner owner = new Owner();
        Farmer farmer = new Farmer();

        PayProxy payWithPermission = new PayProxy(owner.getPermission());
        PayProxy payWithoutPermission = new PayProxy(farmer.getPermission());

        System.out.println("Owner:");
        payWithPermission.welcome();
        payWithPermission.pay();
        System.out.println("\nFarmer:");
        payWithoutPermission.welcome();
        payWithoutPermission.pay();
    }

    public static void main(String[] args) {
        proxyTest();
    }
}
