package org.personal.bookmgmt.ui;

import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.personal.bookmgmt.dao.BooksDao;
import org.personal.bookmgmt.dao.impl.BooksDaoImpl;
import org.personal.bookmgmt.model.Books;

public class Dashboard extends javax.swing.JFrame {

    private final BooksDao booksDao = new BooksDaoImpl();

    private final String[] columns = new String[]{"ID", "Name", "Batch", "Faculty", "ELE", "Student Id" };

    private final DefaultTableModel model = new DefaultTableModel();

    public Dashboard() {
        initComponents();
        setUpTableModel();
        setUpPaddingInTextField();
        findAll();
    }

    private void save() throws NumberFormatException, HeadlessException {
        try {
            Books book = getValueFromTextField();
            int rowCount = booksDao.save(book);
            if (rowCount >= 1) {
                showMessageDialog("Student sucessfully saved");
                resetForm();
                findAll();
            } else {
                showMessageDialog("Something went wrong");
            }
        } catch (SQLException | ClassNotFoundException | NumberFormatException ex) {
            showMessageDialog(ex.getMessage());
        }
    }
//asdadasd
    private void update() throws NumberFormatException {
        double initialEle;
        try {
            int selectedRow = booksTable.getSelectedRow();
            int id = (int) booksTable.getValueAt(selectedRow, 0);
            Books book = booksDao.findOne(id);
            if (editOrUpdateButton.getText().equals("Edit")) {
                editOrUpdateButton.setText("Update");
                bookNameTextField.setText(book.getName());
                authorTextField.setText(book.getAuthor());
                publishedByTextField.setText(book.getPublication());
                priceTextField.setText(String.valueOf(book.getPrice()));
            } else if (editOrUpdateButton.getText().equals("Update")) {
                book.setName(bookNameTextField.getText());
                book.setAuthor(authorTextField.getText());
                book.setPublication(publishedByTextField.getText());
                initialEle = book.getPrice();
                book.setPrice(Double.valueOf(priceTextField.getText())+ initialEle );
                int rowCount = booksDao.update(book, id);
                if (rowCount >= 1) {
                    showMessageDialog("Student sucessfully updated");
                    resetForm();
                    findAll();
                    editOrUpdateButton.setText("Edit");
                } else {
                    showMessageDialog("Something went wrong");
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            showMessageDialog(ex.getMessage());
        }
    }

    private void remove() {
        int selectedRow = booksTable.getSelectedRow();
        int id = (int) booksTable.getValueAt(selectedRow, 0);
        try {
            Books book = booksDao.findOne(id);
            if (book != null) {
                int rowCount = booksDao.remove(id);
                if (rowCount >= 1) {
                    showMessageDialog("Student sucessfully deleted");
                    findAll();
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            showMessageDialog(ex.getMessage());
        }
    }

    private void findAll() {
        model.setRowCount(0);
        try {
            List<Books> books = booksDao.findAll();
            for (Books book : books) {
                Object[] row = {book.getId(), book.getName(), book.getAuthor(), book.getPublication(), book.getPrice(), book.getId2()};
                model.addRow(row);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            showMessageDialog(ex.getMessage());
        }
    }

    private void search() {
        String query = searchTextField.getText();
        if (query.length() == 0) {
            findAll();
        } else {
            model.setRowCount(0);
            try {
                List<Books> books = booksDao.search(searchTextField.getText());
                for (Books book : books) {
                    Object[] row = {book.getId(), book.getName(), book.getAuthor(), book.getPublication(), book.getPrice(),book.getId2()};
                    model.addRow(row);
                }
            } catch (SQLException | ClassNotFoundException ex) {
                showMessageDialog(ex.getMessage());
            }
        }
    }

    private void setUpTableModel() {
        booksTable.setModel(model);
        model.setColumnIdentifiers(columns);
    }

    private void setUpPaddingInTextField() {
        setUpBorderFactory(bookNameTextField);
        setUpBorderFactory(authorTextField);
        setUpBorderFactory(publishedByTextField);
        setUpBorderFactory(priceTextField);
        setUpBorderFactory(searchTextField);
        setUpBorderFactory(id2TextField1);
    }

    private void setUpBorderFactory(JTextField textField) {
        textField.setBorder(BorderFactory.createCompoundBorder(
                textField.getBorder(),
                BorderFactory.createEmptyBorder(5, 10, 5, 5)));
    }

    private void showMessageDialog(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    private Books getValueFromTextField() throws NumberFormatException {
        String booksName = bookNameTextField.getText();
        String author = authorTextField.getText();
        String publication = publishedByTextField.getText();
        Double price = Double.valueOf(priceTextField.getText());
        Double id2 = Double.valueOf(id2TextField1.getText());
        Books book = new Books(booksName, author, publication, price, id2);
        return book;
    }

    private void resetForm() {
        bookNameTextField.setText("");
        authorTextField.setText("");
        publishedByTextField.setText("");
        priceTextField.setText("");
        id2TextField1.setText("");
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputPanel = new javax.swing.JPanel();
        userInputLabel = new javax.swing.JPanel();
        bookNameLabel = new javax.swing.JLabel();
        bookNameTextField = new javax.swing.JTextField();
        publishedByLabel = new javax.swing.JLabel();
        authorLabel = new javax.swing.JLabel();
        authorTextField = new javax.swing.JTextField();
        publishedByTextField = new javax.swing.JTextField();
        priceLabel = new javax.swing.JLabel();
        priceTextField = new javax.swing.JTextField();
        priceLabel1 = new javax.swing.JLabel();
        id2TextField1 = new javax.swing.JTextField();
        buttonPanel = new javax.swing.JPanel();
        saveButton = new javax.swing.JButton();
        editOrUpdateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tablePanel = new javax.swing.JPanel();
        booksTableScrollPane = new javax.swing.JScrollPane();
        booksTable = new javax.swing.JTable();
        searchPanel = new javax.swing.JPanel();
        searchTextField = new javax.swing.JTextField();
        searchLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        inputPanel.setBackground(new java.awt.Color(19, 21, 21));
        inputPanel.setPreferredSize(new java.awt.Dimension(400, 787));

        userInputLabel.setBackground(new java.awt.Color(19, 21, 21));

        bookNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bookNameLabel.setForeground(new java.awt.Color(125, 226, 209));
        bookNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bookNameLabel.setText("Student Name");

        bookNameTextField.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        bookNameTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        bookNameTextField.setBorder(null);
        bookNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookNameTextFieldActionPerformed(evt);
            }
        });

        publishedByLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        publishedByLabel.setForeground(new java.awt.Color(125, 226, 209));
        publishedByLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        publishedByLabel.setText("Faculty");

        authorLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        authorLabel.setForeground(new java.awt.Color(125, 226, 209));
        authorLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        authorLabel.setText("Batch");

        authorTextField.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        authorTextField.setBorder(null);
        authorTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authorTextFieldActionPerformed(evt);
            }
        });

        publishedByTextField.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        publishedByTextField.setBorder(null);
        publishedByTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publishedByTextFieldActionPerformed(evt);
            }
        });

        priceLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        priceLabel.setForeground(new java.awt.Color(125, 226, 209));
        priceLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        priceLabel.setText("ELE Points");

        priceTextField.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        priceTextField.setBorder(null);
        priceTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceTextFieldActionPerformed(evt);
            }
        });

        priceLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        priceLabel1.setForeground(new java.awt.Color(125, 226, 209));
        priceLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        priceLabel1.setText("Student ID");

        id2TextField1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        id2TextField1.setBorder(null);
        id2TextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id2TextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout userInputLabelLayout = new javax.swing.GroupLayout(userInputLabel);
        userInputLabel.setLayout(userInputLabelLayout);
        userInputLabelLayout.setHorizontalGroup(
            userInputLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userInputLabelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userInputLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(userInputLabelLayout.createSequentialGroup()
                        .addGroup(userInputLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(userInputLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(bookNameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(authorLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(publishedByLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(priceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(userInputLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(priceTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                            .addComponent(bookNameTextField)
                            .addComponent(authorTextField)
                            .addComponent(publishedByTextField)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userInputLabelLayout.createSequentialGroup()
                        .addComponent(priceLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(id2TextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)))
                .addContainerGap())
        );
        userInputLabelLayout.setVerticalGroup(
            userInputLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userInputLabelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userInputLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bookNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bookNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(userInputLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(authorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(authorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(userInputLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(publishedByLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(publishedByTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(userInputLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(userInputLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(priceLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(userInputLabelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(id2TextField1)
                        .addContainerGap())))
        );

        buttonPanel.setBackground(new java.awt.Color(19, 21, 21));

        saveButton.setBackground(new java.awt.Color(51, 153, 137));
        saveButton.setForeground(new java.awt.Color(255, 250, 251));
        saveButton.setText("Save");
        saveButton.setBorderPainted(false);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        editOrUpdateButton.setBackground(new java.awt.Color(51, 153, 137));
        editOrUpdateButton.setForeground(new java.awt.Color(255, 250, 251));
        editOrUpdateButton.setText("Edit");
        editOrUpdateButton.setBorderPainted(false);
        editOrUpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editOrUpdateButtonActionPerformed(evt);
            }
        });

        deleteButton.setBackground(new java.awt.Color(51, 153, 137));
        deleteButton.setForeground(new java.awt.Color(255, 250, 251));
        deleteButton.setText("Remove");
        deleteButton.setBorderPainted(false);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(editOrUpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                .addContainerGap())
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editOrUpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(125, 226, 209));
        jLabel2.setText("Menu");

        jLabel3.setBackground(new java.awt.Color(153, 153, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\zerof\\Pictures\\logo (2).png")); // NOI18N

        javax.swing.GroupLayout inputPanelLayout = new javax.swing.GroupLayout(inputPanel);
        inputPanel.setLayout(inputPanelLayout);
        inputPanelLayout.setHorizontalGroup(
            inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputPanelLayout.createSequentialGroup()
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inputPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(userInputLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(inputPanelLayout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(inputPanelLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        inputPanelLayout.setVerticalGroup(
            inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputPanelLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userInputLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(229, Short.MAX_VALUE))
        );

        getContentPane().add(inputPanel, java.awt.BorderLayout.LINE_START);

        tablePanel.setBackground(new java.awt.Color(19, 21, 21));

        booksTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(125, 226, 209)));
        booksTable.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        booksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        booksTable.setGridColor(new java.awt.Color(125, 226, 209));
        booksTable.setRowHeight(35);
        booksTable.setRowMargin(5);
        booksTableScrollPane.setViewportView(booksTable);

        searchPanel.setBackground(new java.awt.Color(19, 21, 21));

        searchTextField.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        searchTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        searchTextField.setToolTipText("Search here");
        searchTextField.setBorder(null);
        searchTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextFieldActionPerformed(evt);
            }
        });
        searchTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTextFieldKeyReleased(evt);
            }
        });

        searchLabel.setBackground(new java.awt.Color(252, 163, 17));
        searchLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        searchLabel.setForeground(new java.awt.Color(125, 226, 209));
        searchLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        searchLabel.setText("Search");

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchTextField)
                .addContainerGap())
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(searchTextField))
                .addContainerGap())
        );

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(125, 226, 209));
        jLabel1.setText("ELE Management System");

        javax.swing.GroupLayout tablePanelLayout = new javax.swing.GroupLayout(tablePanel);
        tablePanel.setLayout(tablePanelLayout);
        tablePanelLayout.setHorizontalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(booksTableScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
                    .addComponent(searchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tablePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(106, 106, 106))
        );
        tablePanelLayout.setVerticalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tablePanelLayout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(booksTableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        getContentPane().add(tablePanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bookNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookNameTextFieldActionPerformed

    private void authorTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authorTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_authorTextFieldActionPerformed

    private void publishedByTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publishedByTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_publishedByTextFieldActionPerformed

    private void priceTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceTextFieldActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        save();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void editOrUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editOrUpdateButtonActionPerformed
        update();
    }//GEN-LAST:event_editOrUpdateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        remove();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void searchTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldKeyReleased
        search();
    }//GEN-LAST:event_searchTextFieldKeyReleased

    private void searchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextFieldActionPerformed

    private void id2TextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id2TextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id2TextField1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel authorLabel;
    private javax.swing.JTextField authorTextField;
    private javax.swing.JLabel bookNameLabel;
    private javax.swing.JTextField bookNameTextField;
    private javax.swing.JTable booksTable;
    private javax.swing.JScrollPane booksTableScrollPane;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editOrUpdateButton;
    private javax.swing.JTextField id2TextField1;
    private javax.swing.JPanel inputPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JLabel priceLabel1;
    private javax.swing.JTextField priceTextField;
    private javax.swing.JLabel publishedByLabel;
    private javax.swing.JTextField publishedByTextField;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel searchLabel;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JPanel userInputLabel;
    // End of variables declaration//GEN-END:variables
}
