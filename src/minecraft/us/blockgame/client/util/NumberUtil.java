package us.blockgame.client.util;

public class NumberUtil {

	public static String getAmplifierNumerals(int amplifier) {
		switch (amplifier) {
		case 0: {
			return " I";
		}
		case 1: {
			return " II";
		}
		case 2: {
			return " III";
		}
		case 3: {
			return " IV";
		}
		case 4: {
			return " V";
		}
		case 5: {
			return " VI";
		}
		case 6: {
			return " VII";
		}
		case 7: {
			return " VIII";
		}
		case 8: {
			return " IX";
		}
		case 9: {
			return " X";
		}
		default: {
			if (amplifier < 1) {
				return "";
			}
			return " " + amplifier + 1;
		}
		}
	}

}
