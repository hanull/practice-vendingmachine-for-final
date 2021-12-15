package vendingmachine.domain;

import vendingmachine.constant.Constant;
import vendingmachine.constant.Message;
import vendingmachine.utils.ValidateUtils;

public class Money {

	private int money;

	public Money(String money) {
		validateInputMoney(money);
		this.money = Integer.parseInt(money);
	}

	private void validateInputMoney(String money) {
		if (!ValidateUtils.isDigit(money)) {
			throw new IllegalArgumentException(Message.ERROR_NOT_DIGIT);
		}
		if (!ValidateUtils.isDivideByMinimumCoin(Integer.parseInt(money))) {
			throw new IllegalArgumentException(Message.ERROR_INVALID_PRICE);
		}
	}

	public boolean hasMoreMoney() {
		return money > Constant.ZERO;
	}

	public void spendMoney(int amount) {
		money -= amount;
	}

	public boolean isOverPay(int pickAmount) {
		return pickAmount > money;
	}
}
