/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoteca;

import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Lou
 */
public class Panel extends javax.swing.JPanel {

    private Pelicula pelicula;
    private NumberFormat formatoEuro = NumberFormat.getCurrencyInstance();

    public Panel() {
        initComponents();
        //documentCharactersLimiter1.setLimit(10);
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public void showData() {
        titulo.setText(pelicula.getTitulo());
        productora.setText(pelicula.getProductora());
        nacionalidad.setText(pelicula.getNacionalidad());
        jDateChooser1.setDate(pelicula.getFechaEstreno());
        duracion.setText(String.valueOf(pelicula.getDuracion()));
        recaudacion.setText(formatoEuro.format(pelicula.getRecaudacion()));
        if(genero == null){
            genero.setSelectedIndex(0);
        }else{
            genero.setSelectedIndex(pelicula.getIdGenero().getIdGenero());
        }
        if(director == null){
            director.setText("");
        }else{
            director.setText(pelicula.getIdDirector().getNombre() + " " + pelicula.getIdDirector().getApellidos());
        }
        if(actor == null){
            actor.setText("");
        }else{
            actor.setText(pelicula.getIdActor().getNombre() + " " + pelicula.getIdActor().getApellidos());
        }
        if(imagen == null){
            imagen.setIcon(new ImageIcon(getClass().getResource("")));
        }else{
            imagen.setIcon(new ImageIcon(getClass().getResource(pelicula.getRutaImagen())));
        }
        if(pelicula.getOscars()){
            jCheckBox1.setSelected(true);
        }else{
            jCheckBox1.setSelected(false);
        }
        this.showValoracion();
    }

    public void clear() {
        titulo.setText("");
        productora.setText("");
        nacionalidad.setText("");
        jDateChooser1.setDate(null);
        duracion.setText("");
        recaudacion.setText("");
        jCheckBox1.setVisible(true);
        jSlider1.setValue(0);
        genero.setSelectedIndex(0);
        director.setText("");
        actor.setText("");
        imagen.setIcon(new ImageIcon(getClass().getResource("")));
        pelicula.setValoracion(0);
        this.showValoracion();
    }

    public Pelicula getData() {
        Pelicula pelicula = new Pelicula();
        String title = titulo.getText();
        String producer = productora.getText();
        String nacionality = nacionalidad.getText();
        Date releaseDate = jDateChooser1.getDate();

        try {
            if (title != null && nacionality != null) {
                Short duration = Short.valueOf(duracion.getText());
                BigInteger income = BigInteger.valueOf(Long.valueOf(recaudacion.getText()));
                pelicula.setTitulo(title);
                pelicula.setProductora(producer);
                pelicula.setNacionalidad(nacionality);
                pelicula.setDuracion(duration);
                pelicula.setRecaudacion(income);
                pelicula.setFechaEstreno(releaseDate);
                pelicula.setValoracion(jSlider1.getValue());
                pelicula.setIdGenero(null);
                pelicula.setIdDirector(null);
                pelicula.setIdActor(null);
                pelicula.setRutaImagen(null);
                if (jCheckBox1.isSelected()) {
                    pelicula.setOscars(true);
                } else {
                    pelicula.setOscars(false);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Debe rellenar los campos Título y Nacionalidad", "Atención", JOptionPane.WARNING_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Debe introducir un número", "Atención", JOptionPane.WARNING_MESSAGE);
        }
        return pelicula;
    }


    public void showValoracion() {
        switch (pelicula.getValoracion()) {
            case 0:
                estrellas.setIcon(new ImageIcon(getClass().getResource("/resources/0stars.png")));
                break;
            case 1:
                estrellas.setIcon(new ImageIcon(getClass().getResource("/resources/1star.png")));
                break;
            case 2:
                estrellas.setIcon(new ImageIcon(getClass().getResource("/resources/2stars.png")));
                break;
            case 3:
                estrellas.setIcon(new ImageIcon(getClass().getResource("/resources/3stars.png")));
                break;
            case 4:
                estrellas.setIcon(new ImageIcon(getClass().getResource("/resources/4stars.png")));
                break;
            case 5:
                estrellas.setIcon(new ImageIcon(getClass().getResource("/resources/5stars.png")));
                break;
        }
    }

    public void editable(boolean si) {
        if (si) {
            productora.setEditable(true);
            genero.setEnabled(true);
            director.setEditable(true);
            titulo.setEditable(true);
            nacionalidad.setEditable(true);
            recaudacion.setEditable(true);
            actor.setEditable(true);
            duracion.setEditable(true);
            jDateChooser1.setEnabled(true);
            jCheckBox1.setEnabled(true);
            jSlider1.setVisible(true);
            botonDirector.setVisible(true);
            botonActor.setVisible(true);
        } else {
            productora.setEditable(false);
            genero.setEnabled(false);
            director.setEditable(false);
            titulo.setEditable(false);
            nacionalidad.setEditable(false);
            recaudacion.setEditable(false);
            actor.setEditable(false);
            duracion.setEditable(false);
            jDateChooser1.setEnabled(false);
            jCheckBox1.setEnabled(false);
            jSlider1.setVisible(false);
            botonDirector.setVisible(false);
            botonActor.setVisible(false);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        titulo = new javax.swing.JTextField();
        productora = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        nacionalidad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        duracion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        director = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        actor = new javax.swing.JTextField();
        recaudacion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        genero = new javax.swing.JComboBox();
        estrellas = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        imagen = new javax.swing.JLabel();
        botonDirector = new javax.swing.JButton();
        botonActor = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        setOpaque(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Título:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 14, -1, -1));
        jPanel1.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 11, 250, -1));
        jPanel1.add(productora, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 49, 250, -1));

