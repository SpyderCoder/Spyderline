package com.github.SpyderCoder.asteroid;

import com.github.SpyderCoder.core.GameObject;

public class Main
{
    public void start()
    {
        GameObject test = new GameObject();
        System.out.println(test.getPosition());
        test.setPosition(0, 2, 0);
        System.out.println(test.getPosition().toString());
    }
    
    public void update()
    {
    
    }
}
