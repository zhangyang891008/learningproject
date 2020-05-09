package com.testspring;

import org.springframework.stereotype.Component;

import java.time.ZoneId;

@Component
public class UserService {
    public final ZoneId zoneId = ZoneId.systemDefault();

    public ZoneId getZoneId(){
        System.out.println("class to string:"+this.toString());
        return zoneId;
    }

    public final ZoneId getFinalZoneId(){
        System.out.println("final class to string:"+this.toString());
        return zoneId;
    }
}
