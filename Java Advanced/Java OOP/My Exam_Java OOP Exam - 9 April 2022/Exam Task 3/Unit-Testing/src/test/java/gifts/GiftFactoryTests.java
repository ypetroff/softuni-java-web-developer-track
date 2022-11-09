package gifts;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GiftFactoryTests {

    private final static String TYPE_1 = "type_1";
    private final static String TYPE_2 = "type_2";
    private final static double MAGIC_1 = 1.99;
    private final static double MAGIC_2 = 2.99;

    private GiftFactory giftFactory;
    private Gift gift_1;
    private Gift gift_2;

    @Before
    public void setup() {
        giftFactory = new GiftFactory();
        gift_1 = new Gift(TYPE_1, MAGIC_1);
        gift_2 = new Gift(TYPE_2, MAGIC_2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testCreateGiftThrowsWhenGiftIsInTheCollection() {
        giftFactory.createGift(gift_1);
        giftFactory.createGift(gift_1);

    }

    @Test
    public void testCreateGiftSuccessfullyAddsGift() {
        giftFactory.createGift(gift_1);
        assertEquals(1, giftFactory.getCount());
        assertEquals(gift_1, giftFactory.getPresent(gift_1.getType()));
    }

    @Test
    public void testGetCountReturnsCorrectNumberOfGifts() {
        giftFactory.createGift(gift_1);
        assertEquals(1, giftFactory.getCount());
    }

    @Test (expected = NullPointerException.class)
    public void testRemoveGiftThrowsWhenNameIsNull() {
        giftFactory.removeGift(null);
    }

    @Test (expected = NullPointerException.class)
    public void testRemoveGiftThrowsWhenNameIsWhiteSpace() {
        giftFactory.removeGift(" ");
    }

    @Test
    public void testRemoveGiftReturnsCorrectBoolean() {
        giftFactory.createGift(gift_1);
        assertFalse(giftFactory.removeGift(gift_2.getType()));
        assertTrue(giftFactory.removeGift(gift_1.getType()));
    }

    @Test
    public void testGetPresentWithLeastMagicReturnsNull() {
        assertNull(giftFactory.getPresentWithLeastMagic());

    }

    @Test
    public void testGetPresentWithLeastMagicWorksCorrectly() {
        giftFactory.createGift(gift_1);
        giftFactory.createGift(gift_2);
        Gift actualGift = giftFactory.getPresentWithLeastMagic();
        assertEquals(gift_1, actualGift);
    }

    @Test
    public void testGetPresentReturnsNull() {
        assertNull(giftFactory.getPresent(null));
    }

    @Test
    public void testGetPresentWorksCorrectly() {
        giftFactory.createGift(gift_1);
        Gift actualGift = giftFactory.getPresent(gift_1.getType());
        assertEquals(gift_1, actualGift);
    }

    @Test (expected = UnsupportedOperationException.class)
    public void testGetPresentsIsUnmodifiable() {
        giftFactory.getPresents().clear();
    }

}
