import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    @Mock
    Feline feline;

    @Test
    public void eatMeatShouldPredatorFood() throws Exception {
        feline = new Feline();
        Feline feline1 = Mockito.spy(feline);
        List<String> expected = List.of("Мороженное", "Животные", "Птицы", "Рыба");
        Mockito.when(feline1.getFood("Хищник")).thenReturn(expected);
        List<String> actual = feline1.eatMeat();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getFamilyShouldPredator() {
        feline = new Feline();
        Feline feline1 = Mockito.spy(feline);
        String expected = "Кошачьи";
        Mockito.when(feline1.getFamily()).thenReturn(expected);
        String actual = feline1.getFamily();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void kittenCount() {
        feline = new Feline();
        Feline feline1 = Mockito.spy(feline);
        int expected = 1;
        Mockito.when(feline1.getKittens()).thenReturn(expected);
        int actual = feline1.getKittens();
        Assert.assertEquals(expected, actual);
    }
}
