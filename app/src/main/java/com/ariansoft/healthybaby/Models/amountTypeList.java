package com.ariansoft.healthybaby.Models;

import com.orm.SugarRecord;

/**
 * Created by elahe on 09/09/2016.
 */
public class amountTypeList  extends SugarRecord {
    public String daruAmountTypeName;
    public amountTypeList(){}

    public amountTypeList(String daruAmountTypeName) {
        this.daruAmountTypeName = daruAmountTypeName;
    }
}
