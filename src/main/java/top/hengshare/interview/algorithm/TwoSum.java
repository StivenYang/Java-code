package top.hengshare.interview.algorithm;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONString;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;

import javax.xml.crypto.Data;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 8};

        int[] index = getIndex(10, arr);
        for (int i : index) {
            System.out.println(i);
        }
    }

    public static int[] getIndex(int target, int[] arr) {
        HashMap<Integer, Integer> indexs = Maps.newHashMap();
        for (int i = 0; i < arr.length; i++) {
            indexs.put(arr[i], i);
            if (indexs.containsKey(target - arr[i])) {
                return new int[]{i, indexs.get(target - arr[i])};
            }
        }

        return new int[]{};
    }
}