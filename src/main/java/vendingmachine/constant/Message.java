package vendingmachine.constant;

public final class Message {
	public static final String INPUT_VENDING_MACHINE_COIN = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	public static final String INPUT_PRODUCTS = "상품명과 가격, 수량을 입력해 주세요.";
	public static final String ERROR_NOT_FOUND_COIN = "[ERROR] 해당 금액에 해당하는 코인이 없습니다.";
	public static final String ERROR_NOT_DIGIT= "[ERROR] 숫자가 아니거나, 음수입니다. 양의 정수만 입력해주세요.";
	public static final String ERROR_INVALID_PRICE= "[ERROR] 10원으로 나누어떨어지지 않습니다.";
	public static final String ERROR_INVALID_PRODUCT_INFORMATION= "[ERROR] 상품 정보가 잘못되었습니다.";
	public static final String ERROR_DUPLICATE= "[ERROR] 중복된 상품이 존재합니다.";
}
