package com.github.SpyderCoder.core;

public class Game
{
    private State state = State.START;
    private static Window window;
    private static Render render;
    private int width = 30;
    private int height = 30;
    private int refreshRateMs = 100;

    public void run()
    {
        start();

        while(state != State.STOP)
        {
            render.draw(refreshRateMs);
        }

        stop();
    }

    private void start()
    {
        KeyListener.start();
        window = new Window(width, height);
        render = new Render();
        render.disableCursor();
    }

    private void stop()
    {
        KeyListener.stop();
        render.enableCursor();
    }

    public static Window getWindow()
    {
        return window;
    }
}
