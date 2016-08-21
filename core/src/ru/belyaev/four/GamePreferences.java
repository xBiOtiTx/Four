package ru.belyaev.four;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class GamePreferences {
    private static final String GAME_PREFERENCES = "GAME_PREFERENCES";
    private static final String BEST_SCORE = "BEST_SCORE";

    private final Preferences mPreferences = Gdx.app.getPreferences(GAME_PREFERENCES);

    public float getBestScore() {
        return mPreferences.getFloat(BEST_SCORE, 0.0f);
    }

    public void setBestScore(float score) {
        mPreferences.putFloat(BEST_SCORE, score);
        mPreferences.flush();
    }
}
