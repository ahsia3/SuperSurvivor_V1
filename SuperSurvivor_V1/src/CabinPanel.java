//This java class is for the end of the story


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JTextField;


public class CabinPanel extends javax.swing.JPanel {
    View jFrame;
    
    BufferedImage img;
    private int clickedNext = 0; //Counter for user clicks on the TextArea of Story
    private int addClicked = 0; //2nd Counter of clickedNext to help //might have not needed this counter
    private boolean check = false, alterCabin = false; //boolean values
    
    private ArrayList<String> listStory = new ArrayList<String>(); //Array list to store Story in String format
    
    //Method that contains the strings of the story in ArrayList format
    private void Story(){
        //The start of the story 0-1
        listStory.add("As you continue through the woods, you see a dim light far infront of you");
        listStory.add("You approach the light and come to a cabin");
        //After first Set of options 2-4
        listStory.add("Is anyone there?");
        listStory.add("You enter cabin");
        listStory.add("You start searching...");
        //Inside cabin story - angry oldman version 5-6
        listStory.add("You open the door and see an angry old man holding a shotgun");
        listStory.add("You get shot!");
        //Search Story 7-12
        listStory.add("You decide to search around the cabin for any clues to leave the woods, with the spooky message still in mind");
        listStory.add("As you search, you hear a wolf howl, leading you to step on a branch");
        listStory.add("You stop for a moment.....");
        listStory.add("......nothing happens, and you continue your search");
        listStory.add("To your surpise, you see a car at the back of the house");
        listStory.add("You want to steal the car to escape, but you first need to find the keys");
        //After second set of options 13-14
        listStory.add("You enter Cabin");
        listStory.add("You continue Searching");
        //Inside cabin story - sleeping oldman version 15-17
        listStory.add("You open the door and immediately see an old man sleeping on a couch with a shotgun beside him");
        listStory.add("You look to your left and see car keys on a table");
        listStory.add("You wonder if you should wake up the old man to ask for directions out of the woods");
        //After third set of options 18-19
        listStory.add("Old man wakes up");
        listStory.add("You grab keys and leave");
        //Exit cabin story - skipped initial search 20-22
        listStory.add("You hastily search around the house in hopes of finding the car to use the keys on");
        listStory.add("By the stroke of luck you see the car at the back of the house");
        listStory.add("You hear the cabin door open and hear footsteps");
        //After alternative choices 23
        listStory.add("You wait and see");
        //Finale 24-28
        listStory.add("With the keys in hand, you quickly start the car and drive out the woods");
        listStory.add("You drive far out away for things to be peaceful again");
        listStory.add(".......Or so you thought");
        listStory.add("The story continues.....");
        listStory.add("In Super Survivor II");
    }
    
    //Set options to be unviewable
    public void MakeOptFalse(){
        firstOption.setVisible(false);
        secondOption.setVisible(false);
        thirdOption.setVisible(false);
    }
  
    //Set options to be viewable
    public void MakeOptTrue(){
        firstOption.setVisible(true);
        secondOption.setVisible(true);
        thirdOption.setVisible(true);
    }
    
    //Set the text of the option buttons
    private void MakeOptions(){
        if(addClicked == 2){
            firstOption.setText("Yell, \"Is anyone there?\"");
            secondOption.setText("Enter cabin");
            thirdOption.setText("Search around");
        }else if(addClicked == 13){
            firstOption.setText("Enter cabin");
            secondOption.setText("Continue searching");
            thirdOption.setVisible(false);
        }else if(addClicked == 18){
            firstOption.setText("Wake up old man");
            secondOption.setText("Grab keys and leave");
            thirdOption.setVisible(false);
        }else if(addClicked == 23) {
            firstOption.setText("Wait and see");
            secondOption.setText("Start car and leave");
            thirdOption.setVisible(false);
        }
    }
    
    //Constructor to initialize stuff
    public CabinPanel(View jframe) {
        initComponents();
        this.jFrame = jframe;
        this.setVisible(true);
        
//        Story();
//        
//        //To set the beginning of the story //This snippit of code was used when using a 2nd panel for User Choices. //Might have not needed this if statement anymore except to set the beginning (0).
//        if(clickedNext > 0){
//            txtStory.setText(listStory.get(clickedNext));
//        }else{
//            txtStory.setText(listStory.get(0));
//        }
//        
//        MakeOptFalse();
//       
//        try {
//            img = ImageIO.read(new File("Images\\cabinimg1.jpg"));
//        } catch (IOException ex) {
//            Logger.getLogger(CabinPanel.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
    }
    
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topPanel = new javax.swing.JPanel();
        txtOfOptions = new javax.swing.JTextField();
        storyPanel = new javax.swing.JPanel();
        optionsPanel = new javax.swing.JPanel();
        thirdOption = new javax.swing.JButton();
        secondOption = new javax.swing.JButton();
        firstOption = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtStory = new javax.swing.JTextArea();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        topPanel.setOpaque(false);

