package go_java_4.vadya_zakusylo.kickstarter;

import java.util.Arrays;

public class Repository {
	private Category[] categories = new Category[0];

	public Category[] getCategories() {
		return categories;
	}

	public void addCategory(Category category) {
		int length = categories.length;
		categories = Arrays.copyOf(categories, ++length);
		categories[length - 1] = category;
	}
}
