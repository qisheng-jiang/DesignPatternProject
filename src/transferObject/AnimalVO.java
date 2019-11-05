package transferObject;

public class AnimalVO {
    private String kind;
    private int total;

    public AnimalVO(String kind, int total){
        this.kind = kind;
        this.total = total;
    }

    public AnimalVO(AnimalVO animalVO){
        this.kind = animalVO.kind;
        this.total = animalVO.total;
    }

    public String getKind(){
        return kind;
    }

    public void setKind(String kind){
        this.kind = kind;
    }

    public int getTotal(){
        return total;
    }

    public void setTotal(int total){
        this.total = total;
    }
}
