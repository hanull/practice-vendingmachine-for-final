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
		addProducts();
	}

	private void addProducts() {
		try {
			OutputView.printInputProducts();
			vendingMachine.addProducts(InputView.InputProducts());
		} catch (IllegalArgumentException exception) {
			OutputView.printException(exception);
			addProducts();
		}
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
