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
		return isNotSoldOut() && isEnoughUserMoney();
	}

	private boolean isEnoughUserMoney() {
		int minimumProductPrice = products.findMinimumProductPrice();
		return userMoney.isEnough(minimumProductPrice);
	}

	private boolean isNotSoldOut() {
		return products.isNotSoldOut();
	}

	public void showUserMoneyStatus() {
		userMoney.showStatus();
	}

	public void selectProduct(String productName) {
		Product purchaseProduct = products.selectProduct(productName);
		purchaseProduct.decrease();
		userMoney.spendMoney(purchaseProduct.getPrice());
	}

	public void returnChanges() {
		userMoney.showStatus();
		Coins userCoins = coins.generateChangeCoin(userMoney);
		userCoins.showChangeStatus();
	}
}
