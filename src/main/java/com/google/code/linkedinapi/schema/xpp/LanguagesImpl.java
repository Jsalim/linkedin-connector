/**
 * Mule LinkedIn Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package com.google.code.linkedinapi.schema.xpp;

import com.google.code.linkedinapi.schema.Language;
import com.google.code.linkedinapi.schema.Languages;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LanguagesImpl
        extends BaseSchemaEntity
        implements Languages {

    private final static long serialVersionUID = 2461660169443089969L;
    protected List<Language> languageList;
    protected Long total;

    public List<Language> getLanguageList() {
        if (languageList == null) {
            languageList = new ArrayList<Language>();
        }
        return this.languageList;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long value) {
        this.total = value;
    }

    @Override
    public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);
        setTotal(XppUtils.getAttributeValueAsLongFromNode(parser, "total"));

        while (parser.nextTag() == XmlPullParser.START_TAG) {
            String name = parser.getName();

            if (name.equals("language")) {
                LanguageImpl languageImpl = new LanguageImpl();
                languageImpl.init(parser);
                getLanguageList().add(languageImpl);
            } else {
                // Consume something we don't understand.
                LOG.warning("Found tag that we don't recognize: " + name);
                XppUtils.skipSubTree(parser);
            }
        }
    }

    @Override
    public void toXml(XmlSerializer serializer) throws IOException {
        XmlSerializer element = serializer.startTag(null, "languages");
        XppUtils.setAttributeValueToNode(element, "total", getTotal());
        for (Language language : getLanguageList()) {
            ((LanguageImpl) language).toXml(serializer);
        }
        serializer.endTag(null, "languages");
    }
}
