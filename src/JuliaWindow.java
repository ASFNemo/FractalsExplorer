import java.awt.*;

public class JuliaWindow extends Canvas{

    int size;
    int iterationsToComplete;

    double xMax;
    double yMin;
    double xMin;
    double yMax;

    public JuliaWindow(){
        size = 600;
        iterationsToComplete = 500;

        xMax = 2;
        yMin = -1.6;
        xMin = -2;
        yMax = 1.6;
    }

    public void paint(Graphics g){
        System.out.println("I am painting");

        for (int i =0; i < size; i++){
            for (int j = 0; j<size; j++){

                double[] infoArray = amountOfIterations(new ComplexNumbers(getY(i), getX(j)));
                int totalIterations = (int) infoArray[1];
                g.setColor((totalIterations == getIterationsToComplete()) ? Color.BLACK : new Color(180,
                        (totalIterations*2)%254, 0));

                g.drawLine(i, j, i, j);
            }
        }
    }

    protected double[] amountOfIterations(ComplexNumbers complexNumber){
        ComplexNumbers DCN = new ComplexNumbers(0.5, 0.5);
        ComplexNumbers cNumber =  complexNumber;
        double totalIterations = 0;
        double[] infoArray = new double[2];
        while ((totalIterations < getIterationsToComplete()) && cNumber.modulusSquared() < 4){

            cNumber.square();
            cNumber.add(DCN);

            totalIterations++;
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
        return y;
        //return (3.2*realY)/size;
    }

    public double getdY(double realY){
        double y = (((double) realY)/(600));
        y = y * (yMax - yMin);
        y = y + yMin;
        //setFractalY(y);
        return y;
        //return (3.2*realY)/size;
    }


    public double getX(double realX){

        double x = (realX)/(this.getWidth());
        x = x * (xMax - xMin);
        x = x + xMin;

        //setFractalX(x);

        return x;
        //return (4*realX)/size;
    }


    public double getdX(double realX){

        double x = (realX)/(600);
        x = x * (xMax - xMin);
        x = x + xMin;

        //setFractalX(x);

        return x;
        //return (4*realX)/size;
    }

}












//import java.awt.*;
//
////
/////**
//// * Created by asherfischbaum on 05/03/2016.
//// */
//public class JuliaWindow extends Canvas{
//
//    int size;√
//    int iterationsToComplete; √
//    int iterationsCompleted;
//
//    ComplexNumbers complexNumberPassedIn;
//
//    double xMax;
//    double yMin;
//    double xMin;
//    double yMax;
//
//    double fractalX;
//    double fractalY;
//
//    double cReal;
//    double cImaginary;
//
//    public JuliaWindow(ComplexNumbers cNum, double real, double imaginary) {
//        //toDraw = false;
//
//        size = 600; // check if we can make the same
//        iterationsToComplete = 500; // check if we can make the same
//
//        //complexNumberSet = new ComplexNumbers[size][size];
//
//        xMax = 2;
//        yMin = -1.6;
//        xMin = -2;
//        yMax = 1.6;
//
//        this.cReal = real;
//        this.cImaginary = imaginary;
//
//        this.complexNumberPassedIn = cNum;
//
////        //double xStep = (xMin * xMax) / size;
////        //double yStep = (yMax * yMin) / size;
//////
//    }
//////
//    public void paint(Graphics g) {
//////        //if (toDraw) {
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) {
//////                //int totalIterations = amountOfIterations(complexNumberSet[i][j]); // convert the pixel to a complex number!!!
//////                //int totalIterations = amountOfIterations(new ComplexNumbers(getY(j), getX(i)));
//////                //int totalIterations = amountOfIterations(complexNumberSet);
//////                //g.setColor((totalIterations == iterationsToComplete) ? Color.BLACK : new Color(180, (totalIterations*2)%254, 0)); // change this to do the colors more simply
//////                //g.setColor(new Color(Math.round(225/(totalIterations+1)), Math.round(225/(totalIterations+1)),
//////                //      Math.round(225/(totalIterations+1))));
//////                //g.fillRect(i, j, 1, 1);
//////                //int color = iterationsToComplete - totalIterations;
////////                    //g.setColor(new Color(color, color, color));
////////                    if (amountOfIterations(new ComplexNumbers(getY(i), getX(j))).modulusSquared() <= 4){
////////                        g.setColor(Color.BLACK);
////////                    } else {
////////                        g.setColor(Color.WHITE);
////////                    }
//////
//                //double[] infoArray = amountOfIterations(new ComplexNumbers(getY(i), getX(j)));
//                double[] infoArray = amountOfIterations(new ComplexNumbers(getY(i), getX(j)));
//                //double[] infoArray = amountOfIterations(complexNumberPassedIn);
//                int totalIterations = (int) infoArray[1];
//                g.setColor((totalIterations == iterationsToComplete) ? Color.BLACK : new Color(180, (totalIterations*2)%254, 0)); // change this to do the colors more simply
////////                    g.setColor(new Color(Math.round(2*(totalIterations+1)/225), Math.round(2*(totalIterations+1)/225),
////////                    Math.round(2*(totalIterations+1)/225)));
//////
//////
////                    g.setColor(new Color(
////                            (new Random()).nextInt(255),
////                            (new Random()).nextInt(255),
////                            (new Random()).nextInt(255)
////                    ));
//
//                g.drawLine(i, j, i, j);
//            }
//        }
//        //}
//    }
//////
//    protected double[] amountOfIterations(ComplexNumbers complexNumber) {
//        ComplexNumbers cNumber = new ComplexNumbers(getY(1), getX(1));
//        double totalIterations = 0;
//        double[] infoArray = new  double[2];
//        while ((totalIterations < iterationsToComplete) && complexNumber.modulusSquared() < 4) {
//            totalIterations++;
//
//            //System.out.println("foo");
//            //cNumber = cNumber.multiply(cNumber).add(complexNumberPassedIn);
//
//            //this.complexNumberPassedIn.square();
//
//            complexNumber.square();
//            complexNumber.add(cNumber);
//            //cNumber.square();
//            //cNumber.add(this.complexNumberPassedIn);
//
////            if (totalIterations % 10 == 0) {
////
////                System.out.println("real: " + complexNumberPassedIn.getReal() + " complex: " + complexNumberPassedIn.getComplex()
////                        + " Total iterations: " + totalIterations + " magnitude: " + cNumber.modulusSquared());
////            }
//        }
//
//        infoArray[0] = complexNumber.modulusSquared();
//        infoArray[1] = totalIterations;
//
//
//        return infoArray;
//        //return totalIterations;
//    }
//
//    public double getY(double realY){
//        double y = (((double) realY)/(this.getHeight()));
//        y = y * (yMax - yMin);
//        y = y + yMin;
//        return y;
//    }
//
//    public double getX(double realX){
//
//        double x = (realX)/(this.getWidth());
//        x = x * (xMax - xMin);
//        x = x + xMin;
//
//        return x;
//    }
//}