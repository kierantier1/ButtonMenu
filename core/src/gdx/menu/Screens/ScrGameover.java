package gdx.menu.Screens;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
//import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.Texture;
import gdx.menu.GamMenu;



public class ScrGameover implements Screen, InputProcessor {
    OrthographicCamera oc;
    Texture txButtonM, txButtonP;
    //BitmapFont screenName;
    GamMenu gamMenu;
    SpriteBatch batch;
    Sprite sprButtonMenu, sprButtonPlay;
    
    public void create(){
        oc = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	oc.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        oc.update();
        batch = new SpriteBatch();
        txButtonM = new Texture("badlogic.jpg");
        sprButtonMenu = new Sprite(txButtonM);
        sprButtonMenu.setFlip(false, true);
        Gdx.input.setInputProcessor(this);
    }
    public ScrGameover(GamMenu _gamMenu) {  //Referencing the main class.
        gamMenu = _gamMenu;
    }

    @Override
    public void show() {
        oc = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	oc.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        oc.update();
        batch = new SpriteBatch();
        txButtonM = new Texture("badlogic.jpg");
        sprButtonMenu = new Sprite(txButtonM);
        sprButtonMenu.setFlip(false, true);
        Gdx.input.setInputProcessor(this);
    }
    @Override
    public void render(float Delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1); //black background.
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.setProjectionMatrix(oc.combined);
        //screenName.draw(batch, "GAME OVER", 230, 275);  SetFlip() doesn't work on BitmapFont, so you should embed the text within the sprites
        sprButtonMenu.draw(batch);
        batch.end();
    }
    
    /*
     * UpdateState(0) for Menu
     * UpdateState(1) for Play
     */
    
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
        txButtonM.dispose();
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
    public boolean IsHit(int nX, int nY){
        System.out.println("Run IsHit");
        if(nX>sprButtonMenu.getX() && nX <sprButtonMenu.getX()+sprButtonMenu.getWidth()&& nY>sprButtonMenu.getY() && nY<sprButtonMenu.getY()+sprButtonMenu.getHeight()){
            System.out.println("hit");
            return true;
        }else{
            return false;
        }
    }
}