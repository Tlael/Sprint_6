import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)

public class LionTest {
    @Mock
    Feline feline;
    Lion lion;

    @Test
    public void eatMeatShouldPredator1Food() throws Exception {
        feline = new Feline();
        lion = new Lion(feline);
        Lion lion1 = Mockito.spy(lion);
        List<String> expected = List.of("Мороженное", "Животные", "Птицы", "Рыба");
        Mockito.when(lion1.getFood("Хищник")).thenReturn(expected);
        List<String> actual = lion1.getFood("Хищник");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void kittenCount1() {
        feline = new Feline();
        lion = new Lion(feline);
        Lion lion1 = Mockito.spy(lion);
        int expected = 1;
        Mockito.when(lion1.getKittens()).thenReturn(expected);
        int actual = lion1.getKittens();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void lionHasManeMale() throws Exception {
        lion = new Lion("Самец", feline);
        boolean expected = true;
        boolean actual = lion.doesHaveMane();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void lionHasManeFemale() throws Exception {
        lion = new Lion("Самка", feline);
        boolean expected = false;
        boolean actual = lion.doesHaveMane();
        Assert.assertEquals(expected, actual);
    }

    @RunWith(Parameterized.class)
    public static class InvalidLionSexTest {
        @Mock
        String sex;
        Lion lion;
        Feline feline;

        @Parameterized.Parameters(name = "{0}")
        public static Object[] getMessage() {
            return new Object[]{
                    null,
                    "Male",
                    "Female",
                    "Лев",
                    "Львица",
            };
        }

        public InvalidLionSexTest(String sex) {
            this.sex = sex;
        }

        @Test
        public void invalidLionSex() {
            Exception message = assertThrows(Exception.class, () -> lion = new Lion(sex, feline));
            String expected = "Используйте допустимые значения пола животного - самец или самка";
            String actual = message.getMessage();
            Assert.assertEquals(expected, actual);
        }

        @Test(expected = java.lang.Exception.class)
        public void messageExcept() {
            try {
                lion = new Lion("Male", feline);
            } catch (Exception message) {
                throw new RuntimeException(message);
            }
        }
    }
}
