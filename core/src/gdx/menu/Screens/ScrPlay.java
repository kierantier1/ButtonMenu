package gdx.menu.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.OrthographicCamera;
import gdx.menu.GamMenu;

public class ScrPlay implements Screen, InputProcessor {

    GamMenu gamMenu;
    OrthographicCamera oc;
    SpriteBatch batch;
    Texture txButtonG, txButtonT;
    Sprite sprButtonQuit, sprButtonTools;
    
    public ScrPlay(GamMenu _gamMenu) {  //Referencing the main class.
        gamMenu = _gamMenu;
    }

    @Override
    public void show() {
        oc = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        oc.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        oc.update();
        batch = new SpriteBatch();
        txButtonT = new Texture("Tools.jpg");
        txButtonG = new Texture("Quit.jpg");
        sprButtonQuit = new Sprite(txButtonG);
        sprButtonQuit.setFlip(false, true);
        sprButtonQuit.setY(Gdx.graphics.getHeight() - sprButtonQuit.getHeight());
        sprButtonTools = new Sprite(txButtonT);
        sprButtonTools.setFlip(false, true);
        sprButtonTools.setX(Gdx.graphics.getWidth() - sprButtonTools.getWidth());
        sprButtonTools.setY(Gdx.graphics.getHeight() - sprButtonTools.getHeight());
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(.135f, .206f, .235f, 1); //blue background.
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.setProjectionMatrix(oc.combined);
        sprButtonQuit.draw(batch);
        sprButtonTools.draw(batch);
        batch.end();

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
        batch.dispose();
        txButtonG.dispose();
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
        if (button == Input.Buttons.LEFT) {
            //System.out.println(screenX +" " + screenY);
            if (IsHit(screenX, screenY) == 1) {
                //GamMenu.updateState(3);
                System.out.println("Hit Tools");
            } else if (IsHit(screenX, screenY) == 2) {
                //GamMenu.updateState(2);
                System.out.println("Hit Quit");
            } else {
            }
        }
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

    public int IsHit(int nX, int nY) {
        if (nX > sprButtonTools.getX() && nX < sprButtonTools.getX() + sprButtonTools.getWidth() && nY > sprButtonTools.getY() && nY < sprButtonTools.getY() + sprButtonTools.getHeight()) {
            return 1;
        } else if (nX > sprButtonQuit.getX() && nX < sprButtonQuit.getX() + sprButtonQuit.getWidth() && nY > sprButtonQuit.getY() && nY < sprButtonQuit.getY() + sprButtonQuit.getHeight()) {
            return 2;
        } else {
            return 0;
        }
    }
}