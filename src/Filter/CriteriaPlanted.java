package Filter;

import java.util.ArrayList;
import java.util.List;

public class CriteriaPlanted implements Criteria {
    //Screening of cultivated land
    @Override
    public List<Field> meetCriteria(List<Field> fields) {
        List<Field> plantedFields = new ArrayList<Field>();
        for (Field field : fields) {
            if(field.checkCrop()!=null){
                plantedFields.add(field);
            }
        }
        return plantedFields;
    }
}
