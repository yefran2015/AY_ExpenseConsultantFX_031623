package gui_v1.mainWindows;

import gui_v1.automation.GUI_ElementCreator;
import gui_v1.settings.GUI_Settings_Variables;
import javax.swing.*;
import java.awt.*;

public class GUI_HowToWindow  extends JFrame implements GUI_Settings_Variables {
    private static final long serialVersionUID = 1L;
    private static GUI_HowToWindow instance = null;
    private ImageIcon howToImage = new ImageIcon("HowToPoster.jpg");

    public GUI_HowToWindow() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(howToWindowFrameSize);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        add(GUI_ElementCreator.newTitle("This is the How to Start Using PEC Quick Manual Help"), BorderLayout.NORTH);
        add(new JScrollPane(new JImagePanel()), BorderLayout.CENTER);
        JButton jbtnClose = GUI_ElementCreator.newJButton("Click Here for Close This How To Help Window");
        jbtnClose.addActionListener(e -> disposeHowToWindow());
        add(jbtnClose, BorderLayout.SOUTH);
    }

    private class JImagePanel extends JPanel {

        ImageIcon scaledHowToImage = getResizedPictureIconForFrame(howToImage);
        Image backGround;

        public JImagePanel() {
            backGround = scaledHowToImage.getImage();
        }

        public void paintComponent(Graphics g) {
            scaledHowToImage = getResizedPictureIconForFrame(howToImage);
            backGround = scaledHowToImage.getImage();
            g.drawImage(backGround, 0, 0, null);
            setPreferredSize(new Dimension(scaledHowToImage.getIconWidth(), scaledHowToImage.getIconHeight()));
        }

    }

    private ImageIcon getResizedPictureIconForFrame(ImageIcon _howToImage) {
        Image img = _howToImage.getImage();
        double proportionFactorW = (double) (getWidth() - 40) / (double) img.getWidth(_howToImage.getImageObserver());
//        double proportionFactorH = (double)getHeight()/ (double) img.getHeight(_howToImage.getImageObserver());
        int newWidth = (int) ((img.getWidth(_howToImage.getImageObserver())) * proportionFactorW);
        int newHeight = (int) ((img.getHeight(_howToImage.getImageObserver())) * proportionFactorW);

        return new ImageIcon(img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH));

    }

    public static GUI_HowToWindow createHowToWindow() {
        if (instance == null) {
            instance = new GUI_HowToWindow();
        }
        return instance;
    }

    public static void showHowToWindow() {
        createHowToWindow();
        instance.setVisible(true);
    }

    public static void hideHowToWindow() {
        createHowToWindow();
        instance.setVisible(false);
    }

    public static void disposeHowToWindow() {
        if(instance!=null){
            instance.dispose();
        }
    }

    @Override
    public Component getComponent() {
        return null;
    }

}


//    private static void out(Object o) {
//        System.out.println(o + "");
//    }
//
//    private void testResizeFactors(Image img, ImageIcon howToImage) {
//        //        Image imgScale = img.getScaledInstance(this.getWidth()-20, (int) ((this.getWidth()-20)/0.777), Image.SCALE_SMOOTH);
//        double proportionFactorW = (double) getWidth() / (double) img.getWidth(howToImage.getImageObserver());
//        double proportionFactorH = (double) getHeight() / (double) img.getHeight(howToImage.getImageObserver());
//        out(img.getWidth(howToImage.getImageObserver()) + " x  " + img.getHeight(howToImage.getImageObserver()));
//        out("FRAME: " + getWidth() + " x  " + getHeight());
//
//        out(howToImage);
//        out("pW " + proportionFactorW + " pH " + proportionFactorH);
//
//        out("newW " + (int) ((img.getWidth(howToImage.getImageObserver()) - 20) * proportionFactorW) +
//                " newH " + (int) ((img.getHeight(howToImage.getImageObserver()) - 20) * proportionFactorW));
//
//    }


