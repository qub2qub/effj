// EnumSet - a modern replacement for bit fields - Page 160
package effj.ch06.item32;

import java.util.EnumSet;
import java.util.Set;

public class Text {

//	public static final int STYLE_.BOLD = 1<<0;		//1
//	public static final int STYLE_.ITALIC = 1<<1;	//2
//	public static final int STYLE_UNDERLINE = 1<<2;//4
//	public static final int STYLE_.STRIKETHROUGH = 1<<3;//8

	public enum Style {
		BOLD, ITALIC, UNDERLINE, STRIKETHROUGH
	}

	// Any Set could be passed in, but EnumSet is clearly best
	public void applyStyles(Set<Style> styles) {
		System.out.println("styles = " + styles);
		// Body goes here
	}

	// Sample use
	public static void main(String[] args) {
		Text text = new Text();
		text.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));
		System.out.println("text = " + text);
		String[] arr = new String[2];
		arr[0] = "A";
		arr[1] = "B";
//		arr[2] = "C";
	}
}
