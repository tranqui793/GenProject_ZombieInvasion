package screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class CommandsScreen extends GenericScreen {

    private TextButton save;
    private TextButton quit;
    private TextButton reinit;
    private TextButton forward;
    private TextButton backward;
    private TextButton left;
    private TextButton right;
    private TextButton listCommand;
    private TextButton editCommand;
    private char forwardChar;
    private char backwardChar;
    private char leftChar;
    private char rightChar;

    public char getForwardChar() {
        return forwardChar;
    }

    public char getBackwardChar() {
        return backwardChar;
    }

    public char getLeftChar() {
        return leftChar;
    }

    public char getRightChar() {
        return rightChar;
    }

    public void setForwardChar(char forwardChar) {
        this.forwardChar = forwardChar;
    }

    public void setBackwardChar(char backwardChar) {
        this.backwardChar = backwardChar;
    }

    public void setLeftChar(char leftChar) {
        this.leftChar = leftChar;
    }

    public void setRightChar(char rightChar) {
        this.rightChar = rightChar;
    }

    public CommandsScreen(final Game game) {
        super(game);

        //----------- Command List-----------
        listCommand = new TextButton(" Commands ", skin);
        listCommand.setPosition(65,300);
        listCommand.setSize(140, 25);
        stage.addActor(listCommand);
        //-----------left button-----------
        left = new TextButton("left", skin);
        left.setPosition(65,150);
        left.setSize(90, 30);
        left.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                //
            }
        });
        left.getText();
        stage.addActor(left);

        //-----------right button-----------
        right = new TextButton("right", skin);
        right.setPosition(65,183);
        right.setSize(90, 30);
        right.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                //
            }
        });
        right.getText();
        stage.addActor(right);

        //-----------forward button-----------
        forward = new TextButton("forward", skin);
        forward.setPosition(65,215);
        forward.setSize(90, 30);
        forward.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                //
            }
        });
        forward.getText();
        stage.addActor(forward);

        //-----------backward button-----------
        backward = new TextButton("backward", skin);
        backward.setPosition(65,245);
        backward.setSize(90, 30);
        backward.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor)
            {
                //
            }
        });
        backward.getText();
        stage.addActor(backward);

        //----------- Edit Command -----------
        editCommand = new TextButton(" Edit Commands ", skin);
        editCommand.setPosition(50,50);
        editCommand.setSize(130, 32);
        editCommand.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new CommandsScreen(game)
                {


                });
            }
        });
        stage.addActor(editCommand);

        //-----------save button-----------
        save = new TextButton("Save", skin);
        save.setPosition(50,20);
        save.setSize(90, 30);
        save.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new StartScreen(game));
            }
        });

        stage.addActor(save);

        //-----------Save button-----------
        quit = new TextButton("Quit", skin);
        quit.setPosition(500,60);
        quit.setSize(90, 30);
        quit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                //save the command in a new file (commandsNew)
                game.setScreen(new StartScreen(game));
            }
        });

        stage.addActor(quit);

        //-----------reinit button-----------
        reinit = new TextButton("Reinit", skin);
        reinit.setPosition(500,20);
        reinit.setSize(90, 30);
        reinit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                //reload  default commandsOrigin
                init();
            }
        });

        stage.addActor(reinit);



    }
    public void editCommand()
    {
        left.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                left.setText("");
                //setForwardChar( left.getText());
            }
        });

    }

    public void init(){
        setForwardChar('w');
        setBackwardChar('s');
        setLeftChar('a');
        setRightChar('d');
    }


}