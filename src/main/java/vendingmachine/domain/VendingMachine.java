package vendingmachine.domain;

public class VendingMachine {

	private Coins coins;
	private Products products;
	private Money userMoney;

	public void generateVendingMachineCoins(Money vendingMachineMoney) {
		this.coins = new Coins(vendingMachineMoney);
		coins.showStatus();
	}

	public void insertUserMoney(Money userMoney) {
		this.userMoney = userMoney;
	}

	public void addProducts(Products products) {
		this.products = products;
	}

	public boolean isPossibleToSell() {
		return !isSoldOut() && isEnoughUserMoney();
	}

	private boolean isEnoughUserMoney() {
		int minimumProductPrice = products.findMinimumProductPrice();
		return userMoney.isEnough(minimumProductPrice);
	}

	private boolean isSoldOut() {
		return products.isSoldOut();
	}
}
