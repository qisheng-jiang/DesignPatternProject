package Tools;

public class Tool extends BaseTool {
    Tool(String name) {
        super(name);
    }
    public void show(){
        System.out.print(getName()+" ");
    }
}
