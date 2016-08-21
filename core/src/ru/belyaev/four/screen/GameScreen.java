package ru.belyaev.four.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;

import ru.belyaev.four.FourGame;
import ru.belyaev.four.World;
import ru.belyaev.four.WorldController;
import ru.belyaev.four.WorldRenderer;

public class GameScreen extends BaseScreen {
    private final int mWidth;
    private final int mHeight;

    private final World mWorld;
    private final WorldRenderer mWorldRenderer;
    private final WorldController mWorldController;

//    private final ClickListener mClickListener = new ClickListener() {
//        @Override
//        public void clicked(InputEvent event, float x, float y) {
//        }
//    };

    public GameScreen(FourGame game) {
        super(game);
        Gdx.input.setInputProcessor(this);

        mWidth = Gdx.graphics.getWidth();
        mHeight = Gdx.graphics.getHeight();

        mWorld = new World(mWidth, mHeight);
        mWorldRenderer = new WorldRenderer(mWorld, getGame().getShapeRenderer(), getGame().getSpriteBatch());
        mWorldController = new WorldController(mWorld);
    }

    @Override
    public void render(float deltaTime) {
        clear();
        switch (mWorld.getWorldState()) {
            case READY:
                updateReady(deltaTime);
                break;

            case RUNNING:
                updateRunning(deltaTime);
                break;

            case GAME_OVER:
                updateGameOver(deltaTime);
                break;
        }
    }

    // =============================================================================================
    // update states
    // =============================================================================================

    private void updateReady(float deltaTime) {
        mWorldRenderer.render();
    }

    private void updateRunning(float deltaTime) {
        mWorldController.update(deltaTime);
        mWorldRenderer.render();
    }

    private void updateGameOver(float deltaTime) {
    }

    // =============================================================================================
    // InputProcessor implementation
    // =============================================================================================


    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        mWorldController.click(screenX, mHeight - screenY);
        return true;
    }
}
