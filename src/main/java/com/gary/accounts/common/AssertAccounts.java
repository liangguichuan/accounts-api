package com.gary.accounts.common;

import org.apache.commons.collections.CollectionUtils;

import java.util.Collection;
import java.util.Objects;

/**
 * 用于业务上的判断
 */
public interface AssertAccounts {

    AccountsException newException();

    default void assertNotNull(Object obj){
        if(Objects.isNull(obj)){
            throw newException();
        }
    }

    default void assertEquals(Object obj1, Object obj2){
        if(!Objects.equals(obj1, obj2)){
            throw newException();
        }
    }

    default void assertListEmpty(Collection collection){
        if(!CollectionUtils.isEmpty(collection)){
            throw newException();
        }
    }

}
