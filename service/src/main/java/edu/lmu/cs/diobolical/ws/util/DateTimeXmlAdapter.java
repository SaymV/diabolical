package edu.lmu.cs.diobolical.ws.util;

import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.joda.time.DateTime;

/**
 * A JAXB adapter for Joda-Time's <code>DateTime</code> class.
 */
public class DateTimeXmlAdapter extends XmlAdapter<Date, DateTime> {

    @Override
    public DateTime unmarshal(Date date) throws Exception {
        return new DateTime(date.getTime());
    }

    @Override
    public Date marshal(DateTime dateTime) throws Exception {
        return new Date(dateTime.getMillis());
    }
}
