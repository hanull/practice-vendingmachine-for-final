package vendingmachine.controller;

import vendingmachine.domain.Money;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
	public void run() {
		Money vendingMachineMoney = getVendingMachineMoney();

	}

	private Money getVendingMachineMoney() {
		try {
			OutputView.printInputVendingMachineCoin();
			return InputView.InputVendingMachineCoin();
		} catch (IllegalArgumentException exception) {
			OutputView.printException(exception);
			return getVendingMachineMoney();
		}
	}
}
