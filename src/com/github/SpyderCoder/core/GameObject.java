package com.github.SpyderCoder.core;

public class GameObject
{
    private Transform position;
    private Transform rotation;
    private Transform scale;
    private String name;
    
    public GameObject(String name)
    {
        position = new Transform();
        rotation = new Transform();
        scale = new Transform();
        this.name = name;
    }
    
    public Transform getPosition()
    {
        return position;
    }
    
    public void setPosition(int x, int y, int z)
    {
        position.setX(x);
        position.setY(y);
        position.setZ(z);
    }
}
