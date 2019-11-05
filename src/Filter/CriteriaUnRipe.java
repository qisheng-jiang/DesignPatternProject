package Filter;

import java.util.ArrayList;
import java.util.List;

public class CriteriaUnRipe implements Criteria{
    //Immature land screening
    @Override
    public List<Field> meetCriteria(List<Field> fields) {
        List<Field> growingFields = new ArrayList<Field>();
        for (Field field : fields) {
            if(field.checkTime()>0){
                growingFields.add(field);
            }
        }
        return growingFields;
    }
}