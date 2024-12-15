package Turing;

public abstract class Employee {
    private String workplace;
    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public abstract String getTitle();
}
