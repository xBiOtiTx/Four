package ru.belyaev.four;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.Random;

public class WorldRenderer {
    private final World mWorld;
    private final ShapeRenderer mShapeRenderer;
    private final SpriteBatch mSpriteBatch;

    private final int mCellSpace;
    private final int mCellSize;
    private final Texture mCellTexture;
    private final BitmapFont mFont;
    private final GlyphLayout mGlyphLayout;

    public WorldRenderer(World world, ShapeRenderer shapeRenderer, SpriteBatch spriteBatch) {
        mWorld = world;
        mShapeRenderer = shapeRenderer;
        mSpriteBatch = spriteBatch;

        mFont = new BitmapFont();
        mFont.getData().setScale(3);
        mFont.setColor(Color.WHITE);

        mCellSpace = 5;
        final int w = mWorld.getWidth() - mCellSpace * (World.FIELD_SIZE - 1);
        final int h = mWorld.getHeight() - mCellSpace * (World.FIELD_SIZE - 1);
        mCellSize = Math.min(w, h) / World.FIELD_SIZE;
        mCellTexture = new Texture(getPixmapRoundedRectangle(mCellSize, mCellSize, 8, Color.GRAY));

        mGlyphLayout = new GlyphLayout();
    }

    public static Pixmap getPixmapRoundedRectangle(int width, int height, int radius, Color color) {
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmap.setColor(color);
        pixmap.fillRectangle(0, radius, pixmap.getWidth(), pixmap.getHeight() - 2 * radius);
        pixmap.fillRectangle(radius, 0, pixmap.getWidth() - 2 * radius, pixmap.getHeight());
        pixmap.fillCircle(radius, radius, radius);
        pixmap.fillCircle(radius, pixmap.getHeight() - radius, radius);
        pixmap.fillCircle(pixmap.getWidth() - radius, radius, radius);
        pixmap.fillCircle(pixmap.getWidth() - radius, pixmap.getHeight() - radius, radius);
        return pixmap;
    }

    public void render() {
        final Cell[][] field = mWorld.getField();
        mSpriteBatch.begin();
        for (int i = 0; i < World.FIELD_SIZE; i++) {
            for (int j = 0; j < World.FIELD_SIZE; j++) {
                mSpriteBatch.draw(mCellTexture, i * mCellSize + i * mCellSpace, j * mCellSize + j * mCellSpace, mCellSize, mCellSize);
                final Cell cell = field[i][j];
                if (cell.getType() == Cell.CellType.NUMBER) {
                    mGlyphLayout.setText(mFont, String.valueOf(cell.getNumber()));
                    final float numberX = i * mCellSize + i * mCellSpace + mCellSize / 2 - mGlyphLayout.width / 2;
                    final float numberY = j * mCellSize + j * mCellSpace + mCellSize / 2 + mGlyphLayout.height / 2;
                    mFont.draw(mSpriteBatch, mGlyphLayout, numberX, numberY);
                }
            }
        }
        mSpriteBatch.end();
    }
}
