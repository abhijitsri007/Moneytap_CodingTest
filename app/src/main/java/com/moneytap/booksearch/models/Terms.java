package com.moneytap.booksearch.models;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Abhijit on 21/07/18.
 */

public class Terms implements Serializable {

    private List<String> description = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Terms(List<String> description) {
        this.description = description;
    }

    public List<String> getDescription() {
        return description;
    }

    public void setDescription(List<String> description) {
        this.description = description;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
