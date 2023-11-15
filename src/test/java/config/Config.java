package config;

@org.aeonbits.owner.Config.Sources({
        "classpath:${launch}.properties"
})
public interface Config extends org.aeonbits.owner.Config {

    @Key("browser")
    @DefaultValue("chrome")
    String browser();

    @Key("version")
    @DefaultValue("100.0")
    String version();

    @Key("size")
    @DefaultValue("1920x1080")
    String size();

    @Key("remoteUrl")
    String remoteUrl();
}
