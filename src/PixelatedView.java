import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;

public class PixelatedView extends JFrame {
    private JPanel panel, cell;
    private JPanel[][] matrix;
    private JButton go;
    private JButton clear;

    public PixelatedView(int size){
        super("Shrink");

        this.panel = new JPanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(size*50, size*50);

        this.matrix = new JPanel[size][size];
        this.panel.setLayout(new GridLayout(size, size));
        for (int row = 0; row < size; row++){
            for (int col = 0; col < size; col++){
                JPanel cell = new JPanel();
                cell.setBorder(BorderFactory.createLineBorder(Color.black));
                MouseHandler handler = new MouseHandler();
                cell.addMouseListener(handler);
                matrix[row][col] = cell;
                panel.add(matrix[row][col]);
            }
        }

        this.add(panel);

        Box box = Box.createHorizontalBox();
        go = new JButton("Go");
        clear = new JButton("Clear");
        box.add(go);
        box.add(clear);

        this.add(box, BorderLayout.SOUTH);

    }

    void addGoListener(ActionListener listenForGo) {
        go.addActionListener(listenForGo);
    }

    void addClearListener(ActionListener listenForClear){
        clear.addActionListener(listenForClear);
    }


    private class MouseHandler extends MouseAdapter{
        public void mouseClicked(MouseEvent e){
            setBackground(Color.black);
            System.out.println("clicked at " + e.getX() + e.getY());
        }
    }



}
