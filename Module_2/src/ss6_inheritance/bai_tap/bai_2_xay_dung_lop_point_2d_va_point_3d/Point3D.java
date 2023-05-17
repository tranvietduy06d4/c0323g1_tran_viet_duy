package ss6_inheritance.bai_tap.bai_2_xay_dung_lop_point_2d_va_point_3d;

import java.util.Arrays;

public class Point3D extends Point2D {
    private float z;

    public Point3D() {

    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z) {
        setX(x);
        setY(y);
        setZ(z);
    }

    public float[] getXYZ() {
        float[] arrayXYZ = new float[3];
        arrayXYZ[0] = getX();
        arrayXYZ[1] = getY();
        arrayXYZ[2] = getZ();
        return arrayXYZ;
    }

    @Override
    public String toString() {
        return "Point3D{" +
                "arrayXYZ=" + Arrays.toString(getXYZ()) +
                '}';
    }
}
