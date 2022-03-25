package com.github.SpyderCoder.core;

public class Transform
{
    private int x = 0;
    private int y = 0;
    private int z = 0;
    private String name;
    
    public Transform(String name)
    {
        this.name = name;
    }
    
    public int getX()
    {
        return x;
    }
    
    public void setX(int x)
    {
        this.x = x;
    }
    
    public int getY()
    {
        return y;
    }
    
    public void setY(int y)
    {
        this.y = y;
    }
    
    public int getZ()
    {
        return z;
    }
    
    public void setZ(int z)
    {
        this.z = z;
    }
    
    public String toString()
    {
        return name + " X: " + x + " "
                + name + " Y: " + y + " " + name + " Z: " + z;
    }
}
