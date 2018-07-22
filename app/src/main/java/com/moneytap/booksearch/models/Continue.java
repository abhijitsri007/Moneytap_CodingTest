package com.moneytap.booksearch.models;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Abhijit on 21/07/18.
 */

public class Continue implements Serializable {

    private Integer gpsoffset;

    public Continue(Integer gpsoffset, String _continue) {
        this.gpsoffset = gpsoffset;
        this._continue = _continue;
    }

    private String _continue;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getGpsoffset() {
        return gpsoffset;
    }

    public void setGpsoffset(Integer gpsoffset) {
        this.gpsoffset = gpsoffset;
    }

    public String getContinue() {
        return _continue;
    }

    public void setContinue(String _continue) {
        this._continue = _continue;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}