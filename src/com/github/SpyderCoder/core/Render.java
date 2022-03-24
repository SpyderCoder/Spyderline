package com.github.SpyderCoder.core;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.InfoCmp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Render
{
    private Terminal terminal;
    private char[] lastFrame = emptyFrame();
    private char[] currentFrame = emptyFrame();

    public Render()
    {
        try
        {
            terminal = TerminalBuilder.terminal();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void disableCursor()
    {
        terminal.puts(InfoCmp.Capability.cursor_invisible);
    }

    public void enableCursor()
    {
        terminal.puts(InfoCmp.Capability.cursor_visible);
    }

    public void draw(int refreshRate)
    {
        try
        {
            Thread.sleep(refreshRate);

            if (compareFrames() != null)
            {
                for (ArrayList<Integer> curPos : compareFrames())
                {
                    int colPos = curPos.get(0);
                    int rowPos = curPos.get(1);
                    int charPos = curPos.get(2);

                    setCursor(colPos, rowPos);
                    System.out.print(charPos);
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void updateFrames(char[] currentFrame)
    {
        lastFrame = currentFrame;
        this.currentFrame = currentFrame;
    }

    private void setCursor(int col, int row)
    {
        terminal.puts(InfoCmp.Capability.cursor_address, col, row);
    }

    private ArrayList<ArrayList<Integer>> compareFrames()
    {
        ArrayList<ArrayList<Integer>> curPositions = new ArrayList<>();
        for(int i = 0; i < lastFrame.length; i++)
        {
            if(lastFrame[i] != currentFrame[i])
            {
                setCursor(i % Game.getWindow().getCols(), i / Game.getWindow().getCols());
                ArrayList pos = new ArrayList();
                pos.add(i % Game.getWindow().getCols());
                pos.add(i / Game.getWindow().getCols());
                pos.add(i);
                curPositions.add(pos);
            }
        }

        return curPositions;
    }

    private char[] emptyFrame()
    {
        List<String> empty = new ArrayList();
        int amountToFill = Game.getWindow().getRows() * Game.getWindow().getCols();

        for(int i = 0; i < amountToFill; i++)
        {
            empty.add(" ");
        }

        return empty.stream().collect(Collectors.joining()).toCharArray();
    }
}
