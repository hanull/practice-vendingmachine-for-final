package vendingmachine.domain;

public class VendingMachine {

	private Coins coins;
	private Products products;

	public void generateVendingMachineCoins(Money vendingMachineMoney) {
		this.coins = new Coins(vendingMachineMoney);
		coins.showStatus();
	}

	public void addProducts(Products products) {
		this.products = products;
	}
}
