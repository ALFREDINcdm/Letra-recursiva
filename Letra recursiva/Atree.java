/******************************************************************************
 *  Compilation:  javac Htree.java
 *  Execution:    java Htree n
 *  Dependencies: StdDraw.java
 *
 *  Plot an order n H-tree.
 *
 *  % java Htree 5
 *
 ******************************************************************************/

public class Atree {

    // plot an A, centered on (x, y) of the given side length
    public static void drawA(int n,double x, double y, double size) {
        if(n==0)
            return;
        // compute the coordinates of the 4 tips of the H
        double x0 = x - size/2;
        double x1 = x + size/2;
        double y0 = y - size/2;
        double y1 = y + size/2;
          
        // se colocan las cordenadas de tal manera que pueda dibujarse una letra A
        // Utilizamos el metodo setPenColor para asginarle un color a nuestra linea
        StdDraw.setPenColor(StdDraw.MAGENTA);
        StdDraw.line(x0, y0, x, y1);  //dibuja una / para la A

        StdDraw.setPenColor(StdDraw.CYAN); 
        StdDraw.line(x0,  y, x1,y);  // dubuja una linea - para formar la A

        StdDraw.setPenColor(StdDraw.PINK);
        StdDraw.line(x1, y0, x, y1);    //dibuja la linea \ para formar la A
        
        // crea un intervalo de un segundo para crear una letra 
        StdDraw.pause(1000);
       
        //aplicamos recursion
        drawA(n-1, x1, y1, size/2);   
        drawA(n-1, x1, y0, size/2);  

        drawA(n-1, x0, y0, size/2);   
        drawA(n-1, x0, y1, size/2);  
    }

    // reads an integer command-line argument n and plots an order n H-tree
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        double x = 0.5, y = 0.5;   // center of A-tree
        double size = 0.5;         // side length of A-tree
        StdDraw.setPenRadius(0.005); //establecemos un radio especifico

        drawA(n,x,y, size);
    }
}
