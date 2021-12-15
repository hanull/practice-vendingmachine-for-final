package vendingmachine.domain;

public class VendingMachine {

	private Coins coins;

	public void generateVendingMachineCoins(Money vendingMachineMoney) {
		this.coins = new Coins(vendingMachineMoney);
		coins.showStatus();
	}
}
