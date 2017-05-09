package battleship.gui.grid;

import battleship.app.GameState;

import battleship.boats.Boat;
import battleship.grid.Coordinates;

import battleship.grid.*;
import battleship.gui.main.BoatImageComponent;

import java.awt.*;
import java.util.logging.Logger;

/**
 * Created by arthurdeschamps and theogiovanna on 05.05.17.
 */

public class DrawGridUser extends DrawGrid {

    @Override
    protected void paintComponent(Graphics g) {

        int width = getWidth();
        int height = getHeight();

        int cellWidth = width / columnCount;
        int cellHeight = height / rowCount;

        int xOffset = (width - (columnCount * cellWidth)) / 2;
        int yOffset = (height - (rowCount * cellHeight)) / 2;

        if (grid.isEmpty()) { //Create a cell that are added to the set grid
            for (int row = 0; row < rowCount; row++) {
                for (int col = 0; col < columnCount; col++) {
                    Cell cell = new Cell(
                            xOffset + (col * cellWidth),
                            yOffset + (row * cellHeight),
                            cellWidth,
                            cellHeight);
                    if (row != 10){
                        grid.add(cell);
                        cell.setCoord(new Coordinates(col, row)); //Set coord of each cell
                    }
                }
            }
        }

        if (selectedCell != null && selectedCell.x != 10) { //If we clicked on one cell, colors it

            // If user is still placing the boats


            int index = selectedCell.x + (selectedCell.y * columnCount);
            Cell cell = grid.get(index);

            g.setColor(Color.RED);


            Square square = GameState.getPlayer().getuserGrid().getSquareByCoordinate(cell.getCoord());

            if (GameState.getPlayer().isPlaying) { //If user pressed "Start" then he is allowed to mark the squares
                if (square.hasBoat){ //If there's a boat on the square
                    g.fillRect((int)cell.getX(), (int)cell.getY(), cellWidth, cellHeight); //Fill it
                }


                // If user wants to place a boat
                Boat selectedBoat = GameState.getPlayer().getSelectedBoat();
                if (selectedBoat != null) {
                    Logger.getGlobal().warning("boat placed");
                    BoatImageComponent boatImage = selectedBoat.getVisualForm(null);
                    //boatImage.setLayout(null);
                    boatImage.setSize(new Dimension(50,10));
                    boatImage.setLocation((int)cell.getX(),(int) cell.getY());
                }
            }
        }

        g.setColor(Color.BLACK);

        for (Cell cell : grid) {
            double x = cell.getX(); //Gets coords of the cell
            double y = cell.getY();
            if (cell.getCoord().getX() != 10) {
                g.drawRect((int) x, (int) y, cellWidth, cellHeight); //Draws outlines of a Cell
            }else{
                switch (cell.getCoord().getY()) {
                    case 0:
                        g.drawString("0", (int) cell.getCenterX(), (int) cell.getCenterY());
                        break;
                    case 1:
                        g.drawString("1", (int) cell.getCenterX(), (int) cell.getCenterY());
                        break;
                    case 2:
                        g.drawString("2", (int) cell.getCenterX(), (int) cell.getCenterY());
                        break;
                    case 3:
                        g.drawString("3", (int) cell.getCenterX(), (int) cell.getCenterY());
                        break;
                    case 4:
                        g.drawString("4", (int) cell.getCenterX(), (int) cell.getCenterY());
                        break;
                    case 5:
                        g.drawString("5", (int) cell.getCenterX(), (int) cell.getCenterY());
                        break;
                    case 6:
                        g.drawString("6", (int) cell.getCenterX(), (int) cell.getCenterY());
                        break;
                    case 7:
                        g.drawString("7", (int) cell.getCenterX(), (int) cell.getCenterY());
                        break;
                    case 8:
                        g.drawString("8", (int) cell.getCenterX(), (int) cell.getCenterY());
                        break;
                    case 9:
                        g.drawString("9", (int) cell.getCenterX(), (int) cell.getCenterY());
                        break;
                    default:
                        break;
                }
            }
        }

        g.dispose(); //Freeing materials used
    }
}
