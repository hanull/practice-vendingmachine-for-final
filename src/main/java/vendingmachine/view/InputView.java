package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Money;

public class InputView {
	public static Money InputVendingMachineCoin() {
		return new Money(Console.readLine());
	}
}
