package com.mygdx.game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Control {
    BitmapFont bitmapFont = new BitmapFont();

    void render(SpriteBatch batch) {
        bitmapFont.setColor(Color.RED);
        bitmapFont.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        bitmapFont.getData().setScale(2f);

        bitmapFont.draw(batch, "Control", 490, 450);
        bitmapFont.draw(batch, "Subir", 400, 370);
        bitmapFont.draw(batch, "Bajar", 400, 320);
        bitmapFont.draw(batch, "Izquierda", 400, 270);
        bitmapFont.draw(batch, "Derecha", 400, 220);
        bitmapFont.draw(batch, "Disparo", 400, 170);

        bitmapFont.draw(batch, "W", 635, 370);
        bitmapFont.draw(batch, "S", 640, 320);
        bitmapFont.draw(batch, "A", 640, 270);
        bitmapFont.draw(batch, "D", 640, 220);
        bitmapFont.draw(batch, "J", 640, 170);


    }
}