        txtOfOptions.setEditable(false);
        txtOfOptions.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtOfOptions.setText("empty");
        txtOfOptions.setOpaque(false);
        txtOfOptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOfOptionsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtOfOptions)
                .addContainerGap())
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtOfOptions, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        storyPanel.setOpaque(false);

        optionsPanel.setOpaque(false);

        thirdOption.setText("third");
        thirdOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thirdOptionActionPerformed(evt);
            }
        });

        secondOption.setText("second");
        secondOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secondOptionActionPerformed(evt);
            }
        });

        firstOption.setText("first");
        firstOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstOptionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout optionsPanelLayout = new javax.swing.GroupLayout(optionsPanel);
        optionsPanel.setLayout(optionsPanelLayout);
        optionsPanelLayout.setHorizontalGroup(
            optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(firstOption, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                .addGap(63, 63, 63)
                .addComponent(secondOption, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                .addGap(45, 45, 45)
                .addComponent(thirdOption, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                .addGap(29, 29, 29))
        );
        optionsPanelLayout.setVerticalGroup(
            optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionsPanelLayout.createSequentialGroup()
                .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(secondOption, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thirdOption, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(optionsPanelLayout.createSequentialGroup()
                .addComponent(firstOption, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout storyPanelLayout = new javax.swing.GroupLayout(storyPanel);
        storyPanel.setLayout(storyPanelLayout);
        storyPanelLayout.setHorizontalGroup(
            storyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(optionsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        storyPanelLayout.setVerticalGroup(
            storyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, storyPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(optionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        txtStory.setEditable(false);
        txtStory.setColumns(20);
        txtStory.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txtStory.setLineWrap(true);
        txtStory.setRows(5);
        txtStory.setWrapStyleWord(true);
        txtStory.setAutoscrolls(false);
        txtStory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtStoryMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(txtStory);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(topPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(storyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 295, Short.MAX_VALUE)
                .addComponent(storyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtOfOptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOfOptionsActionPerformed
        //empty
    }//GEN-LAST:event_txtOfOptionsActionPerformed

    
    //Second User choice button
    private void secondOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secondOptionActionPerformed
//        if(addClicked == 2){
//
//            txtOfOptions.setText("Entered the cabin!");
//            txtOfOptions.setVisible(true);
//            txtStory.setText(listStory.get(3));
//            clickedNext = 14;
//            addClicked = clickedNext;
//            
//        }else if(addClicked == 13){
//            txtOfOptions.setText("Searching...\n\nNothing found");
//            txtOfOptions.setVisible(true);
//            txtStory.setText(listStory.get(14));
//        }else if(addClicked == 18){
//            txtOfOptions.setText("You grab key and leave");
//            txtOfOptions.setVisible(true);
//            txtStory.setText(listStory.get(19));
//            clickedNext = 19;
//            addClicked = clickedNext;
//            
//        }else if(addClicked == 23) {
//            txtOfOptions.setText("Car starting...");
//            txtOfOptions.setVisible(true);
//            txtStory.setText(listStory.get(24));
//            clickedNext = 24;
//            addClicked = clickedNext;
//        }
//        MakeOptFalse();
    }//GEN-LAST:event_secondOptionActionPerformed

    
    //First User choice button
    private void firstOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstOptionActionPerformed
//        if(addClicked == 2){
//            alterCabin = true;
//            txtOfOptions.setText("IS ANYONE THERE!!!!");
//            txtOfOptions.setVisible(true);
//            txtStory.setText(listStory.get(2));
//        }else if(addClicked == 13){
//            txtOfOptions.setText("Cabin entered");
//            txtOfOptions.setVisible(true);
//            txtStory.setText(listStory.get(13));
//            clickedNext = 14;
//            addClicked = clickedNext;
//        }else if(addClicked == 18){
//            txtOfOptions.setVisible(true);
//            txtOfOptions.setText("Old man woken up");
//            txtStory.setText(listStory.get(18));
//            try {
//                Thread.sleep(1000);
//                txtStory.setText("He kills you\n\nClick to Replay scene......");
//            } catch (InterruptedException ex) {
//                Logger.getLogger(CabinPanel.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            clickedNext = 15;
//            addClicked = clickedNext;
//            
//            
//        }else if (addClicked == 23) {
//            txtOfOptions.setText("Waiting...");
//            txtOfOptions.setVisible(true);
//            txtStory.setText(listStory.get(23));
//            try {
//                Thread.sleep(1000);
//                txtStory.setText("Suddenly the old man appears with a shotgon and kills you!\n\nClick to replay scene");
//            } catch (InterruptedException ex) {
//                Logger.getLogger(CabinPanel.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            clickedNext = 21;
//            addClicked = clickedNext;
//        }
//        MakeOptFalse();
    }//GEN-LAST:event_firstOptionActionPerformed

    
    //Third User choice button
    private void thirdOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thirdOptionActionPerformed
//        if(addClicked == 2){
//            txtOfOptions.setText("Searching...");
//            txtOfOptions.setVisible(true);
//            txtStory.setText(listStory.get(4));
//            clickedNext = 6;
//            addClicked = clickedNext;
//        }
//        MakeOptFalse();
    }//GEN-LAST:event_thirdOptionActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        // TODO add your handling code here:
        this.setSize(jFrame.getWidth(), jFrame.getHeight());
    }//GEN-LAST:event_formComponentResized

    private void txtStoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtStoryMouseClicked
//        txtOfOptions.setVisible(false);
//        check = false; //reset so it won't keep going into else if statements
//
//        //Stop to make choice for User in a certain amount of clicks from textArea (story)
//        if (addClicked == 2 || addClicked == 13 || addClicked == 18 || addClicked == 23){
//            check = true;
//            clickedNext = addClicked;
//        }
//
//        //Continute on Story
//        if(check == false){
//            clickedNext++;
//            addClicked = clickedNext;
//            if(clickedNext <= 1 || (clickedNext >= 7 && clickedNext <=12) || (clickedNext >=15 && clickedNext <= 17) || (clickedNext >=20 && clickedNext <= 22) || clickedNext >=24){
//                txtStory.setText(listStory.get(clickedNext));
//                if (clickedNext == 28) {
//                    WinPanel winPan = new WinPanel(jFrame);
//                    jFrame.remove(this);
//                    winPan.setVisible(false);
//                    jFrame.add(winPan);
//                    jFrame.validate();
//                    jFrame.repaint();
//                    winPan.setBackground(Color.white);
//                    winPan.setSize(jFrame.getWidth() - 20, jFrame.getHeight() - 50);
//                    winPan.setVisible(true);
//                }
//            }else if(clickedNext >= 5 && clickedNext <=6){
//                if (clickedNext == 6) {
//                    txtStory.setText("The old man kills you!\n\nClick to replay scene");
//                    clickedNext = 1;
//                    addClicked = clickedNext;
//                }
//            }
//
//            else{
//                check = true;
//            }
//        }else if(alterCabin == true){
//            check = false;
//            clickedNext = 5;
//            addClicked = clickedNext;
//            txtStory.setText(listStory.get(clickedNext));
//            MakeOptFalse();
//        }
//
//        //Get the Choices for the User
//        if(check == true){
//            alterCabin = false;
//            MakeOptTrue();
//            MakeOptions();
//
//        }
//        System.out.print(" " + addClicked + " CHECK: " + check);

    }//GEN-LAST:event_txtStoryMouseClicked

    public void firsBtntOptListener(ActionListener listener){
        this.firstOption.addActionListener(listener);
    }
    
    public void secondBtnOptListener(ActionListener listener){
        this.secondOption.addActionListener(listener);
    }
    
    public void thirdBtnOptListener(ActionListener listener){
        this.thirdOption.addActionListener(listener);
    }
    
    public void txtStoryListener(MouseListener listener){
        this.txtStory.addMouseListener(listener);
    }
    
    public void setStoryText(String d){
        this.txtStory.setText(d);
    }
    
    public void setOptions(String first, String second, String third){
        this.firstOption.setText(first);
        this.secondOption.setText(second);
        this.thirdOption.setText(third);
    }
    
    public void setTxtOfOptions(String d){
        this.txtOfOptions.setText(d);
    }
    
    public void setImage(String image) {
        try {
            img = ImageIO.read(new File(image));
        } catch (IOException ex) {
            Logger.getLogger(CabinPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public JButton getfirstbtn() {
        return this.firstOption;
    }
    
    public JButton getsecondbtn() {
        return this.secondOption;
    }
    
    public JButton getthirdbtn() {
        return this.thirdOption;
    }
    
    public JTextField getTxtOfOptions() {
        return this.txtOfOptions;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        //Put image somewhere else if Window gets big
//        if(jFrame.getWidth() > 500 && jFrame.getHeight() > 500){
//            g.drawImage(img, 10, 70, this);
//        }else{
//            g.drawImage(img, 0, 0, this);
//        }
        g.drawImage(img, 0, 70, this.getWidth(), this.getHeight(), this);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton firstOption;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel optionsPanel;
    private javax.swing.JButton secondOption;
    private javax.swing.JPanel storyPanel;
    private javax.swing.JButton thirdOption;
    private javax.swing.JPanel topPanel;
    private javax.swing.JTextField txtOfOptions;
    private javax.swing.JTextArea txtStory;
    // End of variables declaration//GEN-END:variables
}
