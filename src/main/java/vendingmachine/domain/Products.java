package vendingmachine.domain;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import vendingmachine.constant.Constant;
import vendingmachine.constant.Message;

public class Products {

	private final List<Product> products;

	public Products(List<Product> products) {
		this.products = products;
	}

	public static Products createProducts(String inputProducts) {
		List<Product> productList = Stream.of(inputProducts.split(Constant.DELIMITER))
			.map(Product::fromProductInformation)
			.collect(Collectors.toList());
		if (isDuplicate(productList)) {
			throw new IllegalArgumentException(Message.ERROR_DUPLICATE);
		}
		return new Products(productList);
	}

	private static boolean isDuplicate(List<Product> productList) {
		return productList.size() != new HashSet<>(productList).size();
	}

	public boolean isSoldOut() {
		return products.stream()
			.anyMatch(product -> product.getQuantity() != Constant.ZERO);
	}

	public int findMinimumProductPrice() {
		return products.stream()
			.map(Product::getPrice)
			.min((o1, o2) -> o1 - o2)
			.get();
	}
}
