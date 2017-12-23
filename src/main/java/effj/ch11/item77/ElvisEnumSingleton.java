// Enum singleton - the preferred approach - Page 311
package effj.ch11.item77;

import java.util.Arrays;

public enum ElvisEnumSingleton {

    INSTANCE;

    private String[] favoriteSongs = {"Hound Dog", "Heartbreak Hotel"};

    public void printFavorites() {
        System.out.println(Arrays.toString(favoriteSongs));
    }
}