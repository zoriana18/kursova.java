import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.Before;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

import java.util.logging.Logger;

public class MainTest extends ApplicationTest {
    private static final Logger logger = Logger.getLogger(MainTest.class.getName());
    @Override

    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("com/example/kursova/main.fxml"));

        Scene scene = new Scene(root);

        stage.setResizable(false);

        stage.setScene(scene);

        stage.show();

    }
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        FxToolkit.hideStage();

        release(new KeyCode[]{});

        release(new MouseButton[]{});
    }
}
