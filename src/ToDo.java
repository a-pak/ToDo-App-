public class ToDo {

    private int id;
    private String name;
    private String desc;
    private Boolean state;

    public ToDo(int id, String name, String desc, Boolean state) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.state = state;
    }
    public ToDo(String name, String desc) {
        this(-1, name, desc, false);
    }

    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public Boolean getState() {
        return state;
    }
    public void setState(Boolean state) {
        this.state = state;
    }
}
