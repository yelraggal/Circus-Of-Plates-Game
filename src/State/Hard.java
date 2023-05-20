
package State;

public class Hard implements DifficultyState {

    @Override
    public int getNoOfBars() {
        return 4;
    }

    @Override
    public int getGameSpeed() {
        return 3;
    }
    
}
