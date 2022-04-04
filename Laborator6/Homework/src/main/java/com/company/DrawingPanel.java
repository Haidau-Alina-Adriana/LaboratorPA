package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    private int x, y;
    private int rows, cols;
    private int boardWidth, boardHeight;
    private int cellWidth, cellHeight;
    private int padX, padY;
    private final int stoneSize = 20;
    private final int canvasWidth = 800, canvasHeight = 600;
    private BufferedImage image;
    private Graphics2D offscreen;


    private List<Stone> stones;
    private Map<Stone, Player> positions;
    private Board board;
    private Stone previousStone;
    private boolean endOfGame;
    Player player;
    private Game game;
    int turn;
    List<Player> players = new ArrayList<>();
    MouseAdapter mouse;


    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init();
        players.add(new Player("PlayerOne", Color.blue));
        players.add(new Player("PlayerTwo", Color.red));
    }

    private void createOffscreenImage() {
        image = new BufferedImage(canvasWidth, canvasHeight, BufferedImage.TYPE_INT_ARGB);
        offscreen = image.createGraphics();
        offscreen.setColor(Color.WHITE);
        offscreen.fillRect(0, 0, canvasWidth, canvasHeight);
    }

    private void init() {
        this.padX = stoneSize + 10;
        this.padY = stoneSize + 10;
        this.rows = frame.configPanel.getRows();
        this.cols = frame.configPanel.getCols();
        this.cellWidth = (canvasWidth - 2 * padX) / (cols - 1);
        this.cellHeight = (canvasHeight - 2 * padY) / (rows - 1);
        this.boardWidth = (cols - 1) * cellWidth;
        this.boardHeight = (rows - 1) * cellHeight;

        setPreferredSize(new Dimension(canvasWidth, canvasHeight));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                repaint();
            }
        });
    }

    @Override
    public void update(Graphics g) {
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(image, 0, 0, this);
    }

    public void reinitializeCanvas() {
        init();
        createOffscreenImage();
        repaint();
        paintGrid();
        getStonesCoordinates();
        board = new Board(paintAndCreateSticks());
        game = new Game(board, players);
        positions = game.getPositions();
        endOfGame = false;
        previousStone = null;
        turn = 0;
        player = players.get(turn);

        paintStone();
    }

    private void paintGrid() {
        offscreen.setColor(Color.DARK_GRAY);
        for (int row = 0; row < rows; row++) {
            int x1 = padX;
            int y1 = padY + row * cellHeight;
            int x2 = padX + boardWidth;
            int y2 = y1;
            offscreen.drawLine(x1, y1, x2, y2);
        }

        for (int col = 0; col < cols; col++) {
            int x1 = padX + col * cellWidth;
            int y1 = padY;
            int x2 = x1;
            int y2 = padY + boardHeight;
            offscreen.drawLine(x1, y1, x2, y2);
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = padX + col * cellWidth;
                int y = padY + row * cellHeight;
                offscreen.setColor(Color.LIGHT_GRAY);
                offscreen.drawOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
            }
        }
    }

    private void getStonesCoordinates() {
        stones = new ArrayList<>();
        int counter = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = padX + col * cellWidth;
                int y = padY + row * cellHeight;
                stones.add(new Stone(counter, x, y));
                counter++;
            }
        }
    }

    private Map<Stone, List<Stone>> paintAndCreateSticks() {
        Random rand = new Random();
        int numberOfSticks = -1;
        while (numberOfSticks < (rows * cols)) {
            numberOfSticks = rand.nextInt(rows * (cols - 1) + cols * (rows - 1) / 2);
        }

        offscreen.setColor(Color.BLACK);
        offscreen.setStroke(new BasicStroke(7.0f));
        Map<Stone, List<Stone>> neighbours = new TreeMap<>();

        for (Stone s : stones) {
            neighbours.put(s, new ArrayList<>());
        }

        for (int i = 0, n = numberOfSticks; i < n; i++) {
            while (true) {
                int firstRandStone = rand.nextInt(stones.size());
                int secondRandStone = rand.nextInt(stones.size());
                if (firstRandStone == secondRandStone) {
                    continue;
                }
                if (secondRandStone != (firstRandStone - 1) && secondRandStone != (firstRandStone + 1)
                        && secondRandStone != (firstRandStone - cols) && secondRandStone != (firstRandStone + cols)) {
                    continue;
                }
                if (((firstRandStone + 1) % cols == 0 && secondRandStone == firstRandStone + 1) ||
                        (firstRandStone % cols == 0 && secondRandStone == firstRandStone - 1)) {
                    continue;
                }
                if (neighbours.get(stones.get(firstRandStone)).contains(stones.get(secondRandStone))) {
                    continue;
                }
                neighbours.get(stones.get(firstRandStone)).add(stones.get(secondRandStone));
                neighbours.get(stones.get(secondRandStone)).add(stones.get(firstRandStone));
                offscreen.drawLine(stones.get(firstRandStone).getX(), stones.get(firstRandStone).getY(),
                        stones.get(secondRandStone).getX(), stones.get(secondRandStone).getY());
                break;
            }
        }

        Set<Integer> marginUp = new HashSet<>();
        Set<Integer> marginDown = new HashSet<>();

        for (int j = 0; j < cols; j++) {
            marginUp.add(j);
        }
        for (int j = 0; j < cols; j++) {
            marginDown.add(stones.get((rows - 1) * cols + j).getIndex());
        }

        for (Map.Entry<Stone, List<Stone>> it : neighbours.entrySet()) {
            Stone end1 = it.getKey();

            if (end1.getIndex() == 0 || end1.getIndex() == cols - 1 ||
                    end1.getIndex() == ((rows * cols - 1) - (cols - 1)) || end1.getIndex() == (rows * cols) - 1) {
            } else if (end1.getIndex() % cols == 0) {

                neighbours.get(end1).add(stones.get(end1.getIndex() + 1));
                neighbours.get(stones.get(end1.getIndex() + 1)).add(end1);

                neighbours.get(end1).add(stones.get(end1.getIndex() + cols));
                neighbours.get(stones.get(end1.getIndex() + cols)).add(end1);

                neighbours.get(end1).add(stones.get(end1.getIndex() - cols));
                neighbours.get(stones.get(end1.getIndex() - cols)).add(end1);

                offscreen.drawLine(end1.getX(), end1.getY(),
                        stones.get(end1.getIndex() + 1).getX(), stones.get(end1.getIndex() + 1).getY());

                offscreen.drawLine(end1.getX(), end1.getY(),
                        stones.get(end1.getIndex() + cols).getX(), stones.get(end1.getIndex() + cols).getY());

                offscreen.drawLine(end1.getX(), end1.getY(),
                        stones.get(end1.getIndex() - cols).getX(), stones.get(end1.getIndex() - cols).getY());
            } else if ((end1.getIndex() + 1) % cols == 0) {
                neighbours.get(end1).add(stones.get(end1.getIndex() - 1));
                neighbours.get(stones.get(end1.getIndex() - 1)).add(end1);

                neighbours.get(end1).add(stones.get(end1.getIndex() + cols));
                neighbours.get(stones.get(end1.getIndex() + cols)).add(end1);

                neighbours.get(end1).add(stones.get(end1.getIndex() - cols));
                neighbours.get(stones.get(end1.getIndex() - cols)).add(end1);

                offscreen.drawLine(end1.getX(), end1.getY(),
                        stones.get(end1.getIndex() - 1).getX(), stones.get(end1.getIndex() - 1).getY());

                offscreen.drawLine(end1.getX(), end1.getY(),
                        stones.get(end1.getIndex() + cols).getX(), stones.get(end1.getIndex() + cols).getY());

                offscreen.drawLine(end1.getX(), end1.getY(),
                        stones.get(end1.getIndex() - cols).getX(), stones.get(end1.getIndex() - cols).getY());

            } else if (marginUp.contains(end1.getIndex())) {
                neighbours.get(end1).add(stones.get(end1.getIndex() + cols));
                neighbours.get(stones.get(end1.getIndex() + cols)).add(end1);

                offscreen.drawLine(end1.getX(), end1.getY(),
                        stones.get(end1.getIndex() + cols).getX(), stones.get(end1.getIndex() + cols).getY());

            } else if (marginDown.contains(it.getKey().getIndex())) {
                neighbours.get(end1).add(stones.get(end1.getIndex() - cols));
                neighbours.get(stones.get(end1.getIndex() - cols)).add(end1);

                offscreen.drawLine(end1.getX(), end1.getY(),
                        stones.get(end1.getIndex() - cols).getX(), stones.get(end1.getIndex() - cols).getY());
            } else if (it.getValue().size() == 1) {

                neighbours.get(it.getKey()).add(stones.get(it.getKey().getIndex() - cols));
                neighbours.get(stones.get(it.getKey().getIndex() - cols)).add(it.getKey());

                offscreen.drawLine(it.getKey().getX(), it.getKey().getY(),
                        stones.get(it.getKey().getIndex() - cols).getX(), stones.get(it.getKey().getIndex() - cols).getY());

                neighbours.get(it.getValue().get(0)).add(stones.get(it.getKey().getIndex() + cols));
                neighbours.get(stones.get(it.getKey().getIndex() + cols)).add(it.getValue().get(0));

                offscreen.drawLine(it.getKey().getX(), it.getKey().getY(),
                        stones.get(it.getKey().getIndex() + cols).getX(), stones.get(it.getKey().getIndex() + cols).getY());

            }
        }
        return neighbours;
    }

    public void paintStone() {
        offscreen.setStroke(new BasicStroke(5.0f));
        mouse = new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();
                if (checkStone(x, y)) {
                    repaint();
                }
            }
        };
        this.addMouseListener(mouse);
    }

    public boolean isAvailableStone(Stone stone) {
        if (positions.get(stone) != null) {
            return false;
        }
        return true;
    }

    public boolean isAdjacentStone(Stone stone) {
        if (previousStone == null) {
            return true;
        }
        return board.getEdges().get(previousStone).contains(stone);
    }

    public boolean checkStone(int x, int y) {
        offscreen.setColor(player.getColor());
        boolean foundStone = false;
        for (Stone stone : board.getEdges().keySet()) {
            if(endOfGame){
                break;
            }
            if (x > stone.getX() - stoneSize / 2 && x < stone.getX() + stoneSize / 2
                    && y > stone.getY() - stoneSize / 2 && y < stone.getY() + stoneSize / 2) {
                if (isAvailableStone(stone)) {
                    if (isAdjacentStone(stone)) {
                        offscreen.fillOval(stone.getX() - stoneSize / 2, stone.getY() - stoneSize / 2, stoneSize, stoneSize);
                        positions.put(stone, player);
                        previousStone = stone;
                        if (turn == 0) {
                            turn = 1;
                        } else {
                            turn = 0;
                        }
                        player = game.getPlayers().get(turn);
                        return true;
                    } else {
                        endOfGame = true;
                        foundStone = true;
                        frame.canvas.removeMouseListener(mouse);
                        System.out.println("Not a valid move! You have lost!");
                        if (turn == 0) {
                            System.out.println("Winner is: " + game.getPlayers().get(1).getName());
                        } else {
                            System.out.println("Winner is: " + game.getPlayers().get(0).getName());
                        }
                        break;
                    }
                } else {
                    foundStone = true;
                    System.out.println("Stone already selected!");
                    break;
                }
            }
        }
        if (!foundStone && !endOfGame) {
            System.out.println("Not a stone!");
        }else if(endOfGame){
            System.out.println("Start new game!");
        }
        return false;
    }


    public BufferedImage getCurrentState() {
        return image;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }
}