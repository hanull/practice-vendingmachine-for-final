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
		changeToCoin(vendingMachineMoney);
	}

	private void changeToCoin(Money vendingMachineMoney) {
		while (vendingMachineMoney.hasMoreMoney()) {
			int pickAmount = Randoms.pickNumberInList(Coin.getList());
			if (vendingMachineMoney.isOverPay(pickAmount)) {
				continue;
			}
			Coin pickCoin = Coin.from(pickAmount);
			addCoin(pickCoin);
			vendingMachineMoney.spendMoney(pickAmount);
		}
	}

	private void addCoin(Coin pickCoin) {
		coins.put(pickCoin, coins.get(pickCoin) + 1);
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
			status.append(coin.getAmount())
				.append(Constant.WON)
				.append(Constant.DASH)
				.append(coins.get(coin))
				.append(Constant.EA)
				.append(Constant.NEWLINE)
			;
		}
		OutputView.printCoinStatus(status);
	}
}
