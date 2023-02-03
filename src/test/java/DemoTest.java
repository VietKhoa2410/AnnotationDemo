import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.example.annotation.retention.ClassAnnotation;
import org.example.annotation.retention.RuntimeAnnotation;
import org.example.annotation.retention.SourceAnnotation;
import org.example.model.Customer;
import org.junit.jupiter.api.Test;

@Log4j2
public class DemoTest {
  @Test
  void retentionTest(){
    SourceAnnotation sourceAnnotation = Customer.class.getAnnotation(SourceAnnotation.class);
    log.info("Source annotation: {}", sourceAnnotation);
    ClassAnnotation classAnnotation = Customer.class.getAnnotation(ClassAnnotation.class);
    log.info("Class annotation: {}", classAnnotation);
    RuntimeAnnotation runtimeAnnotation = Customer.class.getAnnotation(RuntimeAnnotation.class);
    log.info("Runtime annotation: {}", runtimeAnnotation);
  }

  @Test
  void nonNullTest() {
    @NonNull String name = null;

    @NonNull Integer age = null;

    age = 20;
  }
}
