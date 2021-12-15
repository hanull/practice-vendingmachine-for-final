package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Money;
import vendingmachine.domain.Products;

public class InputView {
	public static Money InputVendingMachineCoin() {
		return new Money(Console.readLine());
	}

	public static Products InputProducts() {
		String inputProducts = Console.readLine();
		return Products.createProducts(inputProducts);
	}
}
