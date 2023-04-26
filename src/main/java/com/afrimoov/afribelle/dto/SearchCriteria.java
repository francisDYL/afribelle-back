package com.afrimoov.afribelle.dto;

import com.afrimoov.afribelle.enums.SearchOperation;
import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;

@Data
public class SearchCriteria implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    @NonNull
    private boolean orPredicate;
    /** Search field */

    @NonNull
    private String key;

    /** Search operation */
    @NonNull
    private SearchOperation operation;

    /** Search value */
    @NonNull
    private Object value;

    public String getStringValue() {
        return (String) value;
    }
}
