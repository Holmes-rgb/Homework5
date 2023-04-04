import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class URPaint extends JFrame{
    public JPanel controlPanel;
    public JPanel paintPanel;
    public boolean isSquare;

    public URPaint() {

        super("URPaint");
        controlPanel = new ControlPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.PAGE_AXIS));

        paintPanel = new PaintPanel();
        paintPanel.setLayout(null);

        add(paintPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.PAGE_START);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(1500, 1500);
    }



    class ControlPanel extends JPanel implements ActionListener, ChangeListener {

        JPanel buttonPanel = new JPanel();
        JPanel sliderPanel = new JPanel();
        JButton squareButton = new JButton("Square");
        JButton circleButton = new JButton("Circle");
        JButton paletteButton = new JButton("Palette");
        JButton clearButton = new JButton("Clear");

        JSlider redSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 255, 0);
        JSlider greenSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 255, 0);
        JSlider blueSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 255, 0);

        public ControlPanel(){

            add(buttonPanel);
            add(sliderPanel);

            buttonPanel.add(squareButton);
            buttonPanel.add(circleButton);
            buttonPanel.add(paletteButton);
            buttonPanel.add(clearButton);

            squareButton.addActionListener(this);
            circleButton.addActionListener(this);
            paletteButton.addActionListener(this);
            clearButton.addActionListener(this);

            redSlider.addChangeListener(this);
            greenSlider.addChangeListener(this);
            blueSlider.addChangeListener(this);

            sliderPanel.add(new JLabel("R"));
            sliderPanel.add(redSlider);
            sliderPanel.add(new JLabel("G"));
            sliderPanel.add(greenSlider);
            sliderPanel.add(new JLabel("B"));
            sliderPanel.add(blueSlider);

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(e.getSource());
            if (e.getSource() == squareButton) {
                isSquare = true;
            }
            if (e.getSource() == circleButton) {
                isSquare = false;
            }
            if (e.getSource() == paletteButton) {
                //palette();
            }
            if (e.getSource() == clearButton) {
                //clear();
            }
        }


        @Override
        public void stateChanged(ChangeEvent e) {
            int red = redSlider.getValue();
            int green = greenSlider.getValue();
            int blue = blueSlider.getValue();
            paintPanel.setBackground(new Color(red, green, blue));
        }
    }


    class PaintPanel extends JPanel {

        ArrayList<Shape> shapes = new ArrayList<Shape>();

        public PaintPanel() {
            setBackground( new Color(0,0,0));
            //this.addMouseListener( this);
        }

        public abstract class Shapes {
            boolean isSelected;
            public void paintSquare (Graphics g, int x, int y) {
                g.drawRect(x,y,50,50);
                g.fillRect(x,y,50,50);
                shapes.add();
            }

            public void paintCircle (Graphics g, int x, int y) {
                g.drawOval(x,y,25,25);
                g.fillOval(x,y,25,25);
                shapes.add();


            }
        }
    }

    public static void main(String[] args) {
        new URPaint();
    }
}
