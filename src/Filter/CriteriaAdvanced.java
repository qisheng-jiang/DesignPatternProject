package Filter;

import java.util.ArrayList;
import java.util.List;

public class CriteriaAdvanced implements Criteria{
    //Advanced land screening
    @Override
    public List<Field> meetCriteria(List<Field> fields) {
        List<Field> AdvancedFields = new ArrayList<Field>();
        for (Field field : fields) {
            if(field.checkUpdated()){
                AdvancedFields.add(field);
            }
        }
        return AdvancedFields;
    }
}