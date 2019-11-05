package Filter;

import java.util.ArrayList;
import java.util.List;

public class CriteriaUnplanted implements Criteria{
    //Uncultivated land screening
    @Override
    public List<Field> meetCriteria(List<Field> fields) {
        List<Field> unPlantedFields = new ArrayList<Field>();
        for (Field field : fields) {
            if(field.checkCrop()==null){
                unPlantedFields.add(field);
            }
        }
        return unPlantedFields;
    }
}