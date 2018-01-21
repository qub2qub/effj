package effj.ch12_patterns;

/**
 * Created on 2018-01-21
 */
public class StatePattern1 {
  public class MP3PlayerContext {
    private State state;
    private MP3PlayerContext(State state) {
      this.state= state;
    }
    public void play() {
      state.pressPlay(this);
    }
    public void setState(State state) {
      this.state = state;
    }
    public State getState() {
      return state;
    }
  }
  
  private interface State {
    public void pressPlay(MP3PlayerContext context);
  }
  
  public class StandbyState implements State {
    public void pressPlay(MP3PlayerContext context) {
      context.setState(new PlayingState());
    }
  }
  public class PlayingState implements State {
    public void pressPlay(MP3PlayerContext context) {
      context.setState(new StandbyState());
    }
  }
}