//    @Override
//    public void componentResized(ComponentEvent e) {
//
//        out("RESIZEDD IN W: "+ currFrameWidth+"  H: "+currFrameHeight);
//        if(currFrameWidth != getWidth() || currFrameHeight != getHeight()){
//            scaledHowToImage = getResizedPictureIconForFrame(howToImage);
//            currFrameWidth = getWidth();
//            currFrameHeight = getHeight();
//            out("CHANGEDDDD OUT W: "+ currFrameWidth+"  H: "+currFrameHeight);
//
//
//        }
////        currFrameWidth = getWidth();
////        currFrameHeight = getHeight();
//        out("RESIZEDD OUT W: "+ currFrameWidth+"  H: "+currFrameHeight);
//
//    }
//
//    @Override
//    public void componentMoved(ComponentEvent e) {
//        out("componentMoved");
//    }
//
//    @Override
//    public void componentShown(ComponentEvent e) {
//        out("componentShown");
//
//    }
//
//    @Override
//    public void componentHidden(ComponentEvent e) {
//        out("componentHidden");
//    }
//}



//        addComponentListener( new ComponentAdapter(){
//            @Override
//            public void componentResized(ComponentEvent e) {
//                super.componentResized(e);
////                if(e.getSource()==this){
//
//                    out("LLLLL " +e);
////                }
//                if(e.getSource() instanceof JFrame){
//                    out("2222LLLLL " +e);
//                    jlblHowTo.setIcon(getResizedPictureIconForFrame(howToImage));
//
//                }
//            }
//        });
//}
//    private JLabel getJLabelWithResizedIconImage(ImageIcon ii){
//        return new JLabel("",getResizedPictureIconForFrame(ii), JLabel.CENTER);
//    }
//    private void adjustToScreen(){
//        adjustImageIconToScreen(scaledHowToImage);
//    }
//    private void adjustImageIconToScreen(ImageIcon origHowToImage){
//        Image img = howToImage.getImage();
//        double proportionFactorW =  (double)(getWidth()-40)/(double)img.getWidth(howToImage.getImageObserver());
////        double proportionFactorH = (double)getHeight()/ (double) img.getHeight(_howToImage.getImageObserver());
//        int newWidth = (int)((img.getWidth(howToImage.getImageObserver())) * proportionFactorW);
//        int newHeight = (int) ((img.getHeight(howToImage.getImageObserver())) * proportionFactorW);
//
//        origHowToImage.setImage(img.getScaledInstance(newWidth, newHeight, Image. SCALE_SMOOTH));
//
//    }
//
//    private void adjustImageToFrame(){
////        setImage(howToImage);
////        scaledHowToImage = getResizePictureForFrame(howToImage);
//        jlblHowTo.setIcon(getResizePictureForFrame(howToImage));
////        repaint();
////        pack();
//    }
//    private void setImage(ImageIcon howT0Image){
////        jSP.removeAll();
////        jSP.add(new JLabel("",getResizePictureForFrame(howT0Image), JLabel.CENTER));
//        jlblHowTo.setIcon(getResizePictureForFrame(howT0Image));
//    }

//    private ImageIcon getResizedPictureIconForFrame(ImageIcon _howToImage){
//        Image img = _howToImage.getImage();
//
////        out("ICON: "+_howToImage.getIconWidth() + " x  "+_howToImage.getIconHeight());
//
////        out("FRAME: "+getWidth() + " x  "+getHeight());
////
////        out("IMAGE: "+(int)(img.getWidth(_howToImage.getImageObserver())) + " x  "+(int)(img.getHeight(_howToImage.getImageObserver())));
//
//        double proportionFactorW =  (double)(getWidth()-40)/(double)img.getWidth(_howToImage.getImageObserver());
////        double proportionFactorH = (double)getHeight()/ (double) img.getHeight(_howToImage.getImageObserver());
//
//        int newWidth = (int)((img.getWidth(_howToImage.getImageObserver())) * proportionFactorW);
//        int newHeight = (int) ((img.getHeight(_howToImage.getImageObserver())) * proportionFactorW);
//
//
//        return new ImageIcon(img.getScaledInstance(newWidth, newHeight, Image. SCALE_SMOOTH));
//
//    }




