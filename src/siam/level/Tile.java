package siam.level;

import siam.Constants;
import siam.graphics.Screen;
import siam.graphics.Sprite;

public class Tile implements Constants {

    private int x, y;
    private boolean banished = false;
    private Sprite sprite;
    private Piece piece = null;

    public Tile(int x, int y, boolean banished) {
        this.x = x;
        this.y = y;
        this.banished = banished;
        if (banished) sprite = Sprite.bannedTile;
        else sprite = Sprite.tile;
    }

    public boolean isEmpty(){
        return piece == null;
    }

    public boolean isOnEdge(){
        return x == 0 || x == (BOARD_SIZE - 1) || y == 0 || y == (BOARD_SIZE - 1);
    }

    public boolean isBanished(){
        return banished;
    }

    public Piece getPiece(){
        return piece;
    }

    public void insertPiece(Piece piece) {
        this.piece = piece;
    }

    public boolean isEmpty() {
        return piece == null;
    }

    public boolean isOnEdge() {
        return x == 0 || x == (BOARD_SIZE - 1) || y == 0 || y == (BOARD_SIZE - 1);
    }

    public boolean isBanished() {
        return banished;
    }

    public Piece getPiece() {
        return piece;
    }

    public void render(Screen screen) {
        screen.renderTile(x, y, this);
        if (!isEmpty()) piece.render(screen);
    }

    public Sprite getSprite() {
        return sprite;
    }
}
