// Using a nested EnumMap to associate data with enum pairs - Pags 163-164
package effj.ch06.item33;

import java.util.EnumMap;
import java.util.Map;

public enum Phase {
	SOLID, LIQUID, GAS, PLASMA;

	// cannot extend because enum is final
//	enum Ph extends Phase {}

	public enum Transition {
		MELT(SOLID, LIQUID),
		SUBLIME(SOLID, GAS),
		FREEZE(LIQUID, SOLID),
		BOIL(LIQUID, GAS),
		CONDENSE(GAS, LIQUID),
		DEPOSIT(GAS, SOLID),
		IONIZE(GAS, PLASMA),
		DEIONIZE(PLASMA, GAS)
		;

		private final Phase src;
		private final Phase dst;

		Transition(Phase src, Phase dst) {
			this.src = src;
			this.dst = dst;
		}

		// Initialize the phase transition map
		private static final Map<Phase, Map<Phase, Transition>> map = new EnumMap<>( Phase.class );
		static {
			//initializes the outer map to contain the three empty inner maps
			for (Phase p : Phase.values()) { // value=состояние
				// 1я мапа - ключ=состояние, значение = 2я мапа(состояние, физич.процесс)
				map.put(p, new EnumMap<Phase, Transition>( Phase.class ) );
			}
			// initializes the inner maps using the source and destination information
			// provided by each state transition constant.
			for (Transition trans : Transition.values()) { // value=физич.процесс.
				// берём 2ю мапу для каддого состояния,
				// и в неё кладём результат:
				// (каким физич процессом мы переведём в другое состояние)
				map.get(trans.src).put(trans.dst, trans);
//				this.src = null;
			}
		}

		public static Transition from(Phase src, Phase dst) {
			return map.get(src).get(dst);
		}
	}

	// Simple demo program - prints a sloppy table
	public static void main(String[] args) {
		for (Phase src : Phase.values())
			for (Phase dst : Phase.values())
				if (src != dst)
//					System.out.printf("%s to %s : %s %n", src, dst, Transition.from(src, dst));
				{
					Transition trans = Transition.from(src, dst);
//					if (trans!=null)
						System.out.printf("[%s] ->\t %s ->\t [%s]  %n", src, trans, dst);
				}
	}
}
