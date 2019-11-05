package Tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class Bag extends BaseTool {
    protected List<BaseTool> myBag=new ArrayList<>();

    public Bag(BaseTool...components){
        super("Package");
        add(components);
    }

    //Add a BaseTool into the bag
    public void add(BaseTool component){
        myBag.add(component);
    }

    //Put a bag which contains several tools in a bigger bag
    public void add(BaseTool...components){
        myBag.addAll(Arrays.asList(components));
    }

    //Take one BaseTool out of the bag
    public void remove(BaseTool component){
        myBag.remove(component);
    }

    //Take a smaller bag out of the bigger bag
    public void remove(BaseTool...components){
        myBag.removeAll(Arrays.asList(components));
    }

    /*public void show(){
        ListIterator<BaseTool> it = myBag.listIterator();
        while(it.hasNext()){
            BaseTool bt = (BaseTool)it.next();
            bt.show();
        }
    }*/
    @Override
    public void show(Integer level){
        String s=new String("-");
        for(Integer i=0;i<level;i++){
            s=s+"-";
        }
        for(BaseTool b:myBag){
            System.out.println(s+b.getName());
            if(b.getName()=="Package") {
                b.show(level+2);
            }
        }
    }
}

