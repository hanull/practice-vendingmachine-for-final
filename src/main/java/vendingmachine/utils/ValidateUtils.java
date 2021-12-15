package vendingmachine.utils;

import java.util.regex.Pattern;

import vendingmachine.constant.Constant;

public class ValidateUtils {

	public static boolean isDigit(String money) {
		for (char number : money.toCharArray()) {
			if (!Character.isDigit(number)) {
				return false;
			}
		}
		return true;
	}

	public static boolean isDivideByMinimumCoin(int money) {
		return money % Constant.MINIMUM_COIN == Constant.ZERO;
	}

	public static boolean isValidProductInformation(String productInformation) {
		return Pattern.matches(Constant.PRODUCT_REGULAR_EXPRESSION, productInformation);
	}
}
