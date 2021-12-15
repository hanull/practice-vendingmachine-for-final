package vendingmachine.domain;

import vendingmachine.constant.Constant;
import vendingmachine.utils.ValidateUtils;

public class Money {

	private int money;

	public Money(String money) {
		validateInputMoney(money);
		this.money = Integer.parseInt(money);
	}

	private void validateInputMoney(String money) {
		if (!ValidateUtils.isDigit(money)) {
			throw new IllegalArgumentException("숫자가 아니거나, 음수입니다. 양의 정수만 입력해주세요.");
		}
		if (!ValidateUtils.isDivideByMinimumCoin(Integer.parseInt(money))) {
			throw new IllegalArgumentException("10원으로 나누어떨어지지 않습니다.");
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
