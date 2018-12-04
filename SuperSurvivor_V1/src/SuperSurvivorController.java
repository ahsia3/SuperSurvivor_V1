/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;

/**
 *
 * @author Nkwabo Saleh
 */
public class SuperSurvivorController {
    
    private DatabaseBean model;
    private SuperSurvivorView view;
    private ActionListener actionListener;
    private MouseListener mouseListener;
    int x= 0;
    ArrayList<Scenes> scenes = DatabaseBean.RetriveAllScenes();
    ArrayList<Scenes> cscenes = DatabaseBean.RetriveAllCabinScenes();
    ArrayList<User> users = DatabaseBean.RetriveAllUsers();
    private int intOptions = 0; //Counter for User button choices (rarely used)
    private int clickedNext = 0; //Counter for user clicks on the TextArea of Story
    private int addClicked = 0; //2nd Counter of clickedNext to help //might have not needed this counter
    private boolean check = false, intoWoods = false, alterCabin = false; //boolean values
//    SignInPanel signin;
    
    public SuperSurvivorController(DatabaseBean model, SuperSurvivorView view) {
        this.model = model;
        this.view = view;
        
        start();
        //Uncomment the function calls once every thing is done or when you want to test one of them out, otherwise things wont work.
        signInStuff();
        registerStuff();
        menuStuff();
        beginningStoryStuff();
        cabinStuff();
        winStuff();
        
    }
    
    public void start() {
        view.signin = new SignInPanel(view);
        view.registerframe = new RegisterInternalFrame();
        view.menupanel = new MenuPanel(view);
        view.beginningpanel = new BeginningStoryPanel(view);
        view.cabinpanel = new CabinPanel(view);
        view.winpanel = new WinPanel(view);
        view.add(view.signin);
        view.centerMe();
//        view.validate();
        view.pack();
        view.setVisible(true);
        System.out.println("Testing to see what happens");
    }
    
    //This is where the functions in SignInPanel are implemented.
    public void signInStuff() {
        
        
        
        //This is what happends when you click the submit button
        //Its supposed to sign the user from the database in with their database values and go to the menu page
        //Use the evt.getSource() method  and cast it to a button to get the source of where the action is being performed. This will be similar for the remaining functions below.
        actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                JButton b=(JButton) evt.getSource();
                System.out.println(b.getText());
                User user;
                String userName;
                String userPass;
                for(int i = 1; i <= users.size(); i++) {
                    userName = users.get(i).getUname();
                    userPass = users.get(i).getPass();
                    String pass = new String(view.signin.getUserPassword());
                    if (userName.equals(view.signin.getUserName()) && userPass.equals(pass)) {
                        view.add(view.menupanel);
                        view.remove(view.signin);
                        view.validate();
                        view.repaint();
                        view.menupanel.setUserLabel(userName);
                        break;
                    }
                    else{
                        System.out.println("Incorrect login");
                    }
                    
                }
//                
                
            }
        };
        
        //This is what happends when you click the "click here" label. You only need to to implement the mouseClicked method and ignore the rest.
        //Its supposed to open up the register window
        mouseListener = new MouseListener() {
            @Override
            //This is the only one that needs to be overridden. For some reason, the rest have to be defined.
            public void mouseClicked(MouseEvent e) {
//                view.registerframe = new RegisterInternalFrame();
                view.remove(view.signin);
                view.add(view.registerframe);
                view.validate();
                view.repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        
        view.signin.addsubmitListener(actionListener);
        view.signin.addregisterListener(mouseListener);
    }
    
    //This is where the functions in RegisterInternalFrame are implemented.
    public void registerStuff() {
        //This is what happends when you click the submit button
        //Its supposed to create a new user in the database with default values, sign the user in by going to the menu page
        actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                JButton b=(JButton) evt.getSource();
                view.menupanel = new MenuPanel(view);
                view.remove(view.registerframe);
//                view.add(view.menupanel);
                view.validate();
                view.repaint();
                System.out.println(b.getText());
                String pass = new String(view.registerframe.getUserPassword());
                User user = new User(674, view.registerframe.getUserName(), pass);
                DatabaseBean.WriteUser(user);
                String userName = user.getUname();
                view.menupanel.setUserLabel(userName);
                
            }
        };
        view.registerframe.addsubmitListener(actionListener);
    }
    
    //This is where the functions in MenuPanel are implemented.
    public void menuStuff() {
        //This is what happends when you click the play or exit button
        //Its supposed to go on to the beginningstorypanel when you click play and go to signinpanel page when you click exit
        actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                
                JButton b=(JButton) evt.getSource();
                String d=b.getText();
                System.out.println(d);
                if(d.equals("PLAY")) {
                    view.remove(view.menupanel);
                    view.add(view.beginningpanel);
                    view.validate();
                    view.repaint();
                }
                else if (d.equals("EXIT")) {
                    System.exit(0);
                }
            }
        };
        
        view.menupanel.addPlayListener(actionListener);
        view.menupanel.addExitListener(actionListener);
    }
    
