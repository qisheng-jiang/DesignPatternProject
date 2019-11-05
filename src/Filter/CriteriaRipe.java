package Filter;

import java.util.ArrayList;
import java.util.List;

public class CriteriaRipe implements Criteria{
    //Harvesting land screening
    @Override
    public List<Field> meetCriteria(List<Field> fields) {
        List<Field> harvestedFields = new ArrayList<Field>();
        for (Field field : fields) {
            if(field.checkTime()==0){
                harvestedFields.add(field);
            }
        }
        return harvestedFields;
    }
}
