package TowerDefense.GameEnitty.Map;

public class Point {
    private int x;
    private int y;

    public static Point ErrPoint = new Point(-1, -1);

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point p) {
        this.x = p.getX();
        this.y = p.getY();
    }

    public Point center() {
        return new Point(this.getX()+32, this.getY()+32);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String toString() {
        return "("+this.x + " " +this.y +")";
    }
}