//    Options options;
//    boolean notsetopt = true;
    
    //This is where the functions in BeginningStoryPanel are implemented.
    public void beginningStoryStuff() {
        
//        view.beginningpanel.MakeOptFalse();
        view.beginningpanel.setImage("Images\\roadimg.jpg");
        view.beginningpanel.repaint();
//        view.beginningpanel.setTxtOfOptions("*TIP: Click the box of the story to continue.");
//        view.beginningpanel.setStoryText("You have been stressed for quite some time now because you got a lot going on");
        
        if(clickedNext > 0){
            
            view.beginningpanel.setStoryText(scenes.get(clickedNext).getText());
//            txtStory.setText(listStory.get(clickedNext));
        }else{
            
            view.beginningpanel.setStoryText(scenes.get(0).getText());
//            txtStory.setText(listStory.get(0));
        }
        
        view.beginningpanel.MakeOptFalse();
        
//        MakeOptFalse();
        
        //A quick tip for first time Users
        if(clickedNext == 0){
            
            view.beginningpanel.getTxtOfOptions().setVisible(true);
//            txtOfOptions.setVisible(true);

            view.beginningpanel.setTxtOfOptions("*TIP: Click the box of the story to continue.");
//            txtOfOptions.setText("*TIP: Click the box of the story to continue.");
        }else{
            
            view.beginningpanel.getTxtOfOptions().setVisible(false);
//            txtOfOptions.setVisible(false); 
        }
        
        
        //This is what happends when you click any of the options in the beginningstorypanel
        //Its supposed to handle the flowout of the story. So basically what happens after you click an option or click the txtStory jtextarea
        actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                
                JButton b=(JButton) evt.getSource();
                String d=b.getText();
                if (b == view.beginningpanel.getfirstbtn()) {
                    
                    if(addClicked == 6){
                        
                        view.beginningpanel.setTxtOfOptions("CHECKED PHONE");
                        view.beginningpanel.getTxtOfOptions().setVisible(true);
                        view.beginningpanel.setStoryText(scenes.get(6).getText());
//                        txtOfOptions.setText("CHECKED PHONE");
//                        txtOfOptions.setVisible(true);
//                        txtStory.setText(listStory.get(6));
                    }else if(addClicked == 11){
                        
                        view.beginningpanel.setTxtOfOptions("Walked back");
                        view.beginningpanel.getTxtOfOptions().setVisible(true);
                        view.beginningpanel.setStoryText(scenes.get(11).getText());
//                        txtOfOptions.setText("Walked back");
//                        txtOfOptions.setVisible(true);
//                        txtStory.setText(listStory.get(11));
                        addClicked = 6;
                    }else if(addClicked == 19){
                        
                        view.beginningpanel.setTxtOfOptions("Try Again.");
                        view.beginningpanel.getTxtOfOptions().setVisible(true);
                        view.beginningpanel.setStoryText("You tried to leave, but you are lost");
//                        txtOfOptions.setText("Try Again.");
//                        txtOfOptions.setVisible(true);
//                        txtStory.setText("You tried to leave, but you are lost");
                    }
                    view.beginningpanel.MakeOptFalse();
                    
//                    view.beginningpanel.setTxtOfOptions(options.getFirstOptSelected());
//                    view.beginningpanel.setStoryText(options.getFirstOptSelected());
                }
                else if (b == view.beginningpanel.getsecondbtn()) {
                    
                    if(addClicked == 6){
                        intoWoods = true;
                    view.beginningpanel.setImage("Images\\forestimg.jpg");
                    view.beginningpanel.repaint();
                    
                    view.beginningpanel.setTxtOfOptions("WENT INTO WOODS");
                    view.beginningpanel.getTxtOfOptions().setVisible(true);
                    view.beginningpanel.setStoryText(scenes.get(8).getText());
//                        txtOfOptions.setText("WENT INTO WOODS");
//                        txtOfOptions.setVisible(true);
//
//                        txtStory.setText(listStory.get(8));

                    }else if(addClicked == 11){
                        
                    view.beginningpanel.setTxtOfOptions("You Hid");
                    view.beginningpanel.getTxtOfOptions().setVisible(true);
                    view.beginningpanel.setStoryText(scenes.get(12).getText());
//                        txtOfOptions.setText("You Hid");
//                        txtOfOptions.setVisible(true);
//                        txtStory.setText(listStory.get(12));
                        addClicked = 12;
                    }else if(addClicked == 19){
                        intOptions = 7;
                        
                    view.beginningpanel.setTxtOfOptions("");
                    view.beginningpanel.getTxtOfOptions().setVisible(true);
                    view.beginningpanel.setStoryText("");
//                        txtOfOptions.setText(":]");
//                        txtOfOptions.setVisible(true);
//                        txtStory.setText("You continued on.");

                        //Saleh's Panel goes here
                        view.remove(view.beginningpanel);
//                        begPan.setVisible(false);
                        view.add(view.cabinpanel);
                        view.validate();
                        view.repaint();
                        
                        intOptions = 0;
                        clickedNext = 0;
                        addClicked = 0;
                        check = false;
                        intoWoods = false;
                        view.beginningpanel.setImage("Images\\roadimg.jpg");
                        view.beginningpanel.repaint();
//                        begPan.setBackground(Color.white);
//                        begPan.setSize(jFrame.getWidth() - 20, jFrame.getHeight() - 50);   
//                        begPan.setVisible(true);
                    }
                    view.beginningpanel.MakeOptFalse();
                    
//                    view.beginningpanel.setTxtOfOptions(options.getSecondOptSelected());
//                    view.beginningpanel.setStoryText(options.getSecondOptSelected());
                }
                else if (b == view.beginningpanel.getthirdbtn()) {
                    
                    if(addClicked == 6){
                        
                    view.beginningpanel.setTxtOfOptions("WAITED FOR HELP");
                    view.beginningpanel.getTxtOfOptions().setVisible(true);
                    view.beginningpanel.setStoryText(scenes.get(7).getText());
//                        txtOfOptions.setText("WAITED FOR HELP");
//                        txtOfOptions.setVisible(true);
//                        txtStory.setText(listStory.get(7));
                    }else if(addClicked == 11){
                        intOptions = 3;
                        
                    view.beginningpanel.setTxtOfOptions("Yelled");
                    view.beginningpanel.getTxtOfOptions().setVisible(true);
                    view.beginningpanel.setStoryText(scenes.get(13).getText());
//                        txtOfOptions.setText("Yelled");
//                        txtOfOptions.setVisible(true);
//                        txtStory.setText(listStory.get(13));
                    }
                    view.beginningpanel.MakeOptFalse();
                    
//                    view.beginningpanel.setTxtOfOptions(options.getThirdOptSelected());
//                    view.beginningpanel.setStoryText(options.getThirdOptSelected());
                }
//                notsetopt = true;
            }
        };
        
        mouseListener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                view.beginningpanel.getTxtOfOptions().setVisible(false);
