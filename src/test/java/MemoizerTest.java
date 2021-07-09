import org.junit.jupiter.api.Test;

public class MemoizerTest {

    private final Memoizer<Integer, Integer> underTest = new Memoizer<>();

    @Test
    public void test() {
        // Arrange

        // Act
        underTest.memoize(x -> x);

        // Assert

    }
}
