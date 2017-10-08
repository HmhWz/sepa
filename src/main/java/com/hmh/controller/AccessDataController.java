package com.hmh.controller;

import com.hmh.common.BFConstant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/addatas")
public class AccessDataController extends BaseController {
    @RequestMapping(method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<Map<String, Object>> getAdData(){
        System.out.println(BFConstant.HELLO_MSG);
        Map<String, Object> map = new HashMap<String, Object>();
        List<Integer> emailList = new ArrayList<Integer>();
        List<Integer> allianceList = new ArrayList<Integer>();
        List<Integer> vedioList = new ArrayList<Integer>();
        List<Integer> directList = new ArrayList<Integer>();
        List<Integer> searchList = new ArrayList<Integer>();
        List<String> xTitleList = new ArrayList<String>();
        Random r = new Random();
        // 模拟产生数据，实际应用中请调用service获取
        for (int i = 0; i < 60; i++)
        {
            emailList.add(r.nextInt(50));
            allianceList.add(r.nextInt(50));
            vedioList.add(r.nextInt(50));
            directList.add(r.nextInt(50));
            searchList.add(r.nextInt(50));
            xTitleList.add(i + "m");
        }
        map.put("emailList", emailList);
        map.put("allianceList", allianceList);
        map.put("vedioList", vedioList);
        map.put("directList", directList);
        map.put("searchList", searchList);
        map.put("xTitleList", xTitleList);
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }
}
