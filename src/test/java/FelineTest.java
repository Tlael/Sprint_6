import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class testFeline {
    @Mock
    Feline feline;

    @Test
    public void eatMeatShouldPredatorFood() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expected);
        List<String> actual = feline.eatMeat();
        assertEquals(expected, actual);
    }
    @Test
    public void getFamilyShouldPredator() throws Exception {
        String expected = new String("Кошачьи");
        Mockito.when(feline.getFamily()).thenReturn(expected);
        String actual = feline.getFamily();
        assertEquals(expected, actual);
    }


}
