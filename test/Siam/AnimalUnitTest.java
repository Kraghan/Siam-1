package Siam;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AnimalUnitTest {

    private Animal animal;

    @Before
    public void setUp() {
        animal = new Animal(0, 0, Orientation.HAUT, Camp.ELEPHANT, false);
    }

    @Test
    public void testGetOrientation() {
        Assert.assertEquals(Orientation.HAUT, animal.getOrientation());
    }

    @Test
    public void testSetOrientation() {
        animal.setOrientation(Orientation.BAS);
        Assert.assertEquals(Orientation.BAS, animal.getOrientation());
    }
}
