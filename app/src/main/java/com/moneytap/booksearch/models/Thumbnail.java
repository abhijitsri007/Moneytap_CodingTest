package com.moneytap.booksearch.models;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Abhijit on 21/07/18.
 */

public class Thumbnail implements Serializable {

    private String source;
    private Integer width;
    private Integer height;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Thumbnail(String source, Integer width, Integer height) {
        this.source = source;
        this.width = width;
        this.height = height;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}