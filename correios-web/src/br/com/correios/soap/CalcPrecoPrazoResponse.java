
package br.com.correios.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CalcPrecoPrazoResult" type="{http://tempuri.org/}cResultado"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "calcPrecoPrazoResult"
})
@XmlRootElement(name = "CalcPrecoPrazoResponse")
public class CalcPrecoPrazoResponse {

    @XmlElement(name = "CalcPrecoPrazoResult", required = true)
    protected CResultado calcPrecoPrazoResult;

    /**
     * Obtém o valor da propriedade calcPrecoPrazoResult.
     * 
     * @return
     *     possible object is
     *     {@link CResultado }
     *     
     */
    public CResultado getCalcPrecoPrazoResult() {
        return calcPrecoPrazoResult;
    }

    /**
     * Define o valor da propriedade calcPrecoPrazoResult.
     * 
     * @param value
     *     allowed object is
     *     {@link CResultado }
     *     
     */
    public void setCalcPrecoPrazoResult(CResultado value) {
        this.calcPrecoPrazoResult = value;
    }

}
