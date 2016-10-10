package com.ariansoft.healthybaby.Models;

import com.orm.SugarRecord;

/**
 * Created by elahe on 09/09/2016.
 */
public class daruTypeList extends SugarRecord {
    public String daruTypeName;
    public daruTypeList(){}

    public daruTypeList(String daruTypeName) {
        this.daruTypeName = daruTypeName;
    }
}
