package com.github.SpyderCoder.core;

import com.github.SpyderCoder.asteroid.Main;

public class Game
{
    private State state = State.START;
    private static Window window;
    private static Render render;
    private static Main main;
    private int width = 30;
    private int height = 30;
    private int refreshRateMs = 100;

    public void run()
    {
        start();
        update();
        stop();
    }

    private void start()
    {
        KeyListener.start();
        window = new Window(width, height);
        render = new Render();
        render.disableCursor();
        main = new Main();
        main.start();
    }
    
    private void update()
    {
        while(state != State.STOP)
        {
            main.update();
            render.draw(refreshRateMs);
        }
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
