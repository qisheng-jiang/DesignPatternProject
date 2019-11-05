package memento;

//Originator创建并在Memento对象中存储状态
//Originator creates and stores state in Memento objects
public class Originator {

    private Object state;

    public void setState(Object state){
        this.state = state;
    }

    public Object getState(){
        return state;
    }

    public Memento saveStateToMemento(){
        return new Memento(state);
    }

    public void getStateFromMemento(Memento Memento){
        state = Memento.getState();
    }
}
