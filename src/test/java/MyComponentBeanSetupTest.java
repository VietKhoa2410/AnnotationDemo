
import lombok.NonNull;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.GenericWebApplicationContext;

@Component
class MyComponentBeanSetupTest {

  private GenericWebApplicationContext applicationContext = new GenericWebApplicationContext();
  @Test
  void create() {
    @NonNull String name = null;

    @NonNull Integer age = null;

    age = 20;
  }
}