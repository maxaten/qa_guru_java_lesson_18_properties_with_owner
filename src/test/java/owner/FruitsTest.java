package owner;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import owner.config.FruitConfig;

import static org.assertj.core.api.Assertions.assertThat;


public class FruitsTest {

    @Test
    public void testArray() {
        System.setProperty("array", "banana, apple");

        FruitConfig config = ConfigFactory.create(FruitConfig.class, System.getProperties());
        assertThat(config.getFruitsArray()).containsExactly("banana", "apple");
    }

    @Test
    public void testList() {
        System.setProperty("list", "apple,orange");

        FruitConfig config = ConfigFactory.create(FruitConfig.class, System.getProperties());
        assertThat(config.getFruitsList()).containsExactly("apple", "orange");
    }


    @Test
    public void testArrayWithDefaultValue() {

        FruitConfig config = ConfigFactory.create(FruitConfig.class, System.getProperties());
        assertThat(config.getFruitsArrayWithDefaultValues()).containsExactlyInAnyOrder("orange", "apple");
    }

    @Test
    public void testArrayWithSeparator() {

        FruitConfig config = ConfigFactory.create(FruitConfig.class, System.getProperties());
        assertThat(config.getFruitsListWithSeparator()).containsExactlyInAnyOrder("orange", "banana");
    }
}