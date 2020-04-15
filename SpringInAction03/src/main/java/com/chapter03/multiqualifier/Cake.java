package com.chapter03.multiqualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Cold
@Sweet
public class Cake extends Desert {

}
