package mybrowser;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class MYbROWSER extends JFrame
{
    public static void main(String[] args)
    {
        MYbROWSER dude=new MYbROWSER();
        dude.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private static final long serialVersionUID = 1L;
    private JTextField addressBar;
    private JEditorPane display;

    public MYbROWSER()
    {
        super("mY bROWSER");
        System.getProperties().put("http.proxyHost", "172.16.30.20");
        System.getProperties().put("http.proxyPort", "8080");
        System.getProperties().put("http.proxyUser", "NITS");
        System.getProperties().put("http.proxyPassword", "abcde");
        addressBar= new JTextField("http://");
        addressBar.addActionListener
        (
            new ActionListener()
            {
                public void actionPerformed(ActionEvent event)
                {	
                        loadUrl(event.getActionCommand());
                }
            }
        );
        add(addressBar, BorderLayout.NORTH);
        display=new JEditorPane();
        display.setEditable(false);
        display.addHyperlinkListener
        (
            new HyperlinkListener()
            {
                public void hyperlinkUpdate(HyperlinkEvent event)
                {
                if(event.getEventType()==HyperlinkEvent.EventType.ACTIVATED)
                {
                        loadUrl(event.getURL().toString());
                }
                }
            }
        );
        add(new JScrollPane(display), BorderLayout.CENTER);
        setSize(500,300);
        setVisible(true);
    }
    private void loadUrl(String userText)
    {
        try
        {
            display.setPage(userText);
            addressBar.setText(userText);
        }
        catch(Exception e)
        {
            System.out.println("Wrong URL!");
        }
    }
}
