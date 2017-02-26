// Builder Pattern - Pages 14-15
package effj.ch02.item02.builder;

public class NutritionFacts {
	private final int servingSize;
	private final int servings;
	private final int calories;
	private final int fat;
	private final int sodium;
	private final int carbohydrate;

	private NutritionFacts(NFBuilder builder) {
		servingSize = builder.servingSize;
		servings = builder.servings;
		calories = builder.calories;
		fat = builder.fat;
		sodium = builder.sodium;
		carbohydrate = builder.carbohydrate;
	}

	public static class NFBuilder implements Builder<NutritionFacts> {
		// Required parameters
		private final int servingSize;
		private final int servings;

		// Optional parameters - initialized to default values
		private int calories = 0;
		private int fat = 0;
		private int carbohydrate = 0;
		private int sodium = 0;

		public NFBuilder(int servingSize, int servings) {
			this.servingSize = servingSize;
			this.servings = servings;
		}

		public NFBuilder calories(int val) {
			calories = val;
			return this;
		}

		public NFBuilder fat(int val) {
			fat = val;
			return this;
		}

		public NFBuilder carbohydrate(int val) {
			carbohydrate = val;
			return this;
		}

		public NFBuilder sodium(int val) {
			sodium = val;
			return this;
		}

		public NutritionFacts build() {
			return new NutritionFacts(this);
		}
	}

	public static void main(String[] args) {

		Builder<NutritionFacts> builder = new NFBuilder
				(240, 8)
				.calories(100)
				.sodium(35)
				.carbohydrate(27);

		NutritionFacts cocaCola = builder.build();
		System.out.println("builder = " + builder);
		System.out.println("cocaCola = " + cocaCola);
	}
}