//                txtOfOptions.setVisible(false); 
                check = false; //reset so it won't keep going into else if statements

                //Stop to make choice for User in a certain amount of clicks from textArea (story)
                if (addClicked == 6 || addClicked == 11 || addClicked == 19){
                    check = true;
                    clickedNext = addClicked;
                }else if(addClicked == 17){
                    
                    view.beginningpanel.setTxtOfOptions("134v3");
                    view.beginningpanel.getTxtOfOptions().setVisible(true);
//                    txtOfOptions.setText("134v3");
//                    txtOfOptions.setVisible(true);
                    view.beginningpanel.MakeOptFalse();
                }

                //Continute on Story
                if(check == false){
                    clickedNext++;
                    addClicked = clickedNext;
                    if(clickedNext <= 5){
                        view.beginningpanel.setStoryText(scenes.get(clickedNext).getText());
//                        txtStory.setText(listStory.get(clickedNext));
                    }else if((clickedNext >= 9 && clickedNext <=10) || (clickedNext >=14 && clickedNext <= 19)){
                        if(clickedNext == 15) {
                            view.beginningpanel.setImage("Images\\campfireimg.jpg");
                            view.beginningpanel.repaint();
                        }
                        view.beginningpanel.setStoryText(scenes.get(clickedNext).getText());
//                        txtStory.setText(listStory.get(clickedNext));
                    }else if(addClicked == 12){
                        
                        view.beginningpanel.setStoryText("Few minutes later you got bit by a venomous snake. \n You died. \n\n Click to replay scene");
                        view.beginningpanel.setTxtOfOptions("You Died");
                        view.beginningpanel.getTxtOfOptions().setVisible(true);
//                        txtStory.setText("Few minutes later you got bit by a venomous snake. \n You died. \n\n Click to replay scene");
//                        txtOfOptions.setText("You Died");
//                        txtOfOptions.setVisible(true);
                        clickedNext = 8;
                        addClicked = clickedNext;

                    }else{
                        check = true;
                    }
                }else if(intoWoods == true){
                    check = false;
                    clickedNext = 9;
                    addClicked = clickedNext;
                    view.beginningpanel.setStoryText(scenes.get(clickedNext).getText());
//                    txtStory.setText(listStory.get(clickedNext));
                    view.beginningpanel.MakeOptFalse();
                }else if(intOptions == 3){
                    check = false;
                    clickedNext = 14;
                    addClicked = clickedNext;
                    view.beginningpanel.setStoryText(scenes.get(clickedNext).getText());
//                    txtStory.setText(listStory.get(clickedNext));
                }

                //Get the Choices for the User
                if(check == true){
                    intoWoods = false;
                    view.beginningpanel.MakeOptTrue();
                    if(addClicked == 6){
                        view.beginningpanel.setOptions("Check Phone", "Go to Woods", "Wait for Help");
//                        firstOption.setText("Check Phone");
//                        secondOption.setText("Go to Woods");
//                        thirdOption.setText("Wait for Help");
                    }else if(addClicked == 11){
                        view.beginningpanel.setOptions("Go Back", "Hide", "Yell 'Who's there'");
//                        firstOption.setText("Go Back");
//                        secondOption.setText("Hide");
//                        thirdOption.setText("Yell 'Who's there'");
                    }else if(addClicked == 19){
                        view.beginningpanel.setOptions("Leave woods", "Venture on", "");
//                        firstOption.setText("Leave woods");
//                        secondOption.setText("Venture on");
                        view.beginningpanel.getthirdbtn().setVisible(false);
                    }

                }
                intOptions = 0; //reset so it won't keep going into else if statements
                System.out.print(" " + addClicked + " CHECK: " + check);
                
