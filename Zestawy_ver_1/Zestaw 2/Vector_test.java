class Vector {
    int dimensions;
    int [] sizes;
    double [] values;

    Vector (int dimensions, int [] sizes, double [] values) {
        this.dimensions = dimensions;
        this.sizes = sizes;
        this.values = values;
    }

    boolean equal_size(Vector other) {
        return dimensions == other.dimensions;
    }

    // Vector add(Vector other) {
    //     if equal_size(other) {
    //         ;
    //     }
    // }

}


public class Vector_test {
    
}
