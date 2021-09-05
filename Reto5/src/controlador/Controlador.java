/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author Maicol
 */




import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.participante;
import modelo.participanteDAO;
import vista.vista;

/**
 *
 * @author Maicol
 */
public class Controlador  implements ActionListener{

    participanteDAO dao = new participanteDAO();
    participante p = new participante();
    vista vista = new vista();
    DefaultTableModel modelo = new DefaultTableModel();
    
    public Controlador(vista v){
        this.vista = v;
        this.vista.mostrarc.addActionListener(this);
        this.vista.guardarc.addActionListener(this);
        this.vista.editar.addActionListener(this);
        this.vista.actualizarc.addActionListener(this);
        this.vista.eliminarc.addActionListener(this);
        this.vista.nuevo.addActionListener(this);
       
        listar(vista.tabla);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == vista.mostrarc ){
            limpiar();
            listar(vista.tabla);
        }
         if(e.getSource() == vista.guardarc ){
            agregar();
            limpiar();
            listar(vista.tabla);
        }
         
         if(e.getSource() == vista.editar){
             int fila = vista.tabla.getSelectedRow();
             if(fila == -1){
                  JOptionPane.showMessageDialog(vista,"Debe Seleccionar una Fila");
             }else{
                 String apodo = (String) vista.tabla.getValueAt(fila,0);
                 String nombre = (String) vista.tabla.getValueAt(fila,1);
                 String apellido = (String) vista.tabla.getValueAt(fila,2);
                 String email = (String) vista.tabla.getValueAt(fila,3);
                 String celular = (String) vista.tabla.getValueAt(fila,4);
                 String clave = (String) vista.tabla.getValueAt(fila,5);
                 String fecha = (String) vista.tabla.getValueAt(fila,6);
                 
                 vista.apodo.setText(apodo);
                 vista.nombre.setText(nombre);
                 vista.apellido.setText(apellido);
                 vista.email.setText(email);
                 vista.celular.setText(celular);
                 vista.clave.setText(clave);
                 vista.fecha.setText(fecha);
                         
             }
         }
         if(e.getSource() == vista.actualizarc){
            actualizar();
            limpiar();
            listar(vista.tabla);
         }
         if(e.getSource() == vista.eliminarc){
            delete();
            limpiar();
            listar(vista.tabla);
        }
        if (e.getSource() == vista.nuevo) {
            nuevo();
        }
        
    }
   
    void limpiar(){
        for(int i = 0; i < vista.tabla.getRowCount(); i++){
            
            modelo.removeRow(i);
            i = i - 1;
            
        }
    }
    public void delete(){
        int fila = vista.tabla.getSelectedRow();
           
            if(fila == -1){
                  JOptionPane.showMessageDialog(vista,"Debe Seleccionar una usuario");
             }else{
                 String apodo =  (String) vista.tabla.getValueAt(fila, 0).toString();
                dao.delete(apodo);
                JOptionPane.showMessageDialog(vista,"Usuario Eliminado");
            }
    }
     public void actualizar(){
            String apodo = vista.apodo.getText();
            String nombre = vista.nombre.getText();
            String apellido = vista.apellido.getText();
            String email = vista.email.getText();
            String celular = vista.celular.getText();
            String clave = vista.clave.getText();
            String Fecha = vista.fecha.getText();
            
            p.setApodo(apodo);
            p.setNombre(nombre);
            p.setApellido(apellido);
            p.setEmail(email);
            p.setCelular(celular);
            p.setClave(clave);
            p.setFecha(Fecha);
            
            int r = dao.Actualizar(p);
            
        if(r == 1){
            JOptionPane.showMessageDialog(vista,"Usuario Actulizado con Exito!!!");
        }else{
            JOptionPane.showMessageDialog(vista,"ERROR!!!");
        }
     }
    public void agregar(){
        String apodo = vista.apodo.getText();
        String nombre = vista.nombre.getText();
        String apellido = vista.apellido.getText();
        String email = vista.email.getText();
        String celular = vista.celular.getText();
        String clave = vista.clave.getText();
        String Fecha = vista.fecha.getText();
        p.setApodo(apodo);
        p.setNombre(nombre);
        p.setApellido(apellido);
        p.setEmail(email);
        p.setCelular(celular);
        p.setClave(clave);
        p.setFecha(Fecha);
        int r = dao.agregar(p);    
        if(r == 1){
            JOptionPane.showMessageDialog(vista,"Usuario Agregado");
        }else{
            JOptionPane.showMessageDialog(vista,"ERROR!!!");
        }
    }
    public void listar(JTable tabla){
        modelo = (DefaultTableModel)tabla.getModel();
        List<participante> lista = dao.listar();
        Object[] Object = new Object[7];
        
        for(int i = 0; i< lista.size(); i++){
            
            Object[0] = lista.get(i).getApodo();
            Object[1] = lista.get(i).getNombre();
            Object[2] = lista.get(i).getApellido();
            Object[3] = lista.get(i).getEmail();
            Object[4] = lista.get(i).getCelular();
            Object[5] = lista.get(i).getClave();
            Object[6] = lista.get(i).getFecha();
            
            
            modelo.addRow(Object);
            
        }
        vista.tabla.setModel(modelo);
    }
    
    void nuevo() {
       
        vista.apodo.setText("");
        vista.nombre.setText("");
        vista.apellido.setText("");
        vista.email.setText("");
        vista.celular.setText("");
        vista.clave.setText("");
        vista.fecha.setText("");
        JOptionPane.showMessageDialog(null,"Limpiando Campos...");
    }
    
}