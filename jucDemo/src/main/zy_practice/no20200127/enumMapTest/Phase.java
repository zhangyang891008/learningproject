package no20200127.enumMapTest;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

/**
 * EnumMap: effectivejava
 */
public enum Phase {

    SOLID,LIQUID,GAS;

    public enum Transition{
        MELT(SOLID,LIQUID),FREEZE(LIQUID,SOLID),
        BOIL(LIQUID,GAS),CONDENSE(GAS,LIQUID),
        SUBLIME(SOLID,GAS),DEPOSIT(GAS,SOLID);

        private final Phase from;
        private final Phase to;

        Transition(Phase from, Phase to){
            this.from = from;
            this.to = to;

        }
        //TODO
        //private static final Map<Phase, Map<Phase, Transition>> m = Stream.of(values()).;

        public static Transition from(Phase from ,Phase to){
            //return m.get(from).get(to);
            return null;
        }
    }
}
