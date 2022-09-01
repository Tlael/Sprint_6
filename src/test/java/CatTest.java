import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    Feline feline;
    Cat cat;

    @Test
    public void soundCat() {
        String expected = "Мяу";
        String actual = Cat.getSound();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void eatMeatPredatorFood() throws Exception {
        feline = new Feline();
        cat = new Cat(feline);
        Cat cat1 = Mockito.spy(cat);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(cat1.getFood()).thenReturn(expected);
        List<String> actual = cat1.getFood();
        Assert.assertEquals(expected, actual);
    }
}
