import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.Group;
import javafx.scene.shape.*; // Use (*) as I have more shape to create
import javafx.scene.paint.Color;

import javafx.util.Duration;
import java.util.Random;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;

/****************************************************************************
 * Use JavaFX to sketch a snowperson on the grass at night
 * with a button to change the background from day to night
 *
 * @author NGUYEN THANH KHOI TRAN
 * @version Assgn4_W24_v03
 * @date Feb 19th, 2024
 ****************************************************************************/
public class SnowPerson extends Application
{
    // Instance data
    private static int count = 1;
    private static final int NUM_SNOWFLAKES = 100;
    private static final double R_SNOWFLAKE = 3;
    private static final double SPEED = 3;
    
    @Override
    public void start(Stage ps) throws Exception
    {
        // Instantiate a Group object and Random object
        Group root = new Group ();
        Random rd = new Random ();
        
        // Create a day background
        Rectangle day = new Rectangle (1000,500);
        day.setFill (Color.rgb(135,206,250));
        
        // Create a night background
        Rectangle night = new Rectangle (1000,500);
        night.setFill (Color.web("#13294B"));
        
        // Create a grassland in the day
        Rectangle grass = new Rectangle (0, 250, 1000, 600);
        grass.setFill(Color.web("#114B38"));
        
        // Create a sun
        Circle sun = new Circle (960, 30, 60);
        sun.setFill (Color.YELLOW);
        sun.setStroke (Color. ORANGE);
        
        // Create a crescent moon
        Group moon = new Group();
        Circle bigCir = new Circle (900, 80, 70);
        bigCir.setFill (Color.rgb(246,241,213));
        
        Circle smallCir = new Circle (935, 70, 70);
        smallCir.setFill(Color.web("#13294B"));
        
        moon.getChildren().addAll (bigCir, smallCir);
        
        // Create some clouds
        Group cloud1 = new Group();
        Group cloud2 = new Group();
        
            // First cloud
        Circle c1 = new Circle(150, 50, 40);
        Circle c2 = new Circle(190, 50, 40);
        Circle c3 = new Circle(240, 50, 40);
        Ellipse e1 = new Ellipse(200, 70, 40, 30);
        Ellipse e2 = new Ellipse(170, 70, 40, 30);
        Ellipse e3 = new Ellipse(220, 70, 40, 30);
        
        cloud1.getChildren().addAll (c1,c2,c3,e1,e2,e3);
        
            // Second cloud
        Circle c4 = new Circle(490, 50, 40);
        Circle c5 = new Circle(530, 50, 40);
        Circle c6 = new Circle(580, 50, 40);
        Ellipse e4 = new Ellipse(540, 70, 40, 30);
        Ellipse e5 = new Ellipse(510, 70, 40, 30);
        Ellipse e6 = new Ellipse(560, 70, 40, 30);
        
        cloud2.getChildren().addAll (c4,c5,c6,e4,e5,e6);
        nightCloud (c1,c2,c3,e1,e2,e3,c4,c5,c6,e4,e5,e6);
        
        // Create snowfall
        Group snow = new Group ();
        for (int i = 0; i < NUM_SNOWFLAKES; i++) {
            Circle snowflake = new Circle(R_SNOWFLAKE, Color.WHITE);
            snowflake.setCenterX(rd.nextDouble() * 1000);
            snowflake.setCenterY(rd.nextDouble() * 500);
            snow.getChildren().add(snowflake);

            // Create timeline for each snowflake
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20), e -> 
            {
                // Update snowflake position
                double speed = rd.nextDouble() * SPEED;
                snowflake.setCenterY(snowflake.getCenterY() + speed);

                // Reset position if snowflake reaches bottom
                if (snowflake.getCenterY() > 500) 
                {
                    snowflake.setCenterY(0);
                    snowflake.setCenterX(rd.nextDouble() * 1000);
                }
            }));
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();
        }
        
        // Create a snowman
        Group snowMan = new Group ();
        
        Circle c7 = new Circle (500, 350, 80);
        c7.setFill (Color.WHITE);
        Circle c8 = new Circle (500, 230, 65);
        c8.setFill (Color.WHITE);
        
        Circle eye_L = new Circle (480, 210, 7);
        eye_L.setFill (Color.BLACK);
        Circle eye_R = new Circle (520, 210, 7);
        eye_R.setFill (Color.BLACK);
        
        Circle nose = new Circle (500, 230, 7);
        nose.setFill (Color.ORANGE);
        
        Arc mouth = new Arc(500, 250, 20, 15, 0, -180);
        mouth.setType(ArcType.OPEN);
        mouth.setStroke(Color.BLACK);
        mouth.setFill(Color.TRANSPARENT);
        
        Line hand_R = new Line(580, 340, 635, 300);
        hand_R.setStrokeWidth(5);
        hand_R.setStroke(Color.BROWN);
        
        Line hand_L = new Line(420, 340, 365, 300);
        hand_L.setStrokeWidth(5);
        hand_L.setStroke(Color.BROWN);
        
        // Create a rectangle for the hat base
        Rectangle hatBase = new Rectangle(470, 155, 60, 10);
        hatBase.setFill(Color.RED);
        
        // Create a polygon for the hat top (triangular part)
        Polygon hatTop = new Polygon(470, 155, 500, 130, 530, 155);
        hatTop.setFill(Color.RED);
        
        Group hat = new Group (hatBase, hatTop);
        
        snowMan.getChildren().addAll (c7,c8, eye_L, eye_R, nose, hand_L, hand_R, mouth, hat);
        
        // Create a button to change from day to night and vice versa
        Pane p = new Pane ();
        Button change = new Button ("CHANGE");
        change.setStyle("-fx-font-size: 16; -fx-font-weight: bold;");
        change.setOnAction (new EventHandler <ActionEvent> ()
        {
            @Override
            public void handle (ActionEvent event)
            {
                count++;
                if (count % 2 == 0)
                {
                    // Move to morning scene
                    root.getChildren().clear();
                    
                    // Grass colour in the morning
                    grass.setFill (Color.rgb (117,214,177));
                    
                    // Cloud colour in the morning
                    dayCloud (c1,c2,c3,e1,e2,e3,c4,c5,c6,e4,e5,e6);
                    
                    root.getChildren().addAll (day, grass, cloud1, cloud2, snow, p, sun, snowMan);
                }
                else
                {
                    // Move to night scene
                    root.getChildren().clear();
                    
                    // Grass colour at night
                    grass.setFill(Color.web("#114B38"));
                    
                    // Cloud colour at night
                    nightCloud (c1,c2,c3,e1,e2,e3,c4,c5,c6,e4,e5,e6);
                    
                    root.getChildren().addAll (night, grass, cloud1, cloud2, snow, p, moon, snowMan);
                }
            }
        });
        change.setLayoutX(455);
        change.setLayoutY(460);
        p.getChildren().add(change);
        
        // JavaFX must have a Scene (window content) inside a Stage (window)
        root.getChildren().addAll(night, grass, moon, cloud1, cloud2, snow, p, snowMan);
        
        Scene scene = new Scene(root, 1000, 500);
        ps.setTitle("SNOWMAN");
        ps.setScene(scene);
        
        // Avoid resize the window
        ps.setResizable(false);
        
        // Show the Stage (window)
        ps.show();
    }
    
    // colour method for morning cloud
    private void dayCloud (Circle a1, Circle b1, Circle c1, Ellipse m1, Ellipse n1, Ellipse p1, Circle a2, Circle b2, Circle c2, Ellipse m2, Ellipse n2, Ellipse p2)
    {
        a1.setFill(Color.WHITE);
        b1.setFill(Color.WHITE);
        c1.setFill(Color.WHITE);
        m1.setFill(Color.WHITE);
        n1.setFill(Color.WHITE);
        p1.setFill(Color.WHITE);
        a2.setFill(Color.WHITE);
        b2.setFill(Color.WHITE);
        c2.setFill(Color.WHITE);
        m2.setFill(Color.WHITE);
        n2.setFill(Color.WHITE);
        p2.setFill(Color.WHITE);
    }
    
    // Colour method for night cloud
    private void nightCloud (Circle a1, Circle b1, Circle c1, Ellipse m1, Ellipse n1, Ellipse p1, Circle a2, Circle b2, Circle c2, Ellipse m2, Ellipse n2, Ellipse p2)
    {
        a1.setFill(Color.web("#546BAB"));
        b1.setFill(Color.web("#546BAB"));
        c1.setFill(Color.web("#546BAB"));
        m1.setFill(Color.web("#546BAB"));
        n1.setFill(Color.web("#546BAB"));
        p1.setFill(Color.web("#546BAB"));
        a2.setFill(Color.web("#546BAB"));
        b2.setFill(Color.web("#546BAB"));
        c2.setFill(Color.web("#546BAB"));
        m2.setFill(Color.web("#546BAB"));
        n2.setFill(Color.web("#546BAB"));
        p2.setFill(Color.web("#546BAB"));
    }
}
