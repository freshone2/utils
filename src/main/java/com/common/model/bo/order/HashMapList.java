package com.common.model.bo.order;

import org.apache.commons.collections4.CollectionUtils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @Package: pecker.model.bo
 * @Description:
 * @author: jklofs
 * @date: 2018/4/3 下午2:10
 */
public class HashMapList<K,V> extends HashMap<K,List<V>> {

    public HashMapList() {
        super();
    }

    public V putItem(K key, V value) {
        List<V> list = super.get(key);
        V result = null;
        if (CollectionUtils.isEmpty(list)){
            list = new LinkedList<>();
        }else {
            result = list.get(list.size()-1);
        }
        list.add(value);
        super.put(key, list);
        return result;
    }


}
