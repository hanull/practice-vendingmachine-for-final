package vendingmachine.domain;

import java.util.EnumMap;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.constant.Constant;
import vendingmachine.view.OutputView;

public class Coins {

	private Map<Coin, Integer> coins;

	public Coins(Money vendingMachineMoney) {
		this.coins = initialize();
		vendingMachineMoneyChangeToCoin(vendingMachineMoney);
	}

	public Coins(Map<Coin, Integer> changeCoins) {
		this.coins = changeCoins;
	}

	private void vendingMachineMoneyChangeToCoin(Money vendingMachineMoney) {
		while (vendingMachineMoney.hasMoreMoney()) {
			int pickAmount = Randoms.pickNumberInList(Coin.getList());
			if (vendingMachineMoney.isOverPay(pickAmount)) {
				continue;
			}
			Coin pickCoin = Coin.from(pickAmount);
			addCoin(pickCoin, Constant.ONE);
			vendingMachineMoney.spendMoney(pickAmount);
		}
	}

	private void addCoin(Coin pickCoin, int addQuantity) {
		coins.put(pickCoin, coins.get(pickCoin) + addQuantity);
	}

	private Map<Coin, Integer> initialize() {
		Map<Coin, Integer> coinMap = new EnumMap<>(Coin.class);
		for (Coin coin : Coin.values()) {
			coinMap.put(coin, 0);
		}
		return coinMap;
	}

	public void showStatus() {
		StringBuilder status = new StringBuilder();
		for (Coin coin : coins.keySet()) {
			addCoinStatus(status, coin);
		}
		OutputView.printCoinStatus(status);
	}

	public void showChangeStatus() {
		OutputView.printChanges();
		StringBuilder status = new StringBuilder();
		for (Coin coin : coins.keySet()) {
			if (coins.get(coin) == Constant.ZERO) {
				continue;
			}
			addCoinStatus(status, coin);
		}
		OutputView.printCoinStatus(status);
	}

	private void addCoinStatus(StringBuilder status, Coin coin) {
		status.append(coin.getAmount())
			.append(Constant.WON)
			.append(Constant.DASH)
			.append(coins.get(coin))
			.append(Constant.EA)
			.append(Constant.NEWLINE)
		;
	}

	public Coins generateChangeCoin(Money userMoney) {
		Map<Coin, Integer> changeCoins = initialize();
		for (Coin coin : coins.keySet()) {
			if (isPossibleChangeToCoin(userMoney, coin)) {
				addUserChangeCoin(userMoney, changeCoins, coin);
			}
		}
		return new Coins(changeCoins);
	}

	private void addUserChangeCoin(Money userMoney, Map<Coin, Integer> changeCoins, Coin coin) {
		int amount = coin.getAmount();
		int leftCoinOfVendingMachine = coins.get(coin);
		int changeableAmount = amount * leftCoinOfVendingMachine;
		int changedQuantity = changeableAmount / amount;
		if (changeableAmount != Constant.ZERO) {
			changeCoins.put(coin, changeCoins.get(coin) + changedQuantity);
			coins.put(coin, coins.get(coin) - changedQuantity);
			userMoney.spendMoney(amount * changedQuantity);
		}
	}

	private boolean isPossibleChangeToCoin(Money userMoney, Coin coin) {
		return userMoney.hasMoreMoney() && coins.get(coin) != Constant.ZERO;
	}
}
