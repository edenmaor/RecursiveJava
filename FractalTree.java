import java.awt.Color;

public class FractalTree {
    private static final int recursionDepth = 14;
    private static final Color rootColor = Color.BLACK;
    private static final Color leafColor = new Color(195, 255, 112);
    private static final double trunkWidth = 0.008;
    private static final double factor = 0.8;
    private static final int canvasWidth = 600;
    private static final int canvasHeight = 400;
    private static final double branchAngle = Math.PI/4;
    private static final double anglePerturb = 6.0;
    private static final double minWidth = 0.002;
    // private static int counter = 0;

    private static Color adjustColor(int level) {
        double w = (double)level / recursionDepth;
        double red = w * rootColor.getRed() + (1-w) * leafColor.getRed();
        double green = w * rootColor.getGreen() + (1-w) * leafColor.getGreen();
        double blue = w * rootColor.getBlue() + (1-w) * leafColor.getBlue();

        return new Color((int)red, (int)green, (int)blue);
    }

    private static double adjustWidth(int level) {
        double w = (double)level / recursionDepth;
        return Math.max(minWidth, trunkWidth * w);
    }

    /** recursivly generate random fractal tree with a given level
     *
     * @param level- n level
     * @param x0- starting point
     * @param y0- starting point
     * @param length- the length of the branches
     * @param angle- thr angle of the branches
     * @return - a random fractal tree
     */

    public static void drawBranch(int level, double x0, double y0, double length, double angle) {
        //TODO: Implement
        if(level == 0)
            return;

        double newBranch = Math.random()*length;
        StdDraw.setPenColor(adjustColor(level));
        StdDraw.setPenRadius(adjustWidth(level));
        double x1 = x0+newBranch*Math.cos(angle);
        double y1 = y0+ newBranch*Math.sin(angle);
        StdDraw.line(x0,y0,x1,y1);
        double m = anglePerturb/(double)level;
        double angle1 = angle+Math.random()*branchAngle*m;
        double angle2 = angle+Math.random()*branchAngle*m;
        drawBranch(level-1,x1,y1,length*factor,angle1);
        drawBranch(level-1,x1,y1,length*factor,angle2);


    }

    public static void main(String[] args) {
        StdDraw.setXscale(0, canvasWidth);
        StdDraw.setYscale(0, canvasHeight);
        drawBranch(recursionDepth, canvasWidth/2.0, -50, 100, Math.PI/2);
    }
}

// Instructor Comment: Task not performed as required, Your tree always tends to the left
// Grade: -5.0