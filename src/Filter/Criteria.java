package Filter;

import java.util.List;

public interface Criteria {
    List<Field> meetCriteria(List<Field> fields);
}
