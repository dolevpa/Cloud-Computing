package users;

public class Name {

    private String first;
    private String last;

    public Name() {

    }

    public Name(String firstName, String lastName) {
        this.first = firstName;
        this.last = lastName;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    @Override
    public String toString() {
        return "Name [first=" + first + ", last=" + last + "]";
    }

}
