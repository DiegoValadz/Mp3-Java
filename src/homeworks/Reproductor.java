package homeworks;

import java.applet.AudioClip;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import java.awt.*;

public class Reproductor extends JApplet {

    private AudioClip song[] = new AudioClip[5];
    private AudioClip currentSong;
    private JButton playBtn, pauseBtn, nextBtn, prevBtn;
    private static int i = 0;
    private Image img;
    private String nombreImg;

    public void init() {
        setLayout(new FlowLayout());
        setSize(300, 300);
        Listener listener = new Listener();
        System.out.println(getDocumentBase());
        prevBtn = new JButton("Previous");
        prevBtn.addActionListener(listener);
        add(prevBtn);

        playBtn = new JButton("Play");
        playBtn.addActionListener(listener);
        add(playBtn);

        pauseBtn = new JButton("Pause");
        pauseBtn.addActionListener(listener);
        add(pauseBtn);

        nextBtn = new JButton("Next");
        nextBtn.addActionListener(listener);
        add(nextBtn);

        song[0] = getAudioClip(getDocumentBase(), "Cafe Tacuba - Eres.wav");
        song[1] = getAudioClip(getDocumentBase(), "Caifanes  - Afuera.wav");
        song[2] = getAudioClip(getDocumentBase(), "Chayanne -  Y Te Vas.wav");
        song[3] = getAudioClip(getDocumentBase(), "Hombres G -  Devuelveme a mi chica.wav");
        song[4] = getAudioClip(getDocumentBase(), "Juanes -  Nada valgo sin tu amor.wav");
        currentSong = song[i];
        System.out.println(i);

    }

    public void selectImage() {
        
        switch (i) {
            case 0:
                this.nombreImg = "cafe_tacuba.jpg";
                break;
            case 1:
                this.nombreImg = "caifanes.jpg";
                break;
            case 2:
                this.nombreImg = "chayanne.jpg";
                break;
            case 3:
                this.nombreImg = "g_men.jpg";
                break;
            case 4:
                this.nombreImg = "juanes.jpg";
                break;
        
    }
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(img, 40, 60, this);
        
                }

    @Override
    public void update(Graphics grphcs) {
        super.update(grphcs);
        img = null;
        repaint();

    }

    private class Listener implements ActionListener {

        

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == playBtn) {
                currentSong.play(); // play AudioClip once
                System.out.println(i);

            } else if (ae.getSource() == nextBtn) {
                currentSong.stop();
                if (i < 4) {
                    i++;
                    currentSong = song[i];

                } else {
                    i = 0;
                    currentSong = song[i];
                }
                currentSong.play();
                System.out.println(i);
            } else if (ae.getSource() == pauseBtn) {
                currentSong.stop(); // stop AudioClip
            } else if (ae.getSource() == prevBtn) {
                currentSong.stop();
                if (i > 0) {
                    i--;
                    currentSong = song[i];

                } else {
                    i = 4;
                    currentSong = song[i];
                }
                currentSong.play();
                System.out.println(i);

            }

            selectImage();            
            img = getImage(getDocumentBase(), nombreImg);
            repaint();

        }

    }
}
