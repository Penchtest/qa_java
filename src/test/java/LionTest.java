import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline feline;

    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion("Самка", feline);
        List<String> food = List.of("Корм", "Мясо", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(food);
        Assert.assertEquals(food, lion.getFood());
    }

    @Test
    public void doesHaveManeTrue() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Assert.assertTrue(lion.doesHaveMane());
    }

    @Test
    public void doesHaveManeFalse() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Assert.assertFalse(lion.doesHaveMane());
    }

    @Test
    public void doesHaveManeNone() throws Exception {
        Exception exception = Assert.assertThrows(Exception.class, () -> {
            new Lion("Мужской", feline);
        });
        Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

}
