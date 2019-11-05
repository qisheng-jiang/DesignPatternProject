package interceptingFilter;

import java.util.ArrayList;
import java.util.List;

//过滤器链带有多个过滤器，并在 Target 上按照定义的顺序执行这些过滤器
//The filter chain has multiple filters and executes them in a defined order on the Target
public class FilterChain {
    private List<Filter> filters = new ArrayList<Filter>();
    private Target target;

    public void addFilter(Filter filter){
        filters.add(filter);
    }

    public void execute(String request){
        for (Filter filter : filters) {
            filter.execute(request);
        }
        target.execute(request);
    }

    public void setTarget(Target target){
        this.target = target;
    }
}
