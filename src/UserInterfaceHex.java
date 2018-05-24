import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterfaceHex extends UserInterface {
    /**
     * Create a user interface.
     *
     * @param engine The calculator engine.
     */
    public UserInterfaceHex(CalcEngine engine) {
        super(engine);
        makeHexFrame();
    }

    private void makeHexFrame(){
        JPanel contentPane = (JPanel)frame.getContentPane();

        JPanel buttonPanel = new JPanel(new GridLayout(2, 4));
        addButton(buttonPanel, "A");
        addButton(buttonPanel, "B");
        addButton(buttonPanel, "C");
        addButton(buttonPanel, "D");

        addButton(buttonPanel, "E");
        addButton(buttonPanel, "F");
        buttonPanel.add(new JLabel(" "));
        buttonPanel.add(new JLabel(" "));


        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        frame.pack();
    }



    public void actionPerformedHex(ActionEvent event){
        String command = event.getActionCommand();

        switch(command){
            case "A":
                calc.numberPressed(15);
                break;
        }
    }
        
        
}
