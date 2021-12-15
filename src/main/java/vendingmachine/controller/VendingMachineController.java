package vendingmachine.controller;

import vendingmachine.domain.Money;
import vendingmachine.domain.Product;
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
		OutputView.printVendingMachineCoin();
		vendingMachine.generateVendingMachineCoins(vendingMachineMoney);
		addProducts();
		Money userMoney = getUserMoney();
		vendingMachine.insertUserMoney(userMoney);
		purchaseProduct();
		vendingMachine.returnChanges();
	}

	private void purchaseProduct() {
		while (vendingMachine.isPossibleToSell()) {
			vendingMachine.showUserMoneyStatus();
			selectProduct();
		}
	}

	private Product selectProduct() {
		try {
			OutputView.printInputSelectProduct();
			return vendingMachine.selectProduct(InputView.inputSelectProduct());
		} catch (IllegalArgumentException exception) {
			OutputView.printException(exception);
			return selectProduct();
		}
	}

	private Money getUserMoney() {
		try {
			OutputView.printInputUserMoney();
			return InputView.inputUserMoney();
		} catch (IllegalArgumentException exception) {
			OutputView.printException(exception);
			return getUserMoney();
		}
	}

	private void addProducts() {
		try {
			OutputView.printInputProducts();
			vendingMachine.addProducts(InputView.inputProducts());
		} catch (IllegalArgumentException exception) {
			OutputView.printException(exception);
			addProducts();
		}
	}

	private Money getVendingMachineMoney() {
		try {
			OutputView.printInputVendingMachineCoin();
			return InputView.inputVendingMachineCoin();
		} catch (IllegalArgumentException exception) {
			OutputView.printException(exception);
			return getVendingMachineMoney();
		}
	}
}
