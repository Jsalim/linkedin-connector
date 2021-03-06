/**
 * Mule LinkedIn Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package com.google.code.linkedinapi.schema;


/**
 * <p>Java class for anonymous complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}type" minOccurs="0"/>
 *         &lt;element ref="{}name"/>
 *         &lt;element ref="{}industry" minOccurs="0"/>
 *         &lt;element ref="{}size" minOccurs="0"/>
 *         &lt;element ref="{}ticker" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
public interface Company
        extends SchemaEntity {


    /**
     * Gets the value of the type property.
     *
     * @return possible object is
     *         {@link String }
     */
    String getType();

    /**
     * Sets the value of the type property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setType(String value);

    /**
     * Gets the value of the name property.
     *
     * @return possible object is
     *         {@link String }
     */
    String getName();

    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setName(String value);

    /**
     * Gets the value of the industry property.
     *
     * @return possible object is
     *         {@link String }
     */
    String getIndustry();

    /**
     * Sets the value of the industry property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setIndustry(String value);

    /**
     * Gets the value of the size property.
     *
     * @return possible object is
     *         {@link String }
     */
    Long getSize();

    /**
     * Sets the value of the size property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setSize(Long value);

    /**
     * Gets the value of the ticker property.
     *
     * @return possible object is
     *         {@link String }
     */
    String getTicker();

    /**
     * Sets the value of the ticker property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setTicker(String value);

}
