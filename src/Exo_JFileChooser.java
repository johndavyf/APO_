import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Exo_JFileChooser extends JFrame implements ActionListener {
    private JButton openButton, questionButton;
    private JTextArea log;
    private JFileChooser fc;

    public Exo_JFileChooser(String titre)
    {
        super(titre);

        log = new JTextArea(5,20);//5 = nb de lignes, 20 = nb de colonnes
        log.setMargin(new Insets(5,5,5,5));
        log.setEditable(true);
        JScrollPane logScrollPane = new JScrollPane(log);

        fc = new JFileChooser("J:\\ESIG2\\APO\\Tutotu");

        openButton = new JButton("Open a File...");
        openButton.addActionListener(this);

        questionButton = new JButton("Question");
        questionButton.addActionListener(this);


        //For layout purposes, put the buttons in a separate panel
        JPanel buttonPanel = new JPanel(); //use FlowLayout
        buttonPanel.add(openButton);
        buttonPanel.add(questionButton);



        //Add the buttons and the log to this panel.
        add(buttonPanel, "North");//BorderLayout.PAGE_START);//propre � 1.4
        add(logScrollPane, "South");//BorderLayout.CENTER);//propre � 1.4
    }


    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == openButton)
        {
            int returnVal = fc.showOpenDialog(null);//null centre sur l'�cran
            if (returnVal == JFileChooser.APPROVE_OPTION)
            {
                File file = fc.getSelectedFile();
                //This is where a real application would open the file.
                Questionnaire q = new Questionnaire(file);
                for (Item item : q.items){
                    String reponse = JOptionPane.showInputDialog(null, item.question, "Saisir ici la réponse");
                    log.append("\n" +item.reponse + "\n");
                }
            }
            else
                log.append("Open command cancelled by user." + "\n");
        }

    }


}
