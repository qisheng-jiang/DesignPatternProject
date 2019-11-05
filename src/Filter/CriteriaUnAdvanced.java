package Filter;

import java.util.ArrayList;
import java.util.List;

public class CriteriaUnAdvanced implements Criteria{
    //Non senior land screening
    @Override
    public List<Field> meetCriteria(List<Field> fields) {
        List<Field> unAdvancedFields = new ArrayList<Field>();
        for (Field field : fields) {
            if(!field.checkUpdated()){
                unAdvancedFields.add(field);
            }
        }
        return unAdvancedFields;
    }
}