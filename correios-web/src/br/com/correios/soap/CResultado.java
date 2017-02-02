
package br.com.correios.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de cResultado complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="cResultado"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Servicos" type="{http://tempuri.org/}ArrayOfCServico" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cResultado", propOrder = {
    "servicos"
})
public class CResultado {

    @XmlElement(name = "Servicos")
    protected ArrayOfCServico servicos;

    /**
     * Obtém o valor da propriedade servicos.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCServico }
     *     
     */
    public ArrayOfCServico getServicos() {
        return servicos;
    }

    /**
     * Define o valor da propriedade servicos.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCServico }
     *     
     */
    public void setServicos(ArrayOfCServico value) {
        this.servicos = value;
    }

}
