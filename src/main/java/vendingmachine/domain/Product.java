package vendingmachine.domain;

import java.util.Objects;

import vendingmachine.constant.Constant;
import vendingmachine.constant.Message;
import vendingmachine.utils.ValidateUtils;

public class Product {

	private String name;
	private int price;
	private int quantity;

	public Product(String[] productInformation) {
		this.name = productInformation[0];
		this.price = Integer.parseInt(productInformation[1]);
		this.quantity = Integer.parseInt(productInformation[2]);
	}

	public static Product fromProductInformation(String productInformation) {
		validateProductInformation(productInformation);
		return new Product(productInformation.substring(1, productInformation.length() - 1).split(Constant.COMMA));
	}

	private static void validateProductInformation(String productInformation) {
		if (!ValidateUtils.isValidProductInformation(productInformation)) {
			throw new IllegalArgumentException(Message.ERROR_INVALID_PRODUCT_INFORMATION);
		}
	}

	public int getQuantity() {
		return quantity;
	}

	public int getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Product product = (Product)o;
		return name.equals(product.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
