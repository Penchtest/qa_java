import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

@RunWith(Parameterized.class)


public class LionTestParameterized {
    private final int amount;
    private final int result;
    @Mock
    Feline feline;

    public LionTestParameterized(int amount, int result) {
        this.amount = amount;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Object[] getKittenData() {
        return new Object[][]{
                {1, 1},
                {2, 2},
                {3, 3}
        };
    }

    @Before
    public void setMock() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Mockito.when(feline.getKittens()).thenReturn(amount);
        Assert.assertEquals(result, lion.getKittens());
    }
}
