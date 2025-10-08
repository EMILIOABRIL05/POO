mport characters.Turret;
import characters.Cozy;
import structures.CircularQueue;
import game.Wave;
import game.GameManager;
import commands.CommandManager;
import commands.PlaceTowerCommand;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.PixelReader;
import javafx.scene.shape.Path;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.LineTo;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * Tower Defense Game completo cumpliendo con el caso de estudio
 */
public class Game extends Application {
    private final CommandManager commandManager;
    private final GameManager gameManager;
    private final List<Turret> towers;
    private final List<CozyView> activeCozyViews;
    private final List<ImageView> activeProjectiles;
    private Pane gamePane;
    private Pane uiPane;
    private Text gameStatsText;
    private Text waveMessageText;
    private Timeline cozySpawner;
    private Timeline gameLoop;
    private int coziesSpawned = 0;
    private boolean waveInProgress = false;
    private boolean gameOverHandled = false;
    private ProgressBar waveProgressBar;
    private String selectedTowerType = "Basic";
    private Wave currentWave;
    private Button undoBtn; // Nuevo atributo
    private Button redoBtn; // Nuevo atributo

    private static class CozyView {
        final Cozy cozy;
        final PathTransition transition;

        CozyView(Cozy cozy, PathTransition transition) {
            this.cozy = cozy;
            this.transition = transition;
        }
    }

    public Game() {
        commandManager = new CommandManager();
        gameManager = new GameManager();
        towers = new ArrayList<>();
        activeCozyViews = new ArrayList<>();
        activeProjectiles = new ArrayList<>();
    }

    @Override
    public void start(Stage stage) {
        setupGame();
        setupUI(stage);
        startFirstWave();
    }

    private void setupGame() {
        gameOverHandled = false;
        System.out.println("=== TOWER DEFENSE INICIADO ===");
        System.out.println("Caso de estudio: Cozy enemies, CircularQueue, CommandStack");
    }