/*******************************************************************************
 * Copyright (c) 2022 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package jaxb.web.dataobjects;

import java.math.BigDecimal;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * <p>Java class for ShippingAddress complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ShippingAddress">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="street" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="city" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="state" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zip" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *       &lt;attribute name="country" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" fixed="PRC" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ShippingAddress", propOrder = {
                                                 "name",
                                                 "street",
                                                 "city",
                                                 "state",
                                                 "zip"
})
public class ShippingAddress {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String street;
    @XmlElement(required = true)
    protected String city;
    @XmlElement(required = true)
    protected String state;
    @XmlElement(required = true)
    protected BigDecimal zip;
    @XmlAttribute(name = "country")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String country;

    /**
     * Gets the value of the name property.
     *
     * @return
     *         possible object is
     *         {@link String }
     *
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value
     *                  allowed object is
     *                  {@link String }
     *
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the street property.
     *
     * @return
     *         possible object is
     *         {@link String }
     *
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets the value of the street property.
     *
     * @param value
     *                  allowed object is
     *                  {@link String }
     *
     */
    public void setStreet(String value) {
        this.street = value;
    }

    /**
     * Gets the value of the city property.
     *
     * @return
     *         possible object is
     *         {@link String }
     *
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     *
     * @param value
     *                  allowed object is
     *                  {@link String }
     *
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * Gets the value of the state property.
     *
     * @return
     *         possible object is
     *         {@link String }
     *
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     *
     * @param value
     *                  allowed object is
     *                  {@link String }
     *
     */
    public void setState(String value) {
        this.state = value;
    }

    /**
     * Gets the value of the zip property.
     *
     * @return
     *         possible object is
     *         {@link BigDecimal }
     *
     */
    public BigDecimal getZip() {
        return zip;
    }

    /**
     * Sets the value of the zip property.
     *
     * @param value
     *                  allowed object is
     *                  {@link BigDecimal }
     *
     */
    public void setZip(BigDecimal value) {
        this.zip = value;
    }

    /**
     * Gets the value of the country property.
     *
     * @return
     *         possible object is
     *         {@link String }
     *
     */
    public String getCountry() {
        if (country == null) {
            return "PRC";
        } else {
            return country;
        }
    }

    /**
     * Sets the value of the country property.
     *
     * @param value
     *                  allowed object is
     *                  {@link String }
     *
     */
    public void setCountry(String value) {
        this.country = value;
    }

}