        jLabel2.setText("Productora:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 52, -1, -1));

        jLabel3.setText("Fecha de estreno:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 86, -1, -1));
        jPanel1.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 80, 214, -1));
        jPanel1.add(nacionalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 120, 190, -1));

        jLabel4.setText("Nacionalidad:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 123, -1, -1));

        jLabel5.setText("Duración:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 161, -1, -1));

        duracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                duracionActionPerformed(evt);
            }
        });
        jPanel1.add(duracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 158, 190, -1));

        jLabel9.setText("Género:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 199, -1, -1));
        jPanel1.add(director, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 234, 190, -1));

        jLabel10.setText("Director:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 237, -1, -1));

        jLabel11.setText("Actor Principal:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 271, -1, -1));
        jPanel1.add(actor, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 268, 190, -1));
        jPanel1.add(recaudacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, 190, -1));

        jLabel6.setText("Recaudación:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        jLabel7.setText("Óscars:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));

        jLabel8.setText("Valoración:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 376, -1, -1));

        jCheckBox1.setOpaque(false);
        jPanel1.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 331, -1, 20));

        genero.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sin Categoría", "Romance", "Drama", "Ciencia Ficción", "Bélico", "Animación", "Thriller", "Comedia", "Terror", "Biográfica", "Fantasía", "Musical", "Acción" }));
        genero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generoActionPerformed(evt);
            }
        });
        jPanel1.add(genero, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, -1, -1));
        jPanel1.add(estrellas, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 240, 40));

        jSlider1.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jSlider1.setForeground(new java.awt.Color(255, 255, 255));
        jSlider1.setMajorTickSpacing(5);
        jSlider1.setMaximum(5);
        jSlider1.setMinorTickSpacing(1);
        jSlider1.setPaintLabels(true);
        jSlider1.setPaintTicks(true);
        jSlider1.setOpaque(false);
        jPanel1.add(jSlider1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, 240, -1));
        jPanel1.add(imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 301, 446));

        botonDirector.setText("Ver");
        botonDirector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDirectorActionPerformed(evt);
            }
        });
        jPanel1.add(botonDirector, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 50, -1));

        botonActor.setText("Ver");
        botonActor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActorActionPerformed(evt);
            }
        });
        jPanel1.add(botonActor, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/cinema.jpg"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 450));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 446));
    }// </editor-fold>//GEN-END:initComponents

    private void duracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duracionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_duracionActionPerformed

    private void generoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_generoActionPerformed

    private void botonDirectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDirectorActionPerformed

        ListaDirectores dialogListaDirectores = new ListaDirectores(null, true);
        dialogListaDirectores.setVisible(true);
    }//GEN-LAST:event_botonDirectorActionPerformed

    private void botonActorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActorActionPerformed
        
        ListaActores dialogListaGeneros = new ListaActores(null, true);
        dialogListaGeneros.setVisible(true);
    }//GEN-LAST:event_botonActorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField actor;
    private javax.swing.JButton botonActor;
    private javax.swing.JButton botonDirector;
    private javax.swing.JTextField director;
    private javax.swing.JTextField duracion;
    private javax.swing.JLabel estrellas;
    private javax.swing.JComboBox genero;
    private javax.swing.JLabel imagen;
    private javax.swing.JCheckBox jCheckBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTextField nacionalidad;
    private javax.swing.JTextField productora;
    private javax.swing.JTextField recaudacion;
    private javax.swing.JTextField titulo;
    // End of variables declaration//GEN-END:variables
}
