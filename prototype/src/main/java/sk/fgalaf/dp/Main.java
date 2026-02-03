package sk.fgalaf.dp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sk.fgalaf.dp.shapes.Circle;
import sk.fgalaf.dp.shapes.Rectangle;
import sk.fgalaf.dp.shapes.Shape;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        List<Shape> shapeList = new ArrayList<>();
        List<Shape> shapeCopyList = new ArrayList<>();

        Circle circle = new Circle();
        circle.setX(10);
        circle.setY(20);
        circle.setRadius(30);
        circle.setColor("red");
        shapeList.add(circle);

        Circle anotherCircle = (Circle) circle.clone();
        shapeList.add(anotherCircle);

        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(15);
        rectangle.setHeight(25);
        rectangle.setColor("blue");
        shapeList.add(rectangle);

        cloneAndCompare(shapeList, shapeCopyList);
    }

    private static void cloneAndCompare(List<Shape> shapeList, List<Shape> shapeCopyList) {
        for (Shape shape : shapeList) {
            shapeCopyList.add(shape.clone());
        }

        for (int i = 0; i < shapeCopyList.size(); i++) {
            if (shapeList.get(i) != shapeCopyList.get(i)) {
                log.info("{}: Shapes are different objects!", i);
                if (shapeList.get(i).equals(shapeCopyList.get(i))) {
                    log.info("{}: And they are identical!", i);
                } else {
                    log.info("{}: But they are not identical!", i);
                }
            } else {
                log.info("{}: Shapes are identical objects!", i);
            }
        }
    }
}