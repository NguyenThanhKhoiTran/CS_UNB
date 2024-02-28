import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

import javafx.util.Duration;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;

/***********************************************************************
 * Using JavaFX  to design an apology image for not doing some previous
 * bonus question
 *
 * @author NGUYEN THANH KHOI TRAN
 * @version Assgn4_W24_v02
 * @date Feb 24th, 2024
 ***********************************************************************/
public class ApologyImage extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        // Instantiate a Group object and two button
        Group root = new Group ();
        Button yes = new Button ("Yes, of course (*^_^*)");
        Button no = new Button ("No, never ⚆_⚆");
        
        // Create a background
        Rectangle bg = new Rectangle (1000,500);
        bg.setFill (Color.rgb(135,206,250));
        
        // Sketch a circle for a face
        Circle face = new Circle (500, 250, 150);
        face.setFill (Color.YELLOW);
        face.setStroke (Color.BLACK);
        face.setStrokeWidth (10);
        
        // Sketch two eyes
        Circle eyeL = new Circle (430, 200, 20);
        eyeL.setFill (Color.BLACK);
        eyeL.setStrokeWidth (3);
        
        Circle eyeR = new Circle (570, 200, 20);
        eyeR.setFill (Color.BLACK);
        eyeR.setStrokeWidth (3);
        
        // Sketch smile mouth
        Arc smileMouth = new Arc(500, 270, 60, 50, 0, -180);
        smileMouth.setType(ArcType.OPEN);
        smileMouth.setStroke(Color.BLACK);
        smileMouth.setFill(Color.TRANSPARENT);
        smileMouth.setStrokeWidth (10);
        
        // Sketch sad mouth
        Arc sadMouth = new Arc(500, 300, 80, 60, 0, 180);
        sadMouth.setType(ArcType.OPEN);
        sadMouth.setStroke(Color.BLACK);
        sadMouth.setFill(Color.TRANSPARENT);
        sadMouth.setStrokeWidth (10);
        
        // Write the word 'My apologies'
        Label apology = new Label ("MY APOLOGIES FOR NOT DOING BONUS QUESTIONS");
        Label emo1 = new Label (".·´¯`(>▂<)´¯`·. ");
        apology.setStyle ("-fx-font-size: 30; -fx-font-weight: bold");
        emo1.setStyle ("-fx-font-size: 30; -fx-font-weight: bold");
        
        VBox vb1 = new VBox (apology, emo1);
        vb1.setAlignment (Pos.TOP_CENTER);
        vb1.setLayoutX (130);
        vb1.setLayoutY (7);
        
        // Write the word 'Thank you for forgiving me'
        Label thank = new Label ("THANK YOU FOR FORGIVING ME");
        Label emo2 = new Label ("o(*^＠^*)o");
        thank.setStyle ("-fx-font-size: 30; -fx-font-weight: bold");
        emo2.setStyle ("-fx-font-size: 30; -fx-font-weight: bold");
        
        VBox vb2 = new VBox (thank, emo2);
        vb2.setAlignment (Pos.TOP_CENTER);
        vb2.setLayoutX (270);
        vb2.setLayoutY (7);
        
        // Write the word 'WHYYYYYYYYY'
        Label sad = new Label ("WHYYYYYYYYY ????");
        Label emo3 = new Label ("┗( T﹏T )┛");
        sad.setStyle ("-fx-font-size: 30; -fx-font-weight: bold");
        emo3.setStyle ("-fx-font-size: 30; -fx-font-weight: bold");
        
        VBox vb3 = new VBox (sad, emo3);
        vb3.setAlignment (Pos.TOP_CENTER);
        vb3.setLayoutX (365);
        vb3.setLayoutY (7);
        
        // Write "Do you forgive me? ::>_<::"
        Label ask = new Label ("Do you forgive me? ::>_<::");
        ask.setStyle ("-fx-font-size: 30; -fx-font-weight: bold");
        ask.setLayoutX (325);
        ask.setLayoutY (430);
        
        // Sketch teardrops
        Ellipse tear1 = new Ellipse (430, 230, 5, 10);
        tear1.setStroke(Color.BLACK);
        tear1.setStrokeWidth (5);
        tear1.setFill (Color.web ("#86b9d8"));
        
        Ellipse tear2 = new Ellipse (430, 260, 5, 10);
        tear2.setStroke(Color.BLACK);
        tear2.setStrokeWidth (5);
        tear2.setFill (Color.web ("#86b9d8"));
        
        Ellipse tear3 = new Ellipse (570, 230, 5, 10);
        tear3.setStroke(Color.BLACK);
        tear3.setStrokeWidth (5);
        tear3.setFill (Color.web ("#86b9d8"));
        
        Ellipse tear4 = new Ellipse (570, 260, 5, 10);
        tear4.setStroke(Color.BLACK);
        tear4.setStrokeWidth (5);
        tear4.setFill (Color.web ("#86b9d8"));
        
        Timeline tl = new Timeline (
            new KeyFrame (Duration.ZERO, e ->
            {
                tear1.setLayoutY(0);
                tear2.setLayoutY(20);
                tear3.setLayoutY(0);
                tear4.setLayoutY(20);
            }),    
        
            new KeyFrame (Duration.seconds(1), e ->
            {
                tear1.setLayoutY(tear1.getLayoutY() + 30);
                tear2.setLayoutY(tear2.getLayoutY() + 30);
                tear3.setLayoutY(tear3.getLayoutY() + 30);
                tear4.setLayoutY(tear4.getLayoutY() + 30);
            }),
            
            new KeyFrame (Duration.seconds(2), e ->
            {
                tear1.setLayoutY(tear1.getLayoutY() + 30);
                tear2.setLayoutY(tear2.getLayoutY() + 30);
                tear3.setLayoutY(tear3.getLayoutY() + 30);
                tear4.setLayoutY(tear4.getLayoutY() + 30);
            }),
            
            new KeyFrame (Duration.seconds(3), e ->
            {
                tear1.setLayoutY(tear1.getLayoutY() + 30);
                tear2.setLayoutY(tear2.getLayoutY() + 30);
                tear3.setLayoutY(tear3.getLayoutY() + 30);
                tear4.setLayoutY(tear4.getLayoutY() + 30);
            }));
        tl.setCycleCount (tl.INDEFINITE);
        tl.play();
        
        // Add yes button functionality to the left
        yes.setOnAction (new EventHandler <ActionEvent> ()
        {
            @Override
            public void handle (ActionEvent event)
            {
                root.getChildren().remove(sadMouth);
                root.getChildren().remove(vb1);
                root.getChildren().remove(ask);
                root.getChildren().remove(yes);
                root.getChildren().remove(no);
                root.getChildren().add(vb2);
                root.getChildren().add(smileMouth);
            }
        });
        yes.setStyle("-fx-font-size: 20; -fx-font-weight: bold;");
        yes.setLayoutX(80);
        yes.setLayoutY(230);
        
        // Add no button functionality to the right
        no.setOnAction (new EventHandler <ActionEvent> ()
        {
            @Override
            public void handle (ActionEvent event)
            {
                root.getChildren().remove(ask);
                root.getChildren().remove(yes);
                root.getChildren().remove(no);
                root.getChildren().remove(vb1);
                root.getChildren().add(vb3);
                root.getChildren().add(tear1);
                root.getChildren().add(tear2);
                root.getChildren().add(tear3);
                root.getChildren().add(tear4);
            }
        });
        no.setStyle("-fx-font-size: 20; -fx-font-weight: bold;");
        no.setLayoutX(800);
        no.setLayoutY(230);
        
        root.getChildren().addAll (bg, face, eyeL, eyeR, sadMouth, vb1, ask, yes, no);
        
        // JavaFX must have a Scene (window content) inside a Stage (window)
        Scene scene = new Scene(root, 1000, 500);
        primaryStage.setTitle("APOLOGY IMAGE");
        primaryStage.setScene(scene);
        
        // Avoid resizing the window
        primaryStage.setResizable(false);
        
        // Show the Stage (window)
        primaryStage.show();
    }
}
