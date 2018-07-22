package com.moneytap.booksearch.models;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Abhijit on 21/07/18.
 */

public class Book implements Serializable {

    private Boolean batchcomplete;
    private Continue _continue;
    private Query query;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Boolean getBatchcomplete() {
        return batchcomplete;
    }

    public void setBatchcomplete(Boolean batchcomplete) {
        this.batchcomplete = batchcomplete;
    }

    public Continue getContinue() {
        return _continue;
    }

    public void setContinue(Continue _continue) {
        this._continue = _continue;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    // Returns a Book given the expected JSON
    public static Book fromJson(JSONObject jsonObject) {
        Book book = new Book();
        List<Page> page_array= new ArrayList<Page>();
        List<String> desc_array= new ArrayList<String>();
        Thumbnail thumbnail = null;
        // Deserialize json into object fields
        // Check if a cover edition is available
        if (jsonObject.has("pageid")) {

            if (jsonObject.has("terms")){
                JSONArray jsonArray_terms = jsonObject.optJSONObject("terms").optJSONArray("description");
                desc_array.add(jsonArray_terms.optString(0));
            }

            if(jsonObject.has("thumbnail")){
                JSONObject jsonObject_thumbnail = jsonObject.optJSONObject("thumbnail");
                thumbnail = new Thumbnail(jsonObject_thumbnail.optString("source"),jsonObject_thumbnail.optInt("width"),jsonObject_thumbnail.optInt("height"));
            }else
                thumbnail = new Thumbnail(null,null,null);

            page_array.add(new Page(jsonObject.optInt("pageid"),jsonObject.optInt("ns"),jsonObject.optString("title"),jsonObject.optInt("index"),thumbnail,new Terms(desc_array)));
            book.query = new Query(page_array);
        }
        // Return new object
        return book;
    }

    // Decodes array of book json results into business model objects
    public static ArrayList<Book> fromJson(JSONArray jsonArray) {
        ArrayList<Book> books = new ArrayList<Book>(jsonArray.length());
        // Process each result in json array, decode and convert to business
        // object
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject bookJson = null;
            try {
                bookJson = jsonArray.getJSONObject(i);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
            Book book = Book.fromJson(bookJson);
            if (book != null) {
                books.add(book);
            }
        }
        return books;
    }

}