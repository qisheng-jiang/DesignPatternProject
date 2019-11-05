package memento;

//Memento包含了要被恢复的对象的状态
//Memento contains the state of the object to be restored
public class Memento {

    private Object state;

    public Memento(Object state){this.state = state;}

    public Object getState(){return state;}
}
