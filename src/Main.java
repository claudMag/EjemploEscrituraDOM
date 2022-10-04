import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        //definir los 3 objt coches, añadir a una arraylist
        //recorrer el arraylist construyendo nodos coche en el dom
        ArrayList<Coche> listaCoches = new ArrayList<>();

        listaCoches.add(new Coche("Renault", "Megane", "1.5"));
        listaCoches.add(new Coche("Seat", "Leon", "1.6"));
        listaCoches.add(new Coche("Suzuki", "Vitara", "1.9"));

        try {
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dFactory.newDocumentBuilder();
            Document documento = dBuilder.newDocument();

            Element elementoRaiz = documento.createElement("concesionario");
            documento.appendChild(elementoRaiz);

            for (Coche c: listaCoches) {
                Element elementoCoche = documento.createElement("coche");
                elementoRaiz.appendChild(elementoCoche);

                Attr attribute = documento.createAttribute("id");
                attribute.setValue(String.valueOf(c.getId()));
                elementoCoche.setAttributeNode(attribute);

                Element eMarca = documento.createElement("marca");
                eMarca.appendChild(documento.createTextNode(c.getMarca()));
                elementoCoche.appendChild(eMarca);

                Element eModelo = documento.createElement("modelo");
                eModelo.appendChild(documento.createTextNode(c.getModelo()));
                elementoCoche.appendChild(eModelo);

                Element eCilindrada = documento.createElement("cilindrada");
                eCilindrada.appendChild(documento.createTextNode(c.getCilindrada()));
                elementoCoche.appendChild(eCilindrada);

                TransformerFactory tFactory = TransformerFactory.newInstance();
                Transformer transformer = tFactory.newTransformer();
                DOMSource source = new DOMSource(documento);
                StreamResult result = new StreamResult(new File("concesionario.xml"));
                transformer.transform(source, result);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}