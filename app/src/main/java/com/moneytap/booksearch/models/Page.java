package com.moneytap.booksearch.models;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Abhijit on 21/07/18.
 */

public class Page implements Serializable {

    public Page(Integer pageid, Integer ns, String title, Integer index, Thumbnail thumbnail, Terms terms) {
        this.pageid = pageid;
        this.ns = ns;
        this.title = title;
        this.index = index;
        this.thumbnail = thumbnail;
        this.terms = terms;
        this.additionalProperties = additionalProperties;
    }

    private Integer pageid;
    private Integer ns;
    private String title;
    private Integer index;
    private Thumbnail thumbnail;
    private Terms terms;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getPageid() {
        return pageid;
    }

    public void setPageid(Integer pageid) {
        this.pageid = pageid;
    }

    public Integer getNs() {
        return ns;
    }

    public void setNs(Integer ns) {
        this.ns = ns;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Terms getTerms() {
        return terms;
    }

    public void setTerms(Terms terms) {
        this.terms = terms;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}