//This java class is the beginning of the story until the Cabin in the Woods


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

public class BeginningStoryPanel extends javax.swing.JPanel {
    View jFrame;
    
    private int intOptions = 0; //Counter for User button choices (rarely used)
    private int clickedNext = 0; //Counter for user clicks on the TextArea of Story
    private int addClicked = 0; //2nd Counter of clickedNext to help //might have not needed this counter
    private boolean check = false, intoWoods = false; //boolean values
    
    private ArrayList<String> listStory = new ArrayList<String>(); //Array list to store Story in String format
    
    //Method that contains the strings of the story in ArrayList format
    private void Story(){
        //The start of the story
        listStory.add("You have been stressed for quite some time now because you got a lot going on");
        listStory.add("You've decided to go on a drive to take your mind off of things");
        listStory.add("3 hours later . . .");
        listStory.add("You're still driving but you notice something is not right.");
        listStory.add("*Your car starts to breakdown*");
        listStory.add("You got out of the car and you have no idea where you are");
        //Queue FIRST options after 0-5. //6-8 are OPTIONS
        listStory.add("Your Phone has no signal");
        listStory.add("You waited but no one is in sight");
        listStory.add("Went into woods");
        //9-10 Woods story
        listStory.add("After walking for some time, you hear steps somewhere in front of you. But the path in front of you is blocked.");
        listStory.add("What do you do?");
        //11-13 SECOND options //13 Death Scene
        listStory.add("You walked back");
        listStory.add("You quickly dropped and hid in a bush");
        listStory.add("You yelled who's there?!");
        //14 continue story
        listStory.add("Quite some time after, you see it was just a squirrel");
        //15-19 FIREPLACE story
        listStory.add("You venture on continuing your march deeper into the woods hoping to find someone. Something.");
        listStory.add("While walking around for some time, you stumbled upon an unexpected fireplace.");
        listStory.add("You searched around and the first thing that caught your attention was a folded piece of paper.");
        listStory.add("You opened it and it barely was legible. . .");
        listStory.add("Your choice");
    }
    
    //Set options to be unviewable
    public void MakeOptFalse(){
        optionPanel.setVisible(false);
        firstOption.setVisible(false);
        secondOption.setVisible(false);
        thirdOption.setVisible(false);
    }
  
    //Set options to be viewable
    public void MakeOptTrue(){
        optionPanel.setVisible(true);
        firstOption.setVisible(true);
        secondOption.setVisible(true);
        thirdOption.setVisible(true);
    }
    
    //Set the text of the option buttons
    private void MakeOptions(){
        if(addClicked == 6){
            firstOption.setText("Check Phone");
            secondOption.setText("Go to Woods");
            thirdOption.setText("Wait for Help");
        }else if(addClicked == 11){
            firstOption.setText("Go Back");
            secondOption.setText("Hide");
            thirdOption.setText("Yell 'Who's there'");
        }else if(addClicked == 19){
            firstOption.setText("Leave woods");
            secondOption.setText("Venture on");
            thirdOption.setVisible(false);
        }
    }
    
    BufferedImage img;
    
