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

import com.google.code.linkedinapi.schema.Company;
import com.google.code.linkedinapi.schema.Job;
import com.google.code.linkedinapi.schema.JobPoster;
import com.google.code.linkedinapi.schema.Position;
import com.google.code.linkedinapi.schema.SiteJobRequest;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;

public class JobImpl
        extends BaseSchemaEntity
        implements Job {

    private final static long serialVersionUID = 2461660169443089969L;
    protected String id;
    protected PositionImpl position;
    protected CompanyImpl company;
    protected JobPosterImpl jobPoster;
    protected SiteJobRequestImpl siteJobRequest;

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position value) {
        this.position = ((PositionImpl) value);
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company value) {
        this.company = ((CompanyImpl) value);
    }

    public JobPoster getJobPoster() {
        return jobPoster;
    }

    public void setJobPoster(JobPoster value) {
        this.jobPoster = ((JobPosterImpl) value);
    }

    public SiteJobRequest getSiteJobRequest() {
        return siteJobRequest;
    }

    public void setSiteJobRequest(SiteJobRequest value) {
        this.siteJobRequest = ((SiteJobRequestImpl) value);
    }

    @Override
    public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);

        while (parser.nextTag() == XmlPullParser.START_TAG) {
            String name = parser.getName();

            if (name.equals("id")) {
                setId(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("position")) {
                PositionImpl position = new PositionImpl();
                position.init(parser);
                setPosition(position);
            } else if (name.equals("company")) {
                CompanyImpl company = new CompanyImpl();
                company.init(parser);
                setCompany(company);
            } else if (name.equals("job-poster")) {
                JobPosterImpl jobPoster = new JobPosterImpl();
                jobPoster.init(parser);
                setJobPoster(jobPoster);
            } else if (name.equals("site-job-request")) {
                SiteJobRequestImpl apiRequest = new SiteJobRequestImpl();
                apiRequest.init(parser);
                setSiteJobRequest(apiRequest);
            } else {
                // Consume something we don't understand.
                LOG.warning("Found tag that we don't recognize: " + name);
                XppUtils.skipSubTree(parser);
            }
        }
    }

    @Override
    public void toXml(XmlSerializer serializer) throws IOException {
        XmlSerializer element = serializer.startTag(null, "job");
        XppUtils.setElementValueToNode(element, "id", getId());
        if (getPosition() != null) {
            ((PositionImpl) getPosition()).toXml(serializer);
        }
        if (getCompany() != null) {
            ((CompanyImpl) getCompany()).toXml(serializer);
        }
        if (getJobPoster() != null) {
            ((JobPosterImpl) getJobPoster()).toXml(serializer);
        }
        if (getSiteJobRequest() != null) {
            ((SiteJobRequestImpl) getSiteJobRequest()).toXml(serializer);
        }
        serializer.endTag(null, "job");
    }
}
