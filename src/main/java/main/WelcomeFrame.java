/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import mouseAdapters.FrameDragListener;
import java.awt.Cursor;
import java.awt.Frame;
import java.awt.geom.RoundRectangle2D;

/**
 *
 * @author cleber
 */
public class WelcomeFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public WelcomeFrame() {
        initComponents();
        
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
        
        FrameDragListener frameDragListener = new FrameDragListener(this);
        header_title.addMouseListener(frameDragListener);
        header_title.addMouseMotionListener(frameDragListener);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        header_panel = new javax.swing.JPanel();
        header_actions_panel = new javax.swing.JPanel();
        close_btn = new javax.swing.JButton();
        minimize_btn = new javax.swing.JButton();
        header_title = new javax.swing.JLabel();
        header_lang_panel = new javax.swing.JPanel();
        brazil_lang_btn = new javax.swing.JButton();
        usa_lang_btn = new javax.swing.JButton();
        main_panel = new javax.swing.JPanel();
        main_left_panel = new javax.swing.JPanel();
        main_left_panel_header = new javax.swing.JPanel();
        left_panel_title = new javax.swing.JLabel();
        left_panel_subtitle = new javax.swing.JLabel();
        main_left_panel_footer = new javax.swing.JPanel();
        main_left_panel_new_section = new javax.swing.JPanel();
        main_left_panel_new_section_title = new javax.swing.JLabel();
        new_simulation_btn = new javax.swing.JButton();
        open_simulation_btn1 = new javax.swing.JButton();
        main_left_panel_recent_section = new javax.swing.JPanel();
        recent_file_header_panel = new javax.swing.JPanel();
        main_left_panel_recent_section_title = new javax.swing.JLabel();
        recent_file_panel = new javax.swing.JPanel();
        recent_file = new javax.swing.JButton();
        recent_file_path = new javax.swing.JLabel();
        main_right_panel = new javax.swing.JPanel();
        main_right_panel_explore_section = new javax.swing.JPanel();
        main_rigth_panel_explore_section_title = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        main_rigth_panel_gallery_card = new customWidgets.PanelRound();
        gallery_card_title = new javax.swing.JLabel();
        gallery_card_body = new javax.swing.JLabel();
        gallery_card_footer = new customWidgets.PanelRound();
        gallery_card_left_footer = new customWidgets.PanelRound();
        gallery_card_footer_right = new customWidgets.PanelRound();
        main_right_learn_card = new customWidgets.PanelRound();
        main_right_learn_card_btn = new javax.swing.JButton();
        main_right_contact_card = new customWidgets.PanelRound();
        main_right_contact_card_btn = new javax.swing.JButton();
        footer_panel = new javax.swing.JPanel();
        footer_title = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(1024, 768));
        setUndecorated(true);
        setSize(new java.awt.Dimension(1024, 768));
        getContentPane().setLayout(new java.awt.BorderLayout(0, 1));

        header_panel.setBackground(new java.awt.Color(42, 42, 42));
        header_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(42, 42, 42), 5));
        header_panel.setPreferredSize(new java.awt.Dimension(800, 70));
        header_panel.setLayout(new java.awt.BorderLayout(10, 0));

        header_actions_panel.setBackground(new java.awt.Color(42, 42, 42));
        header_actions_panel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 20));

        close_btn.setBackground(new java.awt.Color(0, 0, 0));
        close_btn.setFont(new java.awt.Font("Liberation Sans", 1, 11)); // NOI18N
        close_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close_btn.png"))); // NOI18N
        close_btn.setToolTipText("");
        close_btn.setBorderPainted(false);
        close_btn.setContentAreaFilled(false);
        close_btn.setFocusPainted(false);
        close_btn.setFocusable(false);
        close_btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        close_btn.setMaximumSize(new java.awt.Dimension(25, 25));
        close_btn.setMinimumSize(new java.awt.Dimension(25, 25));
        close_btn.setPreferredSize(new java.awt.Dimension(30, 25));
        close_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                close_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                close_btnMouseExited(evt);
            }
        });
        close_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                close_btnActionPerformed(evt);
            }
        });
        header_actions_panel.add(close_btn);

        minimize_btn.setBackground(new java.awt.Color(0, 0, 0));
        minimize_btn.setFont(new java.awt.Font("Liberation Sans", 1, 11)); // NOI18N
        minimize_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/minimize_btn.png"))); // NOI18N
        minimize_btn.setToolTipText("");
        minimize_btn.setBorderPainted(false);
        minimize_btn.setContentAreaFilled(false);
        minimize_btn.setFocusPainted(false);
        minimize_btn.setFocusable(false);
        minimize_btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        minimize_btn.setMaximumSize(new java.awt.Dimension(25, 25));
        minimize_btn.setMinimumSize(new java.awt.Dimension(25, 25));
        minimize_btn.setPreferredSize(new java.awt.Dimension(30, 25));
        minimize_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minimize_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minimize_btnMouseExited(evt);
            }
        });
        minimize_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimize_btnActionPerformed(evt);
            }
        });
        header_actions_panel.add(minimize_btn);

        header_panel.add(header_actions_panel, java.awt.BorderLayout.LINE_START);

        header_title.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        header_title.setForeground(new java.awt.Color(255, 255, 255));
        header_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        header_title.setText("Bem Vindo");
        header_title.setToolTipText("");
        header_panel.add(header_title, java.awt.BorderLayout.CENTER);

        header_lang_panel.setBackground(new java.awt.Color(42, 42, 42));
        header_lang_panel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 15));

        brazil_lang_btn.setBackground(new java.awt.Color(0, 0, 0));
        brazil_lang_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/brazil_flag.png"))); // NOI18N
        brazil_lang_btn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 214, 10)));
        brazil_lang_btn.setContentAreaFilled(false);
        brazil_lang_btn.setFocusPainted(false);
        brazil_lang_btn.setFocusable(false);
        brazil_lang_btn.setMaximumSize(new java.awt.Dimension(66, 42));
        brazil_lang_btn.setMinimumSize(new java.awt.Dimension(66, 42));
        brazil_lang_btn.setPreferredSize(new java.awt.Dimension(66, 42));
        brazil_lang_btn.setSelected(true);
        brazil_lang_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brazil_lang_btnActionPerformed(evt);
            }
        });
        header_lang_panel.add(brazil_lang_btn);

        usa_lang_btn.setBackground(new java.awt.Color(0, 0, 0));
        usa_lang_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/usa_flag.png"))); // NOI18N
        usa_lang_btn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 214, 10)));
        usa_lang_btn.setBorderPainted(false);
        usa_lang_btn.setContentAreaFilled(false);
        usa_lang_btn.setFocusPainted(false);
        usa_lang_btn.setFocusable(false);
        usa_lang_btn.setMaximumSize(new java.awt.Dimension(66, 42));
        usa_lang_btn.setMinimumSize(new java.awt.Dimension(66, 42));
        usa_lang_btn.setPreferredSize(new java.awt.Dimension(66, 42));
        usa_lang_btn.setSelected(true);
        usa_lang_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usa_lang_btnActionPerformed(evt);
            }
        });
        header_lang_panel.add(usa_lang_btn);

        header_panel.add(header_lang_panel, java.awt.BorderLayout.LINE_END);

        getContentPane().add(header_panel, java.awt.BorderLayout.PAGE_START);

        main_panel.setBackground(new java.awt.Color(53, 53, 53));
        main_panel.setForeground(new java.awt.Color(27, 27, 27));
        main_panel.setLayout(new java.awt.GridLayout(1, 1));

        main_left_panel.setBackground(new java.awt.Color(42, 42, 42));
        java.awt.GridBagLayout main_left_panelLayout = new java.awt.GridBagLayout();
        main_left_panelLayout.columnWidths = new int[] {0};
        main_left_panelLayout.rowHeights = new int[] {0, 1, 0};
        main_left_panelLayout.columnWeights = new double[] {0.0};
        main_left_panelLayout.rowWeights = new double[] {0.0};
        main_left_panel.setLayout(main_left_panelLayout);

        main_left_panel_header.setBackground(new java.awt.Color(42, 42, 42));
        main_left_panel_header.setPreferredSize(new java.awt.Dimension(377, 40));
        main_left_panel_header.setLayout(new java.awt.BorderLayout());

        left_panel_title.setFont(new java.awt.Font("DejaVu Sans", 0, 36)); // NOI18N
        left_panel_title.setForeground(new java.awt.Color(255, 255, 255));
        left_panel_title.setText("IoT-Verse Simulator");
        left_panel_title.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        main_left_panel_header.add(left_panel_title, java.awt.BorderLayout.CENTER);

        left_panel_subtitle.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        left_panel_subtitle.setForeground(new java.awt.Color(255, 255, 255));
        left_panel_subtitle.setText("Simulador baseado em Sistemas Multiagentes para IoT");
        main_left_panel_header.add(left_panel_subtitle, java.awt.BorderLayout.PAGE_END);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        main_left_panel.add(main_left_panel_header, gridBagConstraints);

        main_left_panel_footer.setBackground(new java.awt.Color(42, 42, 42));
        main_left_panel_footer.setLayout(new java.awt.BorderLayout(0, 15));

        main_left_panel_new_section.setBackground(new java.awt.Color(42, 42, 42));
        main_left_panel_new_section.setLayout(new javax.swing.BoxLayout(main_left_panel_new_section, javax.swing.BoxLayout.Y_AXIS));

        main_left_panel_new_section_title.setFont(new java.awt.Font("DejaVu Sans", 0, 22)); // NOI18N
        main_left_panel_new_section_title.setForeground(new java.awt.Color(255, 255, 255));
        main_left_panel_new_section_title.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        main_left_panel_new_section_title.setText("Início");
        main_left_panel_new_section.add(main_left_panel_new_section_title);

        new_simulation_btn.setForeground(new java.awt.Color(255, 214, 10));
        new_simulation_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/new_file.png"))); // NOI18N
        new_simulation_btn.setText("Novo Universo...");
        new_simulation_btn.setContentAreaFilled(false);
        new_simulation_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        new_simulation_btn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        new_simulation_btn.setIconTextGap(8);
        new_simulation_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new_simulation_btnActionPerformed(evt);
            }
        });
        main_left_panel_new_section.add(new_simulation_btn);

        open_simulation_btn1.setForeground(new java.awt.Color(255, 214, 10));
        open_simulation_btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/open_file.png"))); // NOI18N
        open_simulation_btn1.setText("Abrir Universo...");
        open_simulation_btn1.setContentAreaFilled(false);
        open_simulation_btn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        open_simulation_btn1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        open_simulation_btn1.setIconTextGap(6);
        open_simulation_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                open_simulation_btn1ActionPerformed(evt);
            }
        });
        main_left_panel_new_section.add(open_simulation_btn1);

        main_left_panel_footer.add(main_left_panel_new_section, java.awt.BorderLayout.PAGE_START);

        main_left_panel_recent_section.setBackground(new java.awt.Color(42, 42, 42));
        main_left_panel_recent_section.setLayout(new java.awt.BorderLayout());

        recent_file_header_panel.setBackground(new java.awt.Color(42, 42, 42));
        recent_file_header_panel.setAlignmentX(0.0F);
        recent_file_header_panel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        main_left_panel_recent_section_title.setFont(new java.awt.Font("DejaVu Sans", 0, 22)); // NOI18N
        main_left_panel_recent_section_title.setForeground(new java.awt.Color(255, 255, 255));
        main_left_panel_recent_section_title.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        main_left_panel_recent_section_title.setText("Recentes");
        main_left_panel_recent_section_title.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        recent_file_header_panel.add(main_left_panel_recent_section_title);

        main_left_panel_recent_section.add(recent_file_header_panel, java.awt.BorderLayout.PAGE_START);

        recent_file_panel.setBackground(new java.awt.Color(42, 42, 42));
        recent_file_panel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        recent_file.setForeground(new java.awt.Color(255, 214, 10));
        recent_file.setText("Smart House");
        recent_file.setContentAreaFilled(false);
        recent_file.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        recent_file.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        recent_file.setIconTextGap(0);
        recent_file.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recent_fileActionPerformed(evt);
            }
        });
        recent_file_panel.add(recent_file);

        recent_file_path.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        recent_file_path.setForeground(new java.awt.Color(255, 255, 255));
        recent_file_path.setText("/home/foo/smart_house.universe");
        recent_file_panel.add(recent_file_path);

        main_left_panel_recent_section.add(recent_file_panel, java.awt.BorderLayout.CENTER);

        main_left_panel_footer.add(main_left_panel_recent_section, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(50, 20, 0, 0);
        main_left_panel.add(main_left_panel_footer, gridBagConstraints);

        main_panel.add(main_left_panel);

        main_right_panel.setBackground(new java.awt.Color(42, 42, 42));
        main_right_panel.setLayout(new java.awt.GridBagLayout());

        main_right_panel_explore_section.setBackground(new java.awt.Color(42, 42, 42));
        main_right_panel_explore_section.setLayout(new java.awt.BorderLayout(0, 5));

        main_rigth_panel_explore_section_title.setFont(new java.awt.Font("DejaVu Sans", 0, 22)); // NOI18N
        main_rigth_panel_explore_section_title.setForeground(new java.awt.Color(255, 255, 255));
        main_rigth_panel_explore_section_title.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        main_rigth_panel_explore_section_title.setText("Explore");
        main_right_panel_explore_section.add(main_rigth_panel_explore_section_title, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBackground(new java.awt.Color(42, 42, 42));
        jPanel1.setLayout(new java.awt.BorderLayout(0, 15));

        main_rigth_panel_gallery_card.setBackground(new java.awt.Color(52, 52, 52));
        main_rigth_panel_gallery_card.setPreferredSize(new java.awt.Dimension(460, 100));
        main_rigth_panel_gallery_card.setRoundBottom(20);
        main_rigth_panel_gallery_card.setRoundTop(20);
        main_rigth_panel_gallery_card.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                main_rigth_panel_gallery_cardMouseEntered(evt);
            }
        });
        java.awt.GridBagLayout panelRound1Layout = new java.awt.GridBagLayout();
        panelRound1Layout.columnWeights = new double[] {0.5};
        panelRound1Layout.rowWeights = new double[] {0.5};
        main_rigth_panel_gallery_card.setLayout(panelRound1Layout);

        gallery_card_title.setBackground(new java.awt.Color(255, 255, 255));
        gallery_card_title.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        gallery_card_title.setForeground(new java.awt.Color(255, 255, 255));
        gallery_card_title.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        gallery_card_title.setText("Selecione um Universo da nossa Galeria");
        gallery_card_title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
        main_rigth_panel_gallery_card.add(gallery_card_title, gridBagConstraints);

        gallery_card_body.setBackground(new java.awt.Color(255, 255, 255));
        gallery_card_body.setForeground(new java.awt.Color(255, 255, 255));
        gallery_card_body.setText("<html>De Cidades Inteligentes à Estações de Monitoramento de Água.<br>Desenvolva seu Universo à partir de em um dos nossos exemplos.");
        gallery_card_body.setMaximumSize(new java.awt.Dimension(480, 15));
        gallery_card_body.setPreferredSize(new java.awt.Dimension(430, 45));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        main_rigth_panel_gallery_card.add(gallery_card_body, gridBagConstraints);

        gallery_card_footer.setBackground(new java.awt.Color(255, 255, 255));
        gallery_card_footer.setPreferredSize(new java.awt.Dimension(400, 5));
        gallery_card_footer.setRoundBottom(20);
        gallery_card_footer.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        gallery_card_left_footer.setBackground(new java.awt.Color(255, 214, 10));
        gallery_card_left_footer.setPreferredSize(new java.awt.Dimension(300, 5));
        gallery_card_left_footer.setRoundBottomLeft(20);

        javax.swing.GroupLayout gallery_card_left_footerLayout = new javax.swing.GroupLayout(gallery_card_left_footer);
        gallery_card_left_footer.setLayout(gallery_card_left_footerLayout);
        gallery_card_left_footerLayout.setHorizontalGroup(
            gallery_card_left_footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        gallery_card_left_footerLayout.setVerticalGroup(
            gallery_card_left_footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        gallery_card_footer.add(gallery_card_left_footer);

        gallery_card_footer_right.setBackground(new java.awt.Color(66, 66, 66));
        gallery_card_footer_right.setPreferredSize(new java.awt.Dimension(160, 5));
        gallery_card_footer_right.setRoundBottomRight(20);

        javax.swing.GroupLayout gallery_card_footer_rightLayout = new javax.swing.GroupLayout(gallery_card_footer_right);
        gallery_card_footer_right.setLayout(gallery_card_footer_rightLayout);
        gallery_card_footer_rightLayout.setHorizontalGroup(
            gallery_card_footer_rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );
        gallery_card_footer_rightLayout.setVerticalGroup(
            gallery_card_footer_rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        gallery_card_footer.add(gallery_card_footer_right);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_START;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        main_rigth_panel_gallery_card.add(gallery_card_footer, gridBagConstraints);

        jPanel1.add(main_rigth_panel_gallery_card, java.awt.BorderLayout.PAGE_START);

        main_right_learn_card.setBackground(new java.awt.Color(52, 52, 52));
        main_right_learn_card.setPreferredSize(new java.awt.Dimension(460, 40));
        main_right_learn_card.setRoundBottom(20);
        main_right_learn_card.setRoundTop(20);
        main_right_learn_card.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                main_right_learn_cardMouseEntered(evt);
            }
        });
        main_right_learn_card.setLayout(new java.awt.GridBagLayout());

        main_right_learn_card_btn.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        main_right_learn_card_btn.setForeground(new java.awt.Color(255, 255, 255));
        main_right_learn_card_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/youtube_icon.png"))); // NOI18N
        main_right_learn_card_btn.setText("Aprenda os Fundamentos ");
        main_right_learn_card_btn.setContentAreaFilled(false);
        main_right_learn_card_btn.setIconTextGap(8);
        main_right_learn_card_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                main_right_learn_card_btnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        main_right_learn_card.add(main_right_learn_card_btn, gridBagConstraints);

        jPanel1.add(main_right_learn_card, java.awt.BorderLayout.CENTER);

        main_right_contact_card.setBackground(new java.awt.Color(52, 52, 52));
        main_right_contact_card.setPreferredSize(new java.awt.Dimension(460, 40));
        main_right_contact_card.setRoundBottom(20);
        main_right_contact_card.setRoundTop(20);
        main_right_contact_card.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                main_right_contact_cardMouseEntered(evt);
            }
        });
        main_right_contact_card.setLayout(new java.awt.GridBagLayout());

        main_right_contact_card_btn.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        main_right_contact_card_btn.setForeground(new java.awt.Color(255, 255, 255));
        main_right_contact_card_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/website_icon.png"))); // NOI18N
        main_right_contact_card_btn.setText("Entre em Contato com a Comunidade");
        main_right_contact_card_btn.setContentAreaFilled(false);
        main_right_contact_card_btn.setIconTextGap(10);
        main_right_contact_card_btn.setInheritsPopupMenu(true);
        main_right_contact_card_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                main_right_contact_card_btnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        main_right_contact_card.add(main_right_contact_card_btn, gridBagConstraints);

        jPanel1.add(main_right_contact_card, java.awt.BorderLayout.PAGE_END);

        main_right_panel_explore_section.add(jPanel1, java.awt.BorderLayout.PAGE_END);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(305, 0, 0, 0);
        main_right_panel.add(main_right_panel_explore_section, gridBagConstraints);

        main_panel.add(main_right_panel);

        getContentPane().add(main_panel, java.awt.BorderLayout.CENTER);

        footer_panel.setBackground(new java.awt.Color(255, 255, 255));
        footer_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        footer_panel.setPreferredSize(new java.awt.Dimension(800, 40));
        footer_panel.setLayout(new java.awt.BorderLayout(10, 0));

        footer_title.setFont(new java.awt.Font("DejaVu Sans", 1, 10)); // NOI18N
        footer_title.setForeground(new java.awt.Color(42, 42, 42));
        footer_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        footer_title.setText("V0.0.1 @ CleberPeter");
        footer_title.setToolTipText("");
        footer_panel.add(footer_title, java.awt.BorderLayout.CENTER);

        getContentPane().add(footer_panel, java.awt.BorderLayout.PAGE_END);

        setSize(new java.awt.Dimension(1024, 727));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void minimize_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimize_btnActionPerformed
        setState(Frame.ICONIFIED);
    }//GEN-LAST:event_minimize_btnActionPerformed

    private void minimize_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimize_btnMouseExited
        minimize_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/minimize_btn.png"))); // NOI18N
    }//GEN-LAST:event_minimize_btnMouseExited

    private void minimize_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimize_btnMouseEntered
        minimize_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/minimize_btn_focused.png"))); // NOI18N
    }//GEN-LAST:event_minimize_btnMouseEntered

    private void close_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_close_btnActionPerformed
        System.exit(0);
    }//GEN-LAST:event_close_btnActionPerformed

    private void close_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_btnMouseExited
        close_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close_btn.png"))); // NOI18N
    }//GEN-LAST:event_close_btnMouseExited

    private void close_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_btnMouseEntered
        close_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close_btn_focused.png"))); // NOI18N
    }//GEN-LAST:event_close_btnMouseEntered

    private void brazil_lang_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brazil_lang_btnActionPerformed
        brazil_lang_btn.setBorderPainted(true);
        usa_lang_btn.setBorderPainted(false);
    }//GEN-LAST:event_brazil_lang_btnActionPerformed

    private void usa_lang_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usa_lang_btnActionPerformed
        brazil_lang_btn.setBorderPainted(false);
        usa_lang_btn.setBorderPainted(true);
    }//GEN-LAST:event_usa_lang_btnActionPerformed

    private void recent_fileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recent_fileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_recent_fileActionPerformed

    private void open_simulation_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_open_simulation_btn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_open_simulation_btn1ActionPerformed

    private void new_simulation_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_new_simulation_btnActionPerformed
        setVisible(false);
        
        MainFrame createUniserveFrame = new MainFrame();
        createUniserveFrame.setVisible(true);
    }//GEN-LAST:event_new_simulation_btnActionPerformed

    private void main_rigth_panel_gallery_cardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_main_rigth_panel_gallery_cardMouseEntered
        main_rigth_panel_gallery_card.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_main_rigth_panel_gallery_cardMouseEntered

    private void main_right_learn_cardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_main_right_learn_cardMouseEntered
        main_right_learn_card.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_main_right_learn_cardMouseEntered

    private void main_right_learn_card_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_main_right_learn_card_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_main_right_learn_card_btnActionPerformed

    private void main_right_contact_card_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_main_right_contact_card_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_main_right_contact_card_btnActionPerformed

    private void main_right_contact_cardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_main_right_contact_cardMouseEntered
        main_right_contact_card.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_main_right_contact_cardMouseEntered
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brazil_lang_btn;
    private javax.swing.JButton close_btn;
    private javax.swing.JPanel footer_panel;
    private javax.swing.JLabel footer_title;
    private javax.swing.JLabel gallery_card_body;
    private customWidgets.PanelRound gallery_card_footer;
    private customWidgets.PanelRound gallery_card_footer_right;
    private customWidgets.PanelRound gallery_card_left_footer;
    private javax.swing.JLabel gallery_card_title;
    private javax.swing.JPanel header_actions_panel;
    private javax.swing.JPanel header_lang_panel;
    private javax.swing.JPanel header_panel;
    private javax.swing.JLabel header_title;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel left_panel_subtitle;
    private javax.swing.JLabel left_panel_title;
    private javax.swing.JPanel main_left_panel;
    private javax.swing.JPanel main_left_panel_footer;
    private javax.swing.JPanel main_left_panel_header;
    private javax.swing.JPanel main_left_panel_new_section;
    private javax.swing.JLabel main_left_panel_new_section_title;
    private javax.swing.JPanel main_left_panel_recent_section;
    private javax.swing.JLabel main_left_panel_recent_section_title;
    private javax.swing.JPanel main_panel;
    private customWidgets.PanelRound main_right_contact_card;
    private javax.swing.JButton main_right_contact_card_btn;
    private customWidgets.PanelRound main_right_learn_card;
    private javax.swing.JButton main_right_learn_card_btn;
    private javax.swing.JPanel main_right_panel;
    private javax.swing.JPanel main_right_panel_explore_section;
    private javax.swing.JLabel main_rigth_panel_explore_section_title;
    private customWidgets.PanelRound main_rigth_panel_gallery_card;
    private javax.swing.JButton minimize_btn;
    private javax.swing.JButton new_simulation_btn;
    private javax.swing.JButton open_simulation_btn1;
    private javax.swing.JButton recent_file;
    private javax.swing.JPanel recent_file_header_panel;
    private javax.swing.JPanel recent_file_panel;
    private javax.swing.JLabel recent_file_path;
    private javax.swing.JButton usa_lang_btn;
    // End of variables declaration//GEN-END:variables
}
