import java.util.Random;


class Main {

    public static void main(String[] args) {

        int[] d = {15, 13, 11, 9, 7, 5, 3};
        double[] x = new double[12];
        Random random =     new Random();
        float min = -9.0F;
        float max = 3.0F;

        for (int i = 0; i<12; ++i) {
            x[i] = min + random.nextFloat() * (max-min);
        }

        double[][] f = new double[7][12];
        for (int i = 0; i<7; ++i) {
            for (int j = 0; j<12; ++j) {

                if (d[i] == 9) {
                    f[i][j] = Math.cos(Math.atan(Math.sin(x[j])));
                }

                else if ((d[i]==5) || (d[i] == 3) || (d[i] == 11)) {
                    f[i][j] = Math.tan(Math.pow(Math.tan(x[j]), 1.0/3.0));
                }
                else {

                    f[i][j] = Math.cos(Math.pow(Math.pow(2*x[j], 3)+Math.PI, 3)/4);

                }
            }
        }


        for (int i = 0; i < 7; ++i) {
            for (int j = 0; j < 12; ++j) {

                System.out.print(String.format("%.4f ", f[i][j]));


            }
            System.out.println("");
        }

    }
}






