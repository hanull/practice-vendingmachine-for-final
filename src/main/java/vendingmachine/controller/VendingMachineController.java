package vendingmachine.controller;

import vendingmachine.domain.Money;
import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {

	private final VendingMachine vendingMachine;

	public VendingMachineController() {
		this.vendingMachine = new VendingMachine();
	}

	public void run() {
		Money vendingMachineMoney = getVendingMachineMoney();
		vendingMachine.generateVendingMachineCoins(vendingMachineMoney);
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
