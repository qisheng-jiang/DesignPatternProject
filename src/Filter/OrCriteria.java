package Filter;

import java.util.List;

public class OrCriteria implements Criteria {
    //Or condition filter

    private Criteria criteria;
    private Criteria otherCriteria;

    public OrCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Field> meetCriteria(List<Field> fields) {
        List<Field> firstCriteriaItems = criteria.meetCriteria(fields);
        List<Field> otherCriteriaItems = otherCriteria.meetCriteria(fields);

        for (Field field : otherCriteriaItems) {
            if(!firstCriteriaItems.contains(field)){
                firstCriteriaItems.add(field);
            }
        }
        return firstCriteriaItems;
    }
}
