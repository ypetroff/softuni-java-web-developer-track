import java.util.*;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock {

    Map<Integer, Transaction> transactions;

    public ChainblockImpl() {
        this.transactions = new HashMap<>();
    }

    public int getCount() {
        return this.transactions.size();
    }

    public void add(Transaction transaction) {
        this.transactions.putIfAbsent(transaction.getId(), transaction);
    }

    public boolean contains(Transaction transaction) {
        return this.transactions.containsKey(transaction.getId());
    }

    public boolean contains(int id) {
        return this.transactions.containsKey(id);

    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        if(!this.transactions.containsKey(id)) {
            throw new IllegalArgumentException("This transaction is not included in the database!");
        }
        this.transactions.entrySet().stream()
                .filter(t -> t.getKey() == id)
                .map(Map.Entry::getValue)
                .forEach(t -> t.setStatus(newStatus));
    }

    public void removeTransactionById(int id) {
        if(!this.transactions.containsKey(id)) {
            throw new IllegalArgumentException(String.format("No transaction with id: %d", id));
        }
        transactions.remove(id);
    }

    public Transaction getById(int id) {
        return this.transactions.entrySet().stream()
                .filter(t -> t.getKey().equals(id))
                .map(Map.Entry::getValue)
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {

        if(transactions.values().stream().noneMatch(t -> t.getStatus().equals(status))) {
            throw new IllegalArgumentException(String.format(" There isn't a transaction with status %s", status));
        }
        return this.transactions.values().stream()
                .filter(t -> t.getStatus().equals(status))
                .collect(Collectors.toList());
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        List<String> collect = this.transactions.values().stream()
                .filter(t -> t.getStatus().equals(status))
                .map(Transaction::getFrom).collect(Collectors.toList());

        if(collect.size() < 1) {
            throw new IllegalArgumentException();
        }
        return collect;
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {

        if(this.transactions.values().stream().noneMatch(t -> t.getStatus().equals(status))) {
            throw new IllegalArgumentException();
        }

       return this.transactions.values().stream()
                .filter(t -> t.getStatus().equals(status))
                .map(Transaction::getTo).collect(Collectors.toList());
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return null;
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        return null;
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        return null;
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        return null;
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        return null;
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        return null;
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        return null;
    }

    public Iterator<Transaction> iterator() {
        return transactions.values().iterator();
    }
}
