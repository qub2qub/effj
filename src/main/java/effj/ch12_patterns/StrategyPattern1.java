package effj.ch12_patterns;

import effj.ch12_patterns.StatePattern2.Fighter;

/**
 * Created on 2018-01-21
 */
public class StrategyPattern1 {
  static class Fighter {
    public void blockWith(Strategy item) {
      System.out.println("Blocked like " + item.getName());
    }
  }
  interface Strategy {
    String getName();
  }
  public static void main(String[] args) {
    // In the TrainingRoom
    Fighter fighter = new Fighter();
    fighter.blockWith(() -> "Brick");
    fighter.blockWith(() -> "Knife");
  }
}