    //Constructor to initialize stuff
    public BeginningStoryPanel(View jframe) {
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
//        //A quick tip for first time Users
//        if(clickedNext == 0){
//            txtOfOptions.setVisible(true);
//            txtOfOptions.setText("*TIP: Click the box of the story to continue.");
//        }else{
//            txtOfOptions.setVisible(false); 
//        }
//        
//        try {
//            img = ImageIO.read(new File("Images\\roadimg.jpg"));
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
        jScrollPane1 = new javax.swing.JScrollPane();
        txtStory = new javax.swing.JTextArea();
        optionPanel = new javax.swing.JPanel();
        firstOption = new javax.swing.JButton();
        secondOption = new javax.swing.JButton();
        thirdOption = new javax.swing.JButton();
        settingsButton = new javax.swing.JButton();

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
                .addGap(112, 112, 112)
                .addComponent(txtOfOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 764, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtOfOptions, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );

        storyPanel.setOpaque(false);

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

        javax.swing.GroupLayout storyPanelLayout = new javax.swing.GroupLayout(storyPanel);
        storyPanel.setLayout(storyPanelLayout);
        storyPanelLayout.setHorizontalGroup(
            storyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(storyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        storyPanelLayout.setVerticalGroup(
            storyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        optionPanel.setOpaque(false);

        firstOption.setText("first");
        firstOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstOptionActionPerformed(evt);
            }
        });

        secondOption.setText("second");
        secondOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secondOptionActionPerformed(evt);
            }
        });

        thirdOption.setText("third");
        thirdOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thirdOptionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout optionPanelLayout = new javax.swing.GroupLayout(optionPanel);
        optionPanel.setLayout(optionPanelLayout);
        optionPanelLayout.setHorizontalGroup(
            optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(firstOption, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                .addGap(45, 45, 45)
                .addComponent(secondOption, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                .addGap(46, 46, 46)
                .addComponent(thirdOption, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                .addContainerGap())
        );
        optionPanelLayout.setVerticalGroup(
            optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(thirdOption, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(secondOption, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addComponent(firstOption, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        settingsButton.setBackground(new java.awt.Color(0, 0, 0));
        settingsButton.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        settingsButton.setForeground(new java.awt.Color(255, 255, 255));
        settingsButton.setText("Settings");
        settingsButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 10, true));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(optionPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(storyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(settingsButton)
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(settingsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 337, Short.MAX_VALUE)
                .addComponent(optionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(storyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtStoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtStoryMouseClicked
//        txtOfOptions.setVisible(false); 
//        check = false; //reset so it won't keep going into else if statements
//        
//        //Stop to make choice for User in a certain amount of clicks from textArea (story)
//        if (addClicked == 6 || addClicked == 11 || addClicked == 19){
//            check = true;
//            clickedNext = addClicked;
//        }else if(addClicked == 17){
//            txtOfOptions.setText("134v3");
//            txtOfOptions.setVisible(true);
//            MakeOptFalse();
//        }
//        
//        //Continute on Story
//        if(check == false){
//            clickedNext++;
//            addClicked = clickedNext;
//            if(clickedNext <= 5){
//                txtStory.setText(listStory.get(clickedNext));
//            }else if((clickedNext >= 9 && clickedNext <=10) || (clickedNext >=14 && clickedNext <= 19)){
//                if(clickedNext == 15) {
//                    try {
//                        img = ImageIO.read(new File("Images\\campfireimg.jpg"));
//                        this.repaint();
//                    } catch (IOException ex) {
//                        Logger.getLogger(CabinPanel.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//                txtStory.setText(listStory.get(clickedNext));
//            }else if(addClicked == 12){
//                txtStory.setText("Few minutes later you got bit by a venomous snake. \n You died. \n\n Click to replay scene");
//                txtOfOptions.setText("You Died");
//                txtOfOptions.setVisible(true);
//                clickedNext = 8;
//                addClicked = clickedNext;
//                
//            }else{
//                check = true;
//            }
//        }else if(intoWoods == true){
//            check = false;
//            clickedNext = 9;
//            addClicked = clickedNext;
//            txtStory.setText(listStory.get(clickedNext));
//            MakeOptFalse();
//        }else if(intOptions == 3){
//            check = false;
//            clickedNext = 14;
//            addClicked = clickedNext;
//            txtStory.setText(listStory.get(clickedNext));
//        }
//     
//        //Get the Choices for the User
//        if(check == true){
//            intoWoods = false;
//            MakeOptTrue();
//            MakeOptions();
//            
//        }
//        intOptions = 0; //reset so it won't keep going into else if statements
//        System.out.print(" " + addClicked + " CHECK: " + check);
        
    }//GEN-LAST:event_txtStoryMouseClicked

    private void txtOfOptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOfOptionsActionPerformed
        //empty
    }//GEN-LAST:event_txtOfOptionsActionPerformed

    
    //Second User choice button
    private void secondOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secondOptionActionPerformed
//        if(addClicked == 6){
//            intoWoods = true;
//            try {
//            img = ImageIO.read(new File("Images\\forestimg.jpg"));
//            this.repaint();
//            } catch (IOException ex) {
//                Logger.getLogger(CabinPanel.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            txtOfOptions.setText("WENT INTO WOODS");
//            txtOfOptions.setVisible(true);
//
//            txtStory.setText(listStory.get(8));
//            
//        }else if(addClicked == 11){
//            txtOfOptions.setText("You Hid");
//            txtOfOptions.setVisible(true);
//            txtStory.setText(listStory.get(12));
//            addClicked = 12;
//        }else if(addClicked == 19){
//            intOptions = 7;
//            txtOfOptions.setText(":]");
//            txtOfOptions.setVisible(true);
//            txtStory.setText("You continued on.");
//            
//            //Saleh's Panel goes here
//            CabinPanel begPan = new CabinPanel(jFrame);
//            jFrame.remove(this);
//            begPan.setVisible(false);
//            jFrame.add(begPan);
//            jFrame.validate();
//            jFrame.repaint();
//            begPan.setBackground(Color.white);
//            begPan.setSize(jFrame.getWidth() - 20, jFrame.getHeight() - 50);   
//            begPan.setVisible(true);
//        }
//        MakeOptFalse();
    }//GEN-LAST:event_secondOptionActionPerformed

    
    //First User choice button
    private void firstOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstOptionActionPerformed
//        if(addClicked == 6){
//            txtOfOptions.setText("CHECKED PHONE");
//            txtOfOptions.setVisible(true);
//            txtStory.setText(listStory.get(6));
//        }else if(addClicked == 11){
//            txtOfOptions.setText("Walked back");
//            txtOfOptions.setVisible(true);
//            txtStory.setText(listStory.get(11));
//            addClicked = 6;
//        }else if(addClicked == 19){
//            txtOfOptions.setText("Try Again.");
//            txtOfOptions.setVisible(true);
//            txtStory.setText("You tried to leave, but you are lost");
//        }
//        MakeOptFalse();
    }//GEN-LAST:event_firstOptionActionPerformed

    
    //Third User choice button
    private void thirdOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thirdOptionActionPerformed
//        if(addClicked == 6){
//            txtOfOptions.setText("WAITED FOR HELP");
//            txtOfOptions.setVisible(true);
//            txtStory.setText(listStory.get(7));
//        }else if(addClicked == 11){
//            intOptions = 3;
//            txtOfOptions.setText("Yelled");
//            txtOfOptions.setVisible(true);
//            txtStory.setText(listStory.get(13));
//        }
//        MakeOptFalse();
    }//GEN-LAST:event_thirdOptionActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        // TODO add your handling code here:
//        this.setSize(jFrame.getWidth(), jFrame.getHeight());
    }//GEN-LAST:event_formComponentResized

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
            g.drawImage(img, 0, 70, this.getWidth(), this.getHeight(), this);
//            g.drawImage(img, this.getWidth()/2, this.getHeight()/2, this);
//        }else{
//            g.drawImage(img, 0, 0, this);
//        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton firstOption;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel optionPanel;
    private javax.swing.JButton secondOption;
    private javax.swing.JButton settingsButton;
    private javax.swing.JPanel storyPanel;
    private javax.swing.JButton thirdOption;
    private javax.swing.JPanel topPanel;
    private javax.swing.JTextField txtOfOptions;
    private javax.swing.JTextArea txtStory;
    // End of variables declaration//GEN-END:variables
}
