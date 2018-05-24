import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class UserInterfaceHex extends UserInterface {
    private JLabel labelDecHexSwitch;
    private JPanel buttonsForHex;
    /**
     * Create a user interface using the superclass. Adds buttons for hexadecimal calculation.
     *
     * @param engine The calculator engine.
     */
    public UserInterfaceHex(CalcEngineHex engine) {
        super(engine);
        makeHexFrame();
    }

    /**
     * Adds buttons for Hexadecimal calculation and a button to switch between Hex and Dec.
     */
    private void makeHexFrame(){
        JPanel contentPane = (JPanel)frame.getContentPane();
        labelDecHexSwitch = new JLabel();
        labelDecHexSwitch.setText("Dec");

//Hex buttons
        buttonsForHex = new JPanel(new GridLayout(8,1));
        addButton(buttonsForHex, "A");
        addButton(buttonsForHex, "B");
        addButton(buttonsForHex, "C");
        addButton(buttonsForHex, "D");
        
        addButton(buttonsForHex, "E");
        addButton(buttonsForHex, "F");
        buttonsForHex.add(new JLabel(" "));
        buttonsForHex.add(new JLabel(" "));

//Dec/Hex switch-button and text
        JPanel buttonDecHexSwitch = new JPanel(new GridLayout(1,4));
        addButton(buttonDecHexSwitch, "Dec/Hex");
        buttonDecHexSwitch.add(labelDecHexSwitch);
        buttonDecHexSwitch.add(new JLabel(" "));
        buttonDecHexSwitch.add(new JLabel(" "));

        contentPane.add(buttonsForHex, BorderLayout.EAST);
        buttonsForHex.setVisible(false);
        contentPane.add(buttonDecHexSwitch, BorderLayout.SOUTH);
        frame.pack();
    }

    /**
     * Overrides the original actionPerformed method by adding Hthe buttons for Hexadecimal calculation.
     * @param event The event that has occured.
     */
    @Override
    public void actionPerformed(ActionEvent event){
        String command = event.getActionCommand();
        super.actionPerformed(event);
        switch(command){
            case "A":
                calc.numberPressed(10);
                break;
            case "B":
                calc.numberPressed(11);
                break;
            case "C":
                calc.numberPressed(12);
                break;
            case "D":
                calc.numberPressed(13);
                break;
            case "E":
                calc.numberPressed(14);
                break;
            case "F":
                calc.numberPressed(15);
                break;
            case "Dec/Hex":
                calc.switchDecHex();
                switchHexButtons();
            default:
                break;

        }
        redisplay();
    }

    /**
     * This will change the display to show Hexadecimal instead of Decimal.
     */
    @Override
    protected void redisplay() {
        if(!calc.showingHex)super.redisplay();
        else display.setText((Integer.toHexString(calc.getDisplayValue())).toUpperCase());
    }

    /**
     * Configures the button "Dec/Hex" and text next to this button.
     */
    private void switchHexButtons(){
        if(calc.showingHex) {
            labelDecHexSwitch.setText("Hex");
            buttonsForHex.setVisible(true);
        }else {
            labelDecHexSwitch.setText("Dec");
            buttonsForHex.setVisible(false);
        }
    }


}
