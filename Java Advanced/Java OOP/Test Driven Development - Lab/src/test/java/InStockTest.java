import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class InStockTest {

    private static final Product PRODUCT1 = new Product("label-1", 9.99, 1);
    private static final Product PRODUCT2 = new Product("label-2", 19.99, 8);
    private static final Product PRODUCT3 = new Product("label-3", 29.99, 54);
    private static final Product PRODUCT4 = new Product("label-4", 39.99, 101);

    ProductStock products;

    @Before
    public void setup() {
        products = new InStock();
    }

    private Product[] createProducts() {

        return new Product[]{
                PRODUCT3,
                PRODUCT1,
                PRODUCT2
        };
    }

    private Product[] addProducts(ProductStock products) {
        Product[] productsArray = createProducts();

        for (Product product : productsArray) {
            products.add(product);
        }
        return productsArray;
    }

    @Test
    public void testContainsReturnsFalseWhenTheProductIsNotAddedAndTrueIfAdded() {
        addProducts(products);
        assertTrue(products.contains(PRODUCT1));
        assertFalse(products.contains(PRODUCT4));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testAddThrowsUOExceptionWhenElementISAlreadyAdded() {
        addProducts(products);
        products.add(PRODUCT1);
    }

    @Test
    public void testGetCountShouldReturnTheCorrectNumberOfElementsAndZeroIfEmpty() {
        assertEquals(0, products.getCount());
        addProducts(products);
        assertEquals(3, products.getCount());
    }

    @Test
    public void testFindReturnsTheRequestedItem() {
        addProducts(products);
        int indexWithinRange = 0;
        assertEquals(PRODUCT3, products.find(indexWithinRange));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindThrowsIOBException() {
        int indexOutOfBounds = 18;
        products.find(indexOutOfBounds);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindThrowsIOBExceptionWhenIndexIsNegative() {
        int indexOutOfBounds = -1;
        products.find(indexOutOfBounds);
    }

    @Test
    public void testChangeQuantityOfRequestedProduct() {
        addProducts(products);
        assertEquals(PRODUCT1.getQuantity(), 1);
        products.changeQuantity(PRODUCT1.getLabel(), 88);
        assertEquals(PRODUCT1.getQuantity(), 88);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeQuantityThrowNUSOException() {
        addProducts(products);
        products.changeQuantity(PRODUCT4.getLabel(), 99);
    }

    @Test
    public void testFindByLabelReturnCorrectProduct() {
        addProducts(products);
        assertEquals(PRODUCT3, products.findByLabel(PRODUCT3.getLabel()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByLabelReturnCorrectProductOrThrowsIAException() {
        addProducts(products);
        products.findByLabel(PRODUCT4.getLabel());
    }

    @Test
    public void testFindFirstByAlphabeticalOrderReturnsTheCorrectNumberOfProducts() {

        Product[] addedProducts = createProducts();
        addProducts(this.products);
        this.products.add(PRODUCT4);
        Iterable<Product> firstByAlphabeticalOrder = this.products.findFirstByAlphabeticalOrder(addedProducts.length);
        int count = assertAndExtract(firstByAlphabeticalOrder).size();

        assertEquals(addedProducts.length, count);

    }

    @Test
    public void testFindFirstByAlphabeticalOrderReturnsProductInCorrectOrder() {

        Product[] addedProducts = addProducts(this.products);
        this.products.add(PRODUCT4);
        Iterable<Product> iterable = this.products.findFirstByAlphabeticalOrder(addedProducts.length);

        List<String> actualProducts = assertAndExtract(iterable, Product::getLabel);

        List<String> expectedOrder = Arrays.stream(addedProducts)
                .map(Product::getLabel)
                .sorted()
                .collect(Collectors.toList());

        assertEquals(expectedOrder, actualProducts);

    }

    @Test
    public void testFindFirstByAlphabeticalOrderReturnsEmptyCollectionWhenArgumentIsOutOfRange() {
        Product[] addedProducts = addProducts(this.products);


        Iterable<Product> iterable = this.products.findFirstByAlphabeticalOrder(addedProducts.length + 1);

        List<Product> actualProducts = assertAndExtract(iterable);
        assertTrue(actualProducts.isEmpty());
    }

    private static List<Product> assertAndExtract(Iterable<Product> iterable) {
        return assertAndExtract(iterable, p -> p);
    }

    private static <T> List<T> assertAndExtract(Iterable<Product> iterable, Function<Product, T> mapper) {

        assertNotNull(iterable);

        List<T> result = new ArrayList<>();

        for (Product product : iterable) {
            result.add(mapper.apply(product));
        }

        return result;
    }

    @Test
    public void findAllInRangeReturnsCorrectRange() {
        Product[] addedProducts = addProducts(products);
        double start = addedProducts[1].getPrice();
        double end = addedProducts[0].getPrice();
        Iterable<Product> allInRange = this.products.findAllInRange(start, end);
        List<Double> returnedPrices = assertAndExtract(allInRange, Product::getPrice);

        assertEquals(2, returnedPrices.size());
        assertEquals(end, returnedPrices.get(0), 0.00);
    }

    @Test
    public void findAllInRangeReturnsCorrectRangeAndDescendingOrder() {
        Product[] addedProducts = addProducts(products);
        double start = addedProducts[1].getPrice();
        double end = addedProducts[0].getPrice();
        Iterable<Product> allInRange = this.products.findAllInRange(start, end);
        List<Double> returnedPrices = assertAndExtract(allInRange, Product::getPrice);

        List<Double> expected = Arrays.stream(addedProducts)
                .map(Product::getPrice)
                .filter(p -> p > start && p <= end)
                .sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        assertEquals(expected, returnedPrices);
    }

    @Test
    public void findAllInRangeReturnsEmptyCollectionWhenNoneMatch() {
        Product[] addedProducts = addProducts(products);
        double start = -10;
        double end = -5;
        Iterable<Product> allInRange = this.products.findAllInRange(start, end);
        List<Double> returnedPrices = assertAndExtract(allInRange, Product::getPrice);

        assertTrue(returnedPrices.isEmpty());
    }

    @Test
    public void findByPriceReturnsCorrectProducts() {
        Product[] addedProducts = addProducts(products);
        double expectedPrice = addedProducts[1].getPrice();

        Iterable<Product> allInRange = this.products.findAllByPrice(expectedPrice);
        List<Double> returnedPrices = assertAndExtract(allInRange, Product::getPrice);

        assertEquals(1, returnedPrices.size());
        double actualPrice = returnedPrices.get(0);
        assertEquals(expectedPrice, actualPrice, 0.00);
    }

    @Test
    public void findByPriceDoesNotReturnPricesWhenPriceIsNonExisting() {
        Product[] addedProducts = addProducts(products);
        double expectedPrice = 800.8;

        Iterable<Product> allInRange = this.products.findAllByPrice(expectedPrice);
        List<Double> returnedPrices = assertAndExtract(allInRange, Product::getPrice);

        assertTrue(returnedPrices.isEmpty());
    }

    @Test
    public void testFindFirstMostExpensiveProductsShouldReturnCorrectProduct() {
        List<Double> expectedOutput = Arrays.stream(addProducts(products))
                .map(Product::getPrice)
                .sorted(Comparator.reverseOrder())
                .limit(1)
                .collect(Collectors.toList());
        Iterable<Product> mostExpensiveProducts = products.findFirstMostExpensiveProducts(1);
        List<Double> actualOutput = assertAndExtract(mostExpensiveProducts, Product::getPrice);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testFindFirstMostExpensiveProductThrowsException() {
      Product[] addedProducts = addProducts(this.products);
      this.products.findFirstMostExpensiveProducts(addedProducts.length + 1);
    }

    @Test
    public void testFindAllByQuantityReturnsAllProductsWithTheRequestedQuantity() {
        Product[] addedProducts = addProducts(this.products);

        List<Product> expectedOutput = Arrays.stream(addedProducts)
                .filter(p -> p.getQuantity() == PRODUCT3.getQuantity())
                .collect(Collectors.toList());
        Iterable<Product> allByQuantity = this.products.findAllByQuantity(PRODUCT3.getQuantity());
        int actualOutput = assertAndExtract(allByQuantity).size();
        assertEquals(expectedOutput.size(), actualOutput);
    }

    @Test
    public void testFindAllByQuantityReturnsEmptyCollectionIfThereAreNoElementsWithTheRequestedPrice() {
        Product[] addedProducts = addProducts(this.products);

        List<Product> expectedOutput = Arrays.stream(addedProducts)
                .filter(p -> p.getQuantity() == -10)
                .collect(Collectors.toList());
        Iterable<Product> allByQuantity = this.products.findAllByQuantity(-10);
        int actualOutput = assertAndExtract(allByQuantity).size();
        assertEquals(0, actualOutput);
    }

    @Test
    public void testIteratorShouldReturnAllProducts() {
        List<Product> expectedProducts = Arrays.asList(addProducts(this.products));

        Iterator<Product> iterator = this.products.iterator();

        assertNotNull(iterator);

        List<Product> actualProducts = new ArrayList<>();
        while (iterator.hasNext()) {
            Product p = iterator.next();
            actualProducts.add(p);
        }

        assertEquals(expectedProducts, actualProducts);
    }

}


/*
* import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class ProductStockTest {

    private Instock instock;
    private Product product;

    @Before
    public void setUp() {
        instock = new Instock();
        product = new Product("default_test_label", 100, 1);
    }

    @Test
    public void testGetCountShouldReturnTwoWhenTwoProductsAdded() {
        addProducts();
        assertEquals(10, instock.getCount());
    }

    @Test
    public void testGetCountShouldReturnZeroWhenEmpty() {
        assertEquals(0, instock.getCount());
    }

    @Test
    public void testAddProductShouldStoreTheProductByValidatingWithContains() {
        instock.add(product);
        Boolean contains = assertNotNullReturnedObject(() -> instock.contains(product));
        assertTrue(contains);
    }

    @Test
    public void testAddShouldNotAllowAdditionOfTheSameProductTwice() {
        instock.add(product);
        instock.add(product);
        Integer count = assertNotNullReturnedObject(() -> instock.getCount());
        assertEquals(Integer.valueOf(1), count);
    }

    @Test
    public void testContainsShouldReturnFalseWhenProductIsNotPresent() {
        instock.add(product);
        Boolean contains = assertNotNullReturnedObject(() -> instock.contains(
                new Product("test_label", 100, 1)));
        assertFalse(contains);
    }

    @Test
    public void testContainsShouldReturnFalseWhenEmpty() {
        Boolean contains = assertNotNullReturnedObject(() -> instock.contains(product));
        assertFalse(contains);
    }

    @Test
    public void testFindShouldReturnTheCorrect6thProductAdded() {
        assertFindReturnsCorrectProduct(6);
    }

    @Test
    public void testFindShouldReturnTheCorrect1stProductAdded() {
        assertFindReturnsCorrectProduct(0);
    }

    @Test
    public void testFindShouldReturnTheCorrect10thProductAdded() {
        assertFindReturnsCorrectProduct(9);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindShouldFailWhenIndexOutOfBoundsWhenNegativeIndex() {
        instock.find(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindShouldFailWhenIndexOutOfBoundsWhenIndexIsEqualToCount() {
        addProducts();
        instock.find(instock.getCount());
    }

    @Test
    public void testChangeQuantityShouldUpdateTheProductQuantityValue() {
        instock.add(product);
        int quantityBeforeUpdate = product.getQuantity();
        instock.changeQuantity(product.getLabel(), 10);
        assertEquals(quantityBeforeUpdate + 10, product.getQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeQuantityShouldFailForMissingProduct() {
        addProducts();
        instock.changeQuantity(product.getLabel(), 10);
    }

    @Test
    public void testFindByLabelShouldReturnCorrectProduct() {
        addProducts();
        instock.add(product);
        Product foundByLabel = assertNotNullReturnedObject(() -> instock.findByLabel(product.getLabel()));
        assertEquals(product.getLabel(), foundByLabel.getLabel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByLabelShouldThrowIfProductIsMissing() {
        addProducts();
        instock.findByLabel(product.getLabel());
    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnEmptyCollectionIfCountIsOutOfRange() {
        addProducts();
        Iterable<Product> iterable = instock.findFirstByAlphabeticalOrder(instock.getCount() + 1);
        assertEmptySequence(iterable);
    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnCorrectNumberOfProductsThatAreOrderedByLabel() {
        int expectedCount = 5;
        List<String> expectedLabels = addProducts()
                .stream()
                .sorted(Comparator.comparing(Product::getLabel))
                .limit(expectedCount)
                .map(Product::getLabel)
                .collect(Collectors.toList());
        List<Product> actualProducts = getListFromIterable(instock.findFirstByAlphabeticalOrder(expectedCount));
        assertEquals(expectedCount, actualProducts.size());
        for (int i = 0; i < actualProducts.size(); i++) {
            assertEquals(expectedLabels.get(i), actualProducts.get(i).getLabel());
        }
    }

    @Test
    public void testFindAllInRangeShouldReturnEmptyCollectionIfNoProductsInThatRangeAreStored() {
        addProducts();
        Iterable<Product> iterable = instock.findAllInRange(10000, 11000);
        assertEmptySequence(iterable);
    }

    @Test
    public void testFindAllInRangeShouldReturnCorrectRangeWithOrderedPricesDescending() {
        double lowRange = 0.10;
        double upperRange = 100.50;

        List<Product> expected = addProducts()
                .stream()
                .filter(p -> p.getPrice() > lowRange && p.getPrice() <= upperRange)
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
                .collect(Collectors.toList());

        List<Product> actual = getListFromIterable(instock.findAllInRange(lowRange, upperRange));

        assertEquals(expected.size(), actual.size());

        for (int i = 0; i < actual.size(); i++) {
            assertEquals(expected.get(i).getPrice(), actual.get(i).getPrice(), 0);
        }
    }

    @Test
    public void testFindAllByPriceShouldReturnOnlyProductsWithEqualPrice() {
        instock.add(product);
        instock.add(new Product("test_label", product.getPrice(), 1));
        List<Product> actual = getListFromIterable(instock.findAllByPrice(product.getPrice()));
        assertEquals(2, actual.size());
        assertTrue(actual.stream().allMatch(p -> p.getPrice() == product.getPrice()));
    }

    @Test
    public void testFindAllByPriceShouldReturnEmptyCollectionIfNoSuchPricedProductPresent() {
        addProducts();
        List<Product> actual = getListFromIterable(instock.findAllByPrice(100));
        assertTrue(actual.isEmpty());
    }

    @Test
    public void testFindFirstMostExpensiveProductsShouldReturnCorrectNumberOfProductsThatAreOrderedByPriceDescending() {
        int expectedCount = 3;
        List<Double> expectedLabels = addProducts()
                .stream()
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .limit(expectedCount)
                .map(Product::getPrice)
                .collect(Collectors.toList());
        List<Product> actualProducts = getListFromIterable(instock.findFirstMostExpensiveProducts(expectedCount));
        assertEquals(expectedCount, actualProducts.size());
        for (int i = 0; i < actualProducts.size(); i++) {
            assertEquals(expectedLabels.get(i), actualProducts.get(i).getPrice(), 0);
        }
    }

    @Test
    public void testFindFirstMostExpensiveProductsShouldReturnEmptyCollectionIfCountIsOutOfRange() {
        addProducts();
        Iterable<Product> iterable = instock.findFirstMostExpensiveProducts(instock.getCount() + 1);
        assertEmptySequence(iterable);
    }

    @Test
    public void testFindAllByQuantityShouldReturnOnlyProductsWithEqualQuantity() {
        addProducts();
        instock.add(product);
        instock.add(new Product("test_label", product.getPrice(), product.getQuantity()));
        List<Product> actual = getListFromIterable(instock.findAllByQuantity(product.getQuantity()));
        assertEquals(3, actual.size());
        assertTrue(actual.stream().allMatch(p -> p.getQuantity() == product.getQuantity()));
    }

    @Test
    public void testFindAllByQuantityShouldReturnEmptyCollectionIfNoSuchQuantityProductPresent() {
        addProducts();
        List<Product> actual = getListFromIterable(instock.findAllByQuantity(1000));
        assertTrue(actual.isEmpty());
    }

    @Test
    public void testIteratorShouldReturnAllProductsInTheOrderOfAddition() {
        List<Product> expected = addProducts();
        Iterator<Product> iterator = instock.iterator();
        List<Product> actual = new ArrayList<>();
        while (iterator.hasNext()) {
            actual.add(iterator.next());
        }
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i).getLabel(), actual.get(i).getLabel());
        }
    }

    private <T> List<T> getListFromIterable(Iterable<T> iterable) {
        assertNotNull(iterable);
        List<T> list = new ArrayList<>();
        iterable.forEach(list::add);
        return list;
    }

    private void assertFindReturnsCorrectProduct(int index) {
        addProducts();
        assertEquals(10, instock.getCount());
        Product product = assertNotNullReturnedObject(() -> instock.find(index));
        assertEquals("test_label_" + index, product.getLabel());
    }

    private List<Product> addProducts() {
        List<Product> products = Arrays.asList(new Product("test_label_0", 13, 1),
                new Product("test_label_1", 95.8, 10),
                new Product("test_label_2", 1000, 13),
                new Product("test_label_3", 100.50, 42),
                new Product("test_label_4", 42.69, 69),
                new Product("test_label_5", 10000, 32),
                new Product("test_label_6", 0.90, 2),
                new Product("test_label_7", 0.10, 7),
                new Product("test_label_8", 1, 99),
                new Product("test_label_9", 0.94, 73));

        for (Product p : products) {
            instock.add(p);
        }

        return products;
    }

    private void assertEmptySequence(Iterable<Product> iterable) {
        assertNotNull(iterable);
        List<Product> products = new ArrayList<>();
        iterable.forEach(products::add);
        assertTrue(products.isEmpty());
    }

    private <T> T assertNotNullReturnedObject(Supplier<T> supplier) {
        T result = supplier.get();
        assertNotNull(result);
        return result;
    }
}*/