import jdk.jshell.spi.ExecutionControl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class InStock implements ProductStock {

    private List<Product> products;

    public InStock() {
        this.products = new ArrayList<>();
    }

    @Override
    public int getCount() {
       return this.products.size();
    }

    @Override
    public boolean contains(Product product) throws UnsupportedOperationException {
        return this.products.contains(product);
    }

    @Override
    public void add(Product product) {
        if(!this.products.contains(product)) {
            this.products.add(product);
        } else {
            throw new UnsupportedOperationException("Product is already added!");
        }

    }

    @Override
    public void changeQuantity(String product, int quantity) {

      if(products.stream().noneMatch(p -> p.getLabel().equals(product))) {
          throw new IllegalArgumentException("No such product in the list!");
      }

        for (Product aProduct : products) {
            if(aProduct.getLabel().equals(product)) {
                aProduct.setQuantity(quantity);
            }
        }
    }

    @Override
    public Product find(int index) {
        return products.get(index);
    }

    @Override
    public Product findByLabel(String label) {

        return products.stream()
                .filter(p -> p.getLabel().equals(label))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {

        if(count <= 0 || count > this.products.size()) {
           return new ArrayList<>();
        }

       return this.products.stream()
               .limit(count)
               .sorted(Comparator.comparing(Product::getLabel))
               .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
        return this.products.stream()
                .filter(p -> p.getPrice() > lo && p.getPrice() <= hi)
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        return this.products.stream().filter(p -> p.getPrice() == price).collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        if(count > this.products.size()) {
            throw new IllegalArgumentException();
        }

        return this.products.stream().sorted(Comparator.comparing(Product::getPrice).reversed()).limit(count).collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        return this.products.stream().filter(p -> p.getQuantity() == quantity).collect(Collectors.toList());
    }

    @Override
    public Iterator<Product> iterator() {
        return this.products.iterator();
    }
}
