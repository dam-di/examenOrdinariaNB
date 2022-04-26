/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

//import com.sun.org.apache.xml.internal.serializer.OutputPropertiesFactory;
import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/**
 *
 * @author Rafa
 */
public class XMLHandler {
    /*-- Variable para almacenar el XML. El documento se carga una vez ejecutado
    el método loadXML --*/
    private static Document document;
    /*-- Método para cargar el archivo XML en la variable document
    Es el primer método a ejecutar para realizar cualquer operación
    con un documento XML --*/
    public static void loadXML(){
        try {
            File archivo = new File("src/main/java/resources/Users.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            document = documentBuilder.parse(archivo);
        }catch (Exception e){
            e.printStackTrace();
        }// Fin de try-catch
    } // Fin método loadXML
    
    /*
    public static ArrayList<Articulo> obtenerLista(){
      
        ArrayList<Articulo> listaArticulos = new ArrayList<Articulo>();
        loadXML();
        NodeList nodeListArticulos = document.getElementsByTagName("articulo");
        for (int i = 0; i<nodeListArticulos.getLength(); i++) {
           Node nodeArticulo = nodeListArticulos.item(i);
           
           Articulo articulo = new Articulo();

           if(nodeArticulo.getNodeType() == Node.ELEMENT_NODE){
               Element eArticulo = (Element) nodeArticulo;
               articulo.setId(Integer.parseInt((eArticulo.getAttribute("id"))));
               articulo.setAlquilado(Boolean.parseBoolean((eArticulo.getAttribute("alquilado"))));
               articulo.setPrecio(Double.parseDouble((eArticulo.getAttribute("precio"))));
               articulo.setEstante((eArticulo.getAttribute("estante")));
               articulo.setEstanteria((eArticulo.getAttribute("estanteria")));
               articulo.setTitulo((eArticulo.getAttribute("titulo")));
               articulo.setFechaAlquiler((eArticulo.getAttribute("fechaAlquiler")));
               
               listaArticulos.add(articulo);
           }//fin if
        }//fin bucle for        
        return listaArticulos;
    }//fin metodo obtener 
    
    */
    
    
 
    public static User buscarUsuario(String nombre){
        loadXML();
        NodeList nodeListUsuarios = document.getElementsByTagName("user");
        User user = null;
        
        for (int i = 0; i<nodeListUsuarios.getLength(); i++) {
           Node nodeUsuario = nodeListUsuarios.item(i);
            if(nodeUsuario.getNodeType() == Node.ELEMENT_NODE){
                Element eUsuario = (Element) nodeUsuario;
                
                if(nombre.equals(eUsuario.getAttribute("name"))){
                    user = new User(
                            eUsuario.getAttribute("email"),
                            eUsuario.getAttribute("name"),
                            eUsuario.getAttribute("pass"),
                            eUsuario.getAttribute("role"));
                    break;
               }
           }//fin if
        }//fin bucle for
        
        return user; 
    }
    
    
    
    /*
    public static boolean borrarUsuario(String dni){
        
        loadXML();
        Element root = document.getDocumentElement();
        NodeList nodeListUsuarios = document.getElementsByTagName("usuario");
        
        boolean usuarioEncontrado = false;
        
        for (int i = 0; i<nodeListUsuarios.getLength(); i++) {
           Node nodeUsuario = nodeListUsuarios.item(i);
           if(nodeUsuario.getNodeType() == Node.ELEMENT_NODE){
               Element eUsuario = (Element) nodeUsuario;
               //SI EL DNI QUE ESTOY PASANDO AL MÉTODO ES IGUAL
               //AL DNI DEL XML, CREO EL USUARIO
               if(dni.equals(eUsuario.getAttribute("dni"))){
                   usuarioEncontrado = true;
                    root.removeChild(nodeUsuario);
                    break;
               }
           }//fin if
        }//fin bucle for
        saveXML();
        return usuarioEncontrado;
        
        
    }//FIN METODO BORRAR USUARIO
    */
    
    
    
    
}//fin clase XMLHandler