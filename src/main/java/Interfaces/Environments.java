package Interfaces;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;


@Sources({
        "classpath:Environments/${env}.properties" // mention the property file name
})
public interface Environments extends Config {
    String env();
    String url();
}
