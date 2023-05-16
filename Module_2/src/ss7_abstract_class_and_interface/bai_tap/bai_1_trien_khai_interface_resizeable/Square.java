package ss7_abstract_class_and_interface.bai_tap.bai_1_trien_khai_interface_resizeable;

public class Square extends Shape implements Resizeable {
    private double slide;

    public Square() {
    }

    public Square(double slide) {
        this.slide = slide;
    }

    public double getSlide() {
        return slide;
    }

    public void setSlide(double slide) {
        this.slide = slide;
    }

    public double getArea() {
        return slide * this.slide;
    }

    @Override
    public void resize(double percent) {
        setSlide(getSlide()*percent/100);
    }

    @Override
    public String toString() {
        return "A Square with slide ="
                + getSlide()
                + " Area of this square is: "
                + getArea();
    }


}
