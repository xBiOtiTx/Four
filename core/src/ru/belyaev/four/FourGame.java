package ru.belyaev.four;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import ru.belyaev.four.screen.GameScreen;

public class FourGame extends Game {
	private ShapeRenderer mShapeRenderer;
	private SpriteBatch mSpriteBatch;

	@Override
	public void create() {
		mShapeRenderer = new ShapeRenderer();
		mSpriteBatch = new SpriteBatch();
		setScreen(new GameScreen(this));
	}

	@Override
	public void dispose() {
		super.dispose();
		mShapeRenderer.dispose();
		mSpriteBatch.dispose();
	}

	public ShapeRenderer getShapeRenderer() {
		return mShapeRenderer;
	}

	public SpriteBatch getSpriteBatch() {
		return mSpriteBatch;
	}
}