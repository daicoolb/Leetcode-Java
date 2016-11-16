package com.inuker.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Created by dingjikerbo on 2016/11/16.
 */

// 耗时111ms
public class RandomizedSet {

    private HashMap<Integer, Integer> mMap;
    private List<Integer> mList;
    private Random mRandom;

    public RandomizedSet() {
        mList = new ArrayList<Integer>();
        mMap = new HashMap<Integer, Integer>();
        mRandom = new Random();
    }

    public boolean insert(int val) {
        if (mMap.containsKey(val)) {
            return false;
        }
        mList.add(val);
        mMap.put(val, mList.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!mMap.containsKey(val)) {
            return false;
        }
        int index = mMap.remove(val);
        int lastIndex = mList.size() - 1;
        if (index != lastIndex) {
            int lastVal = mList.get(lastIndex);
            mList.set(index, lastVal);
            mMap.put(lastVal, index);
        }
        mList.remove(lastIndex);
        return true;
    }

    public int getRandom() {
        int index = mRandom.nextInt(mList.size());
        return mList.get(index);
    }
}
