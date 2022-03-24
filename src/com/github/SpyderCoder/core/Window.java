package com.github.SpyderCoder.core;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

public class Window
{
    private int rows;
    private int cols;

    public Window(int rows, int cols)
    {
        this.rows = rows;
        this.cols = cols;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}
