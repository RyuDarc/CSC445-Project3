/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vincent.battleshipgame;

import java.awt.Color;
import java.awt.Container;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.BadAttributeValueExpException;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Square;


/**
 *
 * @author johnojacob84
 */
public class SWINGactualBoard extends javax.swing.JFrame {

    ArrayList<String> Current = new ArrayList<>();

    ArrayList<String> LocationGreenLocal = new ArrayList<>();

    ArrayList<String> LocationBlueLocal = new ArrayList<>();

    ArrayList<String> LocationYellowLocal = new ArrayList<>();

    ArrayList<String> LocationPinkLocal = new ArrayList<>();

    ArrayList<String> LocationOrangeLocal = new ArrayList<>();

    ArrayList<javax.swing.JButton> allButtons = new ArrayList<>();

    UserInterface localuser;

    MainFrame mainframe;

    boolean IsTurn = false;

    /**
     * Creates new form SWINGactualBoard
     */
    public SWINGactualBoard() {
        initComponents();
    }

    public SWINGactualBoard(MainFrame mainframe) {
        initComponents();
        this.mainframe = mainframe;
        localuser = new UserInterface("", "", mainframe);
        new Thread(()->{
            for(;;)
            {
                try{
                    // Container contentPane = this.getContentPane();
                    Thread.sleep(100);
                    // if(!this.mainframe.board.isSelfTurn()){
                    //     this.setGlassPane(new JPanel());
                    // }
                    if(this.mainframe.board.isGameOver()){
                        String winner = this.mainframe.getWinner();
                        
                    }
                    if(this.mainframe.board.isSelfTurn()){
                        if(this.mainframe.isHost){
                            jLabel6.setText("Host: This is your turn.");
                        }else{
                            jLabel6.setText("Client: This is your turn.");
                        }
                        
                    }else{
                        if (this.mainframe.isHost) {
                            jLabel6.setText("Host: Not your TURN");
                        } else {
                            jLabel6.setText("Client: Not your TURN");
                        }
                    }
                    for (JButton but : allButtons) {
                        //render the fire button first-> misshit -> hit
                        //where do you fire? -> fire is rendered at the selfboard
                        String name = but.getName().toUpperCase();
                        Square s = this.mainframe.board.self.boardMatrix.selfBoardMap.get(name);
                        Square ss = this.mainframe.board.self.boardMatrix.shootBoardMap.get(name);
                        if(ss.hit){
                            java.awt.EventQueue.invokeLater(new Runnable() {
                                public void run() {
                                    //red means you successfully hit someone
                                    but.setBackground(Color.red);
                                }
                            });
                        }
                        else if(s.hit){
                            java.awt.EventQueue.invokeLater(new Runnable() {
                                public void run() {
                                    
                                    but.setBackground(Color.black);
                                }
                            });
                        }else if(ss.missHit){
                            java.awt.EventQueue.invokeLater(new Runnable() {
                                public void run() {
                                    // gray means you don't hit someone
                                    but.setBackground(Color.gray);
                                }
                            });
                        }else if(s.missHit){
                            java.awt.EventQueue.invokeLater(new Runnable() {
                                public void run() {
                                    // gray means you don't hit someone
                                    but.setBackground(Color.cyan);
                                }
                            });
                        }
                        
                    }
            
                    
                    
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        },"TurnChecker").start();

        this.mainframe.setSWINGactualBoard(this);
        if(this.mainframe.isHost){
            startButton.setVisible(true);
        }else{
            startButton.setVisible(false);
            this.mainframe.lockInBoardButtonActionPerformed(new java.awt.event.ActionEvent("",0,""));
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        m5 = new javax.swing.JButton();
        c5 = new javax.swing.JButton();
        j5 = new javax.swing.JButton();
        a5 = new javax.swing.JButton();
        g5 = new javax.swing.JButton();
        i5 = new javax.swing.JButton();
        b5 = new javax.swing.JButton();
        d5 = new javax.swing.JButton();
        h5 = new javax.swing.JButton();
        l5 = new javax.swing.JButton();
        e5 = new javax.swing.JButton();
        k5 = new javax.swing.JButton();
        g6 = new javax.swing.JButton();
        a20 = new javax.swing.JButton();
        i20 = new javax.swing.JButton();
        j20 = new javax.swing.JButton();
        g20 = new javax.swing.JButton();
        e20 = new javax.swing.JButton();
        d20 = new javax.swing.JButton();
        f20 = new javax.swing.JButton();
        h20 = new javax.swing.JButton();
        i6 = new javax.swing.JButton();
        l19 = new javax.swing.JButton();
        f6 = new javax.swing.JButton();
        b6 = new javax.swing.JButton();
        e6 = new javax.swing.JButton();
        k6 = new javax.swing.JButton();
        m6 = new javax.swing.JButton();
        a6 = new javax.swing.JButton();
        h6 = new javax.swing.JButton();
        b20 = new javax.swing.JButton();
        d6 = new javax.swing.JButton();
        l20 = new javax.swing.JButton();
        c6 = new javax.swing.JButton();
        m12 = new javax.swing.JButton();
        c20 = new javax.swing.JButton();
        l6 = new javax.swing.JButton();
        k20 = new javax.swing.JButton();
        j6 = new javax.swing.JButton();
        m20 = new javax.swing.JButton();
        j7 = new javax.swing.JButton();
        g7 = new javax.swing.JButton();
        l7 = new javax.swing.JButton();
        a7 = new javax.swing.JButton();
        k7 = new javax.swing.JButton();
        i7 = new javax.swing.JButton();
        d7 = new javax.swing.JButton();
        b7 = new javax.swing.JButton();
        l13 = new javax.swing.JButton();
        m13 = new javax.swing.JButton();
        j12 = new javax.swing.JButton();
        e12 = new javax.swing.JButton();
        i12 = new javax.swing.JButton();
        l12 = new javax.swing.JButton();
        g12 = new javax.swing.JButton();
        h7 = new javax.swing.JButton();
        d12 = new javax.swing.JButton();
        c7 = new javax.swing.JButton();
        k12 = new javax.swing.JButton();
        f7 = new javax.swing.JButton();
        a12 = new javax.swing.JButton();
        m7 = new javax.swing.JButton();
        e7 = new javax.swing.JButton();
        k8 = new javax.swing.JButton();
        l8 = new javax.swing.JButton();
        d8 = new javax.swing.JButton();
        j8 = new javax.swing.JButton();
        g8 = new javax.swing.JButton();
        c12 = new javax.swing.JButton();
        e13 = new javax.swing.JButton();
        f13 = new javax.swing.JButton();
        b13 = new javax.swing.JButton();
        k13 = new javax.swing.JButton();
        d13 = new javax.swing.JButton();
        a13 = new javax.swing.JButton();
        h13 = new javax.swing.JButton();
        i8 = new javax.swing.JButton();
        c13 = new javax.swing.JButton();
        b8 = new javax.swing.JButton();
        g13 = new javax.swing.JButton();
        c8 = new javax.swing.JButton();
        j13 = new javax.swing.JButton();
        e8 = new javax.swing.JButton();
        i13 = new javax.swing.JButton();
        h8 = new javax.swing.JButton();
        f8 = new javax.swing.JButton();
        a8 = new javax.swing.JButton();
        m8 = new javax.swing.JButton();
        l9 = new javax.swing.JButton();
        d9 = new javax.swing.JButton();
        m14 = new javax.swing.JButton();
        f14 = new javax.swing.JButton();
        e14 = new javax.swing.JButton();
        k14 = new javax.swing.JButton();
        g14 = new javax.swing.JButton();
        j14 = new javax.swing.JButton();
        m9 = new javax.swing.JButton();
        d14 = new javax.swing.JButton();
        c9 = new javax.swing.JButton();
        c14 = new javax.swing.JButton();
        b9 = new javax.swing.JButton();
        b14 = new javax.swing.JButton();
        f9 = new javax.swing.JButton();
        l14 = new javax.swing.JButton();
        i9 = new javax.swing.JButton();
        a14 = new javax.swing.JButton();
        a9 = new javax.swing.JButton();
        j9 = new javax.swing.JButton();
        g9 = new javax.swing.JButton();
        e9 = new javax.swing.JButton();
        h9 = new javax.swing.JButton();
        c15 = new javax.swing.JButton();
        h15 = new javax.swing.JButton();
        l15 = new javax.swing.JButton();
        g15 = new javax.swing.JButton();
        e15 = new javax.swing.JButton();
        k9 = new javax.swing.JButton();
        d15 = new javax.swing.JButton();
        k10 = new javax.swing.JButton();
        i15 = new javax.swing.JButton();
        l10 = new javax.swing.JButton();
        j15 = new javax.swing.JButton();
        c1 = new javax.swing.JButton();
        g10 = new javax.swing.JButton();
        b15 = new javax.swing.JButton();
        d1 = new javax.swing.JButton();
        b10 = new javax.swing.JButton();
        h14 = new javax.swing.JButton();
        e1 = new javax.swing.JButton();
        d10 = new javax.swing.JButton();
        i14 = new javax.swing.JButton();
        f1 = new javax.swing.JButton();
        a10 = new javax.swing.JButton();
        g1 = new javax.swing.JButton();
        m10 = new javax.swing.JButton();
        h1 = new javax.swing.JButton();
        i10 = new javax.swing.JButton();
        i1 = new javax.swing.JButton();
        c10 = new javax.swing.JButton();
        j1 = new javax.swing.JButton();
        i16 = new javax.swing.JButton();
        d16 = new javax.swing.JButton();
        e16 = new javax.swing.JButton();
        g16 = new javax.swing.JButton();
        l16 = new javax.swing.JButton();
        h16 = new javax.swing.JButton();
        j10 = new javax.swing.JButton();
        k1 = new javax.swing.JButton();
        f10 = new javax.swing.JButton();
        l1 = new javax.swing.JButton();
        e10 = new javax.swing.JButton();
        c16 = new javax.swing.JButton();
        m1 = new javax.swing.JButton();
        h10 = new javax.swing.JButton();
        m15 = new javax.swing.JButton();
        b1 = new javax.swing.JButton();
        l11 = new javax.swing.JButton();
        f15 = new javax.swing.JButton();
        f11 = new javax.swing.JButton();
        a15 = new javax.swing.JButton();
        b11 = new javax.swing.JButton();
        k15 = new javax.swing.JButton();
        c2 = new javax.swing.JButton();
        j11 = new javax.swing.JButton();
        d2 = new javax.swing.JButton();
        d11 = new javax.swing.JButton();
        e2 = new javax.swing.JButton();
        k11 = new javax.swing.JButton();
        f2 = new javax.swing.JButton();
        h17 = new javax.swing.JButton();
        g17 = new javax.swing.JButton();
        l17 = new javax.swing.JButton();
        a17 = new javax.swing.JButton();
        c17 = new javax.swing.JButton();
        k16 = new javax.swing.JButton();
        i11 = new javax.swing.JButton();
        a16 = new javax.swing.JButton();
        g2 = new javax.swing.JButton();
        e11 = new javax.swing.JButton();
        h2 = new javax.swing.JButton();
        m11 = new javax.swing.JButton();
        i2 = new javax.swing.JButton();
        g11 = new javax.swing.JButton();
        j2 = new javax.swing.JButton();
        h11 = new javax.swing.JButton();
        f16 = new javax.swing.JButton();
        k2 = new javax.swing.JButton();
        c11 = new javax.swing.JButton();
        m16 = new javax.swing.JButton();
        l2 = new javax.swing.JButton();
        a11 = new javax.swing.JButton();
        b16 = new javax.swing.JButton();
        m2 = new javax.swing.JButton();
        f12 = new javax.swing.JButton();
        j16 = new javax.swing.JButton();
        b2 = new javax.swing.JButton();
        b12 = new javax.swing.JButton();
        a2 = new javax.swing.JButton();
        h12 = new javax.swing.JButton();
        f18 = new javax.swing.JButton();
        b18 = new javax.swing.JButton();
        a18 = new javax.swing.JButton();
        m17 = new javax.swing.JButton();
        d17 = new javax.swing.JButton();
        f17 = new javax.swing.JButton();
        i17 = new javax.swing.JButton();
        b17 = new javax.swing.JButton();
        c3 = new javax.swing.JButton();
        d3 = new javax.swing.JButton();
        e3 = new javax.swing.JButton();
        f3 = new javax.swing.JButton();
        g3 = new javax.swing.JButton();
        h3 = new javax.swing.JButton();
        j17 = new javax.swing.JButton();
        i3 = new javax.swing.JButton();
        k17 = new javax.swing.JButton();
        j3 = new javax.swing.JButton();
        e17 = new javax.swing.JButton();
        k3 = new javax.swing.JButton();
        l3 = new javax.swing.JButton();
        k18 = new javax.swing.JButton();
        h19 = new javax.swing.JButton();
        j18 = new javax.swing.JButton();
        e18 = new javax.swing.JButton();
        i18 = new javax.swing.JButton();
        d18 = new javax.swing.JButton();
        g18 = new javax.swing.JButton();
        m18 = new javax.swing.JButton();
        m3 = new javax.swing.JButton();
        c18 = new javax.swing.JButton();
        b3 = new javax.swing.JButton();
        a3 = new javax.swing.JButton();
        f4 = new javax.swing.JButton();
        i4 = new javax.swing.JButton();
        d4 = new javax.swing.JButton();
        h4 = new javax.swing.JButton();
        l4 = new javax.swing.JButton();
        l18 = new javax.swing.JButton();
        m4 = new javax.swing.JButton();
        h18 = new javax.swing.JButton();
        e4 = new javax.swing.JButton();
        g19 = new javax.swing.JButton();
        m19 = new javax.swing.JButton();
        c19 = new javax.swing.JButton();
        a19 = new javax.swing.JButton();
        i19 = new javax.swing.JButton();
        b19 = new javax.swing.JButton();
        f19 = new javax.swing.JButton();
        e19 = new javax.swing.JButton();
        j19 = new javax.swing.JButton();
        d19 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        k19 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        a1 = new javax.swing.JButton();
        b4 = new javax.swing.JButton();
        k4 = new javax.swing.JButton();
        c4 = new javax.swing.JButton();
        g4 = new javax.swing.JButton();
        j4 = new javax.swing.JButton();
        a4 = new javax.swing.JButton();
        f5 = new javax.swing.JButton();
        startButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        m5.setName("m5");
        allButtons.add(m5);
        m5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m5ActionPerformed(evt);
            }
        });

        c5.setName("c5");
        allButtons.add(c5);
        c5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c5ActionPerformed(evt);
            }
        });

        j5.setName("j5");
        allButtons.add(j5);
        j5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j5ActionPerformed(evt);
            }
        });

        a5.setName("a5");
        allButtons.add(a5);
        a5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a5ActionPerformed(evt);
            }
        });

        g5.setName("g5");
        allButtons.add(g5);
        g5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g5ActionPerformed(evt);
            }
        });

        i5.setName("i5");
        allButtons.add(i5);
        i5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i5ActionPerformed(evt);
            }
        });

        b5.setName("b5");
        allButtons.add(b5);
        b5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b5ActionPerformed(evt);
            }
        });

        d5.setName("d5");
        allButtons.add(d5);
        d5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d5ActionPerformed(evt);
            }
        });

        h5.setName("h5");
        allButtons.add(h5);
        h5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                h5ActionPerformed(evt);
            }
        });

        l5.setName("l5");
        allButtons.add(l5);
        l5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l5ActionPerformed(evt);
            }
        });

        e5.setName("e5");
        allButtons.add(e5);
        e5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e5ActionPerformed(evt);
            }
        });

        k5.setName("k5");
        allButtons.add(k5);
        k5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                k5ActionPerformed(evt);
            }
        });

        g6.setName("g6");
        allButtons.add(g6);
        g6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g6ActionPerformed(evt);
            }
        });

        a20.setName("a20");
        allButtons.add(a20);
        a20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a20ActionPerformed(evt);
            }
        });

        i20.setName("i20");
        allButtons.add(i20);
        i20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i20ActionPerformed(evt);
            }
        });

        j20.setName("j20");
        allButtons.add(j20);
        j20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j20ActionPerformed(evt);
            }
        });

        g20.setName("g20");
        allButtons.add(g20);
        g20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g20ActionPerformed(evt);
            }
        });

        e20.setName("e20");
        allButtons.add(e20);
        e20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e20ActionPerformed(evt);
            }
        });

        d20.setName("d20");
        allButtons.add(d20);
        d20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d20ActionPerformed(evt);
            }
        });

        f20.setName("f20");
        allButtons.add(f20);
        f20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f20ActionPerformed(evt);
            }
        });

        h20.setName("h20");
        allButtons.add(h20);
        h20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                h20ActionPerformed(evt);
            }
        });

        i6.setName("i6");
        allButtons.add(i6);
        i6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i6ActionPerformed(evt);
            }
        });

        l19.setName("l19");
        allButtons.add(l19);
        l19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l19ActionPerformed(evt);
            }
        });

        f6.setName("f6");
        allButtons.add(f6);
        f6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f6ActionPerformed(evt);
            }
        });

        b6.setName("b6");
        allButtons.add(b6);
        b6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b6ActionPerformed(evt);
            }
        });

        e6.setName("e6");
        allButtons.add(e6);
        e6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e6ActionPerformed(evt);
            }
        });

        k6.setName("k6");
        allButtons.add(k6);
        k6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                k6ActionPerformed(evt);
            }
        });

        m6.setName("m6");
        allButtons.add(m6);
        m6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m6ActionPerformed(evt);
            }
        });

        a6.setName("a6");
        allButtons.add(a6);
        a6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a6ActionPerformed(evt);
            }
        });

        h6.setName("h6");
        allButtons.add(h6);
        h6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                h6ActionPerformed(evt);
            }
        });

        b20.setName("b20");
        allButtons.add(b20);
        b20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b20ActionPerformed(evt);
            }
        });

        d6.setName("d6");
        allButtons.add(d6);
        d6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d6ActionPerformed(evt);
            }
        });

        l20.setName("l20");
        allButtons.add(l20);
        l20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l20ActionPerformed(evt);
            }
        });

        c6.setName("c6");
        allButtons.add(c6);
        c6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c6ActionPerformed(evt);
            }
        });

        m12.setName("m12");
        allButtons.add(m12);
        m12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m12ActionPerformed(evt);
            }
        });

        c20.setName("c20");
        allButtons.add(c20);
        c20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c20ActionPerformed(evt);
            }
        });

        l6.setName("l6");
        allButtons.add(l6);
        l6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l6ActionPerformed(evt);
            }
        });

        k20.setName("k20");
        allButtons.add(k20);
        k20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                k20ActionPerformed(evt);
            }
        });

        j6.setName("j6");
        allButtons.add(j6);
        j6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j6ActionPerformed(evt);
            }
        });

        m20.setName("m20");
        allButtons.add(m20);
        m20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m20ActionPerformed(evt);
            }
        });

        j7.setName("j7");
        allButtons.add(j7);
        j7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j7ActionPerformed(evt);
            }
        });

        g7.setName("g7");
        allButtons.add(g7);
        g7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g7ActionPerformed(evt);
            }
        });

        l7.setName("l7");
        allButtons.add(l7);
        l7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l7ActionPerformed(evt);
            }
        });

        a7.setName("a7");
        allButtons.add(a7);
        a7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a7ActionPerformed(evt);
            }
        });

        k7.setName("k7");
        allButtons.add(k7);
        k7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                k7ActionPerformed(evt);
            }
        });

        i7.setName("i7");
        allButtons.add(i7);
        i7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i7ActionPerformed(evt);
            }
        });

        d7.setName("d7");
        allButtons.add(d7);
        d7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d7ActionPerformed(evt);
            }
        });

        b7.setName("b7");
        allButtons.add(b7);
        b7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b7ActionPerformed(evt);
            }
        });

        l13.setName("l13");
        allButtons.add(l13);
        l13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l13ActionPerformed(evt);
            }
        });

        m13.setName("m13");
        allButtons.add(m13);
        m13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m13ActionPerformed(evt);
            }
        });

        j12.setName("j12");
        allButtons.add(j12);
        j12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j12ActionPerformed(evt);
            }
        });

        e12.setName("e12");
        allButtons.add(e12);
        e12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e12ActionPerformed(evt);
            }
        });

        i12.setName("i12");
        allButtons.add(i12);
        i12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i12ActionPerformed(evt);
            }
        });

        l12.setName("l12");
        allButtons.add(l12);
        l12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l12ActionPerformed(evt);
            }
        });

        g12.setName("g12");
        allButtons.add(g12);
        g12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g12ActionPerformed(evt);
            }
        });

        h7.setName("h7");
        allButtons.add(h7);
        h7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                h7ActionPerformed(evt);
            }
        });

        d12.setName("d12");
        allButtons.add(d12);
        d12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d12ActionPerformed(evt);
            }
        });

        c7.setName("c7");
        allButtons.add(c7);
        c7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c7ActionPerformed(evt);
            }
        });

        k12.setName("k12");
        allButtons.add(k12);
        k12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                k12ActionPerformed(evt);
            }
        });

        f7.setName("f7");
        allButtons.add(f7);
        f7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f7ActionPerformed(evt);
            }
        });

        a12.setName("a12");
        allButtons.add(a12);
        a12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a12ActionPerformed(evt);
            }
        });

        m7.setName("m7");
        allButtons.add(m7);
        m7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m7ActionPerformed(evt);
            }
        });

        e7.setName("e7");
        allButtons.add(e7);
        e7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e7ActionPerformed(evt);
            }
        });

        k8.setName("k8");
        allButtons.add(k8);
        k8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                k8ActionPerformed(evt);
            }
        });

        l8.setName("l8");
        allButtons.add(l8);
        l8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l8ActionPerformed(evt);
            }
        });

        d8.setName("d8");
        allButtons.add(d8);
        d8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d8ActionPerformed(evt);
            }
        });

        j8.setName("j8");
        allButtons.add(j8);
        j8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j8ActionPerformed(evt);
            }
        });

        g8.setName("g8");
        allButtons.add(g8);
        g8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g8ActionPerformed(evt);
            }
        });

        c12.setName("c12");
        allButtons.add(c12);
        c12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c12ActionPerformed(evt);
            }
        });

        e13.setName("e13");
        allButtons.add(e13);
        e13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e13ActionPerformed(evt);
            }
        });

        f13.setName("f13");
        allButtons.add(f13);
        f13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f13ActionPerformed(evt);
            }
        });

        b13.setName("b13");
        allButtons.add(b13);
        b13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b13ActionPerformed(evt);
            }
        });

        k13.setName("k13");
        allButtons.add(k13);
        k13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                k13ActionPerformed(evt);
            }
        });

        d13.setName("d13");
        allButtons.add(d13);
        d13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d13ActionPerformed(evt);
            }
        });

        a13.setName("a13");
        allButtons.add(a13);
        a13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a13ActionPerformed(evt);
            }
        });

        h13.setName("h13");
        allButtons.add(h13);
        h13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                h13ActionPerformed(evt);
            }
        });

        i8.setName("i8");
        allButtons.add(i8);
        i8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i8ActionPerformed(evt);
            }
        });

        c13.setName("c13");
        allButtons.add(c13);
        c13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c13ActionPerformed(evt);
            }
        });

        b8.setName("b8");
        allButtons.add(b8);
        b8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b8ActionPerformed(evt);
            }
        });

        g13.setName("g13");
        allButtons.add(g13);
        g13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g13ActionPerformed(evt);
            }
        });

        c8.setName("c8");
        allButtons.add(c8);
        c8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c8ActionPerformed(evt);
            }
        });

        j13.setName("j13");
        allButtons.add(j13);
        j13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j13ActionPerformed(evt);
            }
        });

        e8.setName("e8");
        allButtons.add(e8);
        e8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e8ActionPerformed(evt);
            }
        });

        i13.setName("i13");
        allButtons.add(i13);
        i13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i13ActionPerformed(evt);
            }
        });

        h8.setName("h8");
        allButtons.add(h8);
        h8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                h8ActionPerformed(evt);
            }
        });

        f8.setName("f8");
        allButtons.add(f8);
        f8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f8ActionPerformed(evt);
            }
        });

        a8.setName("a8");
        allButtons.add(a8);
        a8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a8ActionPerformed(evt);
            }
        });

        m8.setName("m8");
        allButtons.add(m8);
        m8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m8ActionPerformed(evt);
            }
        });

        l9.setName("l9");
        allButtons.add(l9);
        l9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l9ActionPerformed(evt);
            }
        });

        d9.setName("d9");
        allButtons.add(d9);
        d9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d9ActionPerformed(evt);
            }
        });

        m14.setName("m14");
        allButtons.add(m14);
        m14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m14ActionPerformed(evt);
            }
        });

        f14.setName("f14");
        allButtons.add(f14);
        f14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f14ActionPerformed(evt);
            }
        });

        e14.setName("e14");
        allButtons.add(e14);
        e14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e14ActionPerformed(evt);
            }
        });

        k14.setName("k14");
        allButtons.add(k14);
        k14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                k14ActionPerformed(evt);
            }
        });

        g14.setName("g14");
        allButtons.add(g14);
        g14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g14ActionPerformed(evt);
            }
        });

        j14.setName("j14");
        allButtons.add(j14);
        j14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j14ActionPerformed(evt);
            }
        });

        m9.setName("m9");
        allButtons.add(m9);
        m9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m9ActionPerformed(evt);
            }
        });

        d14.setName("d14");
        allButtons.add(d14);
        d14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d14ActionPerformed(evt);
            }
        });

        c9.setName("c9");
        allButtons.add(c9);
        c9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c9ActionPerformed(evt);
            }
        });

        c14.setName("c14");
        allButtons.add(c14);
        c14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c14ActionPerformed(evt);
            }
        });

        b9.setName("b9");
        allButtons.add(b9);
        b9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b9ActionPerformed(evt);
            }
        });

        b14.setName("b14");
        allButtons.add(b14);
        b14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b14ActionPerformed(evt);
            }
        });

        f9.setName("f9");
        allButtons.add(f9);
        f9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f9ActionPerformed(evt);
            }
        });

        l14.setName("l14");
        allButtons.add(l14);
        l14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l14ActionPerformed(evt);
            }
        });

        i9.setName("i9");
        allButtons.add(i9);
        i9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i9ActionPerformed(evt);
            }
        });

        a14.setName("a14");
        allButtons.add(a14);
        a14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a14ActionPerformed(evt);
            }
        });

        a9.setName("a9");
        allButtons.add(a9);
        a9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a9ActionPerformed(evt);
            }
        });

        j9.setName("j9");
        allButtons.add(j9);
        j9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j9ActionPerformed(evt);
            }
        });

        g9.setName("g9");
        allButtons.add(g9);
        g9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g9ActionPerformed(evt);
            }
        });

        e9.setName("e9");
        allButtons.add(e9);
        e9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e9ActionPerformed(evt);
            }
        });

        h9.setName("h9");
        allButtons.add(h9);
        h9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                h9ActionPerformed(evt);
            }
        });

        c15.setName("c15");
        allButtons.add(c15);
        c15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c15ActionPerformed(evt);
            }
        });

        h15.setName("h15");
        allButtons.add(h15);
        h15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                h15ActionPerformed(evt);
            }
        });

        l15.setName("l15");
        allButtons.add(l15);
        l15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l15ActionPerformed(evt);
            }
        });

        g15.setName("g15");
        allButtons.add(g15);
        g15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g15ActionPerformed(evt);
            }
        });

        e15.setName("e15");
        allButtons.add(e15);
        e15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e15ActionPerformed(evt);
            }
        });

        k9.setName("k9");
        allButtons.add(k9);
        k9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                k9ActionPerformed(evt);
            }
        });

        d15.setName("d15");
        allButtons.add(d15);
        d15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d15ActionPerformed(evt);
            }
        });

        k10.setName("k10");
        allButtons.add(k10);
        k10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                k10ActionPerformed(evt);
            }
        });

        i15.setName("i15");
        allButtons.add(i15);
        i15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i15ActionPerformed(evt);
            }
        });

        l10.setName("l10");
        allButtons.add(l10);
        l10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l10ActionPerformed(evt);
            }
        });

        j15.setName("j15");
        allButtons.add(j15);
        j15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j15ActionPerformed(evt);
            }
        });

        c1.setName("c1");
        allButtons.add(c1);
        c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c1ActionPerformed(evt);
            }
        });

        g10.setName("g10");
        allButtons.add(g10);
        g10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g10ActionPerformed(evt);
            }
        });

        b15.setName("b15");
        allButtons.add(b15);
        b15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b15ActionPerformed(evt);
            }
        });

        d1.setName("d1");
        allButtons.add(d1);
        d1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d1ActionPerformed(evt);
            }
        });

        b10.setName("b10");
        allButtons.add(b10);
        b10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b10ActionPerformed(evt);
            }
        });

        h14.setName("h14");
        allButtons.add(h14);
        h14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                h14ActionPerformed(evt);
            }
        });

        e1.setName("e1");
        allButtons.add(e1);
        e1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e1ActionPerformed(evt);
            }
        });

        d10.setName("d10");
        allButtons.add(d10);
        d10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d10ActionPerformed(evt);
            }
        });

        i14.setName("i14");
        allButtons.add(i14);
        i14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i14ActionPerformed(evt);
            }
        });

        f1.setName("f1");
        allButtons.add(f1);
        f1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f1ActionPerformed(evt);
            }
        });

        a10.setName("a10");
        allButtons.add(a10);
        a10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a10ActionPerformed(evt);
            }
        });

        g1.setName("g1");
        allButtons.add(g1);
        g1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g1ActionPerformed(evt);
            }
        });

        m10.setName("m10");
        allButtons.add(m10);
        m10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m10ActionPerformed(evt);
            }
        });

        h1.setName("h1");
        allButtons.add(h1);
        h1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                h1ActionPerformed(evt);
            }
        });

        i10.setName("i10");
        allButtons.add(i10);
        i10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i10ActionPerformed(evt);
            }
        });

        i1.setName("i1");
        allButtons.add(i1);
        i1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i1ActionPerformed(evt);
            }
        });

        c10.setName("c10");
        allButtons.add(c10);
        c10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c10ActionPerformed(evt);
            }
        });

        j1.setName("j1");
        allButtons.add(j1);
        j1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j1ActionPerformed(evt);
            }
        });

        i16.setName("i16");
        allButtons.add(i16);
        i16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i16ActionPerformed(evt);
            }
        });

        d16.setName("d16");
        allButtons.add(d16);
        d16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d16ActionPerformed(evt);
            }
        });

        e16.setName("e16");
        allButtons.add(e16);
        e16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e16ActionPerformed(evt);
            }
        });

        g16.setName("g16");
        allButtons.add(g16);
        g16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g16ActionPerformed(evt);
            }
        });

        l16.setName("l16");
        allButtons.add(l16);
        l16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l16ActionPerformed(evt);
            }
        });

        h16.setName("h16");
        allButtons.add(h16);
        h16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                h16ActionPerformed(evt);
            }
        });

        j10.setName("j10");
        allButtons.add(j10);
        j10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j10ActionPerformed(evt);
            }
        });

        k1.setName("k1");
        allButtons.add(k1);
        k1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                k1ActionPerformed(evt);
            }
        });

        f10.setName("f10");
        allButtons.add(f10);
        f10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f10ActionPerformed(evt);
            }
        });

        l1.setName("l1");
        allButtons.add(l1);
        l1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l1ActionPerformed(evt);
            }
        });

        e10.setName("e10");
        allButtons.add(e10);
        e10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e10ActionPerformed(evt);
            }
        });

        c16.setName("c16");
        allButtons.add(c16);
        c16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c16ActionPerformed(evt);
            }
        });

        m1.setName("m1");
        allButtons.add(m1);
        m1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m1ActionPerformed(evt);
            }
        });

        h10.setName("h10");
        allButtons.add(h10);
        h10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                h10ActionPerformed(evt);
            }
        });

        m15.setName("m15");
        allButtons.add(m15);
        m15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m15ActionPerformed(evt);
            }
        });

        b1.setName("b1");
        allButtons.add(b1);
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });

        l11.setName("l11");
        allButtons.add(l11);
        l11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l11ActionPerformed(evt);
            }
        });

        f15.setName("f15");
        allButtons.add(f15);
        f15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f15ActionPerformed(evt);
            }
        });

        f11.setName("f11");
        allButtons.add(f11);
        f11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f11ActionPerformed(evt);
            }
        });

        a15.setName("a15");
        allButtons.add(a15);
        a15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a15ActionPerformed(evt);
            }
        });

        b11.setName("b11");
        allButtons.add(b11);
        b11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b11ActionPerformed(evt);
            }
        });

        k15.setName("k15");
        allButtons.add(k15);
        k15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                k15ActionPerformed(evt);
            }
        });

        c2.setName("c2");
        allButtons.add(c2);
        c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c2ActionPerformed(evt);
            }
        });

        j11.setName("j11");
        allButtons.add(j11);
        j11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j11ActionPerformed(evt);
            }
        });

        d2.setName("d2");
        allButtons.add(d2);
        d2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d2ActionPerformed(evt);
            }
        });

        d11.setName("d11");
        allButtons.add(d11);
        d11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d11ActionPerformed(evt);
            }
        });

        e2.setName("e2");
        allButtons.add(e2);
        e2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e2ActionPerformed(evt);
            }
        });

        k11.setName("k11");
        allButtons.add(k11);
        k11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                k11ActionPerformed(evt);
            }
        });

        f2.setName("f2");
        allButtons.add(f2);
        f2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f2ActionPerformed(evt);
            }
        });

        h17.setName("h17");
        allButtons.add(h17);
        h17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                h17ActionPerformed(evt);
            }
        });

        g17.setName("g17");
        allButtons.add(g17);
        g17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g17ActionPerformed(evt);
            }
        });

        l17.setName("l17");
        allButtons.add(l17);
        l17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l17ActionPerformed(evt);
            }
        });

        a17.setName("a17");
        allButtons.add(a17);
        a17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a17ActionPerformed(evt);
            }
        });

        c17.setName("c17");
        allButtons.add(c17);
        c17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c17ActionPerformed(evt);
            }
        });

        k16.setName("k16");
        allButtons.add(k16);
        k16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                k16ActionPerformed(evt);
            }
        });

        i11.setName("i11");
        allButtons.add(i11);
        i11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i11ActionPerformed(evt);
            }
        });

        a16.setName("a16");
        allButtons.add(a16);
        a16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a16ActionPerformed(evt);
            }
        });

        g2.setName("g2");
        allButtons.add(g2);
        g2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g2ActionPerformed(evt);
            }
        });

        e11.setName("e11");
        allButtons.add(e11);
        e11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e11ActionPerformed(evt);
            }
        });

        h2.setName("h2");
        allButtons.add(h2);
        h2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                h2ActionPerformed(evt);
            }
        });

        m11.setName("m11");
        allButtons.add(m11);
        m11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m11ActionPerformed(evt);
            }
        });

        i2.setName("i2");
        allButtons.add(i2);
        i2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i2ActionPerformed(evt);
            }
        });

        g11.setName("g11");
        allButtons.add(g11);
        g11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g11ActionPerformed(evt);
            }
        });

        j2.setName("j2");
        allButtons.add(j2);
        j2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j2ActionPerformed(evt);
            }
        });

        h11.setName("h11");
        allButtons.add(h11);
        h11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                h11ActionPerformed(evt);
            }
        });

        f16.setName("f16");
        allButtons.add(f16);
        f16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f16ActionPerformed(evt);
            }
        });

        k2.setName("k2");
        allButtons.add(k2);
        k2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                k2ActionPerformed(evt);
            }
        });

        c11.setName("c11");
        allButtons.add(c11);
        c11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c11ActionPerformed(evt);
            }
        });

        m16.setName("m16");
        allButtons.add(m16);
        m16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m16ActionPerformed(evt);
            }
        });

        l2.setName("l2");
        allButtons.add(l2);
        l2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l2ActionPerformed(evt);
            }
        });

        a11.setName("a11");
        allButtons.add(a11);
        a11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a11ActionPerformed(evt);
            }
        });

        b16.setName("b16");
        allButtons.add(b16);
        b16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b16ActionPerformed(evt);
            }
        });

        m2.setName("m2");
        allButtons.add(m2);
        m2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m2ActionPerformed(evt);
            }
        });

        f12.setName("f12");
        allButtons.add(f12);
        f12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f12ActionPerformed(evt);
            }
        });

        j16.setName("j16");
        allButtons.add(j16);
        j16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j16ActionPerformed(evt);
            }
        });

        b2.setName("b2");
        allButtons.add(b2);
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });

        b12.setName("b12");
        allButtons.add(b12);
        b12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b12ActionPerformed(evt);
            }
        });

        a2.setName("a2");
        allButtons.add(a2);
        a2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a2ActionPerformed(evt);
            }
        });

        h12.setName("h12");
        allButtons.add(h12);
        h12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                h12ActionPerformed(evt);
            }
        });

        f18.setName("f18");
        allButtons.add(f18);
        f18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f18ActionPerformed(evt);
            }
        });

        b18.setName("b18");
        allButtons.add(b18);
        b18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b18ActionPerformed(evt);
            }
        });

        a18.setName("a18");
        allButtons.add(a18);
        a18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a18ActionPerformed(evt);
            }
        });

        m17.setName("m17");
        allButtons.add(m17);
        m17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m17ActionPerformed(evt);
            }
        });

        d17.setName("d17");
        allButtons.add(d17);
        d17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d17ActionPerformed(evt);
            }
        });

        f17.setName("f17");
        allButtons.add(f17);
        f17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f17ActionPerformed(evt);
            }
        });

        i17.setName("i17");
        allButtons.add(i17);
        i17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i17ActionPerformed(evt);
            }
        });

        b17.setName("b17");
        allButtons.add(b17);
        b17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b17ActionPerformed(evt);
            }
        });

        c3.setName("c3");
        allButtons.add(c3);
        c3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c3ActionPerformed(evt);
            }
        });

        d3.setName("d3");
        allButtons.add(d3);
        d3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d3ActionPerformed(evt);
            }
        });

        e3.setName("e3");
        allButtons.add(e3);
        e3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e3ActionPerformed(evt);
            }
        });

        f3.setName("f3");
        allButtons.add(f3);
        f3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f3ActionPerformed(evt);
            }
        });

        g3.setName("g3");
        allButtons.add(g3);
        g3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g3ActionPerformed(evt);
            }
        });

        h3.setName("h3");
        allButtons.add(h3);
        h3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                h3ActionPerformed(evt);
            }
        });

        j17.setName("j17");
        allButtons.add(j17);
        j17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j17ActionPerformed(evt);
            }
        });

        i3.setName("i3");
        allButtons.add(i3);
        i3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i3ActionPerformed(evt);
            }
        });

        k17.setName("k17");
        allButtons.add(k17);
        k17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                k17ActionPerformed(evt);
            }
        });

        j3.setName("j3");
        allButtons.add(j3);
        j3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j3ActionPerformed(evt);
            }
        });

        e17.setName("e17");
        allButtons.add(e17);
        e17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e17ActionPerformed(evt);
            }
        });

        k3.setName("k3");
        allButtons.add(k3);
        k3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                k3ActionPerformed(evt);
            }
        });

        l3.setName("l3");
        allButtons.add(l3);
        l3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l3ActionPerformed(evt);
            }
        });

        k18.setName("k18");
        allButtons.add(k18);
        k18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                k18ActionPerformed(evt);
            }
        });

        h19.setName("h19");
        allButtons.add(h19);
        h19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                h19ActionPerformed(evt);
            }
        });

        j18.setName("j18");
        allButtons.add(j18);
        j18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j18ActionPerformed(evt);
            }
        });

        e18.setName("e18");
        allButtons.add(e18);
        e18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e18ActionPerformed(evt);
            }
        });

        i18.setName("i18");
        allButtons.add(i18);
        i18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i18ActionPerformed(evt);
            }
        });

        d18.setName("d18");
        allButtons.add(d18);
        d18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d18ActionPerformed(evt);
            }
        });

        g18.setName("g18");
        allButtons.add(g18);
        g18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g18ActionPerformed(evt);
            }
        });

        m18.setName("m18");
        allButtons.add(m18);
        m18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m18ActionPerformed(evt);
            }
        });

        m3.setName("m3");
        allButtons.add(m3);
        m3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m3ActionPerformed(evt);
            }
        });

        c18.setName("c18");
        allButtons.add(c18);
        c18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c18ActionPerformed(evt);
            }
        });

        b3.setName("b3");
        allButtons.add(b3);
        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });

        a3.setName("a3");
        allButtons.add(a3);
        a3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a3ActionPerformed(evt);
            }
        });

        f4.setName("f4");
        allButtons.add(f4);
        f4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f4ActionPerformed(evt);
            }
        });

        i4.setName("i4");
        allButtons.add(i4);
        i4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i4ActionPerformed(evt);
            }
        });

        d4.setName("d4");
        allButtons.add(d4);
        d4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d4ActionPerformed(evt);
            }
        });

        h4.setName("h4");
        allButtons.add(h4);
        h4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                h4ActionPerformed(evt);
            }
        });

        l4.setName("l4");
        allButtons.add(l4);
        l4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l4ActionPerformed(evt);
            }
        });

        l18.setName("l18");
        allButtons.add(l18);
        l18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l18ActionPerformed(evt);
            }
        });

        m4.setName("m4");
        allButtons.add(m4);
        m4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m4ActionPerformed(evt);
            }
        });

        h18.setName("h18");
        allButtons.add(h18);
        h18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                h18ActionPerformed(evt);
            }
        });

        e4.setName("e4");
        allButtons.add(e4);
        e4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e4ActionPerformed(evt);
            }
        });

        g19.setName("g19");
        allButtons.add(g19);
        g19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g19ActionPerformed(evt);
            }
        });

        m19.setName("m19");
        allButtons.add(m19);
        m19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m19ActionPerformed(evt);
            }
        });

        c19.setName("c19");
        allButtons.add(c19);
        c19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c19ActionPerformed(evt);
            }
        });

        a19.setName("a19");
        allButtons.add(a19);
        a19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a19ActionPerformed(evt);
            }
        });

        i19.setName("i19");
        allButtons.add(i19);
        i19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i19ActionPerformed(evt);
            }
        });

        b19.setName("b19");
        allButtons.add(b19);
        b19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b19ActionPerformed(evt);
            }
        });

        f19.setName("f19");
        allButtons.add(f19);
        f19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f19ActionPerformed(evt);
            }
        });

        e19.setName("e19");
        allButtons.add(e19);
        e19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e19ActionPerformed(evt);
            }
        });

        j19.setName("j19");
        allButtons.add(j19);
        j19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j19ActionPerformed(evt);
            }
        });

        d19.setName("d19");
        allButtons.add(d19);
        d19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d19ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 0, 20)); // NOI18N
        jLabel6.setText("When it's your turn, click a box to fire a torpedo");

        k19.setName("k19");
        allButtons.add(k19);
        k19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                k19ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Chilanka", 0, 48)); // NOI18N
        jLabel7.setText("BattleShip - Snake Version");

        a1.setName("a1");
        allButtons.add(a1);
        a1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a1ActionPerformed(evt);
            }
        });

        b4.setName("b4");
        allButtons.add(b4);
        b4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4ActionPerformed(evt);
            }
        });

        k4.setName("k4");
        allButtons.add(k4);
        k4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                k4ActionPerformed(evt);
            }
        });

        c4.setName("c4");
        allButtons.add(c4);
        c4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c4ActionPerformed(evt);
            }
        });

        g4.setName("g4");
        allButtons.add(g4);
        g4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g4ActionPerformed(evt);
            }
        });

        j4.setName("j4");
        allButtons.add(j4);
        j4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j4ActionPerformed(evt);
            }
        });

        a4.setName("a4");
        allButtons.add(a4);
        a4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a4ActionPerformed(evt);
            }
        });

        f5.setName("f5");
        allButtons.add(f5);
        f5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f5ActionPerformed(evt);
            }
        });

        startButton.setActionCommand("startButton");
        startButton.setLabel("startButton");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(startButton)
                        .addGap(108, 108, 108)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(a2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(d2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(e2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(f2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(g2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(h2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(i2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(j2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(k2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(l2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(m2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(a3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(d3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(e3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(f3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(g3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(h3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(i3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(j3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(k3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(l3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(m3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(a4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(d4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(e4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(f4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(g4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(h4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(i4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(j4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(k4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(l4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(m4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(a5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(d5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(e5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(f5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(g5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(h5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(i5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(j5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(k5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(l5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(m5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(a6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(d6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(e6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(f6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(g6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(h6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(i6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(j6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(k6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(l6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(m6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(a7, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b7, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c7, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(d7, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(e7, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(f7, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(g7, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(h7, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(i7, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(j7, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(k7, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(l7, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(m7, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(a8, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b8, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c8, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(d8, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(e8, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(f8, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(g8, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(h8, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(i8, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(j8, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(k8, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(l8, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(m8, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(a9, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b9, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c9, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(d9, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(e9, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(f9, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(g9, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(h9, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(i9, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(j9, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(k9, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(l9, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(m9, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(a11, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b11, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c11, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(d11, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(e11, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(f11, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(g11, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(h11, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(i11, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(j11, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(k11, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(l11, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(m11, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(a12, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b12, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c12, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(d12, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(e12, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(f12, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(g12, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(h12, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(i12, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(j12, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(k12, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(l12, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(m12, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(a13, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b13, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c13, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(d13, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(e13, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(f13, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(g13, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(h13, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(i13, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(j13, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(k13, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(l13, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(m13, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(a14, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b14, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c14, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(d14, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(e14, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(f14, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(g14, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(h14, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(i14, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(j14, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(k14, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(l14, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(m14, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(a15, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b15, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c15, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(d15, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(e15, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(f15, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(g15, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(h15, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(i15, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(j15, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(k15, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(l15, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(m15, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(a16, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b16, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c16, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(d16, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(e16, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(f16, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(g16, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(h16, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(i16, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(j16, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(k16, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(l16, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(m16, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(a17, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b17, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c17, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(d17, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(e17, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(f17, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(g17, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(h17, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(i17, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(j17, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(k17, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(l17, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(m17, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(a18, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b18, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c18, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(d18, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(e18, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(f18, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(g18, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(h18, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(i18, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(j18, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(k18, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(l18, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(m18, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(a19, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b19, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c19, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(d19, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(e19, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(f19, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(g19, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(h19, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(i19, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(j19, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(k19, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(l19, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(m19, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(a20, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b20, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c20, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(d20, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(e20, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(f20, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(g20, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(h20, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(i20, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(j20, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(k20, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(l20, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(m20, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(a1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(d1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(e1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(f1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(g1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(h1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(i1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(j1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(k1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(l1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(m1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(a10, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b10, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c10, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(d10, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(e10, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(f10, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(g10, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(h10, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(i10, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(j10, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(k10, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(l10, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(m10, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(jLabel7)))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(a1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(c1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(d1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(e1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(f1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(g1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(h1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(i1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(j1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(k1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(l1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(m1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(startButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(a2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(e2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(h2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(j2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(k2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(m2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(a3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(e3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(h3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(j3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(k3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(m3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(a4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(e4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(h4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(j4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(k4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(m4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(a5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(e5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(h5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(j5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(k5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(m5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(a6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(e6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(h6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(j6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(k6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(m6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(a7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(e7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(h7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(j7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(k7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(m7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(a8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(e8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(h8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(j8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(k8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(m8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(a9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(e9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(h9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(j9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(k9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(m9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(a10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(e10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(h10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(j10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(k10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(m10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(a11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(e11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(h11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(j11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(k11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(m11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(a12, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c12, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d12, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(e12, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f12, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g12, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(h12, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i12, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(j12, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(k12, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l12, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(m12, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b12, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(a13, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c13, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d13, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(e13, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f13, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g13, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(h13, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i13, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(j13, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(k13, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l13, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(m13, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b13, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(a14, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c14, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d14, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(e14, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f14, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g14, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(h14, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i14, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(j14, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(k14, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l14, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(m14, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b14, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(a15, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c15, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d15, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(e15, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f15, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g15, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(h15, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i15, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(j15, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(k15, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l15, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(m15, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b15, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(a16, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c16, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d16, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(e16, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f16, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g16, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(h16, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i16, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(j16, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(k16, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l16, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(m16, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b16, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(a17, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c17, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d17, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(e17, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f17, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g17, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(h17, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i17, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(j17, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(k17, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l17, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(m17, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b17, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(a18, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c18, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d18, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(e18, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f18, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g18, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(h18, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i18, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(j18, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(k18, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l18, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(m18, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b18, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(a19, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c19, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d19, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(e19, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f19, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g19, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(h19, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i19, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(j19, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(k19, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l19, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(m19, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b19, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(a20, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c20, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d20, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(e20, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f20, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g20, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(h20, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i20, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(j20, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(k20, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l20, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(m20, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b20, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        // TODO add your handling code here:
        this.mainframe.startGameButtonActionPerformed(evt);
    }//GEN-LAST:event_startButtonActionPerformed

    private void a1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_a1ActionPerformed

        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);

    }// GEN-LAST:event_a1ActionPerformed

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_b1ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);

    }// GEN-LAST:event_b1ActionPerformed

    private void c1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_c1ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_c1ActionPerformed

    private void d1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_d1ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_d1ActionPerformed

    private void e1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_e1ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_e1ActionPerformed

    private void f1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_f1ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_f1ActionPerformed

    private void g1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_g1ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_g1ActionPerformed

    private void h1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_h1ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_h1ActionPerformed

    private void i1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_i1ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_i1ActionPerformed

    private void j1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_j1ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_j1ActionPerformed

    private void k1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_k1ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_k1ActionPerformed

    private void l1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_l1ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_l1ActionPerformed

    private void m1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_m1ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_m1ActionPerformed

    private void a2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_a2ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_a2ActionPerformed

    private void a7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_a7ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_a7ActionPerformed

    private void a8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_a8ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_a8ActionPerformed

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_b2ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_b2ActionPerformed

    private void c2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_c2ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_c2ActionPerformed

    private void d2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_d2ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_d2ActionPerformed

    private void e2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_e2ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_e2ActionPerformed

    private void f2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_f2ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_f2ActionPerformed

    private void g2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_g2ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_g2ActionPerformed

    private void h2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_h2ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_h2ActionPerformed

    private void i2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_i2ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_i2ActionPerformed

    private void j2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_j2ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_j2ActionPerformed

    private void k2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_k2ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_k2ActionPerformed

    private void l2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_l2ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_l2ActionPerformed

    private void m2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_m2ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_m2ActionPerformed

    private void a3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_a3ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_a3ActionPerformed

    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_b3ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_b3ActionPerformed

    private void c3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_c3ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_c3ActionPerformed

    private void d3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_d3ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_d3ActionPerformed

    private void e3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_e3ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_e3ActionPerformed

    private void f3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_f3ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_f3ActionPerformed

    private void g3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_g3ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_g3ActionPerformed

    private void h3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_h3ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_h3ActionPerformed

    private void i3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_i3ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_i3ActionPerformed

    private void j3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_j3ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_j3ActionPerformed

    private void k3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_k3ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_k3ActionPerformed

    private void l3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_l3ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_l3ActionPerformed

    private void m3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_m3ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_m3ActionPerformed

    private void a4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_a4ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_a4ActionPerformed

    private void b4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_b4ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_b4ActionPerformed

    private void c4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_c4ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_c4ActionPerformed

    private void d4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_d4ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_d4ActionPerformed

    private void e4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_e4ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_e4ActionPerformed

    private void f4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_f4ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_f4ActionPerformed

    private void g4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_g4ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_g4ActionPerformed

    private void h4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_h4ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_h4ActionPerformed

    private void i4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_i4ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_i4ActionPerformed

    private void j4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_j4ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_j4ActionPerformed

    private void k4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_k4ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_k4ActionPerformed

    private void l4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_l4ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_l4ActionPerformed

    private void m4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_m4ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_m4ActionPerformed

    private void a5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_a5ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_a5ActionPerformed

    private void b5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_b5ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_b5ActionPerformed

    private void c5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_c5ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_c5ActionPerformed

    private void d5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_d5ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_d5ActionPerformed

    private void e5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_e5ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_e5ActionPerformed

    private void f5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_f5ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_f5ActionPerformed

    private void g5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_g5ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_g5ActionPerformed

    private void h5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_h5ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_h5ActionPerformed

    private void i5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_i5ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_i5ActionPerformed

    private void j5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_j5ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_j5ActionPerformed

    private void k5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_k5ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_k5ActionPerformed

    private void l5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_l5ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_l5ActionPerformed

    private void m5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_m5ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_m5ActionPerformed

    private void b6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_b6ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_b6ActionPerformed

    private void c6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_c6ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_c6ActionPerformed

    private void d6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_d6ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_d6ActionPerformed

    private void e6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_e6ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_e6ActionPerformed

    private void f6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_f6ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_f6ActionPerformed

    private void g6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_g6ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_g6ActionPerformed

    private void h6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_h6ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_h6ActionPerformed

    private void i6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_i6ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_i6ActionPerformed

    private void j6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_j6ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_j6ActionPerformed

    private void k6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_k6ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_k6ActionPerformed

    private void l6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_l6ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_l6ActionPerformed

    private void m6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_m6ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_m6ActionPerformed

    private void b7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_b7ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_b7ActionPerformed

    private void c7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_c7ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_c7ActionPerformed

    private void d7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_d7ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_d7ActionPerformed

    private void e7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_e7ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_e7ActionPerformed

    private void f7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_f7ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_f7ActionPerformed

    private void g7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_g7ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_g7ActionPerformed

    private void h7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_h7ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_h7ActionPerformed

    private void i7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_i7ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_i7ActionPerformed

    private void j7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_j7ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_j7ActionPerformed

    private void k7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_k7ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_k7ActionPerformed

    private void l7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_l7ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_l7ActionPerformed

    private void m7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_m7ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_m7ActionPerformed

    private void b8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_b8ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_b8ActionPerformed

    private void c8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_c8ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_c8ActionPerformed

    private void d8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_d8ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_d8ActionPerformed

    private void e8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_e8ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_e8ActionPerformed

    private void f8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_f8ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_f8ActionPerformed

    private void g8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_g8ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_g8ActionPerformed

    private void h8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_h8ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_h8ActionPerformed

    private void i8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_i8ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_i8ActionPerformed

    private void j8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_j8ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_j8ActionPerformed

    private void k8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_k8ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_k8ActionPerformed

    private void l8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_l8ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_l8ActionPerformed

    private void m8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_m8ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_m8ActionPerformed

    private void a9ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_a9ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_a9ActionPerformed

    private void b9ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_b9ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_b9ActionPerformed

    private void c9ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_c9ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_c9ActionPerformed

    private void d9ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_d9ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_d9ActionPerformed

    private void e9ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_e9ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_e9ActionPerformed

    private void f9ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_f9ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_f9ActionPerformed

    private void g9ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_g9ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_g9ActionPerformed

    private void h9ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_h9ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_h9ActionPerformed

    private void i9ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_i9ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_i9ActionPerformed

    private void j9ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_j9ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_j9ActionPerformed

    private void k9ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_k9ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_k9ActionPerformed

    private void l9ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_l9ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_l9ActionPerformed

    private void m9ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_m9ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_m9ActionPerformed

    private void a10ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_a10ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_a10ActionPerformed

    private void b10ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_b10ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_b10ActionPerformed

    private void c10ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_c10ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_c10ActionPerformed

    private void d10ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_d10ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_d10ActionPerformed

    private void e10ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_e10ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_e10ActionPerformed

    private void f10ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_f10ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_f10ActionPerformed

    private void g10ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_g10ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_g10ActionPerformed

    private void h10ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_h10ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_h10ActionPerformed

    private void i10ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_i10ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_i10ActionPerformed

    private void j10ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_j10ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_j10ActionPerformed

    private void k10ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_k10ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_k10ActionPerformed

    private void l10ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_l10ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_l10ActionPerformed

    private void m10ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_m10ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_m10ActionPerformed

    private void a11ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_a11ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_a11ActionPerformed

    private void b11ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_b11ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_b11ActionPerformed

    private void c11ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_c11ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_c11ActionPerformed

    private void d11ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_d11ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_d11ActionPerformed

    private void e11ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_e11ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_e11ActionPerformed

    private void f11ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_f11ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_f11ActionPerformed

    private void g11ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_g11ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_g11ActionPerformed

    private void h11ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_h11ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_h11ActionPerformed

    private void i11ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_i11ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_i11ActionPerformed

    private void j11ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_j11ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_j11ActionPerformed

    private void k11ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_k11ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_k11ActionPerformed

    private void l11ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_l11ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_l11ActionPerformed

    private void m11ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_m11ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_m11ActionPerformed

    private void a12ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_a12ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_a12ActionPerformed

    private void b12ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_b12ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_b12ActionPerformed

    private void c12ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_c12ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_c12ActionPerformed

    private void d12ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_d12ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_d12ActionPerformed

    private void e12ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_e12ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_e12ActionPerformed

    private void f12ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_f12ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_f12ActionPerformed

    private void g12ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_g12ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_g12ActionPerformed

    private void h12ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_h12ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_h12ActionPerformed

    private void i12ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_i12ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_i12ActionPerformed

    private void j12ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_j12ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_j12ActionPerformed

    private void k12ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_k12ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_k12ActionPerformed

    private void l12ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_l12ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_l12ActionPerformed

    private void m12ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_m12ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_m12ActionPerformed

    private void a13ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_a13ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_a13ActionPerformed

    private void b13ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_b13ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_b13ActionPerformed

    private void c13ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_c13ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_c13ActionPerformed

    private void d13ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_d13ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_d13ActionPerformed

    private void e13ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_e13ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_e13ActionPerformed

    private void f13ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_f13ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_f13ActionPerformed

    private void g13ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_g13ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_g13ActionPerformed

    private void h13ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_h13ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_h13ActionPerformed

    private void i13ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_i13ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_i13ActionPerformed

    private void j13ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_j13ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_j13ActionPerformed

    private void k13ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_k13ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_k13ActionPerformed

    private void l13ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_l13ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_l13ActionPerformed

    private void m13ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_m13ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_m13ActionPerformed

    private void a14ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_a14ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_a14ActionPerformed

    private void b14ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_b14ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_b14ActionPerformed

    private void c14ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_c14ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_c14ActionPerformed

    private void d14ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_d14ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_d14ActionPerformed

    private void e14ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_e14ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_e14ActionPerformed

    private void f14ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_f14ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_f14ActionPerformed

    private void g14ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_g14ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_g14ActionPerformed

    private void h14ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_h14ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_h14ActionPerformed

    private void i14ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_i14ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_i14ActionPerformed

    private void j14ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_j14ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_j14ActionPerformed

    private void k14ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_k14ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_k14ActionPerformed

    private void l14ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_l14ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_l14ActionPerformed

    private void m14ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_m14ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_m14ActionPerformed

    private void a15ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_a15ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_a15ActionPerformed

    private void b15ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_b15ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_b15ActionPerformed

    private void c15ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_c15ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_c15ActionPerformed

    private void d15ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_d15ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_d15ActionPerformed

    private void e15ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_e15ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_e15ActionPerformed

    private void f15ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_f15ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_f15ActionPerformed

    private void g15ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_g15ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_g15ActionPerformed

    private void h15ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_h15ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_h15ActionPerformed

    private void i15ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_i15ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_i15ActionPerformed

    private void j15ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_j15ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_j15ActionPerformed

    private void k15ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_k15ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_k15ActionPerformed

    private void l15ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_l15ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_l15ActionPerformed

    private void m15ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_m15ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_m15ActionPerformed

    private void a16ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_a16ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_a16ActionPerformed

    private void b16ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_b16ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_b16ActionPerformed

    private void c16ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_c16ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_c16ActionPerformed

    private void d16ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_d16ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_d16ActionPerformed

    private void f16ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_f16ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_f16ActionPerformed

    private void g16ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_g16ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_g16ActionPerformed

    private void h16ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_h16ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_h16ActionPerformed

    private void i16ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_i16ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_i16ActionPerformed

    private void j16ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_j16ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_j16ActionPerformed

    private void k16ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_k16ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_k16ActionPerformed

    private void l16ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_l16ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_l16ActionPerformed

    private void m16ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_m16ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_m16ActionPerformed

    private void a17ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_a17ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_a17ActionPerformed

    private void b17ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_b17ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_b17ActionPerformed

    private void c17ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_c17ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_c17ActionPerformed

    private void d17ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_d17ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_d17ActionPerformed

    private void e17ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_e17ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_e17ActionPerformed

    private void f17ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_f17ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_f17ActionPerformed

    private void g17ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_g17ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_g17ActionPerformed

    private void h17ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_h17ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_h17ActionPerformed

    private void i17ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_i17ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_i17ActionPerformed

    private void j17ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_j17ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_j17ActionPerformed

    private void k17ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_k17ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_k17ActionPerformed

    private void l17ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_l17ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_l17ActionPerformed

    private void m17ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_m17ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_m17ActionPerformed

    private void a18ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_a18ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_a18ActionPerformed

    private void b18ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_b18ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_b18ActionPerformed

    private void c18ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_c18ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_c18ActionPerformed

    private void d18ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_d18ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_d18ActionPerformed

    private void e18ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_e18ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_e18ActionPerformed

    private void f18ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_f18ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_f18ActionPerformed

    private void g18ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_g18ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_g18ActionPerformed

    private void h18ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_h18ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_h18ActionPerformed

    private void i18ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_i18ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_i18ActionPerformed

    private void j18ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_j18ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_j18ActionPerformed

    private void k18ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_k18ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_k18ActionPerformed

    private void l18ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_l18ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_l18ActionPerformed

    private void m18ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_m18ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_m18ActionPerformed

    private void b19ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_b19ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_b19ActionPerformed

    private void c19ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_c19ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_c19ActionPerformed

    private void d19ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_d19ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_d19ActionPerformed

    private void e19ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_e19ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_e19ActionPerformed

    private void f19ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_f19ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_f19ActionPerformed

    private void g19ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_g19ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_g19ActionPerformed

    private void h19ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_h19ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_h19ActionPerformed

    private void i19ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_i19ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_i19ActionPerformed

    private void j19ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_j19ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_j19ActionPerformed

    private void k19ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_k19ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_k19ActionPerformed

    private void l19ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_l19ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_l19ActionPerformed

    private void m19ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_m19ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_m19ActionPerformed

    private void a20ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_a20ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_a20ActionPerformed

    private void b20ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_b20ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_b20ActionPerformed

    private void c20ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_c20ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_c20ActionPerformed

    private void d20ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_d20ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_d20ActionPerformed

    private void e20ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_e20ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_e20ActionPerformed

    private void f20ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_f20ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_f20ActionPerformed

    private void g20ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_g20ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_g20ActionPerformed

    private void h20ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_h20ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_h20ActionPerformed

    private void i20ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_i20ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_i20ActionPerformed

    private void j20ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_j20ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_j20ActionPerformed

    private void k20ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_k20ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_k20ActionPerformed

    private void l20ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_l20ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_l20ActionPerformed

    private void m20ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_m20ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_m20ActionPerformed

    private void a19ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_a19ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_a19ActionPerformed

    private void e16ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_e16ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_e16ActionPerformed

    private void a6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_a6ActionPerformed
        try {
            UserInterface.shootTorpedo(((JButton) evt.getSource()).getName().toUpperCase());
        } catch (BadAttributeValueExpException ex) {
            Logger.getLogger(SWINGactualBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JButton) evt.getSource()).setBackground(Color.red);
    }// GEN-LAST:event_a6ActionPerformed

    // poop
    public void setLocationsOfPiece(ArrayList<String> LocationGreen, ArrayList<String> LocationBlue,
            ArrayList<String> LocationYellow, ArrayList<String> LocationPink, ArrayList<String> LocationOrange,
            UserInterface thisUser) {

        LocationGreenLocal = LocationGreen;
        LocationBlueLocal = LocationBlue;
        LocationYellowLocal = LocationYellow;
        LocationPinkLocal = LocationPink;
        LocationOrangeLocal = LocationOrange;
        localuser = thisUser;

        for (int i = 0; i < LocationGreenLocal.size(); i++) { // for the array containing location of green squares
            for (int j = 0; j < allButtons.size(); j++) { // check if it is a button
                // if so, set the background of the button to the color of it
                String temp = allButtons.get(j).getName().toUpperCase(); // temp = a1.getname()

                if (LocationGreenLocal.get(i).equals(temp)) { // if a3 is contained in allButtons, should always be true

                    allButtons.get(j).setBackground(Color.green);

                }

            }
        }

        for (int i = 0; i < LocationBlueLocal.size(); i++) { // for the array containing location of green squares
            for (int j = 0; j < allButtons.size(); j++) { // check if it is a button
                // if so, set the background of the button to the color of it
                String temp = allButtons.get(j).getName().toUpperCase(); // temp = a1.getname()

                if (LocationBlueLocal.get(i).equals(temp)) { // if a3 is contained in allButtons, should always be true

                    allButtons.get(j).setBackground(Color.blue);

                }

            }
        }

        for (int i = 0; i < LocationYellowLocal.size(); i++) { // for the array containing location of green squares
            for (int j = 0; j < allButtons.size(); j++) { // check if it is a button
                // if so, set the background of the button to the color of it
                String temp = allButtons.get(j).getName().toUpperCase(); // temp = a1.getname()

                if (LocationYellowLocal.get(i).equals(temp)) { // if a3 is contained in allButtons, should always be
                                                               // true

                    allButtons.get(j).setBackground(Color.yellow);

                }

            }
        }

        for (int i = 0; i < LocationPinkLocal.size(); i++) { // for the array containing location of green squares
            for (int j = 0; j < allButtons.size(); j++) { // check if it is a button
                // if so, set the background of the button to the color of it
                String temp = allButtons.get(j).getName().toUpperCase(); // temp = a1.getname()

                if (LocationPinkLocal.get(i).equals(temp)) { // if a3 is contained in allButtons, should always be true

                    allButtons.get(j).setBackground(Color.pink);

                }

            }
        }

        for (int i = 0; i < LocationOrangeLocal.size(); i++) { // for the array containing location of green squares
            for (int j = 0; j < allButtons.size(); j++) { // check if it is a button
                // if so, set the background of the button to the color of it
                String temp = allButtons.get(j).getName().toUpperCase(); // temp = a1.getname()

                if (LocationOrangeLocal.get(i).equals(temp)) { // if a3 is contained in allButtons, should always be
                                                               // true

                    allButtons.get(j).setBackground(Color.orange);

                }

            }
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SWINGactualBoard.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SWINGactualBoard.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SWINGactualBoard.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SWINGactualBoard.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SWINGactualBoard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton a1;
    private javax.swing.JButton a10;
    private javax.swing.JButton a11;
    private javax.swing.JButton a12;
    private javax.swing.JButton a13;
    private javax.swing.JButton a14;
    private javax.swing.JButton a15;
    private javax.swing.JButton a16;
    private javax.swing.JButton a17;
    private javax.swing.JButton a18;
    private javax.swing.JButton a19;
    private javax.swing.JButton a2;
    private javax.swing.JButton a20;
    private javax.swing.JButton a3;
    private javax.swing.JButton a4;
    private javax.swing.JButton a5;
    private javax.swing.JButton a6;
    private javax.swing.JButton a7;
    private javax.swing.JButton a8;
    private javax.swing.JButton a9;
    private javax.swing.JButton b1;
    private javax.swing.JButton b10;
    private javax.swing.JButton b11;
    private javax.swing.JButton b12;
    private javax.swing.JButton b13;
    private javax.swing.JButton b14;
    private javax.swing.JButton b15;
    private javax.swing.JButton b16;
    private javax.swing.JButton b17;
    private javax.swing.JButton b18;
    private javax.swing.JButton b19;
    private javax.swing.JButton b2;
    private javax.swing.JButton b20;
    private javax.swing.JButton b3;
    private javax.swing.JButton b4;
    private javax.swing.JButton b5;
    private javax.swing.JButton b6;
    private javax.swing.JButton b7;
    private javax.swing.JButton b8;
    private javax.swing.JButton b9;
    private javax.swing.JButton c1;
    private javax.swing.JButton c10;
    private javax.swing.JButton c11;
    private javax.swing.JButton c12;
    private javax.swing.JButton c13;
    private javax.swing.JButton c14;
    private javax.swing.JButton c15;
    private javax.swing.JButton c16;
    private javax.swing.JButton c17;
    private javax.swing.JButton c18;
    private javax.swing.JButton c19;
    private javax.swing.JButton c2;
    private javax.swing.JButton c20;
    private javax.swing.JButton c3;
    private javax.swing.JButton c4;
    private javax.swing.JButton c5;
    private javax.swing.JButton c6;
    private javax.swing.JButton c7;
    private javax.swing.JButton c8;
    private javax.swing.JButton c9;
    private javax.swing.JButton d1;
    private javax.swing.JButton d10;
    private javax.swing.JButton d11;
    private javax.swing.JButton d12;
    private javax.swing.JButton d13;
    private javax.swing.JButton d14;
    private javax.swing.JButton d15;
    private javax.swing.JButton d16;
    private javax.swing.JButton d17;
    private javax.swing.JButton d18;
    private javax.swing.JButton d19;
    private javax.swing.JButton d2;
    private javax.swing.JButton d20;
    private javax.swing.JButton d3;
    private javax.swing.JButton d4;
    private javax.swing.JButton d5;
    private javax.swing.JButton d6;
    private javax.swing.JButton d7;
    private javax.swing.JButton d8;
    private javax.swing.JButton d9;
    private javax.swing.JButton e1;
    private javax.swing.JButton e10;
    private javax.swing.JButton e11;
    private javax.swing.JButton e12;
    private javax.swing.JButton e13;
    private javax.swing.JButton e14;
    private javax.swing.JButton e15;
    private javax.swing.JButton e16;
    private javax.swing.JButton e17;
    private javax.swing.JButton e18;
    private javax.swing.JButton e19;
    private javax.swing.JButton e2;
    private javax.swing.JButton e20;
    private javax.swing.JButton e3;
    private javax.swing.JButton e4;
    private javax.swing.JButton e5;
    private javax.swing.JButton e6;
    private javax.swing.JButton e7;
    private javax.swing.JButton e8;
    private javax.swing.JButton e9;
    private javax.swing.JButton f1;
    private javax.swing.JButton f10;
    private javax.swing.JButton f11;
    private javax.swing.JButton f12;
    private javax.swing.JButton f13;
    private javax.swing.JButton f14;
    private javax.swing.JButton f15;
    private javax.swing.JButton f16;
    private javax.swing.JButton f17;
    private javax.swing.JButton f18;
    private javax.swing.JButton f19;
    private javax.swing.JButton f2;
    private javax.swing.JButton f20;
    private javax.swing.JButton f3;
    private javax.swing.JButton f4;
    private javax.swing.JButton f5;
    private javax.swing.JButton f6;
    private javax.swing.JButton f7;
    private javax.swing.JButton f8;
    private javax.swing.JButton f9;
    private javax.swing.JButton g1;
    private javax.swing.JButton g10;
    private javax.swing.JButton g11;
    private javax.swing.JButton g12;
    private javax.swing.JButton g13;
    private javax.swing.JButton g14;
    private javax.swing.JButton g15;
    private javax.swing.JButton g16;
    private javax.swing.JButton g17;
    private javax.swing.JButton g18;
    private javax.swing.JButton g19;
    private javax.swing.JButton g2;
    private javax.swing.JButton g20;
    private javax.swing.JButton g3;
    private javax.swing.JButton g4;
    private javax.swing.JButton g5;
    private javax.swing.JButton g6;
    private javax.swing.JButton g7;
    private javax.swing.JButton g8;
    private javax.swing.JButton g9;
    private javax.swing.JButton h1;
    private javax.swing.JButton h10;
    private javax.swing.JButton h11;
    private javax.swing.JButton h12;
    private javax.swing.JButton h13;
    private javax.swing.JButton h14;
    private javax.swing.JButton h15;
    private javax.swing.JButton h16;
    private javax.swing.JButton h17;
    private javax.swing.JButton h18;
    private javax.swing.JButton h19;
    private javax.swing.JButton h2;
    private javax.swing.JButton h20;
    private javax.swing.JButton h3;
    private javax.swing.JButton h4;
    private javax.swing.JButton h5;
    private javax.swing.JButton h6;
    private javax.swing.JButton h7;
    private javax.swing.JButton h8;
    private javax.swing.JButton h9;
    private javax.swing.JButton i1;
    private javax.swing.JButton i10;
    private javax.swing.JButton i11;
    private javax.swing.JButton i12;
    private javax.swing.JButton i13;
    private javax.swing.JButton i14;
    private javax.swing.JButton i15;
    private javax.swing.JButton i16;
    private javax.swing.JButton i17;
    private javax.swing.JButton i18;
    private javax.swing.JButton i19;
    private javax.swing.JButton i2;
    private javax.swing.JButton i20;
    private javax.swing.JButton i3;
    private javax.swing.JButton i4;
    private javax.swing.JButton i5;
    private javax.swing.JButton i6;
    private javax.swing.JButton i7;
    private javax.swing.JButton i8;
    private javax.swing.JButton i9;
    private javax.swing.JButton j1;
    private javax.swing.JButton j10;
    private javax.swing.JButton j11;
    private javax.swing.JButton j12;
    private javax.swing.JButton j13;
    private javax.swing.JButton j14;
    private javax.swing.JButton j15;
    private javax.swing.JButton j16;
    private javax.swing.JButton j17;
    private javax.swing.JButton j18;
    private javax.swing.JButton j19;
    private javax.swing.JButton j2;
    private javax.swing.JButton j20;
    private javax.swing.JButton j3;
    private javax.swing.JButton j4;
    private javax.swing.JButton j5;
    private javax.swing.JButton j6;
    private javax.swing.JButton j7;
    private javax.swing.JButton j8;
    private javax.swing.JButton j9;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton k1;
    private javax.swing.JButton k10;
    private javax.swing.JButton k11;
    private javax.swing.JButton k12;
    private javax.swing.JButton k13;
    private javax.swing.JButton k14;
    private javax.swing.JButton k15;
    private javax.swing.JButton k16;
    private javax.swing.JButton k17;
    private javax.swing.JButton k18;
    private javax.swing.JButton k19;
    private javax.swing.JButton k2;
    private javax.swing.JButton k20;
    private javax.swing.JButton k3;
    private javax.swing.JButton k4;
    private javax.swing.JButton k5;
    private javax.swing.JButton k6;
    private javax.swing.JButton k7;
    private javax.swing.JButton k8;
    private javax.swing.JButton k9;
    private javax.swing.JButton l1;
    private javax.swing.JButton l10;
    private javax.swing.JButton l11;
    private javax.swing.JButton l12;
    private javax.swing.JButton l13;
    private javax.swing.JButton l14;
    private javax.swing.JButton l15;
    private javax.swing.JButton l16;
    private javax.swing.JButton l17;
    private javax.swing.JButton l18;
    private javax.swing.JButton l19;
    private javax.swing.JButton l2;
    private javax.swing.JButton l20;
    private javax.swing.JButton l3;
    private javax.swing.JButton l4;
    private javax.swing.JButton l5;
    private javax.swing.JButton l6;
    private javax.swing.JButton l7;
    private javax.swing.JButton l8;
    private javax.swing.JButton l9;
    private javax.swing.JButton m1;
    private javax.swing.JButton m10;
    private javax.swing.JButton m11;
    private javax.swing.JButton m12;
    private javax.swing.JButton m13;
    private javax.swing.JButton m14;
    private javax.swing.JButton m15;
    private javax.swing.JButton m16;
    private javax.swing.JButton m17;
    private javax.swing.JButton m18;
    private javax.swing.JButton m19;
    private javax.swing.JButton m2;
    private javax.swing.JButton m20;
    private javax.swing.JButton m3;
    private javax.swing.JButton m4;
    private javax.swing.JButton m5;
    private javax.swing.JButton m6;
    private javax.swing.JButton m7;
    private javax.swing.JButton m8;
    private javax.swing.JButton m9;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables

}