////                view.beginningpanel.setStoryText("An incrementing number is: " + x++);
//                if (x<scenes.size() && scenes.get(x).getOptions() > 0 ) {
//                    view.beginningpanel.MakeOptTrue();
//                    notsetopt = false;
//                    options = DatabaseBean.RetrieveOptions(scenes.get(x).getOptions());
//                    view.beginningpanel.setOptions(options.getFirstOpt(), options.getSecondOpt(), options.getThirdOpt());
//                    x++;
////                    return;
//                }
//                if(x<scenes.size() && notsetopt) {
//                    view.beginningpanel.MakeOptFalse();
//                    view.beginningpanel.setStoryText(scenes.get(x++).getText());
//                }
////                if (scenes.get(x).getOptions() > 0) {
////                    view.beginningpanel.setOptions(scenes.get(x++).getText());
////                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            @Override
            public void mouseReleased(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        };
        
        view.beginningpanel.firsBtntOptListener(actionListener);
        view.beginningpanel.secondBtnOptListener(actionListener);
        view.beginningpanel.thirdBtnOptListener(actionListener);
        view.beginningpanel.txtStoryListener(mouseListener);
    }
    
    //This is where the functions in BeginningStoryPanel are implemented.
    public void cabinStuff() {
        
        view.cabinpanel.setImage("Images\\cabinimg1.jpg");
        view.cabinpanel.repaint();
        if(clickedNext > 0){
            
            view.cabinpanel.setStoryText(scenes.get(clickedNext).getText());
        }else{
            
            view.cabinpanel.setStoryText(scenes.get(0).getText());
        }
        
        view.cabinpanel.MakeOptFalse();
        //A quick tip for first time Users
        if(clickedNext == 0){
            
            view.cabinpanel.getTxtOfOptions().setVisible(true);

            view.cabinpanel.setTxtOfOptions("*TIP: Click the box of the story to continue.");
        }else{
            
            view.cabinpanel.getTxtOfOptions().setVisible(false);
        }
        
        //This is what happends when you click any of the options in the cabinpanel
        //Its supposed to handle the flowout of the story. So basically what happens after you click an option or click the txtStory jtextarea
        actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                
                JButton b=(JButton) evt.getSource();
                String d=b.getText();
                if (b == view.cabinpanel.getfirstbtn()) {
                    
                    if(addClicked == 2){
                    alterCabin = true;
                    view.cabinpanel.setTxtOfOptions("IS ANYONE THERE!!!!");
                    view.cabinpanel.getTxtOfOptions().setVisible(true);
                    view.cabinpanel.setStoryText(cscenes.get(2).getText());
                }else if(addClicked == 13){
                    view.cabinpanel.setTxtOfOptions("Cabin entered");
                    view.cabinpanel.getTxtOfOptions().setVisible(true);
                    view.cabinpanel.setStoryText(cscenes.get(13).getText());
                    clickedNext = 14;
                    addClicked = clickedNext;
                }else if(addClicked == 18){
                    view.cabinpanel.getTxtOfOptions().setVisible(true);
                    view.cabinpanel.setTxtOfOptions("Old man woken up");
                    view.cabinpanel.setStoryText(cscenes.get(13).getText());
                    try {
                        Thread.sleep(1000);
                        view.cabinpanel.setStoryText("He kills you\n\nClick to Replay scene......");
                    } catch (InterruptedException ex) {
                        Logger.getLogger(CabinPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    clickedNext = 15;
                    addClicked = clickedNext;


                }else if (addClicked == 23) {
                    view.cabinpanel.setTxtOfOptions("Waiting...");
                    view.cabinpanel.getTxtOfOptions().setVisible(true);
                    view.cabinpanel.setStoryText(cscenes.get(23).getText());
                    try {
                        Thread.sleep(1000);
                        view.cabinpanel.setStoryText("Suddenly the old man appears with a shotgon and kills you!\n\nClick to replay scene");
                    } catch (InterruptedException ex) {
                        Logger.getLogger(CabinPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    clickedNext = 21;
                    addClicked = clickedNext;
                }
                view.cabinpanel.MakeOptFalse();
                    
                }
                else if (b == view.cabinpanel.getsecondbtn()) {
                    
                    if(addClicked == 2){

                    view.cabinpanel.setTxtOfOptions("Entered the cabin!");
                    view.cabinpanel.getTxtOfOptions().setVisible(true);
                    view.cabinpanel.setStoryText(cscenes.get(3).getText());
                    clickedNext = 14;
                    addClicked = clickedNext;

                }else if(addClicked == 13){
                    view.cabinpanel.setTxtOfOptions("Searching...\n\nNothing found");
                    view.cabinpanel.getTxtOfOptions().setVisible(true);
                    view.cabinpanel.setStoryText(cscenes.get(14).getText());
                }else if(addClicked == 18){
                    view.cabinpanel.setTxtOfOptions("You grab key and leave");
                    view.cabinpanel.getTxtOfOptions().setVisible(true);
                    view.cabinpanel.setStoryText(cscenes.get(19).getText());
                    clickedNext = 19;
                    addClicked = clickedNext;

                }else if(addClicked == 23) {
                    view.cabinpanel.setTxtOfOptions("Car starting...");
                    view.cabinpanel.getTxtOfOptions().setVisible(true);
                    view.cabinpanel.setStoryText(cscenes.get(24).getText());
                    clickedNext = 24;
                    addClicked = clickedNext;
                }
                view.cabinpanel.MakeOptFalse();
                    
                }
                else if (b == view.cabinpanel.getthirdbtn()) {
                    
                    if(addClicked == 2){
                    view.cabinpanel.setTxtOfOptions("Searching...");
                    view.cabinpanel.getTxtOfOptions().setVisible(true);
                    view.cabinpanel.setStoryText(cscenes.get(4).getText());
                    clickedNext = 6;
                    addClicked = clickedNext;
        }
        view.cabinpanel.MakeOptFalse();
                    
                }
            }
        };
        
        mouseListener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                view.cabinpanel.getTxtOfOptions().setVisible(false);
                check = false; //reset so it won't keep going into else if statements

                //Stop to make choice for User in a certain amount of clicks from textArea (story)
                if (addClicked == 2 || addClicked == 13 || addClicked == 18 || addClicked == 23){
                    check = true;
                    clickedNext = addClicked;
                }

                //Continute on Story
                if(check == false){
                    clickedNext++;
                    addClicked = clickedNext;
                    if(clickedNext <= 1 || (clickedNext >= 7 && clickedNext <=12) || (clickedNext >=15 && clickedNext <= 17) || (clickedNext >=20 && clickedNext <= 22) || clickedNext >=24){
                        view.cabinpanel.setStoryText(cscenes.get(clickedNext).getText());
                        if (clickedNext == 28) {
                            
                            view.remove(view.cabinpanel);
                            view.add(view.winpanel);
                            view.validate();
                            view.repaint();
                            
                            intOptions = 0;
                            clickedNext = 0;
                            addClicked = 0;
                            check = false;
                            intoWoods = false;
                            alterCabin = false;
                        }
                    }else if(clickedNext >= 5 && clickedNext <=6){
                        if (clickedNext == 6) {
                            view.cabinpanel.setStoryText("The old man kills you!\n\nClick to replay scene");
                            clickedNext = 1;
                            addClicked = clickedNext;
                        }
                    }

                    else{
                        check = true;
                    }
                }else if(alterCabin == true){
                    check = false;
                    clickedNext = 5;
                    addClicked = clickedNext;
                    view.cabinpanel.setStoryText(cscenes.get(clickedNext).getText());
                    view.cabinpanel.MakeOptFalse();
                }

                //Get the Choices for the User
                if(check == true){
                    alterCabin = false;
                    view.cabinpanel.MakeOptTrue();
                    
                    if(addClicked == 2){
                        view.cabinpanel.setOptions("Yell, \"Is anyone there?\"", "Enter cabin", "Search around");
                }else if(addClicked == 13){
                    view.cabinpanel.setOptions("Enter cabin", "Continue searching", "");
                    view.cabinpanel.getthirdbtn().setVisible(false);
                }else if(addClicked == 18){
                    view.cabinpanel.setOptions("Wake up old man", "Grab keys and leave", "");
                    view.cabinpanel.getthirdbtn().setVisible(false);
                }else if(addClicked == 23) {
                    view.cabinpanel.setOptions("Wait and see", "Start car and leave", "");
                    view.cabinpanel.getthirdbtn().setVisible(false);
                }

                }
                System.out.print(" " + addClicked + " CHECK: " + check);
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        };
        
        view.cabinpanel.firsBtntOptListener(actionListener);
        view.cabinpanel.secondBtnOptListener(actionListener);
        view.cabinpanel.thirdBtnOptListener(actionListener);
        view.cabinpanel.txtStoryListener(mouseListener);
    }
    
    //This is where the functions in winpanel are implemented.
    public void winStuff() {
        
        view.winpanel.setImage("Images\\youwinimg.jpg");
        //This is what happends when you click anything on winpanel
        //Its supposed direct back to the menupanel
        mouseListener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                view.remove(view.winpanel);
                view.add(view.menupanel);
                view.validate();
                view.repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        
        view.winpanel.addWinListener(mouseListener);
    }
    
}
