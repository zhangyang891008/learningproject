package com._02xml.xmlway;

import org.springframework.stereotype.Component;

@Component
public class PersonService implements IPersonService {

    public void working() {
        System.out.println("working");
    }
}
