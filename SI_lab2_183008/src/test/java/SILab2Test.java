package java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    private SILab2 siLab2 = new SILab2();
    private User userNull = null;
    private User user1 = new User(null, null, null);
    private User user2 = new User("Filip", null, null);
    private User user3 = new User("Filip", null, "emy.c");
    private User user4 = new User("Filip", null, "em@yc");
    private User user5 = new User("Filip", null, "em2@y.c");
    public List<String> allUsers = new ArrayList<>();


    @Test
    public void everyPathFunctionTest() {

        RuntimeException re;

//        1, 2, 3, 20
        re = assertThrows(RuntimeException.class, () -> siLab2.function(userNull, allUsers));
        assertTrue(re.getMessage().contains("The user argument is not initialized!"));

//        1, 2, 4, 5, 6, 20
        re = assertThrows(RuntimeException.class, () -> siLab2.function(user1, allUsers));
        assertTrue(re.getMessage().contains("User already exists!"));

//        1, 2, 4, 5, 7, 8, 9, 20
        assertFalse(siLab2.function(user2, allUsers));

//        1, 2, 4, 5, 7, 8, 10, 11.1, 11.2, (12, 14, 16, 11.3, 11.2), 17, 18, 20
        assertFalse(siLab2.function(user3, allUsers));

//        1, 2, 4, 5, 7, 8, 10, 11.1, 11.2, (12, 13, 14, 16, 11.3, 11.2), 17, 18, 20
        assertFalse(siLab2.function(user4, allUsers));

//        1, 2, 4, 5, 7, 8, 10, 11.1, 11.2, (12, 13, 14, 15, 16, 11.3, 11.2), 17, 19, 20
        assertTrue(siLab2.function(user5, allUsers));
    }

    @Test
    public void everyBranchFunctionTest() {

        RuntimeException re;

// 1=2 // 2=3 // 3=20
        re = assertThrows(RuntimeException.class, () -> siLab2.function(userNull, allUsers));
        assertTrue(re.getMessage().contains("The user argument is not initialized!"));

// 1=2 // 2=4 // 4=5 // 5=6 // 6=20
        re = assertThrows(RuntimeException.class, () -> siLab2.function(user1, allUsers));
        assertTrue(re.getMessage().contains("User already exists!"));

// 1=2 // 2=4 // 5=7 // 7=8 // 8=9 // 9=20
        assertFalse(siLab2.function(user2, allUsers));

// 1=2 // 2=4 // 5=7 // 7=8 // 8=10 // 10=11.1 // 11.1=11.2 // 11.2=12 // 12=14 // 14=16 // 16=11.3 // 11.3=11.2 // 11.2=17 // 17=18 // 18=20
        assertFalse(siLab2.function(user3, allUsers));

// 1=2 // 2=4 // 5=7 // 7=8 // 8=10 // 10=11.1 // 11.1=11.2// 11.2=12// 12=13// 12=14 // 13=14 // 14=16 // 16=11.3 // 11.3=11.2 // 11.2=17 // 17=18 // 18=20
        assertFalse(siLab2.function(user4, allUsers));

// 1=2 // 2=4 // 5=7 // 7=8 // 8=10 // 10=11.1 // 11.1=11.2 // 11.2=12 // 12=13 // 12=14 // 13=14 // 14=15 // 14=16 // 15=16 // 16=11.3 // 11.3=11.2 // 11.2=17 // 17=19 // 19=20
        assertTrue(siLab2.function(user5, allUsers));

    }

    @Test
    public void multipleConditionTest(){

        RuntimeException re;

        allUsers.add("Filip");
        // true i nebitno
        re = assertThrows(RuntimeException.class, () -> siLab2.function(user1, allUsers));
        assertTrue(re.getMessage().contains("User already exists!"));

        // false i true
        re = assertThrows(RuntimeException.class, () -> siLab2.function(user2, allUsers));
        assertTrue(re.getMessage().contains("User already exists!"));

        allUsers.remove(1);
        // false i false
        assertTrue(siLab2.function(user5, allUsers));
    }
}