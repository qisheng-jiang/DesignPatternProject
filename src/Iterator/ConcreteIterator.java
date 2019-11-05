package Iterator;

import Iterator.Iterator;

import java.util.ArrayList;
import java.util.List;

//具体迭代器
public class ConcreteIterator implements Iterator {
    int index=0;
    private List<Object> list = new ArrayList<Object>();

    public ConcreteIterator(List<Object>list){
        this.list=list;
    }
    @Override
    public boolean hasNext() {
        if(index < list.size()){
            return true;
        }
        return false;
    }
    @Override
    public Object next() {
        Object obj=null;
        if(this.hasNext()){
            obj=this.list.get(index++);
        }
        return obj;
    }
}
