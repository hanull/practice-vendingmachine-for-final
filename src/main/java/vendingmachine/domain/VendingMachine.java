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

	public Product selectProduct(String productName) {
		Product selectProduct = products.selectProduct(productName);
		userMoney.spendMoney(selectProduct.getPrice());
		return selectProduct;
	}

	public void returnChanges() {
		userMoney.showStatus();
		Coins userCoins = coins.generateChangeCoin(userMoney);
		userCoins.showChangeStatus();
	}
}
