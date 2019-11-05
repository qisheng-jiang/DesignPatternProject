package patternTest;

import State.*;

public class StateTest {
    public static void main(String[] args) {
        System.out.println("\n------State Pattern------\n");
        State state= StateCollection.getState("Unplanted");
        state.showState(1);
    }
}
