import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Frame extends JFrame implements ActionListener
{
    JButton library;
    JButton settings;
    JButton quit;
    JButton back;
    JButton dark;
    JButton light;
    JButton custom;
    JButton confirm;
    JTable gameTable;
    JTextField url = new JTextField("");
    JPanel menu = new JPanel(){
        public void paint(Graphics g){
            super.paint(g);
            Graphics2D g2D = (Graphics2D) g;
            g2D.drawImage(menuPicture, 0, 0, null);
            super.paintComponents(g);
        }
    };
    JPanel mainScreen = new JPanel(){
        public void paint(Graphics g){
            super.paint(g);
            Graphics2D g2D = (Graphics2D) g;
            g2D.drawImage(img, 0, 0, null);
            super.paintComponents(g);
        }
    };
    JPanel library1 = new JPanel(){
        public void paint(Graphics g){
            super.paint(g);
            Graphics2D g2D = (Graphics2D) g;
            g2D.drawImage(img, 0, 0, null);
            super.paintComponents(g);
        }
    };
    JPanel settings1 = new JPanel(){
        public void paint(Graphics g){
            super.paint(g);
            Graphics2D g2D = (Graphics2D) g;
            g2D.drawImage(img, 0, 0, null);
            super.paintComponents(g);
        }
    };
    Image img = new ImageIcon("image.jpg").getImage();
    Image menuPicture = new ImageIcon("holmer.png").getImage();

    public Frame()
    {
        this.setSize(1280, 755);
        this.setTitle("maetS");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

        library = new JButton();
        library.setText("library");
        library.addActionListener(this);
        library.setBounds(565, 260, 150, 50);
        mainScreen.add(library);

        settings = new JButton();
        settings.setText("settings");
        settings.addActionListener(this);
        settings.setBounds(565, 360, 150, 50);
        mainScreen.add(settings);

        quit = new JButton();
        quit.setText("quit");
        quit.addActionListener(this);
        quit.setBounds(565, 460, 150, 50);
        mainScreen.add(quit);

        back = new JButton();
        back.setText("back");
        back.addActionListener(this);
        back.setBounds(10, 10, 75, 25);

        dark = new JButton();
        dark.setText("dark mode");
        dark.addActionListener(this);
        dark.setBounds(565, 260, 150, 50);

        light = new JButton();
        light.setText("light mode");
        light.addActionListener(this);
        light.setBounds(565, 360, 150, 50);

        custom = new JButton();
        custom.setText("custom background");
        custom.addActionListener(this);
        custom.setBounds(565, 460, 150, 50);
        confirm = new JButton();
        confirm.setText("✓");
        confirm.addActionListener(this);
        confirm.setBounds(745, 520, 25, 25);
        confirm.setVisible(false);

        String[] columnNames = {"title", "author"};
        Object[][] games = {
                {"tetris", "matthew"},
                {"naruto", "yuchen"},
                {"fill", "fill"},
                {"fill", "fill"},
                {"fill", "fill"},
        };
        gameTable = new JTable(games, columnNames);
        JScrollPane scrollPane = new JScrollPane(gameTable);
        scrollPane.setBounds(345, 110, 600, 500);
        library1.add(scrollPane);
        scrollPane.setViewportView(gameTable);

//        menu.setBounds(0, 0, 1280, 755);
//        menu.setVisible(true);
//        menu.setLayout(null);

        mainScreen.setBackground(Color.red);
        mainScreen.setBounds(0, 0, 1280, 755);
        mainScreen.setVisible(true);
        mainScreen.setLayout(null);

        library1.setBackground(Color.blue);
        library1.add(back);
        library1.setBounds(0, 0, 1280, 755);
        library1.setVisible(false);
        library1.setLayout(null);

        settings1.setBackground(Color.black);
        settings1.add(back);
        settings1.add(dark);
        settings1.add(light);
        settings1.add(custom);
        settings1.add(url);
        settings1.add(confirm);
        settings1.setBounds(0, 0, 1280, 755);
        settings1.setVisible(false);
        settings1.setLayout(null);

        url.setBounds(490, 520, 250, 25);
        url.setVisible(false);

//        this.add(menu);
        this.add(mainScreen);
        this.add(library1);
        this.add(settings1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        if(e.getSource() == light)
//        {
//            Main.saveImage("https://www.patternpictures.com/wp-content/uploads/Kristal-subtle-glass-white-background-pattern-patternpictures-0220.png", "image.jpg");
//            img.flush();
//            img = new ImageIcon("image.jpg").getImage();
//            mainScreen.repaint();
//        }
//        if(e.getSource() == dark)
//        {
//            Main.saveImage("https://media.istockphoto.com/vectors/abstract-black-background-geometric-texture-vector-id936834172?k=20&m=936834172&s=612x612&w=0&h=rpSBvPplOiceRBGmKhoo8hiQlfXQxUz50qXuFrbDOGw=", "image.jpg");
//            img.flush();
//            img = new ImageIcon("image.jpg").getImage();
//            mainScreen.repaint();
//        }
        if(e.getSource() == confirm)
        {
            String urlString = url.getText();
            Main.saveImage(urlString, "image.jpg");
            img.flush();
            img = new ImageIcon("image.jpg").getImage();
            mainScreen.repaint();
        }
        if(e.getSource() == library)
        {
            library1.setVisible(true);
            mainScreen.setVisible(false);
            back.setVisible(true);
        }
        if(e.getSource() == settings)
        {
            settings1.setVisible(true);
            mainScreen.setVisible(false);
            back.setVisible(true);
        }
        if(e.getSource() == custom)
        {
            url.setVisible(true);
            confirm.setVisible(true);
//            boolean a = true;
//            if(a)
//            {
//                url.setVisible(true);
//                confirm.setVisible(true);
//                a = false;
//                settings1.repaint();
//            }
//            if(!a)
//            {
//                url.setVisible(false);
//                confirm.setVisible(false);
//                settings1.repaint();
//            }
        }
        if(e.getSource() == back)
        {
            mainScreen.setVisible(true);
            library1.setVisible(false);
            settings1.setVisible(false);
            back.setVisible(false);
            url.setVisible(false);
            confirm.setVisible(false);
        }
        if(e.getSource() == quit)
        {
            try {
                Files.deleteIfExists(Paths.get("image.jpg"));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            System.exit(0);
        }
    }
}
