/*
 * The MIT License (MIT)
 * Copyright (c) 2019 GameplayJDK
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package de.gameplayjdk.jwfcimage.engine.data;

import de.gameplayjdk.jwfcimage.image.ImageScreen;

import java.util.Arrays;

public class TileMap extends TileMapAbstract {

    public static final int TILE_SIZE = 16;

    private final Tile[] map;

    public TileMap(int width, int height, int tileSize) {
        super(width, height, tileSize);

        this.map = new Tile[this.width * this.height];

        this.initialize();
    }

    private void initialize() {
        Tile.initialize();

        Arrays.fill(this.map, Tile.empty);
    }

    public void update(double deltaTime) {
        for (Tile tile : this.map) {
            tile.update(deltaTime);
        }
    }

    public void render(ImageScreen screen, int x, int y) {
        for (int w = 0; w < this.width; w++) {
            for (int h = 0; h < this.height; h++) {
                Tile tile = this.map[(h * this.width) + w];

                if (null == tile) {
                    continue;
                }

                tile.render(screen, x + (w * this.tileSize), y + (h * this.tileSize));
            }
        }
    }

    @Override
    public TileAbstract[] getMap() {
        return this.map;
    }
}
