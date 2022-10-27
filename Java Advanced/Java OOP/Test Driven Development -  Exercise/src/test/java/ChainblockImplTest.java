import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class ChainblockImplTest {
    private static final Transaction TRANSACTION_01 =
            new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Vesi", "Dani", 101.01);
    private static final Transaction TRANSACTION_02 =
            new TransactionImpl(2, TransactionStatus.ABORTED, "Gogo", "Pepi", 1.01);
    private static final Transaction TRANSACTION_03 =
            new TransactionImpl(3, TransactionStatus.FAILED, "Pesho", "Dimo", 333.33);
    private static final Transaction TRANSACTION_04 =
            new TransactionImpl(4, TransactionStatus.UNAUTHORIZED, "Marto", "Desi", -3.14);
    private static final Transaction TRANSACTION_05 =
            new TransactionImpl(88, TransactionStatus.SUCCESSFUL, "Marto", "Desi", -3.14);


    private Chainblock chainblock;
    private List<Transaction> transactions;

    @Before
    public void setup() {
        chainblock = new ChainblockImpl();
        transactions = new ArrayList<>();
    }

    @Test
    public void testContainsUsingTransactionReturnsCorrectValue() {
        assertFalse(chainblock.contains(TRANSACTION_01));
        chainblock.add(TRANSACTION_01);
        assertTrue(chainblock.contains(TRANSACTION_01));
    }

    @Test
    public void testContainsUsingIdReturnsCorrectValue() {
        assertFalse(chainblock.contains(TRANSACTION_02.getId()));
        chainblock.add(TRANSACTION_02);
        assertTrue(chainblock.contains(TRANSACTION_02.getId()));
    }

    @Test
    public void testAddAddsTransaction() {
        assertEquals(0, chainblock.getCount());
        chainblock.add(TRANSACTION_03);
        assertEquals(1, chainblock.getCount());
    }

    @Test
    public void testAddDontAddAlreadyAddedTransaction() {
        chainblock.add(TRANSACTION_04);
        assertEquals(1, chainblock.getCount());
        chainblock.add(TRANSACTION_04);
        assertEquals(1, chainblock.getCount());
    }

    @Test
    public void testGetCountReturnsCorrectNumberOfElements() {
        assertEquals(0, chainblock.getCount());
        chainblock.add(TRANSACTION_02);
        assertEquals(1, chainblock.getCount());
        chainblock.add(TRANSACTION_01);
        assertEquals(2, chainblock.getCount());
        chainblock.add(TRANSACTION_03);
    }

    @Test
    public void testChangeTransactionStatusReturnsCorrectValue() {
        chainblock.add(TRANSACTION_02);
        assertNotEquals(TransactionStatus.SUCCESSFUL, TRANSACTION_02.getStatus());
        chainblock.changeTransactionStatus(TRANSACTION_02.getId(), TransactionStatus.SUCCESSFUL);
        assertEquals(TransactionStatus.SUCCESSFUL, chainblock.getById(2).getStatus());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeTransactionStatusThrowsExceptionWhenChangeTransactionWhichIsNotAdded() {
        chainblock.changeTransactionStatus(TRANSACTION_03.getId(), TransactionStatus.SUCCESSFUL);
    }

    @Test
    public void testRemoveTransactionById() {
        fillChainblockWithTransactions();
        chainblock.removeTransactionById(TRANSACTION_03.getId());
        assertFalse(chainblock.contains(TRANSACTION_03));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveTransactionByIdThrowsExceptionWhenElementNotPresent() {
        fillChainblockWithTransactions();
        chainblock.removeTransactionById(TRANSACTION_02.getId());

    }

    @Test
    public void testGetByIdReturnsTransactionWithTheProvidedId() {
        fillChainblockWithTransactions();
        assertEquals(TRANSACTION_01, chainblock.getById(TRANSACTION_01.getId()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByIdThrowsExceptionWhenThereIsNotTransactionWithRequestedId() {
        fillChainblockWithTransactions();
        assertEquals(TRANSACTION_01, chainblock.getById(TRANSACTION_02.getId()));
    }

    @Test
    public void testGetByTransactionStatusReturnsTransactionsWithRequestedStatus() {
        fillChainblockWithTransactions();

        chainblock.add(TRANSACTION_05);
        Iterable<Transaction> transactionsByStatus = chainblock.getByTransactionStatus(TransactionStatus.SUCCESSFUL);
        List<Transaction> actualTransactions = new ArrayList<>();

        for (Transaction status : transactionsByStatus) {
            actualTransactions.add(status);
        }

        assertEquals(2, actualTransactions.size());
        assertTrue(actualTransactions.contains(TRANSACTION_01));
        assertTrue(actualTransactions.contains(TRANSACTION_05));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByTransactionStatusThrowsIAExceptionWhenRequestedStatusNotPresent() {
        fillChainblockWithTransactions();
        chainblock.getByTransactionStatus(TRANSACTION_02.getStatus());
    }

    @Test
    public void testGetAllSendersWithTransactionStatusReturnsAllRequestedTransactions() {
        fillChainblockWithTransactions();
        chainblock.add(TRANSACTION_05);

        for (Transaction transaction : chainblock) {
            transactions.add(transaction);
        }

        Iterable<String> transactionCollection = chainblock.getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL);
        List<String> expectedResult = transactions.stream()
                .filter(t -> t.getStatus().equals(TransactionStatus.SUCCESSFUL))
                .map(Transaction::getFrom)
                .collect(Collectors.toList());

        List<String> actualResult = new ArrayList<>();
        for (String transaction : transactionCollection) {
            actualResult.add(transaction);
        }

        assertEquals(expectedResult.size(), actualResult.size());
        assertEquals(expectedResult.get(0), actualResult.get(0));
        assertEquals(expectedResult.get(1), actualResult.get(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllSendersWithTransactionStatusThrowsIOExceptionWhenTransactionWithRequestedStatusIsNotInTheList() {
        chainblock.getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL);
    }

    @Test
    public void testGetAllReceiversWithTransactionStatusReturnsAllSenders() {
        fillChainblockWithTransactions();
        chainblock.add(TRANSACTION_05);

        for (Transaction transaction : chainblock) {
            transactions.add(transaction);
        }

        Iterable<String> transactionCollection = chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.SUCCESSFUL);
        List<String> expectedResult = transactions.stream()
                .filter(t -> t.getStatus().equals(TransactionStatus.SUCCESSFUL))
                .map(Transaction::getTo)
                .collect(Collectors.toList());

        List<String> actualResult = new ArrayList<>();
        for (String transaction : transactionCollection) {
            actualResult.add(transaction);
        }

        assertEquals(expectedResult.size(), actualResult.size());
        assertEquals(expectedResult.get(0), actualResult.get(0));
        assertEquals(expectedResult.get(1), actualResult.get(1));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetAllReceiversWithTransactionStatusThrowsIOE() {
        chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.ABORTED);
    }

    private void fillChainblockWithTransactions() {
        chainblock.add(TRANSACTION_01);
        chainblock.add(TRANSACTION_04);
        chainblock.add(TRANSACTION_03);
    }


}