//    private void resizePictureForFrame2(){
////        Dimension dim = new Dimension(getWidth(), getHeight());
//
//        Image imgScale = img.getScaledInstance((int) (getWidth()-20),
//                (int) ((getWidth()-20)/0.777), Image.SCALE_SMOOTH);
//        ImageIcon scaledHowToImage = new ImageIcon(imgScale);
////        hideHowToWindow();
//        remove(jSP);
////        setSize(dim);
//        jSP = new JScrollPane(new JLabel("",scaledHowToImage, JLabel.CENTER));
//        add(jSP);
////        showHowToWindow();
//    }



//    @Override
//    public void windowStateChanged(WindowEvent e) {
//        System.out.println("CHANGED");
//        Dimension dim = new Dimension(getWidth(), getHeight());
//
//        Image imgScale = img.getScaledInstance((int) (dim.getWidth()-20),
//                (int) ((dim.getWidth()-20)/0.777), Image.SCALE_SMOOTH);
//        ImageIcon scaledHowToImage = new ImageIcon(imgScale);
//        hideHowToWindow();
//        remove(jSP);
//        setSize(dim);
//        jSP = new JScrollPane(new JLabel("",scaledHowToImage, JLabel.CENTER));
//        add(jSP);
//        showHowToWindow();
//    }
//    @Override
//    public void actionPerformed(ActionEvent a) {
//        Dimension dim = new Dimension(getWidth(), getHeight());
//        if (a.getActionCommand().compareToIgnoreCase(resizeButtonText) == 0) {
//            Image imgScale = img.getScaledInstance((int) (dim.getWidth()-20),
//                    (int) ((dim.getWidth()-20)/0.777), Image.SCALE_SMOOTH);
//            ImageIcon scaledHowToImage = new ImageIcon(imgScale);
//            hideHowToWindow();
//            remove(jSP);
//            remove(jbtResize);
//            setSize(dim);
//            jSP = new JScrollPane(new JLabel("",scaledHowToImage, JLabel.CENTER));
//            add(jSP);
//            add(jbtResize, BorderLayout.SOUTH);
//            showHowToWindow();
//        }
//    }





//
//    //        Image imgScale = img.getScaledInstance(this.getWidth()-20, (int) ((this.getWidth()-20)/0.777), Image.SCALE_SMOOTH);
//    out(img.getWidth(howToImage.getImageObserver()) + " x  "+img.getHeight(howToImage.getImageObserver()));
//        out("FRAME: "+getWidth() + " x  "+getHeight());
//
//        out(howToImage);
//        double proportionFactorW =  (double)getWidth()/(double)img.getWidth(howToImage.getImageObserver());
//        double proportionFactorH = (double)getHeight()/ (double) img.getHeight(howToImage.getImageObserver());
//        out("pW "+ proportionFactorW  +" pH "+proportionFactorH);
//
//        out("newW "+ (int)((img.getWidth(howToImage.getImageObserver())- 20)* proportionFactorW) +
//        " newH "+(int) ((img.getHeight(howToImage.getImageObserver())- 20)*proportionFactorW));
////
////        Image imgScale = img.getScaledInstance((int)((img.getWidth(howToImage.getImageObserver())- 20)/proportionFactorW ),
////                (int)  ((img.getHeight(howToImage.getImageObserver())- 20)/proportionFactorH ) , Image.SCALE_SMOOTH);
//
//        int newWidth = (int)((img.getWidth(howToImage.getImageObserver())- 20) * proportionFactorW);
//        int newHeight = (int) ((img.getHeight(howToImage.getImageObserver())- 20) * proportionFactorW);
//
//        Image imgScale = img.getScaledInstance(newWidth, newHeight, Image.SCALE_AREA_AVERAGING);
//        ImageIcon scaledHowToImage = new ImageIcon(imgScale);
////        jbtResize = new JButton(resizeButtonText);
////        jbtResize.addActionListener(this);
//        jSP = new JScrollPane(new JLabel("",scaledHowToImage, JLabel.CENTER));
//        add(jSP);
////        add(jbtResize, BorderLayout.SOUTH);
//        addWindowListener(new WindowAdapter() {
//@Override
//public void windowClosing(WindowEvent e) {
//        GUI_HowToWindow.disposeHowToWindow();
//        }
//        });
////        pack();
////        setVisible(true);
//        }