package ru.belyaev.four;

public class World {
    private final int mWidth;
    private final int mHeight;

    private WorldState mWorldState = WorldState.READY;

    public World(int width, int height) {
        mWidth = width;
        mHeight = height;
    }

    public WorldState getWorldState() {
        return mWorldState;
    }

    public void setWorldState(WorldState worldState) {
        mWorldState = worldState;
    }

    public enum WorldState {
        READY,
        RUNNING,
        GAME_OVER
    }

    public interface WorldListener {
        void onBound();
    }
}
