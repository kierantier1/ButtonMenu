package gdx.menu.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.OrthographicCamera;

import gdx.menu.GamMenu;

public class ScrMenu implements Screen, InputProcessor {
    GamMenu gamMenu;
    OrthographicCamera oc;
    SpriteBatch batch;
    BitmapFont screenName;
    public void create(){
       oc = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
       oc.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }
    public ScrMenu(GamMenu _gamMenu) {  //Referencing the main class.
        gamMenu = _gamMenu;
    }
    
    @Override
    public void show() {
        batch = new SpriteBatch();
        screenName = new BitmapFont();
        btnPlayListener();
        btnOptionsListener();
    }
    
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 1, 0, 1); //Green background.
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        screenName.draw(batch, "This is the MENU screen", 230, 275);
        batch.end();
    }

    public void btnPlayListener() {
        
    }

    public void btnOptionsListener() {
       
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}