package task01;

public class Pen {

    private String name;
    private String color;

    public Pen(String name, String color){
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Pen { name: " + name +
                ", color " + color +
                " }";
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null)
            return false;

        if (this == obj)
            return true;

        if (this.getClass() != obj.getClass())
            return false;

        Pen pen = (Pen) obj;

        return (this.name.equals(pen.getName()) && this.color.equals(pen.getColor()));
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + color.hashCode();
        return result;
    }
}
