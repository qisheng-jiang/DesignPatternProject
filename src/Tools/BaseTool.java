package Tools;

public class BaseTool {
    private String name;

    BaseTool(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }
    public void show(){}
    public void show(Integer level){}
}
