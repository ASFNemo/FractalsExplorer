import javax.swing.*;
import java.awt.*;

/**
 * Created by asherfischbaum on 02/03/2016.
 */
public class MandelbrotPanel extends JPanel {

    int windowSiza;
    int iterationsToComplete;

    String fractalToShow;

    double xMax;
    double yMin;
    double xMin;
    double yMax;


    //String FractalToDraw

    double fractalX;
    double fractalY;


    public MandelbrotPanel() {
        windowSiza = 600; // check if we can make the same
        iterationsToComplete = 100; // check if we can make the same

        fractalToShow = "Mandelbrot";
        //complexNumberSet = new ComplexNumbers[windowSiza][windowSiza];

        xMax = 2;
        yMin = -1.6;
        xMin = -2;
        yMax = 1.6;
    }

    public void paintComponent(Graphics g) {
        System.out.println("I am here");
        super.paintComponent(g);


            for (int i = 0; i < windowSiza; i++) {
                for (int j = 0; j < windowSiza; j++) {


                    double[] infoArray = amountOfMAndelbrotIterations(new ComplexNumbers(getX(i), getY(j)));
                    int totalIterations = (int) infoArray[1];
//                    g.setColor((totalIterations == getIterationsToComplete()) ? Color.BLACK : new
//                            Color(180 / (2 * totalIterations), (totalIterations * 2) % 254, 180/ (2 * totalIterations))); // change this to do the colors more simply
//                    g.setColor((totalIterations == getIterationsToComplete()) ? Color.BLACK : new
//                            Color(180 / (totalIterations), 220/ (totalIterations), 180/ (5 * totalIterations)));

//                    g,setRGB(x, y, maxColors * 10%20)
//                    g.setColor(new Color(x, y, iter_counter | (iter_counter << 20)));

//                    g.setColor(new Color(
//                            (new Random()).nextInt(255),
//                            (new Random()).nextInt(255),
//                            (new Random()).nextInt(255)
//                    ));

//                    float saturation = 1f;
//                    float brightness = totalIterations < iterationsToComplete ? 1f : 0;
//                    float hue =  (totalIterations%256)/255.0f;
//                    Color color = Color.getHSBColor((float) hue, saturation, brightness);
//                    g.setColor(color);

//                    g.setColor((totalIterations ==getIterationsToComplete()) ? Color.BLACK : new Color(2*totalIterations/((totalIterations%2 + 1)), totalIterations/5, 4*totalIterations/((totalIterations%4) + 4)));

                   g.setColor((totalIterations ==getIterationsToComplete()) ? Color.BLACK :new Color((2*255)/(totalIterations + 3), (3*255)/(totalIterations + 4), (24*255)/(totalIterations+32)));

//                    g.setColor((totalIterations ==getIterationsToComplete()) ? Color.BLACK :new Color((2*255)/(totalIterations + 3), (2*255)/(totalIterations + 3), (2*255)/(totalIterations + 3)));
                    g.drawLine(i, j, i, j);
                }
            }

        }



    protected double[] amountOfMAndelbrotIterations(ComplexNumbers complexNumber) {
        ComplexNumbers cNumber = new ComplexNumbers();
        double totalIterations = 0;
        double[] infoArray = new  double[2];
        while ((totalIterations < getIterationsToComplete()) && cNumber.modulusSquared() < 4) {
            totalIterations++;

            if (fractalToShow.equals("Mandelbrot")) {
                cNumber.square();
                cNumber.add(complexNumber);
            } else if (fractalToShow.equals("BurningShip")){
                //cNumber.burningShipSquare();
                //cNumber.makePositive();
                cNumber.square();
                cNumber.add(complexNumber);
                cNumber.makePositive();
            } else if (fractalToShow.equals("NewtonsFractal")){
                //cNumber = cNumber.cube();
                cNumber.add(cNumber);
                cNumber.add(new ComplexNumbers(1, 0));

            } else if(fractalToShow.equals("BirdOFPrey")){
                cNumber.cube();
                cNumber.add(complexNumber);
               // System.out.println("bird of prey");

            } else if (fractalToShow.equals("z^8")){
                cNumber.square();
                cNumber.square();
                cNumber.square();

//                cNumber.cube();
//                cNumber.cube();
//                cNumber.cube();
                cNumber.add(complexNumber);
            } else if (fractalToShow.equals("bsv")){
                cNumber.square();
                //cNumber.makePositive();
                cNumber.add(complexNumber);

                //cNumber.makePositive();

            }


        }

        infoArray[0] = cNumber.modulusSquared();
        infoArray[1] = totalIterations;


        return infoArray;
    }



    public void setIterationsToComplete(int iterationsToComplete) {
        this.iterationsToComplete = iterationsToComplete;
    }
    public int getIterationsToComplete() {
        return iterationsToComplete;
    }

    public double getY(double realY){
        double y = (((double) realY)/(this.getHeight()));
        y = y * (yMax - yMin);
        y = y + yMin;
        //setFractalY(y);
        return -y;
        //return (3.2*realY)/windowSiza;
    }

//    public double getdY(double realY){
//        double y = (((double) realY)/(600));
//        y = y * (yMax - yMin);
//        y = y + yMin;
//        return y;
//    }


    public double getX(double realX){

        double x = (realX)/(this.getWidth());
        x = x * (xMax - xMin);
        x = x + xMin;

        return x;
    }

//
//    public double getdX(double realX){
//
//        double x = (realX)/(600);
//        x = x * (xMax - xMin);
//        x = x + xMin;
//
//        return x;
//    }

    public ComplexNumbers getComplexNumber(double real, double complex){
        double realNum = 2* xMin *real/ windowSiza + xMax;
        double complexNum = 2* yMax *complex/ windowSiza + yMin;

        return new ComplexNumbers(realNum, complexNum);

    }

    public double getFractalX() {
        return fractalX;
    }

    public void setFractalX(double fractalX) {
        this.fractalX = fractalX;
    }

    public double getFractalY() {
        return fractalY;
    }

    public void setFractalY(double fractalY) {
        this.fractalY = fractalY;
    }


    public int getWindowSiza() {
        return windowSiza;
    }

    public void setWindowSiza(int windowSiza) {
        this.windowSiza = windowSiza;
    }

    public void setxMax(double xMax) {
        this.xMax = xMax;
    }

    public void setyMin(double yMin) {
        this.yMin = yMin;
    }

    public void setxMin(double xMin) {
        this.xMin = xMin;
    }

    public void setyMax(double yMax) {
        this.yMax = yMax;
    }

    public double getxMax() {
        return xMax;
    }

    public double getyMin() {
        return yMin;
    }

    public double getxMin() {
        return xMin;
    }

    public double getyMax() {
        return yMax;
    }

    public void setFractalToShow(String fractalToShow) {
        this.fractalToShow = fractalToShow;
    }
}
