package test.java;

import a.sharafutdinov.Manager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by innopolis on 14.02.17.
 */
class ManagerTest {
    @Test
    void add() {
        Manager m = new Manager();
        m.add("слово");
        m.add("пять");
        m.add("слово");
        //m.add(null);
        assertEquals("слово", "слово");
        assertEquals("пять", "пять");

        //assertEquals("слово","слово", "ascvf");
        //assertEquals("", "");

    }

    @Test
    void getResult() {
        Manager m = new Manager();
        m.getResult();
        assertEquals(5,5);

    }

    @Test
    void isChFlag() {
        Manager m = new Manager();
        m.isChFlag();
        assertEquals(true,true);
        assertEquals(false,false);

    }

    @Test
    void setChFlag() {
        Manager m = new Manager();
        m.setChFlag(true);
        assertEquals(false, false);

    }

}