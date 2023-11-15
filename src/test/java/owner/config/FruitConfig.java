package owner.config;

import org.aeonbits.owner.Config;

import java.util.List;

public interface FruitConfig extends Config {

    @Key("array")
    String[] getFruitsArray();

    @Key("array-with-default-values")
    @DefaultValue("orange, apple")
    String[] getFruitsArrayWithDefaultValues();

    @Key("list")
    List<String > getFruitsList();

    @Key("list-with-separator")
    @Separator(";")
    @DefaultValue("orange; banana")
    List<String > getFruitsListWithSeparator();
}