package effj.ch12_patterns;

/**
 * Created on 2018-01-21
 */
public class StatePattern2 {
  static class Fighter {
    MartialArtState state;
    public MartialArtState getState() {
      return state;
    }
    public void setState(MartialArtState state) {
      this.state = state;
    }
    public String action() {
      return state.fight();
    }
  }
  
  interface MartialArtState {
    String fight();
  }
  static class Karate implements MartialArtState {
    @Override
    public String fight() {
      return "Karate";
    }
  }
  static class Aikido implements MartialArtState {
    @Override
    public String fight() {
      return "Aikido";
    }
  }
  public static void main(String[] args) {
    // In the TrainingRoom
    Fighter fighter = new Fighter();
    fighter.setState(new Karate());
    System.out.println(fighter.action());
    // learn some aikido
    fighter.setState(new Aikido());
    System.out.println(fighter.action());
  }
  
}
