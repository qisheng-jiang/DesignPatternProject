package Filter;

import java.util.List;

public class AndCriteria implements Criteria {
    //And condition screening
    private Criteria criteria;
    private Criteria otherCriteria;

    public AndCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Field> meetCriteria(List<Field> fields) {
        List<Field> firstCriteriaFields = criteria.meetCriteria(fields);
        return otherCriteria.meetCriteria(firstCriteriaFields);
    }
}