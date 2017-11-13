package gdx.menu.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.OrthographicCamera;

import gdx.menu.GamMenu;

public class ScrMenu implements Screen, InputProcessor {
    GamMenu gamMenu;
    Texture txButtonP, txButtonT;
    OrthographicCamera oc;
    SpriteBatch batch;
    Sprite sprButtonPlay, sprButtonTools;
    
    public void create(){
       
    }
    public ScrMenu(GamMenu _gamMenu) {  //Referencing the main class.
        gamMenu = _gamMenu;
    }
    
    @Override
    public void show() {
       oc = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
       oc.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
       oc.update();       
       batch = new SpriteBatch();
       txButtonP = new Texture("Play.jpg");
       txButtonT = new Texture("Tools.jpg");
       sprButtonPlay = new Sprite(txButtonP);
       sprButtonPlay.setFlip(false, true);
       sprButtonPlay.setY(Gdx.graphics.getHeight()-sprButtonPlay.getHeight());
       sprButtonTools = new Sprite(txButtonT);
       sprButtonTools.setFlip(false, true);
       sprButtonTools.setY(Gdx.graphics.getHeight()-sprButtonTools.getHeight());
       sprButtonTools.setX(Gdx.graphics.getWidth()-sprButtonTools.getWidth());
       Gdx.input.setInputProcessor(this);
    }
    
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 1, 0, 1); //Green background.
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.setProjectionMatrix(oc.combined);
        sprButtonPlay.draw(batch);
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
        txButtonP.dispose();
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
                            //GamMenu.updateState(1);
                            System.out.println("Hit Play");
                        } else if(IsHit(screenX, screenY) == 2){
                            System.out.println("Hit Tools");
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
    public int IsHit(int nX, int nY){
        if(nX>sprButtonPlay.getX() && nX <sprButtonPlay.getX()+sprButtonPlay.getWidth()&& nY>sprButtonPlay.getY() && nY<sprButtonPlay.getY()+sprButtonPlay.getHeight()){
            return 1;
        }else if(nX>sprButtonTools.getX() && nX < sprButtonTools.getX()+sprButtonTools.getWidth() && nY > sprButtonTools.getY() && nY < sprButtonTools.getY() + sprButtonTools.getHeight()){
            return 2;
        }else{
            return 0;
        }
    }
}